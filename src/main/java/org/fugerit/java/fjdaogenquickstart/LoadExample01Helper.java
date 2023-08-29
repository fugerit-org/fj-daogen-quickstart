package org.fugerit.java.fjdaogenquickstart;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.core.db.daogen.BasicDaoResult;
import org.fugerit.java.core.db.daogen.CloseableDAOContext;
import org.fugerit.java.core.db.daogen.DAOContext;
import org.fugerit.java.core.db.daogen.SimpleServiceResult;
import org.fugerit.java.daogen.quickstart.def.facade.EntityExample01Facade;
import org.fugerit.java.daogen.quickstart.def.facade.Example01Finder;
import org.fugerit.java.daogen.quickstart.def.facade.QuickstartLogicFacade;
import org.fugerit.java.daogen.quickstart.def.model.ModelExample01;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * LoadExample01Helper, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class LoadExample01Helper extends org.fugerit.java.daogen.quickstart.config.ServiceProviderHelper<ModelExample01> {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final long serialVersionUID = 358524568279L;

	public static SimpleServiceResult<ModelExample01> loadByIdWorker( DAOContext context, java.lang.String field1, java.util.Date field2 ) throws DAOException {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityExample01Facade facade = factory.getEntityExample01Facade();
		ModelExample01 model = facade.loadById( context , field1, field2 );
		SimpleServiceResult<ModelExample01>  result = SimpleServiceResult.newDefaultResult( model );
		return result;
	}

	@RequestMapping(value = "/field1/{field1}/field2/{field2}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getByID(@PathVariable( "field1") String field1, @PathVariable( "field2") String field2) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelExample01>  result = loadByIdWorker( context, field1, this.defaultConvertToUtilDate(field2) );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromObject( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadExample01 - getByID - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

	public static SimpleServiceResult<ModelExample01> loadByIdDeepWorker( DAOContext context, java.lang.String field1, java.util.Date field2 ) throws DAOException {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityExample01Facade facade = factory.getEntityExample01Facade();
		ModelExample01 model = facade.loadById( context , field1, field2 );
		SimpleServiceResult<ModelExample01>  result = SimpleServiceResult.newDefaultResult( model );
		if ( result.getContent() != null ) {
		}
		return result;
	}

	@RequestMapping(value = "/deep/field1/{field1}/field2/{field2}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getByIDdeep(@PathVariable( "field1") String field1, @PathVariable( "field2") String field2) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelExample01>  result = loadByIdDeepWorker( context, field1, this.defaultConvertToUtilDate(field2) );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromObject( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadExample01 - getByID - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAll() throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityExample01Facade facade = factory.getEntityExample01Facade();
			BasicDaoResult<ModelExample01> resultFacade = facade.loadAll( context );
			SimpleServiceResult<List<ModelExample01>>  result = SimpleServiceResult.newDefaultResult( resultFacade.getList() );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadExample01 - getAll - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

	/**
	 * Service method to load entity of type ModelExample01.
	 * Property ModelExample01 is being used as filter
	 * 
	 * @param context	DAO context
	 * @param model	Tee value of property ModelExample01 to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelExample01>> loadByModelWorker( DAOContext context, ModelExample01 model ) throws DAOException {
		Example01Finder finder = Example01Finder.newInstance( model );
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityExample01Facade facade = factory.getEntityExample01Facade();
		BasicDaoResult<ModelExample01> resultFacade = facade.loadAllByFinder( context , finder );
		SimpleServiceResult<List<ModelExample01>>  result = SimpleServiceResult.newDefaultResult( resultFacade.getList() );
		return result;
	}

	/**
	 * Service method to load entity of type ModelExample01.
	 * Property field1 is being used as filter
	 * 
	 * @param context	DAO context
	 * @param current	Tee value of property field1 to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelExample01>> loadByField1( DAOContext context, java.lang.String current ) throws DAOException {
		org.fugerit.java.daogen.quickstart.impl.helper.HelperExample01 model = new org.fugerit.java.daogen.quickstart.impl.helper.HelperExample01();
		model.setField1( current );
		SimpleServiceResult<List<ModelExample01>>  result = loadByModelWorker( context , model );
		return result;
	}

	@RequestMapping(value = "/field1/{field1}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAllField1(@PathVariable( "field1" ) String field1) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			String value = field1;
			SimpleServiceResult<List<ModelExample01>>  result = loadByField1( context, value );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadExample01 - getAllField1 - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

	/**
	 * Service method to load entity of type ModelExample01.
	 * Property field3 is being used as filter
	 * 
	 * @param context	DAO context
	 * @param current	Tee value of property field3 to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelExample01>> loadByField3( DAOContext context, java.lang.String current ) throws DAOException {
		org.fugerit.java.daogen.quickstart.impl.helper.HelperExample01 model = new org.fugerit.java.daogen.quickstart.impl.helper.HelperExample01();
		model.setField3( current );
		SimpleServiceResult<List<ModelExample01>>  result = loadByModelWorker( context , model );
		return result;
	}

	@RequestMapping(value = "/field3/{field3}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAllField3(@PathVariable( "field3" ) String field3) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			String value = field3;
			SimpleServiceResult<List<ModelExample01>>  result = loadByField3( context, value );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadExample01 - getAllField3 - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

}
