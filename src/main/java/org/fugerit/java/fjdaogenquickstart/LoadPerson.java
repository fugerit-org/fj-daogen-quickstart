package org.fugerit.java.fjdaogenquickstart;

import javax.servlet.http.HttpServletResponse;

import org.fugerit.java.core.db.daogen.CloseableDAOContext;
import org.fugerit.java.core.db.daogen.SimpleServiceResult;
import org.fugerit.java.daogen.quickstart.def.model.ModelPerson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * LoadPerson, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
@RestController
@RequestMapping("/person/load")
public class LoadPerson extends LoadPersonHelper {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final long serialVersionUID = 485519845436L;

	@GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> getByID(@PathVariable( "id") String id) throws Exception {
		ResponseEntity<Object> res = null;
		try (CloseableDAOContext context = this.newDefaultContext() ) {
			SimpleServiceResult<ModelPerson>  result = loadByIdWorker( context, new java.math.BigDecimal(id) );
			res = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( result.getContent() );
		} catch(Exception e) {
			logger.error("ERRORE - REST- LoadPerson - getByID - "+e, e );
			res = ResponseEntity.status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
		return res;
	}

	
	// [HELPER/IMPL MODEL] this class is a stub and can be modified as you see fit (it will not been overwritten)
}
