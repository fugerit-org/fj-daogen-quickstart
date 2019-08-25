package org.fugerit.java.daogen.quickstart.impl.helper;

import org.fugerit.java.daogen.quickstart.def.model.ModelDocument;
import org.fugerit.java.daogen.quickstart.def.model.ModelPerson;
import org.fugerit.java.core.db.daogen.BasicHelper;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * HelperPerson, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class HelperPerson extends BasicHelper implements ModelPerson {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final long serialVersionUID = 15367710913L;

	/*
	 * fields generated for relations 
	 */

	private ModelPerson Mother;

	@Override
	public void setMother( ModelPerson value ) {
		this.Mother = value;
	}

	@Override
	public ModelPerson getMother() {
		return this.Mother;
	}

	private ModelPerson Father;

	@Override
	public void setFather( ModelPerson value ) {
		this.Father = value;
	}

	@Override
	public ModelPerson getFather() {
		return this.Father;
	}

	private java.util.List<ModelDocument> Owndocuments;

	@Override
	public void setOwndocuments( java.util.List<ModelDocument> value ) {
		this.Owndocuments = value;
	}

	@Override
	public java.util.List<ModelDocument> getOwndocuments() {
		return this.Owndocuments;
	}

	/*
	 * fields generated for entity attributes 
	 */
	private java.math.BigDecimal id;

	@Override
	public void setId( java.math.BigDecimal value ) {
		this.id = value;
	}

	@Override
	public java.math.BigDecimal getId() {
		return this.id;
	}

	private java.lang.String surname;

	@Override
	public void setSurname( java.lang.String value ) {
		this.surname = value;
	}

	@Override
	public java.lang.String getSurname() {
		return this.surname;
	}

	private java.lang.String name;

	@Override
	public void setName( java.lang.String value ) {
		this.name = value;
	}

	@Override
	public java.lang.String getName() {
		return this.name;
	}

	private java.util.Date birthDate;

	@Override
	public void setBirthDate( java.util.Date value ) {
		this.birthDate = value;
	}

	@Override
	public java.util.Date getBirthDate() {
		return this.birthDate;
	}

	private java.lang.String note;

	@Override
	public void setNote( java.lang.String value ) {
		this.note = value;
	}

	@Override
	public java.lang.String getNote() {
		return this.note;
	}

	private java.math.BigDecimal idMother;

	@Override
	public void setIdMother( java.math.BigDecimal value ) {
		this.idMother = value;
	}

	@Override
	public java.math.BigDecimal getIdMother() {
		return this.idMother;
	}

	private java.math.BigDecimal idFather;

	@Override
	public void setIdFather( java.math.BigDecimal value ) {
		this.idFather = value;
	}

	@Override
	public java.math.BigDecimal getIdFather() {
		return this.idFather;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append( this.getClass().getSimpleName() );
		buffer.append( "[id=" );
		buffer.append( this.getId() );
		buffer.append( ",surname=" );
		buffer.append( this.getSurname() );
		buffer.append( ",name=" );
		buffer.append( this.getName() );
		buffer.append( ",birthDate=" );
		buffer.append( this.getBirthDate() );
		buffer.append( ",note=" );
		buffer.append( this.getNote() );
		buffer.append( ",idMother=" );
		buffer.append( this.getIdMother() );
		buffer.append( ",idFather=" );
		buffer.append( this.getIdFather() );
		buffer.append( "]" );
		return buffer.toString();
	}

}
