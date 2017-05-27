package org.xtu.common;

import org.json.JSONException;
import org.json.JSONObject;

public class TaxationResult_ZJSXGG {
	public String TYPE = "税务登记证件失效公告";
	public String nsrmc = ""; //非正常户名称
	public String nsrsbh = ""; //非正常人识别号
	public String scjydz = ""; //生产经营地址
	public String fddbrmc = ""; //法人姓名
	public String sfzjhm = ""; //身份证号码
	public String rddw = "";  //认定单位
	public String rdfzcsj = "";  //认定非正常时间
	public String zjsxyy= ""; //证件失效原因
	public String province = ""; //源
	
	public JSONObject toJSONObject(){
		JSONObject json = new JSONObject();
		try {
			json.put("TYPE", TYPE);
			json.put("nsrmc", nsrmc);
			json.put("nsrsbh", nsrsbh);
			json.put("scjydz", scjydz);
			json.put("fddbrmc", fddbrmc);
			json.put("sfzjhm", sfzjhm);
			json.put("rddw", rddw);
			json.put("rdfzcsj", rdfzcsj);
			json.put("zjsxyy", zjsxyy);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public String getFddbrmc() {
		return fddbrmc;
	}

	public void setFddbrmc(String fddbrmc) {
		this.fddbrmc = fddbrmc;
	}
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

	public String getSfzjhm() {
		return sfzjhm;
	}

	public void setSfzjhm(String sfzjhm) {
		this.sfzjhm = sfzjhm;
	}

	public String getRddw() {
		return rddw;
	}

	public void setRddw(String rddw) {
		this.rddw = rddw;
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
	public String getScjydz() {
		return scjydz;
	}
	public void setScjydz(String scjydz) {
		this.scjydz = scjydz;
	}
	public String getRdfzcsj() {
		return rdfzcsj;
	}
	public void setRdfzcsj(String rdfzcsj) {
		this.rdfzcsj = rdfzcsj;
	}
	public String getZjsxyy() {
		return zjsxyy;
	}
	public void setZjsxyy(String zjsxyy) {
		this.zjsxyy = zjsxyy;
	}

	@Override
	public String toString() {
		return "TaxationResult_ZJSXGG [TYPE=" + TYPE + ", nsrmc=" + nsrmc + ", nsrsbh=" + nsrsbh + ", scjydz=" + scjydz
				+ ", fddbrmc=" + fddbrmc + ", sfzjhm=" + sfzjhm + ", rddw=" + rddw + ", rdfzcsj=" + rdfzcsj
				+ ", zjsxyy=" + zjsxyy + "]";
	}
}