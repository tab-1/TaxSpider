package org.xtu.qsgg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xtu.common.TaxationResult_QSGG;
import org.xtu.common.Taxation_QSGG;

import com.qdcz.spider.http.GZIPUtils;
import com.qdcz.spider.utils.Function;
import com.qdcz.spider.utils.Function.RequestType;
import com.qdcz.spider.utils.Tools;

public class TianJinGS extends Taxation_QSGG {
	
	public static void main(String[] args) {
		TianJinGS instance = new TianJinGS();
		instance.GetTaxation_QSGG();
	}
	
	@Override
	public Vector<String> getUrls(Object obj) {
		Vector<String> urls = new Vector<>();
		
		byte[] data = Function.downloadByURLConn((String)obj,RequestType.GET);
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
				"//div[@id='qsgglb']//tbody//tr[position()>1]//td[3]/@onclick", urls);
		for (int i = 0; i < urls.size(); i++) {
			String temp = urls.get(i);
			urls.set(i, "http://wzcx.tjsat.gov.cn" + temp.replace("javascript:window.open('", "")
					.replace("');", ""));
		}
		return urls;
	}
	
	public TaxationResult_QSGG GetTaxation_QSGG(){
		Vector<String> urls = getUrls("http://wzcx.tjsat.gov.cn/ssggcx.action?cxgglx=8");
		System.out.println("urls " + urls);
		for (int i = 0; i < 1; i++) {
			dealOneUrl(urls.get(i));
		}
		return null;
	}

	public byte[] download(String strRequest){
		byte[] result = null;
		int timeout = 60000;
		String resultStr = null;
		InputStream is = null;
		ByteArrayOutputStream buffer = null;
		try {
			URL url1 = new URL(strRequest);
			HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
			conn.setReadTimeout(timeout);
			conn.setConnectTimeout(timeout);
			conn.setRequestMethod("GET");
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Host","wzcx.tjsat.gov.cn");
			conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
			conn.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			conn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
			conn.setRequestProperty("Accept-Encoding","gzip, deflate");
			conn.setRequestProperty("Referer","http://wzcx.tjsat.gov.cn/ssggcx.action?cxgglx=8");
			conn.setRequestProperty("Cookie","JSESSIONID=1FED0ECE2E66758644FFD240C5C201FE");
			conn.setRequestProperty("Connection","keep-alive");
			conn.setRequestProperty("Upgrade-Insecure-Requests","1");
//			conn.setRequestProperty("If-Modified-Since","Fri, 05 Dec 2014 08:35:54 GMT");
			conn.setRequestProperty("Cache-Control","max-age=0");
			
			conn.setDoOutput(true);
			int code = conn.getResponseCode();
			if(code == 500){
				throw new IOException();
			}
			is = conn.getInputStream();
			String contentEncoding = conn.getContentEncoding();
			
			buffer = new ByteArrayOutputStream();
		
			int len;
			byte[] data = new byte[16384];
			while ((len = is.read(data)) != -1) {
				buffer.write(data, 0, len);
			}
			result = buffer.toByteArray();
			buffer.flush();
			if (buffer != null) {
				buffer.close();
			}
			is.close();
			if ((contentEncoding != null) && (contentEncoding.equals("gzip"))) {
				result = GZIPUtils.unzip(result);
			}
			
			resultStr = new String(result, "utf-8");
		}catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	private void dealOneUrl(String url) {
//		byte[] data = Function.downloadByURLConn(url, "JSESSIONID=1FED0ECE2E66758644FFD240C5C201FE",RequestType.GET);
		byte[] data = download(url);
		Vector<String> numbers = new Vector<>();
		Vector<String> names = new Vector<>();
		Vector<String> fddbrmcs = new Vector<>();
		Vector<String> sfzjhms = new Vector<>();
		Vector<String> scjydzs = new Vector<>();
		Vector<String> zsxmMcs = new Vector<>();
		Vector<String> qsyes = new Vector<>();
		
		
		System.out.println(new String(data));
		
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
				"//td[@class='back']//tbody//tr[position()>2]//td[2]/text()", numbers);
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
				"//td[@class='back']//tbody//tr[position()>2]//td[3]/text()", names);
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
				"//td[@class='back']//tbody//tr[position()>2]//td[4]/text()", fddbrmcs);
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
				"//td[@class='back']//tbody//tr[position()>2]//td[5]/text()", sfzjhms);
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
				"//td[@class='back']//tbody//tr[position()>2]//td[6]/text()", scjydzs);
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
				"//td[@class='back']//tbody//tr[position()>2]//td[7]/text()", zsxmMcs);
		Tools.getMultiResultsByOneXpathPattern(data, "utf-8",
				"//td[@class='back']//tbody//tr[position()>2]//td[8]/text()", qsyes);
		for (int i = 0; i < numbers.size(); i++) {
			try {
				TaxationResult_QSGG one = new TaxationResult_QSGG();
				one.setNsrsbh(numbers.get(i));
				one.setNsrmc(names.get(i));
				one.setFddbrmc(fddbrmcs.get(i));
				one.setSfzjhm(sfzjhms.get(i));
				one.setScjydz(scjydzs.get(i));
				one.setZsxmMc(new JSONArray().put(new JSONObject().put("税种",zsxmMcs.get(i) )));
				one.setQsye(qsyes.get(i));
				one.setProvince("TianJinGS");
				System.out.println(one.toJSONObject());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
