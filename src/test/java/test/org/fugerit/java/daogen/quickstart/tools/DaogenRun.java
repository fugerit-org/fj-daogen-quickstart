package test.org.fugerit.java.daogen.quickstart.tools;

import java.io.InputStream;

import org.fugerit.java.core.lang.helpers.ClassHelper;
import org.fugerit.java.daogen.base.config.DaogenFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaogenRun {

	private final static Logger logger = LoggerFactory.getLogger( DaogenRun.class );
	
	public static void main( String[] args ) {
		try {
			try ( InputStream is = ClassHelper.loadFromDefaultClassLoader( "daogen/daogen-config.xml" ) ) {
				logger.info( "DAOGEN start!" );
				DaogenFacade.generate( is );
				logger.info( "DAOGEN end!" );
			}
		} catch (Exception e)  {
			logger.error( "Error during dump : "+e , e );
		}
	}
	
}
