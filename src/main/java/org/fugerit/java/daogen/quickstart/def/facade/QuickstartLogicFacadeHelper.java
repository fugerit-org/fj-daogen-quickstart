package org.fugerit.java.daogen.quickstart.def.facade;

import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.daogen.quickstart.def.facade.EntityDocumentFacade;
import org.fugerit.java.daogen.quickstart.def.facade.EntityExample01Facade;
import org.fugerit.java.daogen.quickstart.def.facade.EntityMappedTableFacade;
import org.fugerit.java.daogen.quickstart.def.facade.EntityPersonFacade;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * QuickstartLogicFacadeHelper, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public interface QuickstartLogicFacadeHelper {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	public static final String ATT_NAME = "QuickstartLogicFacadeHelper";

	/**
	 * Facade incapsulating persistance for entity : DOCUMENT
	 *
	 * @return	the facade
	 * @throws DAOException	in case of problems
	 */
	EntityDocumentFacade getEntityDocumentFacade() throws DAOException;

	/**
	 * Facade incapsulating persistance for entity : EXAMPLE_01
	 *
	 * @return	the facade
	 * @throws DAOException	in case of problems
	 */
	EntityExample01Facade getEntityExample01Facade() throws DAOException;

	/**
	 * Facade incapsulating persistance for entity : MAPPED_TABLE
	 *
	 * @return	the facade
	 * @throws DAOException	in case of problems
	 */
	EntityMappedTableFacade getEntityMappedTableFacade() throws DAOException;

	/**
	 * Facade incapsulating persistance for entity : PERSON
	 *
	 * @return	the facade
	 * @throws DAOException	in case of problems
	 */
	EntityPersonFacade getEntityPersonFacade() throws DAOException;

}
