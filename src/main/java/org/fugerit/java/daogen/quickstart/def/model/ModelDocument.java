package org.fugerit.java.daogen.quickstart.def.model;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * ModelDocument, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public interface ModelDocument {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	/**
	 * Getter method for property : id (nullable: no)
	 *
	 * 
	 *
	 * @return the value of id
	 */
	java.math.BigDecimal getId();

	/**
	 * Setter method for property : id (nullable: no)
	 *
	 * 
	 *
	 * @param value the value of id
	 */
	void setId( java.math.BigDecimal value );

	/**
	 * Getter method for property : idOwner (nullable: no)
	 *
	 * Reference to owner
	 *
	 * @return the value of idOwner
	 */
	java.math.BigDecimal getIdOwner();

	/**
	 * Setter method for property : idOwner (nullable: no)
	 *
	 * Reference to owner
	 *
	 * @param value the value of idOwner
	 */
	void setIdOwner( java.math.BigDecimal value );

	/**
	 * Getter method for property : idCreator (nullable: no)
	 *
	 * Reference to creator
	 *
	 * @return the value of idCreator
	 */
	java.math.BigDecimal getIdCreator();

	/**
	 * Setter method for property : idCreator (nullable: no)
	 *
	 * Reference to creator
	 *
	 * @param value the value of idCreator
	 */
	void setIdCreator( java.math.BigDecimal value );

	/**
	 * Getter method for property : creationDate (nullable: no)
	 *
	 * Document creation time
	 *
	 * @return the value of creationDate
	 */
	java.util.Date getCreationDate();

	/**
	 * Setter method for property : creationDate (nullable: no)
	 *
	 * Document creation time
	 *
	 * @param value the value of creationDate
	 */
	void setCreationDate( java.util.Date value );

	/**
	 * Getter method for property : updateDate (nullable: no)
	 *
	 * Document update time
	 *
	 * @return the value of updateDate
	 */
	java.util.Date getUpdateDate();

	/**
	 * Setter method for property : updateDate (nullable: no)
	 *
	 * Document update time
	 *
	 * @param value the value of updateDate
	 */
	void setUpdateDate( java.util.Date value );

	/**
	 * Getter method for property : path (nullable: no)
	 *
	 * Documents path
	 *
	 * @return the value of path
	 */
	java.lang.String getPath();

	/**
	 * Setter method for property : path (nullable: no)
	 *
	 * Documents path
	 *
	 * @param value the value of path
	 */
	void setPath( java.lang.String value );

	/**
	 * Getter method for property : state (nullable: no)
	 *
	 * Document state
	 *
	 * @return the value of state
	 */
	java.math.BigDecimal getState();

	/**
	 * Setter method for property : state (nullable: no)
	 *
	 * Document state
	 *
	 * @param value the value of state
	 */
	void setState( java.math.BigDecimal value );

}
