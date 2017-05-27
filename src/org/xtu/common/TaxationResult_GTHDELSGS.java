package org.xtu.common;

import org.json.JSONException;
import org.json.JSONObject;

public class TaxationResult_GTHDELSGS {
	public String TYPE = "个体户定额历史公示";
	public String nsrmc = ""; //纳税人名称
	public String nsrsbh = ""; //纳税人识别号
	public String sqrq = "";  //申请日期
	public String zsxmMc = ""; //税种
	public String swjgMc = ""; //所属税务机关
	public String gtnsdeHydlMc = ""; //行业大类
	public String xssr = ""; //核定销售额
	public String se = "";  //核定税额
	public String gtnsdeHyxlMc = ""; //行业小类
	public String hdrqQ= ""; //核定日期起
	public String hdrqZ = ""; //核定日期止
	public String szscMc="";  //所在市场
	public String gsrqZ="";  //公示日期止
	
	public JSONObject toJSONObject(){
		JSONObject json = new JSONObject();
		try {
			json.put("TYPE", TYPE);
			json.put("nsrmc", nsrmc);
			json.put("nsrsbh", nsrsbh);
			json.put("sqrq", sqrq);
			json.put("zsxmMc", zsxmMc);
			json.put("swjgMc", swjgMc);
			json.put("gtnsdeHydlMc", gtnsdeHydlMc);
			json.put("xssr", xssr);
			json.put("se", se);
			json.put("gtnsdeHyxlMc", gtnsdeHyxlMc);
			json.put("hdrqQ", hdrqQ);
			json.put("hdrqZ", hdrqZ);
			json.put("szscMc", szscMc);
			json.put("gsrqZ", gsrqZ);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public String getNsrmc() {
		return nsrmc;
	}

	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}

	public String getNsrsbh() {
		return nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

	public String getSqrq() {
		return sqrq;
	}

	public void setSqrq(String sqrq) {
		this.sqrq = sqrq;
	}

	public String getZsxmMc() {
		return zsxmMc;
	}

	public void setZsxmMc(String zsxmMc) {
		this.zsxmMc = zsxmMc;
	}

	public String getSwjgMc() {
		return swjgMc;
	}

	public void setSwjgMc(String swjgMc) {
		this.swjgMc = swjgMc;
	}

	public String getGtnsdeHydlMc() {
		return gtnsdeHydlMc;
	}

	public void setGtnsdeHydlMc(String gtnsdeHydlMc) {
		this.gtnsdeHydlMc = gtnsdeHydlMc;
	}

	public String getXssr() {
		return xssr;
	}

	public void setXssr(String xssr) {
		this.xssr = xssr;
	}

	public String getSe() {
		return se;
	}

	public void setSe(String se) {
		this.se = se;
	}

	public String getGtnsdeHyxlMc() {
		return gtnsdeHyxlMc;
	}

	public void setGtnsdeHyxlMc(String gtnsdeHyxlMc) {
		this.gtnsdeHyxlMc = gtnsdeHyxlMc;
	}

	public String getHdrqQ() {
		return hdrqQ;
	}

	public void setHdrqQ(String hdrqQ) {
		this.hdrqQ = hdrqQ;
	}

	public String getHdrqZ() {
		return hdrqZ;
	}

	public void setHdrqZ(String hdrqZ) {
		this.hdrqZ = hdrqZ;
	}

	public String getSzscMc() {
		return szscMc;
	}

	public void setSzscMc(String szscMc) {
		this.szscMc = szscMc;
	}

	public String getGsrqZ() {
		return gsrqZ;
	}

	public void setGsrqZ(String gsrqZ) {
		this.gsrqZ = gsrqZ;
	}	
}
