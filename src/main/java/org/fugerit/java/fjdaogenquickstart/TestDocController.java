package org.fugerit.java.fjdaogenquickstart;

import javax.servlet.http.HttpServletResponse;

import org.fugerit.java.core.db.daogen.CloseableDAOContext;
import org.fugerit.java.core.db.daogen.SimpleServiceResult;
import org.fugerit.java.daogen.quickstart.def.model.ModelPerson;
import org.fugerit.java.daogen.quickstart.impl.rest.load.LoadPersonHelper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDocController extends LoadPersonHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5211347388899024831L;

	@RequestMapping(value = "/person/load/id/{id}", 
			method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Object> getSbByID(@PathVariable( "id") String id) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelPerson>  result = loadByIdWorker( context, new java.math.BigDecimal(id) );
			res = ResponseEntity
		                .ok()
		                .contentType(MediaType.APPLICATION_JSON)
		                .body( result );			
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getByID - "+e, e );
			res = ResponseEntity
	                .status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
    }

}
