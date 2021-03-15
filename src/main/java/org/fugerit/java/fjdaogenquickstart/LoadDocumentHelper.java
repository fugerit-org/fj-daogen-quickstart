package org.fugerit.java.fjdaogenquickstart;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.core.db.daogen.BasicDaoResult;
import org.fugerit.java.core.db.daogen.CloseableDAOContext;
import org.fugerit.java.core.db.daogen.DAOContext;
import org.fugerit.java.core.db.daogen.SimpleServiceResult;
import org.fugerit.java.daogen.quickstart.def.facade.DocumentFinder;
import org.fugerit.java.daogen.quickstart.def.facade.EntityDocumentFacade;
import org.fugerit.java.daogen.quickstart.def.facade.QuickstartLogicFacade;
import org.fugerit.java.daogen.quickstart.def.model.ModelDocument;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * LoadDocumentHelper, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class LoadDocumentHelper extends org.fugerit.java.daogen.quickstart.config.ServiceProviderHelper<ModelDocument> {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final long serialVersionUID = 272342896197L;

	public static SimpleServiceResult<ModelDocument> loadByIdWorker( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityDocumentFacade facade = factory.getEntityDocumentFacade();
		ModelDocument model = facade.loadById( context , id );
		SimpleServiceResult<ModelDocument>  result = SimpleServiceResult.newDefaultResult( model );
		return result;
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getByID(@PathVariable( "id") String id) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelDocument>  result = loadByIdWorker( context, new java.math.BigDecimal(id) );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromObject( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getByID - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

	public static SimpleServiceResult<ModelDocument> loadByIdDeepWorker( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityDocumentFacade facade = factory.getEntityDocumentFacade();
		ModelDocument model = facade.loadById( context , id );
		SimpleServiceResult<ModelDocument>  result = SimpleServiceResult.newDefaultResult( model );
		if ( result.getContent() != null ) {
		}
		return result;
	}

	@RequestMapping(value = "/deep/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getByIDdeep(@PathVariable( "id") String id) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelDocument>  result = loadByIdDeepWorker( context, new java.math.BigDecimal(id) );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromObject( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getByID - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAll() throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityDocumentFacade facade = factory.getEntityDocumentFacade();
			BasicDaoResult<ModelDocument> resultFacade = facade.loadAll( context );
			SimpleServiceResult<List<ModelDocument>>  result = SimpleServiceResult.newDefaultResult( resultFacade.getList() );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getAll - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

	/**
	 * Service method to load entity of type ModelDocument.
	 * Property ModelDocument is being used as filter
	 * 
	 * @param context	DAO context
	 * @param model	Tee value of property ModelDocument to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelDocument>> loadByModelWorker( DAOContext context, ModelDocument model ) throws DAOException {
		DocumentFinder finder = DocumentFinder.newInstance( model );
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityDocumentFacade facade = factory.getEntityDocumentFacade();
		BasicDaoResult<ModelDocument> resultFacade = facade.loadAllByFinder( context , finder );
		SimpleServiceResult<List<ModelDocument>>  result = SimpleServiceResult.newDefaultResult( resultFacade.getList() );
		return result;
	}

	/**
	 * Service method to load entity of type ModelDocument.
	 * Property idOwner is being used as filter
	 * 
	 * @param context	DAO context
	 * @param current	Tee value of property idOwner to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelDocument>> loadByIdOwner( DAOContext context, java.math.BigDecimal current ) throws DAOException {
		org.fugerit.java.daogen.quickstart.impl.helper.HelperDocument model = new org.fugerit.java.daogen.quickstart.impl.helper.HelperDocument();
		model.setIdOwner( current );
		SimpleServiceResult<List<ModelDocument>>  result = loadByModelWorker( context , model );
		return result;
	}

	@RequestMapping(value = "/id_owner/{id_owner}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAllIdOwner(@PathVariable( "id_owner" ) String idOwner) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			java.math.BigDecimal value = new java.math.BigDecimal(idOwner);
			SimpleServiceResult<List<ModelDocument>>  result = loadByIdOwner( context, value );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getAllIdOwner - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

	/**
	 * Service method to load entity of type ModelDocument.
	 * Property idCreator is being used as filter
	 * 
	 * @param context	DAO context
	 * @param current	Tee value of property idCreator to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelDocument>> loadByIdCreator( DAOContext context, java.math.BigDecimal current ) throws DAOException {
		org.fugerit.java.daogen.quickstart.impl.helper.HelperDocument model = new org.fugerit.java.daogen.quickstart.impl.helper.HelperDocument();
		model.setIdCreator( current );
		SimpleServiceResult<List<ModelDocument>>  result = loadByModelWorker( context , model );
		return result;
	}

	@RequestMapping(value = "/id_creator/{id_creator}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAllIdCreator(@PathVariable( "id_creator" ) String idCreator) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			java.math.BigDecimal value = new java.math.BigDecimal(idCreator);
			SimpleServiceResult<List<ModelDocument>>  result = loadByIdCreator( context, value );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getAllIdCreator - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

	/**
	 * Service method to load entity of type ModelDocument.
	 * Property path is being used as filter
	 * 
	 * @param context	DAO context
	 * @param current	Tee value of property path to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelDocument>> loadByPath( DAOContext context, java.lang.String current ) throws DAOException {
		org.fugerit.java.daogen.quickstart.impl.helper.HelperDocument model = new org.fugerit.java.daogen.quickstart.impl.helper.HelperDocument();
		model.setPath( current );
		SimpleServiceResult<List<ModelDocument>>  result = loadByModelWorker( context , model );
		return result;
	}

	@RequestMapping(value = "/path/{path}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAllPath(@PathVariable( "path" ) String path) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			String value = path;
			SimpleServiceResult<List<ModelDocument>>  result = loadByPath( context, value );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getAllPath - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

	/**
	 * Service method to load entity of type ModelDocument.
	 * Property state is being used as filter
	 * 
	 * @param context	DAO context
	 * @param current	Tee value of property state to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelDocument>> loadByState( DAOContext context, java.math.BigDecimal current ) throws DAOException {
		org.fugerit.java.daogen.quickstart.impl.helper.HelperDocument model = new org.fugerit.java.daogen.quickstart.impl.helper.HelperDocument();
		model.setState( current );
		SimpleServiceResult<List<ModelDocument>>  result = loadByModelWorker( context , model );
		return result;
	}

	@RequestMapping(value = "/state/{state}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAllState(@PathVariable( "state" ) String state) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			java.math.BigDecimal value = new java.math.BigDecimal(state);
			SimpleServiceResult<List<ModelDocument>>  result = loadByState( context, value );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getAllState - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

}
