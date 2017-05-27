package org.xtu.common;

import java.util.Vector;

public class Taxation_ZJSXGG implements Taxation {

	public NewMongo mongo ;
	public Taxation_ZJSXGG() {
		super();
		this.mongo = new NewMongo("test","Taxation_ZJSXGG");
	}
	
	@Override
	public byte[] getOnePage(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getUrls(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public TaxationResult_ZJSXGG GetTaxation_ZJSXGG(){
		return null;
	}

}
