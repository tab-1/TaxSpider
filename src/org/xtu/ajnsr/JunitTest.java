package org.xtu.ajnsr;

import org.junit.Test;

public class JunitTest {
	@Test
	public void testBeiJingDs() {
		BeiJingDS instance = new BeiJingDS();
		instance.GetTaxation_A();
	}
	@Test
	public void testChongQingDS() {
		ChongQingDS isntance = new ChongQingDS();
		isntance.GetTaxation_A();
	}
	@Test
	public void testFuJianDS(){
		FuJianDS instance = new FuJianDS();
		instance.GetTaxation_A();
	}
	@Test
	public void testInitCredit(){
		InitCredit instance = new InitCredit();
		instance.GetTaxation_A();
	}
}
