package org.fugerit.java.daogen.quickstart.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;

import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.core.db.daogen.BasicHelper;
import org.fugerit.java.core.db.daogen.CloseableDAOContext;
import org.fugerit.java.core.db.daogen.CloseableDAOContextSC;
import org.fugerit.java.core.db.daogen.SimpleServiceResult;
import org.fugerit.java.core.function.SafeFunction;
import org.fugerit.java.core.util.result.ResultHelper;
import org.fugerit.java.daogen.quickstart.def.facade.QuickstartLogicFacade;
import org.fugerit.java.daogen.quickstart.def.facade.QuickstartLogicFacadeHelper;
import org.fugerit.java.daogen.quickstart.impl.facade.data.QuickstartDataLogicFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceProviderHelper<T> extends BasicHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3421974923085310713L;

	protected static Logger logger = LoggerFactory.getLogger( ServiceProviderHelper.class );
	
	private static final QuickstartLogicFacade FACADE = new QuickstartDataLogicFacade();
	
	public Object createResultFromList( SimpleServiceResult<List<T>> result ) {
		return result.getContent();
	}
	
	public Object createResultFromObject( SimpleServiceResult<T> result ) {
		return ResultHelper.createList( result.getContent() );
	}
			
	public List<T> createResponseFromList( SimpleServiceResult<List<T>> result ) {
		return result.getContent();
	}

	public List<T> createResponseFromObject( SimpleServiceResult<T> result ) {
		List<T> list = new ArrayList<>();
		SafeFunction.applyIfNotNull( result.getContent() , () -> list.add( result.getContent() ) );
		return list;
	}
	
	protected CloseableDAOContext newDefaultContext() throws DAOException {
		try {
			CloseableDAOContext context = new CloseableDAOContextSC( QuickstartDBHelper.newConnection() ); // NOSONAR
			context.setAttribute( QuickstartLogicFacadeHelper.ATT_NAME , FACADE );
			return context;
		} catch (Exception e) {
			throw new DAOException( e );
		}
	}
	
	public Date defaultConvertToUtilDate( String s ) {
		return SafeFunction.getIfNotNull( s , () -> DatatypeFactory.newInstance().newXMLGregorianCalendar( s ).toGregorianCalendar().getTime() );
	}

}
