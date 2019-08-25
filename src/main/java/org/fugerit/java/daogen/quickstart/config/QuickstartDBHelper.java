package org.fugerit.java.daogen.quickstart.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.fugerit.java.core.db.helpers.SQLScriptFacade;
import org.fugerit.java.core.db.helpers.SQLScriptReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickstartDBHelper {

	private final static Logger logger = LoggerFactory.getLogger( QuickstartDBHelper.class );
	 
	public static final String DEFAULT_DB_CONN_PATH = "quickstart_db/quickstart-db-conn.properties";
	public static final String DEFAULT_DB_INIT_PATH = "quickstart_db/hsqldb";

	private static final String DRV = "db-mode-dc-drv";
	private static final String URL = "db-mode-dc-url";
	private static final String USR = "db-mode-dc-usr";
	private static final String PWD = "db-mode-dc-pwd";
	

	private static Properties cf;
	
	private static Connection newConnection( Properties props ) throws Exception {
		Class.forName( props.getProperty( DRV ) );
		return DriverManager.getConnection( props.getProperty( URL ), props.getProperty( USR ), props.getProperty( PWD ) );
	}

    public static void init() throws Exception
    {
    	if ( cf == null ) {
    		try ( InputStream is = QuickstartDBHelper.class.getClassLoader().getResourceAsStream( DEFAULT_DB_CONN_PATH ) ) {
    			Properties props = new Properties();
    			props.load( is );
            	try ( Connection conn = newConnection( props ) ) {
            		cf = props;
            		ResScanner scanner = new ResScanner();
            		List<String> initFiles = scanner.getResourceFiles( DEFAULT_DB_INIT_PATH );
            		for ( String current : initFiles ) {
            			String res = DEFAULT_DB_INIT_PATH+"/"+current;
            			logger.info( "Current : "+res );
                		try ( SQLScriptReader reader = new SQLScriptReader( QuickstartDBHelper.class.getClassLoader().getResourceAsStream( res ) ) ) {
                			SQLScriptFacade.executeAll(reader, conn);
                			cf = props;
                		}
            		}
        		}	
    		}
    	}
    } 
    
    public static Connection newConnection() throws Exception {
    	init();
    	return newConnection( cf );
    }
		
}

class ResScanner {
	
	public List<String> getResourceFiles(String path) throws IOException {
	    List<String> filenames = new ArrayList<>();
	
	    try (
	            InputStream in = getResourceAsStream(path);
	            BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
	        String resource;
	
	        while ((resource = br.readLine()) != null) {
	            filenames.add(resource);
	        }
	    }
	
	    return filenames;
	}
	
	private InputStream getResourceAsStream(String resource) {
	    final InputStream in
	            = getContextClassLoader().getResourceAsStream(resource);
	
	    return in == null ? getClass().getResourceAsStream(resource) : in;
	}
	
	private ClassLoader getContextClassLoader() {
	    return Thread.currentThread().getContextClassLoader();
	}
	
}

