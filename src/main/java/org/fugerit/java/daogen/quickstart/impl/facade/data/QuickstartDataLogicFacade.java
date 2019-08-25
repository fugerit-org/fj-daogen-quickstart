package org.fugerit.java.daogen.quickstart.impl.facade.data;

import org.fugerit.java.daogen.quickstart.impl.facade.data.DataEntityPersonFacade;
import org.fugerit.java.daogen.quickstart.def.facade.EntityPersonFacade;
import org.fugerit.java.daogen.quickstart.impl.facade.data.DataEntityDocumentFacade;
import org.fugerit.java.daogen.quickstart.def.facade.EntityDocumentFacade;
import org.fugerit.java.core.db.dao.DAOException;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * QuickstartDataLogicFacade, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class QuickstartDataLogicFacade implements org.fugerit.java.daogen.quickstart.def.facade.QuickstartLogicFacade {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private EntityDocumentFacade entitydocumentfacade = new DataEntityDocumentFacade();

	@Override
	public EntityDocumentFacade getEntityDocumentFacade() throws DAOException {
		return this.entitydocumentfacade;
	}

	private EntityPersonFacade entitypersonfacade = new DataEntityPersonFacade();

	@Override
	public EntityPersonFacade getEntityPersonFacade() throws DAOException {
		return this.entitypersonfacade;
	}

}
