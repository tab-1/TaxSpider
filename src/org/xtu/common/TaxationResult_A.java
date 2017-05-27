package org.xtu.common;

import org.json.JSONException;
import org.json.JSONObject;

public class TaxationResult_A {
	public String TYPE = "A级纳税人";
	public String swjgMc = "";  //纳税人主管税务机构
	public String nsrdzdah = ""; //纳税人身份证号码
	public String pdrq = ""; //评定日期
	public String nsrmc = ""; //纳税人名称
	public String nd = "";  //评价年度
	public String nsrsbh = ""; //纳税人识别号
	public String province = ""; //省份
	public JSONObject toJSONObject(){
		JSONObject json = new JSONObject();
		try {
			json.put("TYPE", TYPE);
			json.put("swjgMc", swjgMc);
			json.put("nsrdzdah", nsrdzdah);
			json.put("pdrq", pdrq);
			json.put("nsrmc", nsrmc);
			json.put("nd", nd);
			json.put("nsrsbh", nsrsbh);
			json.put("province", province);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getSwjgMc() {
		return swjgMc;
	}
	public void setSwjgMc(String swjgMc) {
		this.swjgMc = swjgMc;
	}
	public String getNsrdzdah() {
		return nsrdzdah;
	}
	public void setNsrdzdah(String nsrdzdah) {
		this.nsrdzdah = nsrdzdah;
	}
	public String getPdrq() {
		return pdrq;
	}
	public void setPdrq(String pdrq) {
		this.pdrq = pdrq;
	}
	public String getNsrmc() {
		return nsrmc;
	}
	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public String getNsrsbh() {
		return nsrsbh;
	}
	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}
	@Override
	public String toString() {
		return "TaxationResult_A [TYPE=" + TYPE + ", swjgMc=" + swjgMc + ", nsrdzdah=" + nsrdzdah + ", pdrq=" + pdrq
				+ ", nsrmc=" + nsrmc + ", nd=" + nd + ", nsrsbh=" + nsrsbh + "]";
	}
	
}