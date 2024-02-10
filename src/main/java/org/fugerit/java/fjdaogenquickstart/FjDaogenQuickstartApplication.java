package org.fugerit.java.fjdaogenquickstart;

import org.fugerit.java.daogen.quickstart.config.QuickstartDBHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FjDaogenQuickstartApplication {

	private static Logger logger = LoggerFactory.getLogger( FjDaogenQuickstartApplication.class );

	public static void main(String[] args) {
		SpringApplication.run(FjDaogenQuickstartApplication.class, args);
		logger.info( "app init start" );
		QuickstartDBHelper.init();
		logger.info( "app init end" );
	}

}
