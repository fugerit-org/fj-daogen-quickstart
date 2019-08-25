package test.org.fugerit.java.daogen.quickstart.tools;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.fugerit.java.core.db.connect.ConnectionFactory;
import org.fugerit.java.core.db.connect.SingleConnectionFactory;
import org.fugerit.java.daogen.base.config.DaogenConfigDump;
import org.fugerit.java.daogen.quickstart.config.QuickstartDBHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaogenDump {

	private final static Logger logger = LoggerFactory.getLogger( DaogenDump.class );
	
	public static void main( String[] args ) {
		try {
			logger.info( "daogen dump start!" );
			try ( StringWriter writer = new StringWriter() ) {
				ConnectionFactory cf = new SingleConnectionFactory( QuickstartDBHelper.newConnection() );
				Properties params = new Properties();
				params.setProperty( DaogenConfigDump.PARAM_SCHEMA , "DAOGEN_QUICKSTART" );
				List<String> tnl = new ArrayList<String>();
				tnl.add( "*" );
				DaogenConfigDump.dumpConfig( cf , params, writer, tnl );
				logger.info( "OUTPUT > \n"+writer.toString() );
			}
			logger.info( "daogen dump end!" );
		} catch (Exception e)  {
			logger.error( "Error during dump : "+e , e );
		}
	}
	
}
