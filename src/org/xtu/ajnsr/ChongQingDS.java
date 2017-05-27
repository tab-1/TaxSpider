package org.xtu.ajnsr;

import java.util.Vector;

import org.xtu.common.TaxationResult_A;
import org.xtu.common.Taxation_A;

import com.qdcz.spider.utils.Function;
import com.qdcz.spider.utils.Function.RequestType;
import com.qdcz.spider.utils.Tools;

public class ChongQingDS extends Taxation_A{
	
	public static void main(String[] args) {
		ChongQingDS isntance = new ChongQingDS();
		isntance.GetTaxation_A();
	}
	
	@Override
	public Vector<String> getUrls(Object obj) {
		Vector<String> urls = new Vector<>();
		byte[] data = Function.downloadByURLConn((String) obj, RequestType.GET);
		
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
				"//div[@class='subList']//a/@href", urls);
		
		return urls;
	}
	
	@Override
	public byte[] getOnePage(Object obj) {
//		Vector<String> urls = getUrls("http://www.cq-l-tax.gov.cn/zwgk/ssgg/nsxyajgg/");
		Vector<String> urls = getUrls(obj);
		for (int i = 0; i < urls.size(); i++) {
			String url = urls.get(i).replace("./", "http://www.cq-l-tax.gov.cn/zwgk/ssgg/nsxyajgg/");
			
			byte[] data = Function.downloadByURLConn(url,
					RequestType.GET);
			
			Vector<String> numbers = new Vector<>();
			Vector<String> names = new Vector<>();
			Vector<String> jgs = new Vector<>();
			Vector<String> nds = new Vector<>();
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8", 
					"//div[@class='TRS_PreExcel TRS_PreAppend']//tbody//tr[position()>1]/td[1]/text()", numbers);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8", 
					"//div[@class='TRS_PreExcel TRS_PreAppend']//tbody//tr[position()>1]/td[2]/text()", names);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8", 
					"//div[@class='TRS_PreExcel TRS_PreAppend']//tbody//tr[position()>1]/td[3]/text()", jgs);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8", 
					"//div[@class='TRS_PreExcel TRS_PreAppend']//tbody//tr[position()>1]/td[4]/text()", nds);
			for (int j = 0; j < numbers.size(); j++) {
				try {
					TaxationResult_A one = new TaxationResult_A();
					one.setNsrsbh(numbers.get(j).replace("\\s+", "").replace("\r\n", "").replace("\n", ""));
					one.setNsrmc(names.get(j).replace("\\s+", "").replace("\r\n", "").replace("\n", ""));
					one.setSwjgMc(jgs.get(j).replace("\\s+", "").replace("\r\n", "").replace("\n", ""));
					one.setNd(nds.get(j).replace("\\s+", "").replace("\r\n", "").replace("\n", ""));
					one.setProvince("ChongQingDS");
					this.mongo.saveOrReplaceOneDocument(one.getNsrmc(),one.toJSONObject());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public TaxationResult_A GetTaxation_A() {
		for (int i = 1; i <= 19; i++) {
			System.out.println("begin deal with page " + i);
			if(i==1){
				getOnePage("http://www.cq-l-tax.gov.cn/zwgk/ssgg/nsxyajgg/index.html");
			}else{
				getOnePage("http://www.cq-l-tax.gov.cn/zwgk/ssgg/nsxyajgg/index_"+(i-1)+".html");
			}
		}
		return null;
	}

}
