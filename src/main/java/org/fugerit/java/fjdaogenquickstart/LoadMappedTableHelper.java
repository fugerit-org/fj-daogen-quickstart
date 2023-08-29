package org.fugerit.java.fjdaogenquickstart;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.core.db.daogen.BasicDaoResult;
import org.fugerit.java.core.db.daogen.CloseableDAOContext;
import org.fugerit.java.core.db.daogen.DAOContext;
import org.fugerit.java.core.db.daogen.SimpleServiceResult;
import org.fugerit.java.daogen.quickstart.def.facade.EntityMappedTableFacade;
import org.fugerit.java.daogen.quickstart.def.facade.MappedTableFinder;
import org.fugerit.java.daogen.quickstart.def.facade.QuickstartLogicFacade;
import org.fugerit.java.daogen.quickstart.def.model.ModelMappedTable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	private static final long serialVersionUID = 945576504334L;

	public static SimpleServiceResult<ModelMappedTable> loadByIdWorker( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityMappedTableFacade facade = factory.getEntityMappedTableFacade();
		ModelMappedTable model = facade.loadById( context , id );
		SimpleServiceResult<ModelMappedTable>  result = SimpleServiceResult.newDefaultResult( model );
		return result;
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getByID(@PathVariable( "id") String id) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelMappedTable>  result = loadByIdWorker( context, new java.math.BigDecimal(id) );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromObject( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadMappedTable - getByID - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
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

	@RequestMapping(value = "/deep/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getByIDdeep(@PathVariable( "id") String id) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelMappedTable>  result = loadByIdDeepWorker( context, new java.math.BigDecimal(id) );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromObject( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadMappedTable - getByID - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAll() throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityMappedTableFacade facade = factory.getEntityMappedTableFacade();
			BasicDaoResult<ModelMappedTable> resultFacade = facade.loadAll( context );
			SimpleServiceResult<List<ModelMappedTable>>  result = SimpleServiceResult.newDefaultResult( resultFacade.getList() );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadMappedTable - getAll - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
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

	@RequestMapping(value = "/content/{content}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAllContent(@PathVariable( "content" ) String content) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			String value = content;
			SimpleServiceResult<List<ModelMappedTable>>  result = loadByContent( context, value );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadMappedTable - getAllContent - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

}
