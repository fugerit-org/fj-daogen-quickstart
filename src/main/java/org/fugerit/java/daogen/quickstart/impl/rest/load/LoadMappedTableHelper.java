package org.fugerit.java.daogen.quickstart.impl.rest.load;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.core.db.daogen.BasicDaoResult;
import org.fugerit.java.core.db.daogen.CloseableDAOContext;
import org.fugerit.java.core.db.daogen.DAOContext;
import org.fugerit.java.core.db.daogen.SimpleServiceResult;
import org.fugerit.java.daogen.quickstart.def.facade.EntityMappedTableFacade;
import org.fugerit.java.daogen.quickstart.def.facade.MappedTableFinder;
import org.fugerit.java.daogen.quickstart.def.facade.QuickstartLogicFacade;
import org.fugerit.java.daogen.quickstart.def.model.ModelMappedTable;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * LoadMappedTableHelper, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class LoadMappedTableHelper extends org.fugerit.java.daogen.quickstart.config.ServiceProviderHelper<ModelMappedTable> {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final long serialVersionUID = 857124230176L;

	public static SimpleServiceResult<ModelMappedTable> loadByIdWorker( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityMappedTableFacade facade = factory.getEntityMappedTableFacade();
		ModelMappedTable model = facade.loadById( context , id );
		SimpleServiceResult<ModelMappedTable>  result = SimpleServiceResult.newDefaultResult( model );
		return result;
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByID(@PathParam( "id") String id) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelMappedTable>  result = loadByIdWorker( context, new java.math.BigDecimal(id) );
			res = this.createResponseFromObject( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadMappedTable - getByID - "+e, e );
		}
		return res;
	}

	public static SimpleServiceResult<ModelMappedTable> loadByIdDeepWorker( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityMappedTableFacade facade = factory.getEntityMappedTableFacade();
		ModelMappedTable model = facade.loadById( context , id );
		SimpleServiceResult<ModelMappedTable>  result = SimpleServiceResult.newDefaultResult( model );
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
			SimpleServiceResult<ModelMappedTable>  result = loadByIdDeepWorker( context, new java.math.BigDecimal(id) );
			res = this.createResponseFromObject( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadMappedTable - getByID - "+e, e );
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
		EntityMappedTableFacade facade = factory.getEntityMappedTableFacade();
			BasicDaoResult<ModelMappedTable> resultFacade = facade.loadAll( context );
			SimpleServiceResult<List<ModelMappedTable>>  result = SimpleServiceResult.newDefaultResult( resultFacade.getList() );
			res = this.createResponseFromList( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadMappedTable - getAll - "+e, e );
		}
		return res;
	}

	/**
	 * Service method to load entity of type ModelMappedTable.
	 * Property ModelMappedTable is being used as filter
	 * 
	 * @param context	DAO context
	 * @param model	Tee value of property ModelMappedTable to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelMappedTable>> loadByModelWorker( DAOContext context, ModelMappedTable model ) throws DAOException {
		MappedTableFinder finder = MappedTableFinder.newInstance( model );
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityMappedTableFacade facade = factory.getEntityMappedTableFacade();
		BasicDaoResult<ModelMappedTable> resultFacade = facade.loadAllByFinder( context , finder );
		SimpleServiceResult<List<ModelMappedTable>>  result = SimpleServiceResult.newDefaultResult( resultFacade.getList() );
		return result;
	}

	/**
	 * Service method to load entity of type ModelMappedTable.
	 * Property content is being used as filter
	 * 
	 * @param context	DAO context
	 * @param current	Tee value of property content to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelMappedTable>> loadByContent( DAOContext context, java.lang.String current ) throws DAOException {
		org.fugerit.java.daogen.quickstart.impl.helper.HelperMappedTable model = new org.fugerit.java.daogen.quickstart.impl.helper.HelperMappedTable();
		model.setContent( current );
		SimpleServiceResult<List<ModelMappedTable>>  result = loadByModelWorker( context , model );
		return result;
	}

	@GET
	@Path("/content/{content}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllContent(@PathParam( "content" ) String content) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			String value = content;
			SimpleServiceResult<List<ModelMappedTable>>  result = loadByContent( context, value );
			res = this.createResponseFromList( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadMappedTable - getAllContent - "+e, e );
		}
		return res;
	}

}
