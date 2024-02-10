package org.fugerit.java.daogen.quickstart.config;

import org.fugerit.java.core.db.dao.DAORuntimeException;
import org.fugerit.java.core.db.helpers.SQLScriptFacade;
import org.fugerit.java.core.db.helpers.SQLScriptReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class QuickstartDBHelper {

	private QuickstartDBHelper() {}
	
	private static final Logger logger = LoggerFactory.getLogger( QuickstartDBHelper.class );

	private static final String DEFAULT_DB_CONN_PATH = "quickstart_db/quickstart-db-conn.properties";
	private static final String DEFAULT_DB_INIT_PATH = "quickstart_db/hsqldb";

	private static final String[] SQL_INIT_SCRIPTS = { "100_db_setup.sql", "200_sample_db.sql", "900_examples.sql" };

	private static final String DRV = "db-mode-dc-drv";
	private static final String URL = "db-mode-dc-url";
	private static final String USR = "db-mode-dc-usr";
	private static final String PWD = "db-mode-dc-pwd";
	

	private static Properties cf;
	
	private static Connection newConnection( Properties props ) {
		return DAORuntimeException.get( () -> {
			Class.forName( props.getProperty( DRV ) );
			return DriverManager.getConnection( props.getProperty( URL ), props.getProperty( USR ), props.getProperty( PWD ) );
		} );
	}

    public static void init()
    {
    	if ( cf == null ) {
    		DAORuntimeException.apply( () -> {
    			try ( InputStream is = QuickstartDBHelper.class.getClassLoader().getResourceAsStream( DEFAULT_DB_CONN_PATH ) ) {
        			Properties props = new Properties();
        			props.load( is );
                	try ( Connection conn = newConnection( props ) ) {
						for ( int k=0; k<SQL_INIT_SCRIPTS.length; k++ ) {
							String current = SQL_INIT_SCRIPTS[k];
							String res = DEFAULT_DB_INIT_PATH+"/"+current;
							logger.info( "Current : {}", res );
							try ( SQLScriptReader reader = new SQLScriptReader( QuickstartDBHelper.class.getClassLoader().getResourceAsStream( res ) ) ) {
								SQLScriptFacade.executeAll(reader, conn);

							}
						}
            		}
					cf = props;
        		}
    		} );
    	}
    } 
    
    public static Connection newConnection() {
    	init();
    	return newConnection( cf );
    }
		
}
