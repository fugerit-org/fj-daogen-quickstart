package org.fugerit.java.daogen.quickstart.junit5test.model;

import org.fugerit.java.daogen.quickstart.def.facade.PersonFinder;
import org.fugerit.java.daogen.quickstart.def.model.ModelPerson;
import org.fugerit.java.daogen.quickstart.impl.helper.HelperPerson;
import org.fugerit.java.daogen.quickstart.impl.helper.WrapperPerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * PersonJunit5ModelTest, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
class PersonJunit5ModelTest {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final Logger logger = LoggerFactory.getLogger( PersonJunit5ModelTest.class );

	public void printAll( ModelPerson current ) { 
		logger.info( "ID-> {}", current.getId() );
		logger.info( "SURNAME-> {}", current.getSurname() );
		logger.info( "NAME-> {}", current.getName() );
		logger.info( "BIRTH_DATE-> {}", current.getBirthDate() );
		logger.info( "NOTE-> {}", current.getNote() );
		logger.info( "ID_MOTHER-> {}", current.getIdMother() );
		logger.info( "ID_FATHER-> {}", current.getIdFather() );
		logger.info( "relation : PUBLIC.DAOGEN_QUICKSTART.PERSON_PUBLIC.DAOGEN_QUICKSTART.PERSON-> {}", current.getMother() );
		logger.info( "relation : PUBLIC.DAOGEN_QUICKSTART.PERSON_PUBLIC.DAOGEN_QUICKSTART.PERSON-> {}", current.getFather() );
		logger.info( "relation : PUBLIC.DAOGEN_QUICKSTART.DOCUMENT_PUBLIC.DAOGEN_QUICKSTART.PERSON-> {}", current.getOwndocuments() );
	}

	public ModelPerson newInstance() { 
		WrapperPerson current = new WrapperPerson( new HelperPerson() );
		Assertions.assertTrue( current.isEmpty() );
		current.setId(new java.math.BigDecimal( "1" ));
		Assertions.assertFalse( current.isEmpty() );
		current.setSurname("1");
		Assertions.assertFalse( current.isEmpty() );
		current.setName("1");
		Assertions.assertFalse( current.isEmpty() );
		current.setBirthDate(new java.util.Date());
		Assertions.assertFalse( current.isEmpty() );
		current.setNote("1");
		Assertions.assertFalse( current.isEmpty() );
		current.setIdMother(new java.math.BigDecimal( "1" ));
		Assertions.assertFalse( current.isEmpty() );
		current.setIdFather(new java.math.BigDecimal( "1" ));
		Assertions.assertFalse( current.isEmpty() );
		current.setMother( new org.fugerit.java.daogen.quickstart.impl.helper.HelperPerson() );
		current.setFather( new org.fugerit.java.daogen.quickstart.impl.helper.HelperPerson() );
		current.setOwndocuments( new java.util.ArrayList<org.fugerit.java.daogen.quickstart.def.model.ModelDocument>() );
		logger.info( "unwrap :  {}", current.unwrap( current ) );
		return current;
	}

	@Test
	 void testJUnit5ModelPerson() { 
		ModelPerson current = this.newInstance();
		this.printAll( current );
		logger.info( "current toString() : {}", current );
		org.fugerit.java.core.function.SafeFunction.apply( () -> org.fugerit.java.core.io.ObjectIO.fullSerializationTest( current ) );
		Assertions.assertNotNull( current );
		PersonFinder finder1 = new PersonFinder();
		finder1.setModel( current );
		logger.info( "finder1.getModel() -> {}", finder1.getModel() );
		finder1.setId( current.getId() );
		Assertions.assertEquals( current.getId(), finder1.getId() );
		Assertions.assertNotNull( PersonFinder.newInstance( current.getId() ) );
		Assertions.assertNotNull( PersonFinder.newInstance( current ) );
		Assertions.assertNotNull( finder1 );
	}

}
