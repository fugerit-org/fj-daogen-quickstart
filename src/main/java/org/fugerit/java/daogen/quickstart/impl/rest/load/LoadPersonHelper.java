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
import org.fugerit.java.daogen.quickstart.def.facade.EntityPersonFacade;
import org.fugerit.java.daogen.quickstart.def.facade.PersonFinder;
import org.fugerit.java.daogen.quickstart.def.facade.QuickstartLogicFacade;
import org.fugerit.java.daogen.quickstart.def.model.ModelPerson;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * LoadPersonHelper, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class LoadPersonHelper extends org.fugerit.java.daogen.quickstart.config.ServiceProviderHelper<ModelPerson> {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final long serialVersionUID = 244086910135L;

	public static SimpleServiceResult<ModelPerson> loadByIdWorker( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityPersonFacade facade = factory.getEntityPersonFacade();
		ModelPerson model = facade.loadById( context , id );
		SimpleServiceResult<ModelPerson>  result = SimpleServiceResult.newDefaultResult( model );
		return result;
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByID(@PathParam( "id") String id) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelPerson>  result = loadByIdWorker( context, new java.math.BigDecimal(id) );
			res = this.createResponseFromObject( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getByID - "+e, e );
		}
		return res;
	}

	public static SimpleServiceResult<ModelPerson> loadByIdDeepWorker( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityPersonFacade facade = factory.getEntityPersonFacade();
		ModelPerson model = facade.loadById( context , id );
		SimpleServiceResult<ModelPerson>  result = SimpleServiceResult.newDefaultResult( model );
		if ( result.getContent() != null ) {
			result.getContent().setMother(LoadPerson.loadByIdWorker( context, result.getContent().getIdMother() ).getContent());
			result.getContent().setFather(LoadPerson.loadByIdWorker( context, result.getContent().getIdFather() ).getContent());
			result.getContent().setOwndocuments(LoadDocument.loadByIdOwner( context, result.getContent().getId() ).getContent());
		}
		return result;
	}

	@GET
	@Path("/deep/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByIDdeep(@PathParam( "id") String id) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelPerson>  result = loadByIdDeepWorker( context, new java.math.BigDecimal(id) );
			res = this.createResponseFromObject( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getByID - "+e, e );
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
		EntityPersonFacade facade = factory.getEntityPersonFacade();
			BasicDaoResult<ModelPerson> resultFacade = facade.loadAll( context );
			SimpleServiceResult<List<ModelPerson>>  result = SimpleServiceResult.newDefaultResult( resultFacade.getList() );
			res = this.createResponseFromList( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getAll - "+e, e );
		}
		return res;
	}

	/**
	 * Service method to load entity of type ModelPerson.
	 * Property ModelPerson is being used as filter
	 * 
	 * @param context	DAO context
	 * @param model	Tee value of property ModelPerson to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelPerson>> loadByModelWorker( DAOContext context, ModelPerson model ) throws DAOException {
		PersonFinder finder = PersonFinder.newInstance( model );
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityPersonFacade facade = factory.getEntityPersonFacade();
		BasicDaoResult<ModelPerson> resultFacade = facade.loadAllByFinder( context , finder );
		SimpleServiceResult<List<ModelPerson>>  result = SimpleServiceResult.newDefaultResult( resultFacade.getList() );
		return result;
	}

	/**
	 * Service method to load entity of type ModelPerson.
	 * Property surname is being used as filter
	 * 
	 * @param context	DAO context
	 * @param current	Tee value of property surname to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelPerson>> loadBySurname( DAOContext context, java.lang.String current ) throws DAOException {
		org.fugerit.java.daogen.quickstart.impl.helper.HelperPerson model = new org.fugerit.java.daogen.quickstart.impl.helper.HelperPerson();
		model.setSurname( current );
		SimpleServiceResult<List<ModelPerson>>  result = loadByModelWorker( context , model );
		return result;
	}

	@GET
	@Path("/surname/{surname}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSurname(@PathParam( "surname" ) String surname) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			String value = surname;
			SimpleServiceResult<List<ModelPerson>>  result = loadBySurname( context, value );
			res = this.createResponseFromList( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getAllSurname - "+e, e );
		}
		return res;
	}

	/**
	 * Service method to load entity of type ModelPerson.
	 * Property name is being used as filter
	 * 
	 * @param context	DAO context
	 * @param current	Tee value of property name to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelPerson>> loadByName( DAOContext context, java.lang.String current ) throws DAOException {
		org.fugerit.java.daogen.quickstart.impl.helper.HelperPerson model = new org.fugerit.java.daogen.quickstart.impl.helper.HelperPerson();
		model.setName( current );
		SimpleServiceResult<List<ModelPerson>>  result = loadByModelWorker( context , model );
		return result;
	}

	@GET
	@Path("/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllName(@PathParam( "name" ) String name) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			String value = name;
			SimpleServiceResult<List<ModelPerson>>  result = loadByName( context, value );
			res = this.createResponseFromList( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getAllName - "+e, e );
		}
		return res;
	}

	/**
	 * Service method to load entity of type ModelPerson.
	 * Property note is being used as filter
	 * 
	 * @param context	DAO context
	 * @param current	Tee value of property note to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelPerson>> loadByNote( DAOContext context, java.lang.String current ) throws DAOException {
		org.fugerit.java.daogen.quickstart.impl.helper.HelperPerson model = new org.fugerit.java.daogen.quickstart.impl.helper.HelperPerson();
		model.setNote( current );
		SimpleServiceResult<List<ModelPerson>>  result = loadByModelWorker( context , model );
		return result;
	}

	@GET
	@Path("/note/{note}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllNote(@PathParam( "note" ) String note) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			String value = note;
			SimpleServiceResult<List<ModelPerson>>  result = loadByNote( context, value );
			res = this.createResponseFromList( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getAllNote - "+e, e );
		}
		return res;
	}

	/**
	 * Service method to load entity of type ModelPerson.
	 * Property idMother is being used as filter
	 * 
	 * @param context	DAO context
	 * @param current	Tee value of property idMother to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelPerson>> loadByIdMother( DAOContext context, java.math.BigDecimal current ) throws DAOException {
		org.fugerit.java.daogen.quickstart.impl.helper.HelperPerson model = new org.fugerit.java.daogen.quickstart.impl.helper.HelperPerson();
		model.setIdMother( current );
		SimpleServiceResult<List<ModelPerson>>  result = loadByModelWorker( context , model );
		return result;
	}

	@GET
	@Path("/id_mother/{id_mother}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllIdMother(@PathParam( "id_mother" ) String idMother) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			java.math.BigDecimal value = new java.math.BigDecimal(idMother);
			SimpleServiceResult<List<ModelPerson>>  result = loadByIdMother( context, value );
			res = this.createResponseFromList( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getAllIdMother - "+e, e );
		}
		return res;
	}

	/**
	 * Service method to load entity of type ModelPerson.
	 * Property idFather is being used as filter
	 * 
	 * @param context	DAO context
	 * @param current	Tee value of property idFather to use as a filter
	 * @return			the result found
	 * @throws DAOException		in case of any issue
	 */
	public static SimpleServiceResult<List<ModelPerson>> loadByIdFather( DAOContext context, java.math.BigDecimal current ) throws DAOException {
		org.fugerit.java.daogen.quickstart.impl.helper.HelperPerson model = new org.fugerit.java.daogen.quickstart.impl.helper.HelperPerson();
		model.setIdFather( current );
		SimpleServiceResult<List<ModelPerson>>  result = loadByModelWorker( context , model );
		return result;
	}

	@GET
	@Path("/id_father/{id_father}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllIdFather(@PathParam( "id_father" ) String idFather) throws Exception {
		Response res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			java.math.BigDecimal value = new java.math.BigDecimal(idFather);
			SimpleServiceResult<List<ModelPerson>>  result = loadByIdFather( context, value );
			res = this.createResponseFromList( result );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getAllIdFather - "+e, e );
		}
		return res;
	}

}
