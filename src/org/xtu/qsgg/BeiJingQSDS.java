package org.xtu.qsgg;

import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xtu.common.TaxationResult_QSGG;
import org.xtu.common.Taxation_QSGG;
import com.qdcz.spider.utils.Function;
import com.qdcz.spider.utils.Function.RequestType;
import com.qdcz.spider.utils.Tools;

public class BeiJingQSDS extends Taxation_QSGG {

	public static void main(String[] args) {
		BeiJingQSDS instance = new BeiJingQSDS();
		instance.GetTaxation_QSGG();
		// instance.getSZ("qsgg_xs.asp?id=6204");
	}

	@Override
	public TaxationResult_QSGG GetTaxation_QSGG() {
		byte[] data = Function.downloadByURLConn(
				"http://shiju.tax861.gov.cn/nsfw/qshcx/qsgg_index.asp",
				RequestType.GET);
		try {
			Vector<String> names = new Vector<>();
			Vector<String> numbers = new Vector<>();
			Vector<String> fddbs = new Vector<>();
			Vector<String> IDcards = new Vector<>();
			Vector<String> xqUrls = new Vector<>();

			Vector<String> qsyes = new Vector<>();
			Vector<String> dqqses = new Vector<>();

			Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
					"//table[@class='center_04']/tbody//tr/td[1]/a/text()",
					names);
			Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
					"//table[@class='center_04']/tbody//tr/td[2]/text()",
					numbers);
			Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
					"//table[@class='center_04']/tbody//tr/td[3]/text()",
					fddbs);
			Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
					"//table[@class='center_04']/tbody//tr/td[4]/text()",
					IDcards);
			Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
					"//table[@class='center_04']/tbody//tr/td[5]/a/@href",
					xqUrls);
			Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
					"//table[@class='center_04']/tbody//tr/td[7]/text()",
					qsyes);
			Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
					"//table[@class='center_04']/tbody//tr/td[8]/text()",
					dqqses);
			for (int i = 0; i < names.size(); i++) {
				try {
					TaxationResult_QSGG one = new TaxationResult_QSGG();
					one.setNsrmc(
							names.get(i).replace("\r\n", "").replace("\\s+", "")
									.replace(" ", "").replace("&nbsp;", ""));
					one.setNsrsbh(numbers.get(i).replace("\r\n", "")
							.replace("\\s+", "").replace(" ", "")
							.replace("&nbsp;", ""));
					one.setFddbrmc(
							fddbs.get(i).replace("\r\n", "").replace("\\s+", "")
									.replace(" ", "").replace("&nbsp;", ""));
					one.setSfzjhm(IDcards.get(i).replace("\r\n", "")
							.replace("\\s+", "").replace(" ", "")
							.replace("&nbsp;", ""));

					byte[] xdata = Function.downloadByURLConn(
							"http://shiju.tax861.gov.cn/nsfw/qshcx/" + xqUrls
									.get(i).replace("\r\n", "")
									.replace("\\s+", "").replace(" ", "")
									.replace("&nbsp;", ""),
							RequestType.GET);

					one.setScjydz(getAddress(xdata));
					one.setZsxmMc(getSZ(xdata));
					one.setQsye(
							qsyes.get(i).replace("\r\n", "").replace("\\s+", "")
									.replace(" ", "").replace("&nbsp;", ""));
					one.setDqxfsqs(dqqses.get(i).replace("\r\n", "")
							.replace("\\s+", "").replace(" ", "")
							.replace("&nbsp;", ""));
					// System.out.println(one.toJSONObject());
					one.setProvince("BeiJingQSDS");
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

	private JSONArray getSZ(byte[] data) {
		JSONArray arr = new JSONArray();
		Vector<String> keys = new Vector<>();
		Vector<String> values1 = new Vector<>();
		Vector<String> values2 = new Vector<>();
		Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
				"//div[@class='sz_01']//td[@align='left']//tbody//tr[position()>1]/td[1]/text()",
				keys);
		Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
				"//div[@class='sz_01']//td[@align='left']//tbody//tr[position()>1]/td[2]/text()",
				values1);
		Tools.getMultiResultsByOneXpathPattern(data, "gb2312",
				"//div[@class='sz_01']//td[@align='left']//tbody//tr[position()>1]/td[3]/text()",
				values2);
		for (int i = 0; i < (keys.size() - 1); i++) {
			try {
				JSONObject one = new JSONObject();
				one.put("税种",
						keys.get(i).replace("\r\n", "").replace("\\s+", "")
								.replace(" ", "").replace("&nbsp;", ""));
				one.put("当期欠税金额（元）",
						values1.get(i).replace("\r\n", "").replace("\\s+", "")
								.replace(" ", "").replace("&nbsp;", ""));
				one.put("历史欠税金额（元）",
						values2.get(i).replace("\r\n", "").replace("\\s+", "")
								.replace(" ", "").replace("&nbsp;", ""));
				arr.put(one);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr;
	}

	private String getAddress(byte[] data) {

		String address = Tools.get_one_item(data, "gb2312",
				"//td[@class='detailed01_03_01']/text()");
		return address;
	}

}
