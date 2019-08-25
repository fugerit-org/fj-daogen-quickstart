package org.fugerit.java.daogen.quickstart.config;

import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.core.db.daogen.CloseableDAOContext;
import org.fugerit.java.core.db.daogen.CloseableDAOContextSC;
import org.fugerit.java.core.db.daogen.SimpleServiceProvider;

public class ServiceProviderHelper<T> extends SimpleServiceProvider<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3421974923085310713L;

	@Override
	protected CloseableDAOContext newDefaultContext() throws DAOException {
		try {
			return new CloseableDAOContextSC( QuickstartDBHelper.newConnection() );
		} catch (Exception e) {
			throw new DAOException( e );
		}
	}

}
