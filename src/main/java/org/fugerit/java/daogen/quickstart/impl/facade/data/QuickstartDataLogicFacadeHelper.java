package org.fugerit.java.daogen.quickstart.impl.facade.data;

import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.daogen.quickstart.def.facade.EntityDocumentFacade;
import org.fugerit.java.daogen.quickstart.def.facade.EntityExample01Facade;
import org.fugerit.java.daogen.quickstart.def.facade.EntityMappedTableFacade;
import org.fugerit.java.daogen.quickstart.def.facade.EntityPersonFacade;
import org.fugerit.java.daogen.quickstart.impl.facade.data.DataEntityDocumentFacade;
import org.fugerit.java.daogen.quickstart.impl.facade.data.DataEntityExample01Facade;
import org.fugerit.java.daogen.quickstart.impl.facade.data.DataEntityMappedTableFacade;
import org.fugerit.java.daogen.quickstart.impl.facade.data.DataEntityPersonFacade;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * QuickstartDataLogicFacadeHelper, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class QuickstartDataLogicFacadeHelper implements org.fugerit.java.daogen.quickstart.def.facade.QuickstartLogicFacadeHelper {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private EntityDocumentFacade entitydocumentfacade = new DataEntityDocumentFacade();

	@Override
	public EntityDocumentFacade getEntityDocumentFacade() throws DAOException {
		return this.entitydocumentfacade;
	}

	protected void setEntityDocumentFacade( EntityDocumentFacade facade ) throws DAOException {
		this.entitydocumentfacade = facade;
	}

	private EntityExample01Facade entityexample01facade = new DataEntityExample01Facade();

	@Override
	public EntityExample01Facade getEntityExample01Facade() throws DAOException {
		return this.entityexample01facade;
	}

	protected void setEntityExample01Facade( EntityExample01Facade facade ) throws DAOException {
		this.entityexample01facade = facade;
	}

	private EntityMappedTableFacade entitymappedtablefacade = new DataEntityMappedTableFacade();

	@Override
	public EntityMappedTableFacade getEntityMappedTableFacade() throws DAOException {
		return this.entitymappedtablefacade;
	}

	protected void setEntityMappedTableFacade( EntityMappedTableFacade facade ) throws DAOException {
		this.entitymappedtablefacade = facade;
	}

	private EntityPersonFacade entitypersonfacade = new DataEntityPersonFacade();

	@Override
	public EntityPersonFacade getEntityPersonFacade() throws DAOException {
		return this.entitypersonfacade;
	}

	protected void setEntityPersonFacade( EntityPersonFacade facade ) throws DAOException {
		this.entitypersonfacade = facade;
	}

}
