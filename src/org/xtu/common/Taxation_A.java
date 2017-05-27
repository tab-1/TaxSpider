package org.xtu.common;

import java.util.Vector;

public class Taxation_A implements Taxation{
	public NewMongo mongo ;
	public Taxation_A() {
		super();
		this.mongo = new NewMongo("test","Taxation_A");
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
	
	public TaxationResult_A GetTaxation_A() {
		return null;
	}

}
