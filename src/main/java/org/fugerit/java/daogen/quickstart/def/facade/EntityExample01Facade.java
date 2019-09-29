package org.fugerit.java.daogen.quickstart.def.facade;

import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.core.db.daogen.BasicDaoResult;
import org.fugerit.java.core.db.daogen.DAOContext;
import org.fugerit.java.daogen.quickstart.def.model.ModelExample01;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * EntityExample01Facade, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public interface EntityExample01Facade {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	/*
	 * NOTE: It is advised to use a finder for incapsulating search params, except searches for primary key.
	 */

	/**
	 * Method to load all the items for entity : ModelExample01
	 *
	 * @param context	DAOContext
	 *
	 * @return search result
	 * @throws DAOException			in case of errors
	 */
	BasicDaoResult<ModelExample01> loadAll( DAOContext context ) throws DAOException;

	/**
	 * Method to load all the items for entity : ModelExample01
	 *
	 * @param context	DAOContext
	 * @param finder	the finder incapsulating search params
	 *
	 * @return search result
	 * @throws DAOException			in caso di errori
	 */
	BasicDaoResult<ModelExample01> loadAllByFinder( DAOContext context, Example01Finder finder ) throws DAOException;

	/**
	 * Load method by primary key for entity : ModelExample01
	 *
	 * @param context	DAO Context
	 * @param field1 First field of the primary key
	 * @param field2 Second field of the primary key

	 *
	 * @return The found object or <code>null</code>
	 * @throws DAOException			in case of errors
	 */
	ModelExample01 loadById( DAOContext context, java.lang.String field1, java.util.Date field2 ) throws DAOException;

	/**
	 * Method to create an new entity of type : ModelExample01
	 *
	 * A new ID should be assigned by this method.
	 *
	 * @param context	DAO context
	 * @param model		Entity to create
	 *
	 * @return 			The created entity
	 * @throws DAOException		In case of any error.
	 */
	BasicDaoResult<ModelExample01> create( DAOContext context, ModelExample01 model ) throws DAOException;

	/**
	 * Delete method by primary key for entity : ModelExample01
	 *
	 * @param context	DAO Context
	 * @param field1 First field of the primary key
	 * @param field2 Second field of the primary key

	 *
	 * @return Delete result (resultCode=0, delete ok)
	 * @throws DAOException			in case of errors
	 */
	BasicDaoResult<ModelExample01> deleteById( DAOContext context, java.lang.String field1, java.util.Date field2 ) throws DAOException;

	/**
	 * Delete method by primary key for entity : ModelExample01
	 *
	 * @param context	DAO Context
	 * @param 	model	entity to update
	 *
	 * @return Update result (resultCode=0, update ok)
	 * @throws DAOException			in case of errors
	 */
	BasicDaoResult<ModelExample01> updateById( DAOContext context, ModelExample01 model ) throws DAOException;

}
