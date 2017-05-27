package org.xtu.ajnsr;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xtu.common.TaxationResult_A;
import org.xtu.common.Taxation_A;

import com.qdcz.spider.utils.Function;
import com.qdcz.spider.utils.Function.RequestType;
import com.qdcz.spider.utils.Tools;

public class ShengZhengGS extends Taxation_A {
	
	public static void main(String[] args) {
		ShengZhengGS instance = new ShengZhengGS();
		instance.GetTaxation_A();
	}
	
	@Override
	public byte[] getOnePage(Object obj) {
		try {
			Map<String, String> map = new HashMap<>();
			map.put("param", "firstPage=" + (Integer)obj + "&pageSize=15&yzm=");
			byte[] data = Function.downloadByURLConn("http://www.szgs.gov.cn/bswmh/jsp/inspur/ssgg/nsxy/html/inspur.ssgg.nsxy.NsxyCmd.cmd?method=query",
					map, RequestType.POST);
			System.out.println(new String(data));
			JSONObject json = new JSONObject(new String(data));
			JSONObject web = json.getJSONObject("Web");
			JSONArray response = web.getJSONArray("response");
			for (int i = 0; i < response.length(); i++) {
				JSONObject one = response.getJSONObject(i);
				if(one.has("list")){
					JSONArray values = one.getJSONArray("value");
					for (int j = 0; j < values.length(); j++) {
						TaxationResult_A oneData = new TaxationResult_A();
						oneData.setProvince("ShengZhengGS");
						JSONObject oneCompany = values.getJSONObject(j);
						JSONArray oneValues = oneCompany.getJSONArray("value");
						for (int k = 0; k < oneValues.length(); k++) {
							JSONObject onevalue = oneValues.getJSONObject(k);
							String param = onevalue.getString("param");
							if("nd".equals(param)){
								oneData.setNd(onevalue.getString("value"));
							}else if("nsrsbh".equals(param)){
								oneData.setNsrsbh(onevalue.getString("value"));
							}else if("nsrmc".equals(param)){
								oneData.setNsrmc(onevalue.getString("value"));
							}else if("pdrq".equals(param)){
								oneData.setPdrq(onevalue.getString("value"));
							}else if("swjgMc".equals(param)){
								oneData.setSwjgMc(onevalue.getString("value"));
							}
						}
						this.mongo.saveOrReplaceOneDocument(oneData.getNsrmc(), oneData.toJSONObject());
					}
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public TaxationResult_A GetTaxation_A() {
		byte[] data = Function.downloadByURLConn("http://www.szgs.gov.cn/bswmh/jsp/inspur/ssgg/nsxy/html/nsxy.html?rd=1492159544475",
				RequestType.GET);
		Vector<String> numbers = new Vector<>();
		Vector<String> names = new Vector<>();
		Vector<String> nds = new Vector<>();
		Vector<String> jgs = new Vector<>();
		Tools.getMultiResultsByOneXpathPattern(data, "gbk",
				"//tr[@multirow='true']/td[2]/text()", numbers);
		Tools.getMultiResultsByOneXpathPattern(data, "gbk",
				"//tr[@multirow='true']/td[3]/text()", names);
		Tools.getMultiResultsByOneXpathPattern(data, "gbk",
				"//tr[@multirow='true']/td[4]/text()", nds);
		Tools.getMultiResultsByOneXpathPattern(data, "gbk",
				"//tr[@multirow='true']/td[5]/text()", jgs);
		for (int i = 0; i < numbers.size(); i++) {
			try {
				TaxationResult_A one = new TaxationResult_A();
				one.setNsrsbh(numbers.get(i));
				one.setNsrmc(names.get(i));
				one.setNd(nds.get(i));
				one.setSwjgMc(jgs.get(i));
				one.setProvince("ShengZhengGS");
//				 System.out.println(one.toJSONObject());
				this.mongo.saveOrReplaceOneDocument(one.getNsrmc(), one.toJSONObject());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			String pageStr = Tools.get_one_match(new String(data,"gbk"), "var tpages = \\d+;");
			int totalPage = Integer.parseInt(pageStr.replace("var tpages = ", "").replace(";", ""));
			for (int i = 2; i <= totalPage; i++) {
				try {
					getOnePage(i);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
