package org.xtu.common;

import java.util.Vector;

public class Taxation_QSGG implements Taxation {

	public NewMongo mongo ;
	public Taxation_QSGG() {
		super();
		this.mongo = new NewMongo("test","Taxation_QSGG");
	}
	
	@Override
	public byte[] getOnePage(Object obj) {
		return null;
	}

	@Override
	public Vector<String> getUrls(Object obj) {
		return null;
	}
	
	public TaxationResult_QSGG GetTaxation_QSGG(){
		return null;
	}

}
