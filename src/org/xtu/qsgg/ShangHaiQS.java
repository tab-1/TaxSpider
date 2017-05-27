package org.xtu.qsgg;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xtu.common.TaxationResult_QSGG;
import org.xtu.common.Taxation_QSGG;

import com.qdcz.spider.utils.Function;
import com.qdcz.spider.utils.Function.RequestType;
import com.qdcz.spider.utils.Tools;

public class ShangHaiQS extends Taxation_QSGG {
	
	public static void main(String[] args) {
		ShangHaiQS instance = new ShangHaiQS();
		instance.GetTaxation_QSGG();
	}
	
	@Override
	public byte[] getOnePage(Object obj) {
		try {
			Map<String, String> map = new HashMap<>();
			map.put("param", "type=" + ((JSONObject)obj).getString("type") 
					+ "&nsrmc=&swdjh=&fzrxm=&tsnr=Sat+Dec+31+00%3A00%3A00+GMT%2B08%3A00+2016&curPage=" 
					+ ((JSONObject)obj).getString("page") );
			byte[] data = Function.downloadByURLConn("http://www.tax.sh.gov.cn/tycx/TYCXqjsknsrmdCtrl-getQjsknsrmd.pfv", 
					map, RequestType.POST);
			
			Vector<String> names = new Vector<>();
			Vector<String> numbers = new Vector<>();
			Vector<String> fddbrmcs = new Vector<>();
			Vector<String> zjzls = new Vector<>();
			Vector<String> sfzjhms = new Vector<>();//
			Vector<String> zsxmMcs = new Vector<>();//欠税税种
			Vector<String> qsyes = new Vector<>();
			Vector<String> swjgMcs = new Vector<>();
			
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//table[@class='csstable']/tbody//tr[position()>2]/td[1]/text()", names);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//table[@class='csstable']/tbody//tr[position()>2]/td[2]/text()", numbers);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//table[@class='csstable']/tbody//tr[position()>2]/td[3]/text()", fddbrmcs);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//table[@class='csstable']/tbody//tr[position()>2]/td[4]/text()", zjzls);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//table[@class='csstable']/tbody//tr[position()>2]/td[5]/text()", sfzjhms);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//table[@class='csstable']/tbody//tr[position()>2]/td[6]/text()", zsxmMcs);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//table[@class='csstable']/tbody//tr[position()>2]/td[7]/text()", qsyes);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//table[@class='csstable']/tbody//tr[position()>2]/td[10]/text()", swjgMcs);
			for (int j = 0; j < names.size(); j++) {
				try {
					TaxationResult_QSGG one = new TaxationResult_QSGG();
					one.setNsrmc(names.get(j));
					one.setNsrsbh(numbers.get(j));
					one.setFddbrmc(fddbrmcs.get(j));
					one.setZjzl(zjzls.get(j));
					one.setSfzjhm(sfzjhms.get(j));
					one.setZsxmMc(new JSONArray().put(new JSONObject().put("税种", zsxmMcs.get(j))));
					one.setQsye(qsyes.get(j));
					one.setSwjgMc(swjgMcs.get(j));
					one.setProvince("ShangHaiQS");
//					System.out.println(one.toJSONObject());
					this.mongo.saveOrReplaceOneDocument(one.getNsrmc(), one.toJSONObject());
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
	public TaxationResult_QSGG GetTaxation_QSGG(){
		Vector<String> types = new Vector<>();
		types.add("QY");
		types.add("GT");
		for (int i = 0; i < types.size(); i++) {
			try {
				Map<String, String> map = new HashMap<>();
				map.put("param", "type=" + types.get(i) + "&nsrmc=&swdjh=&fzrxm=&tsnr=Sat+Dec+31+00%3A00%3A00+GMT%2B08%3A00+2016&curPage=1");
				byte[] data = Function.downloadByURLConn("http://www.tax.sh.gov.cn/tycx/TYCXqjsknsrmdCtrl-getQjsknsrmd.pfv", 
						map, RequestType.POST);
				
				Vector<String> names = new Vector<>();
				Vector<String> numbers = new Vector<>();
				Vector<String> fddbrmcs = new Vector<>();
				Vector<String> zjzls = new Vector<>();
				Vector<String> sfzjhms = new Vector<>();//
				Vector<String> zsxmMcs = new Vector<>();//欠税税种
				Vector<String> qsyes = new Vector<>();
				Vector<String> swjgMcs = new Vector<>();
				
				Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
						"//table[@class='csstable']/tbody//tr[position()>2]/td[1]/text()", names);
				Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
						"//table[@class='csstable']/tbody//tr[position()>2]/td[2]/text()", numbers);
				Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
						"//table[@class='csstable']/tbody//tr[position()>2]/td[3]/text()", fddbrmcs);
				Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
						"//table[@class='csstable']/tbody//tr[position()>2]/td[4]/text()", zjzls);
				Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
						"//table[@class='csstable']/tbody//tr[position()>2]/td[5]/text()", sfzjhms);
				Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
						"//table[@class='csstable']/tbody//tr[position()>2]/td[6]/text()", zsxmMcs);
				Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
						"//table[@class='csstable']/tbody//tr[position()>2]/td[7]/text()", qsyes);
				Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
						"//table[@class='csstable']/tbody//tr[position()>2]/td[10]/text()", swjgMcs);
				for (int j = 0; j < names.size(); j++) {
					try {
						TaxationResult_QSGG one = new TaxationResult_QSGG();
						one.setNsrmc(names.get(j));
						one.setNsrsbh(numbers.get(j));
						one.setFddbrmc(fddbrmcs.get(j));
						one.setZjzl(zjzls.get(j));
						one.setSfzjhm(sfzjhms.get(j));
						one.setZsxmMc(new JSONArray().put(new JSONObject().put("税种", zsxmMcs.get(j))));
						one.setQsye(qsyes.get(j));
						one.setSwjgMc(swjgMcs.get(j));
						one.setProvince("ShangHaiQS");
//						System.out.println(one.toJSONObject());
						this.mongo.saveOrReplaceOneDocument(one.getNsrmc(), one.toJSONObject());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				String totalPage = Tools.get_one_item(data, "utf-8", 
						"//span[@class='redColor']/text()").replace("\r\n", "").replace(" ", "");
				int pageNum = Integer.parseInt(totalPage);
				
				for (int j = 2; j <= pageNum; j++) {
					JSONObject json = new JSONObject();
					json.put("type", types.get(i));
					json.put("page", j);
					getOnePage(json);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}

}
