package org.fugerit.java.fjdaogenquickstart;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.core.db.daogen.BasicDaoResult;
import org.fugerit.java.core.db.daogen.CloseableDAOContext;
import org.fugerit.java.core.db.daogen.DAOContext;
import org.fugerit.java.core.db.daogen.SimpleServiceResult;
import org.fugerit.java.daogen.quickstart.def.facade.EntityPersonFacade;
import org.fugerit.java.daogen.quickstart.def.facade.PersonFinder;
import org.fugerit.java.daogen.quickstart.def.facade.QuickstartLogicFacade;
import org.fugerit.java.daogen.quickstart.def.model.ModelPerson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	private static final long serialVersionUID = 976434324651L;

	public static SimpleServiceResult<ModelPerson> loadByIdWorker( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityPersonFacade facade = factory.getEntityPersonFacade();
		ModelPerson model = facade.loadById( context , id );
		SimpleServiceResult<ModelPerson>  result = SimpleServiceResult.newDefaultResult( model );
		return result;
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getByID(@PathVariable( "id") String id) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelPerson>  result = loadByIdWorker( context, new java.math.BigDecimal(id) );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromObject( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getByID - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
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

	@RequestMapping(value = "/deep/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getByIDdeep(@PathVariable( "id") String id) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelPerson>  result = loadByIdDeepWorker( context, new java.math.BigDecimal(id) );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromObject( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getByID - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAll() throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
		QuickstartLogicFacade factory = (QuickstartLogicFacade) context.getAttribute(QuickstartLogicFacade.ATT_NAME );
		EntityPersonFacade facade = factory.getEntityPersonFacade();
			BasicDaoResult<ModelPerson> resultFacade = facade.loadAll( context );
			SimpleServiceResult<List<ModelPerson>>  result = SimpleServiceResult.newDefaultResult( resultFacade.getList() );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getAll - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
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

	@RequestMapping(value = "/surname/{surname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAllSurname(@PathVariable( "surname" ) String surname) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			String value = surname;
			SimpleServiceResult<List<ModelPerson>>  result = loadBySurname( context, value );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getAllSurname - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
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

	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAllName(@PathVariable( "name" ) String name) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			String value = name;
			SimpleServiceResult<List<ModelPerson>>  result = loadByName( context, value );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getAllName - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
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

	@RequestMapping(value = "/note/{note}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAllNote(@PathVariable( "note" ) String note) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			String value = note;
			SimpleServiceResult<List<ModelPerson>>  result = loadByNote( context, value );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getAllNote - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
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

	@RequestMapping(value = "/id_mother/{id_mother}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAllIdMother(@PathVariable( "id_mother" ) String idMother) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			java.math.BigDecimal value = new java.math.BigDecimal(idMother);
			SimpleServiceResult<List<ModelPerson>>  result = loadByIdMother( context, value );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getAllIdMother - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
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

	@RequestMapping(value = "/id_father/{id_father}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getAllIdFather(@PathVariable( "id_father" ) String idFather) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			java.math.BigDecimal value = new java.math.BigDecimal(idFather);
			SimpleServiceResult<List<ModelPerson>>  result = loadByIdFather( context, value );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( this.createResultFromList( result ) );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getAllIdFather - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

}
