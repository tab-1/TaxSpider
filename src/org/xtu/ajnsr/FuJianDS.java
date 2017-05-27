package org.xtu.ajnsr;

import java.util.Vector;

import org.xtu.common.TaxationResult_A;
import org.xtu.common.Taxation_A;

import com.qdcz.spider.utils.Function;
import com.qdcz.spider.utils.Tools;
import com.qdcz.spider.utils.Function.RequestType;

public class FuJianDS extends Taxation_A{
	public static void main(String[] args) {
		FuJianDS instance = new FuJianDS();
		instance.GetTaxation_A();
	}
	
	@Override
	public TaxationResult_A GetTaxation_A() {
		byte[] data = Function.downloadByURLConn("http://www.fj-l-tax.gov.cn/ar/2016042714000072.htm", RequestType.GET);
		Vector<String> numbers = new Vector<>();
		Vector<String> names = new Vector<>();
		Vector<String> nds = new Vector<>();
		
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
				"//div[@id='cms_article_content']/table/tbody//tr/td[2]/text()", numbers);
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
				"//div[@id='cms_article_content']//tbody//tr/td[3]/text()", names);
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
				"//div[@id='cms_article_content']//tbody//tr/td[4]/text()", nds);
		for (int i = 0; i < numbers.size(); i++) {
			TaxationResult_A one = new TaxationResult_A();
			one.setNsrsbh(numbers.get(i));
			one.setNsrmc(names.get(i));
			one.setNd(nds.get(i));
			one.setProvince("FuJianDS");
			this.mongo.saveOrReplaceOneDocument(one.getNsrmc(),one.toJSONObject());
		}
		
		return null;
	}

}
