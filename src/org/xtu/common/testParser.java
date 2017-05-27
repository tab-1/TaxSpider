package org.xtu.common;

import java.util.Vector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.qdcz.spider.utils.Function;
import com.qdcz.spider.utils.Function.RequestType;
import com.qdcz.spider.utils.Tools;

public class testParser {
	public Vector<String> codes = new Vector<>();
	public Vector<String> names = new Vector<>();
	public Vector<String> nds = new Vector<>();
	public Vector<String> jgs = new Vector<>();
	public byte[] data;
	@Before
	public void setp(){
		System.out.println("开始初始化...");
		data = Function.downloadByURLConn(
				"http://www.cq-l-tax.gov.cn/zwgk/ssgg/nsxyajgg/201704/t20170421_83889.html",RequestType.GET);
	}
	@Test
	public void testparser(){
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8", 
				"//div[@class='TRS_PreExcel TRS_PreAppend']//tbody//tr[position()>1]/td[1]/text()", codes);
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8", 
				"//div[@class='TRS_PreExcel TRS_PreAppend']//tbody//tr[position()>1]/td[2]/text()", names);
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8", 
				"//div[@class='TRS_PreExcel TRS_PreAppend']//tbody//tr[position()>1]/td[3]/text()", jgs);
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8", 
				"//div[@class='TRS_PreExcel TRS_PreAppend']//tbody//tr[position()>1]/td[4]/text()", nds);
	}
	@After
	public void finsh(){
		for (int j = 0; j < codes.size(); j++) {
			TaxationResult_A one = new TaxationResult_A();
			one.setNsrsbh(codes.get(j).replace("\\s+", "").replace("\r\n", "").replace("\n", ""));
			one.setNsrmc(names.get(j).replace("\\s+", "").replace("\r\n", "").replace("\n", ""));
			one.setSwjgMc(jgs.get(j).replace("\\s+", "").replace("\r\n", "").replace("\n", ""));
			one.setNd(nds.get(j).replace("\\s+", "").replace("\r\n", "").replace("\n", ""));
			System.out.println(one.toJSONObject());
		}
	}
}
