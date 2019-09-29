package org.fugerit.java.daogen.quickstart.def.facade;

import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.daogen.quickstart.def.facade.EntityDocumentFacade;
import org.fugerit.java.daogen.quickstart.def.facade.EntityExample01Facade;
import org.fugerit.java.daogen.quickstart.def.facade.EntityPersonFacade;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * QuickstartLogicFacade, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public interface QuickstartLogicFacade {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	public static final String ATT_NAME = "QuickstartLogicFacade";

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
	 * Facade incapsulating persistance for entity : PERSON
	 *
	 * @return	the facade
	 * @throws DAOException	in case of problems
	 */
	EntityPersonFacade getEntityPersonFacade() throws DAOException;

}
