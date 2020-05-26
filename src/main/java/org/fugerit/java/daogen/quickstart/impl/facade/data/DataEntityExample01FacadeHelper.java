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
import org.fugerit.java.daogen.quickstart.def.facade.EntityExample01FacadeHelper;
import org.fugerit.java.daogen.quickstart.def.facade.Example01Finder;
import org.fugerit.java.daogen.quickstart.def.model.ModelExample01;
import org.fugerit.java.daogen.quickstart.impl.rse.Example01RSE;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * DataEntityExample01FacadeHelper, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class DataEntityExample01FacadeHelper extends BasicDataFacade<ModelExample01> implements EntityExample01FacadeHelper {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final long serialVersionUID = 341387990861L;

	private final static String TABLE_NAME = "PUBLIC.DAOGEN_QUICKSTART.EXAMPLE_01";

	public DataEntityExample01FacadeHelper() {
		super( TABLE_NAME, Example01RSE.DEFAULT, null );
	}

 	public final static String SEQUENCE_NAME = "quickstart_id";

 	@Override
 	public String getSequenceName() {
 		return SEQUENCE_NAME;
 	}

 	public final static String COL_FIELD1 = "FIELD1";
 	public final static String COL_FIELD2 = "FIELD2";
 	public final static String COL_FIELD3 = "FIELD3";

	/* loadAll( context ) is inherited from BasicDataFacade */

	@Override
	public BasicDaoResult<ModelExample01> loadAllByFinder( DAOContext context, Example01Finder finder ) throws DAOException {
		BasicDaoResult<ModelExample01> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelExample01> daoHelper = new BasicDAOHelper<>( context );
		SelectHelper query = daoHelper.newSelectHelper( this.getQueryView(), this.getTableName() );
		if ( finder.getModel() != null ) {
			ModelExample01 model = finder.getModel();
			query.andEqualParam( COL_FIELD1, model.getField1() );
			query.andEqualParam( COL_FIELD2, model.getField2() );
			query.andEqualParam( COL_FIELD3, model.getField3() );
		}
		daoHelper.loadAllHelper( result.getList(), query, this.getRse() ); 
		result.evaluateResultFromList(); 
		return result;
	}

	@Override
	public BasicDaoResult<ModelExample01> create( DAOContext context, ModelExample01 model ) throws DAOException {
		BasicDaoResult<ModelExample01> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelExample01> daoHelper = new BasicDAOHelper<>( context );
		InsertHelper query = daoHelper.newInsertHelper( this.getTableName() );
		query.addParam( COL_FIELD1, model.getField1() );
		query.addParam( COL_FIELD2, model.getField2() );
		query.addParam( COL_FIELD3, model.getField3() );
		int res = daoHelper.update( query );
		this.evaluteSqlUpdateResult(res, model, result);
		return result;
	}

	@Override
	public ModelExample01 loadById( DAOContext context, java.lang.String field1, java.util.Date field2 ) throws DAOException {
		ModelExample01 result = null;
		BasicDAOHelper<ModelExample01> daoHelper = new BasicDAOHelper<>( context );
		SelectHelper query = daoHelper.newSelectHelper( this.getQueryView(), this.getTableName() );
		query.andEqualParam( COL_FIELD1, field1 );
		query.andEqualParam( COL_FIELD2, field2 );
		result = daoHelper.loadOneHelper( query, this.getRse() );
		return result;
	}

	@Override
	public BasicDaoResult<ModelExample01> deleteById( DAOContext context, java.lang.String field1, java.util.Date field2 ) throws DAOException {
		BasicDaoResult<ModelExample01> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelExample01> daoHelper = new BasicDAOHelper<>( context );
		DeleteHelper query = daoHelper.newDeleteHelper( this.getTableName() );
		query.andWhereParam( COL_FIELD1, field1 );
		query.andWhereParam( COL_FIELD2, field2 );
		int res = daoHelper.update( query );
		this.evaluteSqlUpdateResult(res, null, result);
		return result;
	}

	@Override
	public BasicDaoResult<ModelExample01> updateById( DAOContext context, ModelExample01 model ) throws DAOException {
		BasicDaoResult<ModelExample01> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelExample01> daoHelper = new BasicDAOHelper<>( context );
		UpdateHelper query = daoHelper.newUpdateHelper( this.getTableName() );
		query.addSetParam( COL_FIELD3, model.getField3() );
		query.andWhereParam( COL_FIELD1, model.getField1() );
		query.andWhereParam( COL_FIELD2, model.getField2() );
		int res = daoHelper.update( query );
		this.evaluteSqlUpdateResult(res, model, result);
		return result;
	}

}
