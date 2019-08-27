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
import org.fugerit.java.daogen.quickstart.def.facade.DocumentFinder;
import org.fugerit.java.daogen.quickstart.def.facade.EntityDocumentFacade;
import org.fugerit.java.daogen.quickstart.def.model.ModelDocument;
import org.fugerit.java.daogen.quickstart.impl.rse.DocumentRSE;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * DataEntityDocumentFacade, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class DataEntityDocumentFacade extends BasicDataFacade<ModelDocument> implements EntityDocumentFacade {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final long serialVersionUID = 542106186925L;

	public DataEntityDocumentFacade() {
		super( "PUBLIC.DAOGEN_QUICKSTART.DOCUMENT", DocumentRSE.DEFAULT );
	}

 	public final static String SEQUENCE_NAME = "quickstart_id";

 	@Override
 	public String getSequenceName() {
 		return SEQUENCE_NAME;
 	}

 	public final static String COL_ID = "ID";
 	public final static String COL_ID_OWNER = "ID_OWNER";
 	public final static String COL_ID_CREATOR = "ID_CREATOR";
 	public final static String COL_CREATION_DATE = "CREATION_DATE";
 	public final static String COL_UPDATE_DATE = "UPDATE_DATE";
 	public final static String COL_PATH = "PATH";
 	public final static String COL_STATE = "STATE";
 	public final static String COL_INFO = "INFO";

	/* loadAll( context ) is inherited from BasicDataFacade */

	@Override
	public BasicDaoResult<ModelDocument> loadAllByFinder( DAOContext context, DocumentFinder finder ) throws DAOException {
		BasicDaoResult<ModelDocument> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelDocument> daoHelper = new BasicDAOHelper<>( context );
		SelectHelper query = daoHelper.newSelectHelper( this.getTableName() );
		query.andEqualParam( COL_ID, finder.getId() );
		if ( finder.getModel() != null ) {
			ModelDocument model = finder.getModel();
			query.andEqualParam( COL_ID, model.getId() );
			query.andEqualParam( COL_ID_OWNER, model.getIdOwner() );
			query.andEqualParam( COL_ID_CREATOR, model.getIdCreator() );
			query.andEqualParam( COL_CREATION_DATE, model.getCreationDate() );
			query.andEqualParam( COL_UPDATE_DATE, model.getUpdateDate() );
			query.andEqualParam( COL_PATH, model.getPath() );
			query.andEqualParam( COL_STATE, model.getState() );
			query.andEqualParam( COL_INFO, model.getInfo() );
		}
		daoHelper.loadAllHelper( result.getList(), query, this.getRse() ); 
		return result;
	}

	@Override
	public BasicDaoResult<ModelDocument> create( DAOContext context, ModelDocument model ) throws DAOException {
		BasicDaoResult<ModelDocument> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelDocument> daoHelper = new BasicDAOHelper<>( context );
		if ( model.getId() == null ) { 
			model.setId( this.generateId( context ) ); 
		} 
		InsertHelper query = daoHelper.newInsertHelper( this.getTableName() );
		query.addParam( COL_ID, model.getId() );
		query.addParam( COL_ID_OWNER, model.getIdOwner() );
		query.addParam( COL_ID_CREATOR, model.getIdCreator() );
		query.addParam( COL_CREATION_DATE, model.getCreationDate() );
		query.addParam( COL_UPDATE_DATE, model.getUpdateDate() );
		query.addParam( COL_PATH, model.getPath() );
		query.addParam( COL_STATE, model.getState() );
		query.addParam( COL_INFO, model.getInfo() );
		int res = daoHelper.update( query );
		this.evaluteSqlUpdateResult(res, model, result);
		return result;
	}

	@Override
	public ModelDocument loadById( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		ModelDocument result = null;
		BasicDAOHelper<ModelDocument> daoHelper = new BasicDAOHelper<>( context );
		SelectHelper query = daoHelper.newSelectHelper( this.getTableName() );
		query.andEqualParam( COL_ID, id );
		result = daoHelper.loadOneHelper( query, this.getRse() );
		return result;
	}

	@Override
	public BasicDaoResult<ModelDocument> deleteById( DAOContext context, java.math.BigDecimal id ) throws DAOException {
		BasicDaoResult<ModelDocument> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelDocument> daoHelper = new BasicDAOHelper<>( context );
		DeleteHelper query = daoHelper.newDeleteHelper( this.getTableName() );
		query.andWhereParam( COL_ID, id );
		int res = daoHelper.update( query );
		this.evaluteSqlUpdateResult(res, null, result);
		return result;
	}

	@Override
	public BasicDaoResult<ModelDocument> updateById( DAOContext context, ModelDocument model ) throws DAOException {
		BasicDaoResult<ModelDocument> result = new BasicDaoResult<>();
		BasicDAOHelper<ModelDocument> daoHelper = new BasicDAOHelper<>( context );
		UpdateHelper query = daoHelper.newUpdateHelper( this.getTableName() );
		query.addSetParam( COL_ID_OWNER, model.getIdOwner() );
		query.addSetParam( COL_ID_CREATOR, model.getIdCreator() );
		query.addSetParam( COL_CREATION_DATE, model.getCreationDate() );
		query.addSetParam( COL_UPDATE_DATE, model.getUpdateDate() );
		query.addSetParam( COL_PATH, model.getPath() );
		query.addSetParam( COL_STATE, model.getState() );
		query.addSetParam( COL_INFO, model.getInfo() );
		query.andWhereParam( COL_ID, model.getId() );
		int res = daoHelper.update( query );
		this.evaluteSqlUpdateResult(res, model, result);
		return result;
	}

}
