package org.fugerit.java.daogen.quickstart.impl.helper;

import org.fugerit.java.core.db.daogen.BasicWrapper;
import org.fugerit.java.daogen.quickstart.def.model.ModelExample01;

// custom import start ( code above here will be overwritten )
// custom import end ( code below here will be overwritten )

/**
 * WrapperExample01, version : 1.0.0
 *
 * author: fugerit
 *
 * warning!: auto generated object, insert custom code only between comments :
 * // custom code start ( code above here will be overwritten )
 * // custom code end ( code below here will be overwritten )
 */
public class WrapperExample01 extends BasicWrapper<ModelExample01> implements ModelExample01 {

	// custom code start ( code above here will be overwritten )
	// custom code end ( code below here will be overwritten )

	private static final long serialVersionUID = 798168127201L;

	public WrapperExample01( ModelExample01 wrapped ) {
		super( wrapped );
	}

	public ModelExample01 unwrap( WrapperExample01 wrapper ) {
		ModelExample01 res = wrapper;
		while ( res != null && res instanceof WrapperExample01 ) { 
			res = ((WrapperExample01)res).unwrapModel();
		}
		return res;
	}

	/*
	 * fields generated for entity attributes 
	 */
	@Override
	public void setField1( java.lang.String value ) {
		this.unwrapModel().setField1( value );
	}

	@Override
	public java.lang.String getField1() {
		return this.unwrapModel().getField1();
	}

	@Override
	public void setField2( java.util.Date value ) {
		this.unwrapModel().setField2( value );
	}

	@Override
	public java.util.Date getField2() {
		return this.unwrapModel().getField2();
	}

	@Override
	public void setField3( java.lang.String value ) {
		this.unwrapModel().setField3( value );
	}

	@Override
	public java.lang.String getField3() {
		return this.unwrapModel().getField3();
	}

}
