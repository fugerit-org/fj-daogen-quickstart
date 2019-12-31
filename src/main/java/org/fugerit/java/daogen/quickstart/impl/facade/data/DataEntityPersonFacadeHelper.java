package org.fugerit.java.daogen.quickstart.impl.facade.data;

import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.core.db.daogen.BasicDAOHelper;
import org.fugerit.java.core.db.daogen.BasicDaoResult;
import org.fugerit.java.core.db.daogen.BasicDataFacade;
import org.fugerit.java.core.db.daogen.DAOContext;
import org.fugerit.java.core.db.daogen.DeleteHelper;
import org.fugerit.java.core.db.daogen.InsertHelper;
import org.fugerit.java.core.db.daogen.SelectHelper;
import org.fugerit.java.core.db.daogen.UpdateHelper;
import org.fugerit.java.daogen.quickstart.def.facade.EntityPersonFacadeHelper;
import org.fugerit.java.daogen.quickstart.def.facade.PersonFinder;
import org.fugerit.java.daogen.quickstart.def.model.ModelPerson;
import org.fugerit.java.daogen.quickstart.impl.rse.PersonRSE;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * DataEntityPersonFacadeHelper, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class DataEntityPersonFacadeHelper extends BasicDataFacade<ModelPerson> implements EntityPersonFacadeHelper {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final long serialVersionUID = 725013410722L;

	public DataEntityPersonFacadeHelper() {
		super( "PUBLIC.DAOGEN_QUICKSTART.PERSON", PersonRSE.DEFAULT );
	}

 	public final static String SEQUENCE_NAME = "quickstart_id";

 	@Override
 	public String getSequenceName() {
 		return SEQUENCE_NAME;
 	}

 	public final static String COL_ID = "ID";
 	public final static String COL_SURNAME = "SURNAME";
 	public final static String COL_NAME = "NAME";
 	public final static String COL_BIRTH_DATE = "BIRTH_DATE";
 	public final static String COL_NOTE = "NOTE";
 	public final static String COL_ID_MOTHER = "ID_MOTHER";
 	public final static String COL_ID_FATHER = "ID_FATHER";

	/* loadAll( context ) is inherited from BasicDataFacade */

	@Override
	public BasicDaoResult<ModelPerson> loadAllByFinder( DAOContext context, PersonFinder finder ) throws DAOException {
		BasicDaoResult<ModelPerson> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelPerson> daoHelper = new BasicDAOHelper<>( context );
		SelectHelper query = daoHelper.newSelectHelper( this.getTableName() );
		query.andEqualParam( COL_ID, finder.getId() );
		if ( finder.getModel() != null ) {
			ModelPerson model = finder.getModel();
			query.andEqualParam( COL_ID, model.getId() );
			query.andEqualParam( COL_SURNAME, model.getSurname() );
			query.andEqualParam( COL_NAME, model.getName() );
			query.andEqualParam( COL_BIRTH_DATE, model.getBirthDate() );
			query.andEqualParam( COL_NOTE, model.getNote() );
			query.andEqualParam( COL_ID_MOTHER, model.getIdMother() );
			query.andEqualParam( COL_ID_FATHER, model.getIdFather() );
		}
		daoHelper.loadAllHelper( result.getList(), query, this.getRse() ); 
		result.evaluateResultFromList(); 
		return result;
	}

	@Override
	public BasicDaoResult<ModelPerson> create( DAOContext context, ModelPerson model ) throws DAOException {
		BasicDaoResult<ModelPerson> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelPerson> daoHelper = new BasicDAOHelper<>( context );
		if ( model.getId() == null ) { 
			model.setId( this.generateId( context ) ); 
		} 
		InsertHelper query = daoHelper.newInsertHelper( this.getTableName() );
		query.addParam( COL_ID, model.getId() );
		query.addParam( COL_SURNAME, model.getSurname() );
		query.addParam( COL_NAME, model.getName() );
		query.addParam( COL_BIRTH_DATE, model.getBirthDate() );
		query.addParam( COL_NOTE, model.getNote() );
		query.addParam( COL_ID_MOTHER, model.getIdMother() );
		query.addParam( COL_ID_FATHER, model.getIdFather() );
		int res = daoHelper.update( query );
		this.evaluteSqlUpdateResult(res, model, result);
		return result;
	}

	@Override
	public ModelPerson loadById( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		ModelPerson result = null;
		BasicDAOHelper<ModelPerson> daoHelper = new BasicDAOHelper<>( context );
		SelectHelper query = daoHelper.newSelectHelper( this.getTableName() );
		query.andEqualParam( COL_ID, id );
		result = daoHelper.loadOneHelper( query, this.getRse() );
		return result;
	}

	@Override
	public BasicDaoResult<ModelPerson> deleteById( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		BasicDaoResult<ModelPerson> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelPerson> daoHelper = new BasicDAOHelper<>( context );
		DeleteHelper query = daoHelper.newDeleteHelper( this.getTableName() );
		query.andWhereParam( COL_ID, id );
		int res = daoHelper.update( query );
		this.evaluteSqlUpdateResult(res, null, result);
		return result;
	}

	@Override
	public BasicDaoResult<ModelPerson> updateById( DAOContext context, ModelPerson model ) throws DAOException {
		BasicDaoResult<ModelPerson> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelPerson> daoHelper = new BasicDAOHelper<>( context );
		UpdateHelper query = daoHelper.newUpdateHelper( this.getTableName() );
		query.addSetParam( COL_SURNAME, model.getSurname() );
		query.addSetParam( COL_NAME, model.getName() );
		query.addSetParam( COL_BIRTH_DATE, model.getBirthDate() );
		query.addSetParam( COL_NOTE, model.getNote() );
		query.addSetParam( COL_ID_MOTHER, model.getIdMother() );
		query.addSetParam( COL_ID_FATHER, model.getIdFather() );
		query.andWhereParam( COL_ID, model.getId() );
		int res = daoHelper.update( query );
		this.evaluteSqlUpdateResult(res, model, result);
		return result;
	}

}
