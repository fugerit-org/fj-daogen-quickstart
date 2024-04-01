package org.fugerit.java.daogen.quickstart.junit4test.model;

import org.fugerit.java.daogen.quickstart.def.facade.MappedTableFinder;
import org.fugerit.java.daogen.quickstart.def.model.ModelMappedTable;
import org.fugerit.java.daogen.quickstart.impl.helper.HelperMappedTable;
import org.fugerit.java.daogen.quickstart.impl.helper.WrapperMappedTable;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * MappedTableJunit4ModelTest, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class MappedTableJunit4ModelTest {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final Logger logger = LoggerFactory.getLogger( MappedTableJunit4ModelTest.class );

	public void printAll( ModelMappedTable current ) { 
		logger.info( "ID-> {}", current.getId() );
		logger.info( "CONTENT-> {}", current.getContent() );
	}

	public ModelMappedTable newInstance() { 
		WrapperMappedTable current = new WrapperMappedTable( new HelperMappedTable() );
		Assert.assertTrue( current.isEmpty() );
		current.setId(new java.math.BigDecimal( "1" ));
		Assert.assertFalse( current.isEmpty() );
		current.setContent("1");
		Assert.assertFalse( current.isEmpty() );
		logger.info( "unwrap :  {}", current.unwrap( current ) );
		return current;
	}

	@Test
	public void testJUnit4ModelMappedTable() { 
		ModelMappedTable current = this.newInstance();
		this.printAll( current );
		logger.info( "current toString() : {}", current );
		org.fugerit.java.core.function.SafeFunction.apply( () -> org.fugerit.java.core.io.ObjectIO.fullSerializationTest( current ) );
		Assert.assertNotNull( current );
		MappedTableFinder finder1 = new MappedTableFinder();
		finder1.setModel( current );
		logger.info( "finder1.getModel() -> {}", finder1.getModel() );
		finder1.setId( current.getId() );
		Assert.assertEquals( current.getId(), finder1.getId() );
		Assert.assertNotNull( MappedTableFinder.newInstance( current.getId() ) );
		Assert.assertNotNull( MappedTableFinder.newInstance( current ) );
		Assert.assertNotNull( finder1 );
	}

}
