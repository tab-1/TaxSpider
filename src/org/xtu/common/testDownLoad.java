package org.xtu.common;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.qdcz.spider.utils.Function;
import com.qdcz.spider.utils.Function.RequestType;

public class testDownLoad {
	public Map<String, String> map;
	public String url = "";
	public byte[] data ;
	
	@Before
	public void step(){
		System.out.println("开始初始化 URL 和 请求头");
		this.url = "http://www.szgs.gov.cn/bswmh/jsp/inspur/ssgg/nsxy/html/inspur.ssgg.nsxy.NsxyCmd.cmd?method=query";
		map = new HashMap<>();
		map.put("param", "firstPage=" + 1 + "&pageSize=15&yzm=");
		
	}
	
	@Test
	public void testDownload(){
		data = Function.downloadByURLConn(url,
				map, RequestType.POST);
	}
	
	@After
	public void finsh(){
		System.out.println(new String(data));
	}
}
