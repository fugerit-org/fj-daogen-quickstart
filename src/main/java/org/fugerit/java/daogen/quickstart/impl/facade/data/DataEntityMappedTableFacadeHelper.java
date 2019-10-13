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
import org.fugerit.java.daogen.quickstart.def.facade.EntityMappedTableFacadeHelper;
import org.fugerit.java.daogen.quickstart.def.facade.MappedTableFinder;
import org.fugerit.java.daogen.quickstart.def.model.ModelMappedTable;
import org.fugerit.java.daogen.quickstart.impl.rse.MappedTableRSE;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * DataEntityMappedTableFacadeHelper, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class DataEntityMappedTableFacadeHelper extends BasicDataFacade<ModelMappedTable> implements EntityMappedTableFacadeHelper {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final long serialVersionUID = 222193553767L;

	public DataEntityMappedTableFacadeHelper() {
		super( "PUBLIC.DAOGEN_QUICKSTART.SAMPLE_MAP_TABLE", MappedTableRSE.DEFAULT );
	}

 	public final static String SEQUENCE_NAME = "quickstart_id";

 	@Override
 	public String getSequenceName() {
 		return SEQUENCE_NAME;
 	}

 	public final static String COL_ID = "ID";
 	public final static String COL_CONTENT = "CONTENT";

	/* loadAll( context ) is inherited from BasicDataFacade */

	@Override
	public BasicDaoResult<ModelMappedTable> loadAllByFinder( DAOContext context, MappedTableFinder finder ) throws DAOException {
		BasicDaoResult<ModelMappedTable> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelMappedTable> daoHelper = new BasicDAOHelper<>( context );
		SelectHelper query = daoHelper.newSelectHelper( this.getTableName() );
		query.andEqualParam( COL_ID, finder.getId() );
		if ( finder.getModel() != null ) {
			ModelMappedTable model = finder.getModel();
			query.andEqualParam( COL_ID, model.getId() );
			query.andEqualParam( COL_CONTENT, model.getContent() );
		}
		daoHelper.loadAllHelper( result.getList(), query, this.getRse() ); 
		result.evaluateResultFromList(); 
		return result;
	}

	@Override
	public BasicDaoResult<ModelMappedTable> create( DAOContext context, ModelMappedTable model ) throws DAOException {
		BasicDaoResult<ModelMappedTable> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelMappedTable> daoHelper = new BasicDAOHelper<>( context );
		if ( model.getId() == null ) { 
			model.setId( this.generateId( context ) ); 
		} 
		InsertHelper query = daoHelper.newInsertHelper( this.getTableName() );
		query.addParam( COL_ID, model.getId() );
		query.addParam( COL_CONTENT, model.getContent() );
		int res = daoHelper.update( query );
		this.evaluteSqlUpdateResult(res, model, result);
		return result;
	}

	@Override
	public ModelMappedTable loadById( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		ModelMappedTable result = null;
		BasicDAOHelper<ModelMappedTable> daoHelper = new BasicDAOHelper<>( context );
		SelectHelper query = daoHelper.newSelectHelper( this.getTableName() );
		query.andEqualParam( COL_ID, id );
		result = daoHelper.loadOneHelper( query, this.getRse() );
		return result;
	}

	@Override
	public BasicDaoResult<ModelMappedTable> deleteById( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		BasicDaoResult<ModelMappedTable> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelMappedTable> daoHelper = new BasicDAOHelper<>( context );
		DeleteHelper query = daoHelper.newDeleteHelper( this.getTableName() );
		query.andWhereParam( COL_ID, id );
		int res = daoHelper.update( query );
		this.evaluteSqlUpdateResult(res, null, result);
		return result;
	}

	@Override
	public BasicDaoResult<ModelMappedTable> updateById( DAOContext context, ModelMappedTable model ) throws DAOException {
		BasicDaoResult<ModelMappedTable> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelMappedTable> daoHelper = new BasicDAOHelper<>( context );
		UpdateHelper query = daoHelper.newUpdateHelper( this.getTableName() );
		query.addSetParam( COL_CONTENT, model.getContent() );
		query.andWhereParam( COL_ID, model.getId() );
		int res = daoHelper.update( query );
		this.evaluteSqlUpdateResult(res, model, result);
		return result;
	}

}
