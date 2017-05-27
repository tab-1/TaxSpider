package org.xtu.ajnsr;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xtu.common.TaxationResult_A;
import org.xtu.common.Taxation_A;

import com.qdcz.spider.utils.Function;
import com.qdcz.spider.utils.Function.ConnPropertyType;
import com.qdcz.spider.utils.Function.RequestType;

public class BeiJingDS extends Taxation_A{

	public static void main(String[] args) {
		BeiJingDS instance = new BeiJingDS();
		instance.GetTaxation_A();
		
	}
	
	@Override
	public TaxationResult_A GetTaxation_A() {
		byte[] data = getOnePage(1);
		
		try {
			JSONObject json = new JSONObject(new String(data,"gb2312"));
			System.out.println(json);
			JSONObject paging = json.getJSONObject("result").getJSONObject("paging");
			int pagecount = paging.getInt("pagecount");
			for (int i = 1; i < pagecount; i++) {
				try {
					if(i==1){
						JSONArray list = json.getJSONObject("result").getJSONArray("list");
						for (int j = 0; j < list.length(); j++) {
							try {
								TaxationResult_A one = new TaxationResult_A();
								one.setNsrmc(list.getJSONObject(j).getString("NSRMC"));
								one.setNsrsbh(list.getJSONObject(j).getString("NSRMC"));
								one.setNd(list.getJSONObject(j).getString("TAXYEAR"));
								one.setSwjgMc(list.getJSONObject(j).getString("DW"));
								
								this.mongo.saveOrReplaceOneDocument(one.getNsrmc(),one.toJSONObject());
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}else{
						byte[] bdata = getOnePage(i);
						JSONObject bjson = new JSONObject(new String(bdata,"gb2312"));
						JSONArray blist = bjson.getJSONObject("result").getJSONArray("list");
						for (int j = 0; j < blist.length(); j++) {
							try {
								TaxationResult_A one = new TaxationResult_A();
								one.setNsrmc(blist.getJSONObject(j).getString("NSRMC"));
								one.setNsrsbh(blist.getJSONObject(j).getString("NSRMC"));
								one.setNd(blist.getJSONObject(j).getString("TAXYEAR"));
								one.setSwjgMc(blist.getJSONObject(j).getString("DW"));
								one.setProvince("BeiJingDS");
								this.mongo.saveOrReplaceOneDocument(one.getNsrmc(),one.toJSONObject());
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public byte[] getOnePage(Object obj){
		String url = "http://shiju.tax861.gov.cn/bjds/swcx/nsajcx2015/result_json.asp?1=1&aa=" + (int)obj + "&d=" + System.currentTimeMillis();
		Map<String, String> map = new HashMap<String, String>();
		map.put("param", "nsrmc=&nsrsbh=&taxyear=");
		map.put(ConnPropertyType.Cookie, "");
		byte[] data = Function.downloadByURLConn(url, map, RequestType.POST);
		return data;
	}
}