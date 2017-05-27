package org.xtu.zjsxgg;

import java.util.Vector;

import org.xtu.common.TaxationResult_ZJSXGG;
import org.xtu.common.Taxation_ZJSXGG;

import com.qdcz.spider.utils.Function;
import com.qdcz.spider.utils.Function.RequestType;
import com.qdcz.spider.utils.Tools;

public class BeiJingZJSXGGDS extends Taxation_ZJSXGG {
	
	public static void main(String[] args) {
		BeiJingZJSXGGDS insatnce = new BeiJingZJSXGGDS();
		insatnce.GetTaxation_ZJSXGG();
	}
	
	@Override
	public byte[] getOnePage(Object url) {//
		byte[] data = Function.downloadByURLConn((String)url,RequestType.GET);
		Vector<String> numbers = new Vector<>();
		Vector<String> names = new Vector<>();
		Vector<String> fddbrmcs = new Vector<>();
		Vector<String> sfzjhms = new Vector<>();
		Vector<String> rddws = new Vector<>();
		Vector<String> rdfzcsjs = new Vector<>();
		
		
		Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
				"//table[@class='biankuang3']/tbody//tr[position()>1]/td[2]/text()", numbers);
		Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
				"//table[@class='biankuang3']/tbody//tr[position()>1]/td[3]/a/text()", names);
		Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
				"//table[@class='biankuang3']/tbody//tr[position()>1]/td[4]/text()", fddbrmcs);
		Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
				"//table[@class='biankuang3']/tbody//tr[position()>1]/td[5]/text()", sfzjhms);
		Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
				"//table[@class='biankuang3']/tbody//tr[position()>1]/td[9]/text()", rddws);
		Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
				"//table[@class='biankuang3']/tbody//tr[position()>1]/td[9]/text()", rdfzcsjs);
		for (int i = 0; i < numbers.size()-1; i++) {
			try {
				TaxationResult_ZJSXGG one = new TaxationResult_ZJSXGG();
				one.setNsrsbh(numbers.get(i));
				one.setNsrmc(names.get(i));
				one.setFddbrmc(fddbrmcs.get(i));
				one.setSfzjhm(sfzjhms.get(i));
				one.setRddw(rddws.get(i));
				one.setRdfzcsj(rdfzcsjs.get(i));
				one.setProvince("BeiJingZJSXGGDS");
				this.mongo.saveOrReplaceOneDocument(one.getNsrmc(), one.toJSONObject());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public TaxationResult_ZJSXGG GetTaxation_ZJSXGG(){
		for (int i = 1; i <= 176; i++) {
			try {
				Thread.sleep(3000);
				getOnePage("http://shiju.tax861.gov.cn/bjds/swcx/fzczxhcx/result.asp?aa=" + i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
