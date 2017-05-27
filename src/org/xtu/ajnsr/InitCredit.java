package org.xtu.ajnsr;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.json.JSONObject;
import org.xtu.common.TaxationResult_A;
import org.xtu.common.Taxation_A;

import com.qdcz.spider.utils.Function;
import com.qdcz.spider.utils.Function.RequestType;
import com.qdcz.spider.utils.Tools;

public class InitCredit extends Taxation_A {
	public static void main(String[] args) {
		InitCredit instance = new InitCredit();
		instance.GetTaxation_A();
	}

	@Override
	public TaxationResult_A GetTaxation_A() {
		Vector<String> provices = getUrls("");
		for (int i = 1; i < provices.size(); i++) {

			System.out.println("begin deal with province " + provices.get(i));

			Map<String, String> map = new HashMap<>();
			map.put("param",
					"articleField01=&articleField02=&articleField03=2015&articleField06="
							+ provices.get(i)
							+ "&cPage=&randCode=6h43145h&flag=1");
			byte[] data = Function.downloadByURLConn(
					"http://hd.chinatax.gov.cn/fagui/action/InitCredit.do", map,
					RequestType.POST);
			Vector<String> numbers = new Vector<>();
			Vector<String> names = new Vector<>();
			Vector<String> nds = new Vector<>();

			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//td[@class='sv_hei']/table/tbody//tr[position()>1]/td[1]/text()",
					numbers);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//td[@class='sv_hei']/table/tbody//tr[position()>1]/td[2]/text()",
					names);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//td[@class='sv_hei']/table/tbody//tr[position()>1]/td[3]/text()",
					nds);
			for (int j = 0; j < numbers.size(); j++) {
				TaxationResult_A one = new TaxationResult_A();
				one.setNsrsbh(numbers.get(j));
				one.setNsrmc(names.get(j));
				one.setNd(nds.get(j));
				one.setProvince("InitCredit");
				// System.out.println(one.toJSONObject());
				this.mongo.saveOrReplaceOneDocument(one.getNsrmc(), one.toJSONObject());
			}
			String totalPage = Tools
					.get_one_item(data, "utf-8",
							"//td[@class='sv_black12_24']/a[2]/@onclick")
					.replace("changeParam('cPage','", "").replace("')", "");
			int pageNum = Integer.parseInt(totalPage);
			pageNum = 3;
			for (int page = 2; page <= pageNum; page++) {
				try {

					System.out.println("deal with page " + page);

					JSONObject param = new JSONObject();
					param.put("province", provices.get(i));
					param.put("page", page);

					getOnePage(param);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public byte[] getOnePage(Object obj) {
		try {
			Map<String, String> map = new HashMap<>();
			map.put("param",
					"articleField01=&articleField02=&articleField03=2015&articleField06="
							+ ((JSONObject) obj).getString("province")
							+ "&cPage=" + ((JSONObject) obj).getInt("page")
							+ "&randCode=6h43145h&flag=1");
			byte[] data = Function.downloadByURLConn(
					"http://hd.chinatax.gov.cn/fagui/action/InitCredit.do", map,
					RequestType.POST);
			Vector<String> numbers = new Vector<>();
			Vector<String> names = new Vector<>();
			Vector<String> nds = new Vector<>();

			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//td[@class='sv_hei']/table/tbody//tr[position()>1]/td[1]/text()",
					numbers);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//td[@class='sv_hei']/table/tbody//tr[position()>1]/td[2]/text()",
					names);
			Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
					"//td[@class='sv_hei']/table/tbody//tr[position()>1]/td[3]/text()",
					nds);
			for (int j = 0; j < numbers.size(); j++) {
				try {
					TaxationResult_A one = new TaxationResult_A();
					one.setNsrsbh(numbers.get(j));
					one.setNsrmc(names.get(j));
					one.setNd(nds.get(j));
					one.setProvince("InitCredit");
					// System.out.println(one.toJSONObject());
					this.mongo.saveOrReplaceOneDocument(one.getNsrmc(),
							one.toJSONObject());
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
	public Vector<String> getUrls(Object obj) {
		Vector<String> provices = new Vector<>();
		provices.add("&taxCode=110000");
		provices.add("&taxCode=120000");
		provices.add("&taxCode=130000");
		provices.add("&taxCode=140000");
		provices.add("&taxCode=150000");
		provices.add("&taxCode=210000");
		provices.add("&taxCode=210200");
		provices.add("&taxCode=220000");
		provices.add("&taxCode=230000");
		provices.add("&taxCode=310000");
		provices.add("&taxCode=320000");
		provices.add("&taxCode=330000");
		provices.add("&taxCode=330200");
		provices.add("&taxCode=340000");
		provices.add("&taxCode=350000");
		provices.add("&taxCode=350200");
		provices.add("&taxCode=360000");
		provices.add("&taxCode=370000");
		provices.add("&taxCode=370200");
		provices.add("&taxCode=410000");
		provices.add("&taxCode=420000");
		provices.add("&taxCode=430000");
		provices.add("&taxCode=440000");
		provices.add("&taxCode=440300");
		provices.add("&taxCode=450000");
		provices.add("&taxCode=460000");
		provices.add("&taxCode=500000");
		provices.add("&taxCode=510000");
		provices.add("&taxCode=520000");
		provices.add("&taxCode=530000");
		provices.add("&taxCode=540000");
		provices.add("&taxCode=610000");
		provices.add("&taxCode=620000");
		provices.add("&taxCode=630000");
		provices.add("&taxCode=640000");
		provices.add("&taxCode=650000");

		return provices;
	}

}
