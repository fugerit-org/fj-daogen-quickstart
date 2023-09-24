package org.fugerit.java.daogen.quickstart.config;

import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.core.db.daogen.CloseableDAOContext;
import org.fugerit.java.core.db.daogen.CloseableDAOContextSC;
import org.fugerit.java.core.db.daogen.SimpleServiceProvider;
import org.fugerit.java.daogen.quickstart.def.facade.QuickstartLogicFacade;
import org.fugerit.java.daogen.quickstart.impl.facade.data.QuickstartDataLogicFacade;

public class ServiceProviderHelper<T> extends SimpleServiceProvider<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3421974923085310713L;

	private static final QuickstartLogicFacade FACADE = new QuickstartDataLogicFacade();
	
	@Override
	protected CloseableDAOContext newDefaultContext() throws DAOException {
		try {
			CloseableDAOContext context = new CloseableDAOContextSC( QuickstartDBHelper.newConnection() );
			context.setAttribute( QuickstartLogicFacade.ATT_NAME , FACADE );
			return context;
		} catch (Exception e) {
			throw new DAOException( e );
		}
	}

}
