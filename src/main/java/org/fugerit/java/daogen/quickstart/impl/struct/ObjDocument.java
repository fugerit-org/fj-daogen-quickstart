package org.fugerit.java.daogen.quickstart.impl.struct;

import org.fugerit.java.daogen.quickstart.def.model.ModelDocument;
import java.sql.SQLData;
import java.sql.SQLException;
import org.fugerit.java.daogen.quickstart.impl.helper.WrapperDocument;
import java.sql.SQLOutput;
import java.sql.SQLInput;
import org.fugerit.java.core.db.daogen.StructMapper;
import org.fugerit.java.daogen.quickstart.impl.helper.HelperDocument;
import java.util.Map;
import java.util.HashMap;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * ObjDocument, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class ObjDocument extends WrapperDocument implements SQLData, StructMapper {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final long serialVersionUID = 687610147895L;

	public ObjDocument( ModelDocument wrapped ) {
		super( wrapped );
	}

	public ObjDocument() {
		this( new HelperDocument() );
	}

	public final static String SQL_TYPE_NAME = "OBJ_DOCUMENT";

	@Override
	public Map<String, Class<?>> newTypeMapper() throws SQLException {
		Map<String, Class<?>> map = new HashMap<String, Class<?>>();
		map.put( SQL_TYPE_NAME, ObjDocument.class );
		return map;
	}

	@Override
	public String getSQLTypeName() throws SQLException {
		return SQL_TYPE_NAME;
	}

	public static ObjDocument wrap( ModelDocument model ) {
		ObjDocument res = null;
		if ( model instanceof ObjDocument ) {
			res = (ObjDocument) model;
		} else { 
			res = new ObjDocument( model );
		}
		return res;
	}

	@Override
	public void readSQL(SQLInput stream, String typeName) throws SQLException {
		this.setId( stream.readBigDecimal() );
		this.setIdOwner( stream.readBigDecimal() );
		this.setIdCreator( stream.readBigDecimal() );
		this.setCreationDate( stream.readTimestamp() );
		this.setUpdateDate( stream.readTimestamp() );
		this.setPath( stream.readString() );
		this.setState( stream.readBigDecimal() );
		this.setInfo( org.fugerit.java.core.db.daogen.SQLTypeConverter.clobToCharHandler( (java.sql.Clob) stream.readObject() ) );
	}

	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		throwUnsupported( "Method writeSQL() not implemented for "+this.getSQLTypeName() );
		stream.writeBigDecimal( this.getId() );
		stream.writeBigDecimal( this.getIdOwner() );
		stream.writeBigDecimal( this.getIdCreator() );
		stream.writeTimestamp( org.fugerit.java.core.db.daogen.SQLTypeConverter.utilDateToSqlTimestamp( this.getCreationDate() ) );
		stream.writeTimestamp( org.fugerit.java.core.db.daogen.SQLTypeConverter.utilDateToSqlTimestamp( this.getUpdateDate() ) );
		stream.writeString( this.getPath() );
		stream.writeBigDecimal( this.getState() );
		// clob must be writtern separately : this.getInfo();
	}

}
