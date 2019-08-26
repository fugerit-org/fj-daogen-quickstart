package org.fugerit.java.daogen.quickstart.impl.rest.load;

import org.fugerit.java.daogen.quickstart.def.model.ModelDocument;
import javax.ejb.Stateless;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import org.fugerit.java.core.db.daogen.CloseableDAOContext;
import javax.ws.rs.Path;
import org.fugerit.java.daogen.quickstart.def.facade.EntityDocumentFacade;
import org.fugerit.java.core.db.daogen.BasicDaoResult;
import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.daogen.quickstart.def.facade.QuickstartLogicFacade;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.fugerit.java.daogen.quickstart.def.facade.DocumentFinder;
import org.fugerit.java.daogen.quickstart.impl.helper.HelperDocument;
import org.fugerit.java.core.db.daogen.SimpleServiceResult;
import org.fugerit.java.core.db.daogen.DAOContext;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * LoadDocument, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
@Stateless
@Path("/document/load")
public class LoadDocument extends org.fugerit.java.daogen.quickstart.config.ServiceProviderHelper<ModelDocument> {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final long serialVersionUID = 601474428409L;

	public static SimpleServiceResult<ModelDocument> loadByIdWorker( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityDocumentFacade facade = factory.getEntityDocumentFacade();
		ModelDocument model = facade.loadById( context , id );
		SimpleServiceResult<ModelDocument>  result = SimpleServiceResult.newDefaultResult( model );
		return result;
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByID(@PathParam( "id") String id) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelDocument>  result = loadByIdWorker( context, new java.math.BigDecimal(id) );
			res = this.createResponseFromObject( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getByID - "+e, e );
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

	@GET
	@Path("/deep/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByIDdeep(@PathParam( "id") String id) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelDocument>  result = loadByIdDeepWorker( context, new java.math.BigDecimal(id) );
			res = this.createResponseFromObject( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getByID - "+e, e );
		}
		return res;
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityDocumentFacade facade = factory.getEntityDocumentFacade();
			BasicDaoResult<ModelDocument> resultFacade = facade.loadAll( context );
			SimpleServiceResult<List<ModelDocument>>  result = SimpleServiceResult.newDefaultResult( resultFacade.getList() );
			res = this.createResponseFromList( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getAll - "+e, e );
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
		HelperDocument model = new HelperDocument();
		model.setIdOwner( current );
		SimpleServiceResult<List<ModelDocument>>  result = loadByModelWorker( context , model );
		return result;
	}

	@GET
	@Path("/id_owner/{id_owner}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllIdOwner(@PathParam( "id_owner" ) String idOwner) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			java.math.BigDecimal value = new java.math.BigDecimal(idOwner);
			SimpleServiceResult<List<ModelDocument>>  result = loadByIdOwner( context, value );
			res = this.createResponseFromList( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getAllIdOwner - "+e, e );
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
		HelperDocument model = new HelperDocument();
		model.setIdCreator( current );
		SimpleServiceResult<List<ModelDocument>>  result = loadByModelWorker( context , model );
		return result;
	}

	@GET
	@Path("/id_creator/{id_creator}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllIdCreator(@PathParam( "id_creator" ) String idCreator) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			java.math.BigDecimal value = new java.math.BigDecimal(idCreator);
			SimpleServiceResult<List<ModelDocument>>  result = loadByIdCreator( context, value );
			res = this.createResponseFromList( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getAllIdCreator - "+e, e );
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
		HelperDocument model = new HelperDocument();
		model.setPath( current );
		SimpleServiceResult<List<ModelDocument>>  result = loadByModelWorker( context , model );
		return result;
	}

	@GET
	@Path("/path/{path}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPath(@PathParam( "path" ) String path) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			String value = path;
			SimpleServiceResult<List<ModelDocument>>  result = loadByPath( context, value );
			res = this.createResponseFromList( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getAllPath - "+e, e );
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
		HelperDocument model = new HelperDocument();
		model.setState( current );
		SimpleServiceResult<List<ModelDocument>>  result = loadByModelWorker( context , model );
		return result;
	}

	@GET
	@Path("/state/{state}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllState(@PathParam( "state" ) String state) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			java.math.BigDecimal value = new java.math.BigDecimal(state);
			SimpleServiceResult<List<ModelDocument>>  result = loadByState( context, value );
			res = this.createResponseFromList( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadDocument - getAllState - "+e, e );
		}
		return res;
	}

}
