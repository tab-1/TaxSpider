package org.xtu.common;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TaxationResult_QSGG {
	public String TYPE = "欠税公告";
	public String xjrq = "";  //限缴日期
	public String sfzjhm = "";  //证件号码
	public String dqxfsqs = "";  //当期新发生欠税
	public JSONArray zsxmMc; //欠税税种
	public String sfssqq = ""; //税费所属期起
	public String sfssqz = ""; //税费所属期止
	public String scjydz = ""; //生产经营地址
	public String qsye = "";  //欠税余额
	public String fddbrmc = ""; //法定代表
	public String zjzl= ""; //证件种类
	public String qszspm = ""; //欠税征收品目
	public String nsrmc = ""; //纳税人名称
	public String nsrsbh = ""; //纳税人识别号
	public String swjgMc = "";  //纳税人主管税务机构
	public String province = ""; //源
	
	public JSONObject toJSONObject(){
		JSONObject json = new JSONObject();
		try {
			json.put("TYPE", TYPE);
			json.put("xjrq", xjrq);
			json.put("sfzjhm", sfzjhm);
			json.put("dqxfsqs", dqxfsqs);
			json.put("zsxmMc", zsxmMc);
			json.put("sfssqq", sfssqq);
			json.put("sfssqz", sfssqz);
			json.put("scjydz", scjydz);
			json.put("qsye", qsye);
			json.put("fddbrmc", fddbrmc);
			json.put("zjzl", zjzl);
			json.put("qszspm", qszspm);
			json.put("nsrmc", nsrmc);
			json.put("nsrsbh", nsrsbh);
			json.put("swjgMc", swjgMc);
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getXjrq() {
		return xjrq;
	}
	public void setXjrq(String xjrq) {
		this.xjrq = xjrq;
	}
	public String getSwjgMc() {
		return swjgMc;
	}
	public void setSwjgMc(String swjgMc) {
		this.swjgMc = swjgMc;
	}
	public String getDqxfsqs() {
		return dqxfsqs;
	}
	public void setDqxfsqs(String dqxfsqs) {
		this.dqxfsqs = dqxfsqs;
	}
	
	public JSONArray getZsxmMc() {
		return zsxmMc;
	}
	public void setZsxmMc(JSONArray zsxmMc) {
		this.zsxmMc = zsxmMc;
	}
	public String getSfssqq() {
		return sfssqq;
	}
	public void setSfssqq(String sfssqq) {
		this.sfssqq = sfssqq;
	}
	public String getSfssqz() {
		return sfssqz;
	}
	public void setSfssqz(String sfssqz) {
		this.sfssqz = sfssqz;
	}
	public String getScjydz() {
		return scjydz;
	}
	public void setScjydz(String scjydz) {
		this.scjydz = scjydz;
	}
	public String getQsye() {
		return qsye;
	}
	public void setQsye(String qsye) {
		this.qsye = qsye;
	}
	
	public String getSfzjhm() {
		return sfzjhm;
	}
	public void setSfzjhm(String sfzjhm) {
		this.sfzjhm = sfzjhm;
	}
	public String getFddbrmc() {
		return fddbrmc;
	}
	public void setFddbrmc(String fddbrmc) {
		this.fddbrmc = fddbrmc;
	}
	public String getZjzl() {
		return zjzl;
	}
	public void setZjzl(String zjzl) {
		this.zjzl = zjzl;
	}
	public String getQszspm() {
		return qszspm;
	}
	public void setQszspm(String qszspm) {
		this.qszspm = qszspm;
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
	@Override
	public String toString() {
		return "TaxationResult_QSGG [TYPE=" + TYPE + ", xjrq=" + xjrq + ", sfzjhm=" + sfzjhm + ", dqxfsqs=" + dqxfsqs
				+ ", zsxmMc=" + zsxmMc + ", sfssqq=" + sfssqq + ", sfssqz=" + sfssqz + ", scjydz=" + scjydz + ", qsye="
				+ qsye + ", fddbrmc=" + fddbrmc + ", zjzl=" + zjzl + ", qszspm=" + qszspm + ", nsrmc=" + nsrmc
				+ ", nsrsbh=" + nsrsbh + "]";
	}
	
}