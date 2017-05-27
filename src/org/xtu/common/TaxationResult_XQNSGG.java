package org.xtu.common;

import org.json.JSONException;
import org.json.JSONObject;

public class TaxationResult_XQNSGG {
	public String TYPE = "限期纳税公告";
	public String nsrmc = ""; //纳税人名称
	public String nsrsbh = ""; //纳税人识别号
	public String swjgMc = "";  //纳税人主管税务机关
	public String zsxmMc = "";  //税种
	public String ssqq = "";  //所属期起
	public String ssqz = ""; //所属期止
	public String sk = ""; //税款 
	public String jkqx = ""; //缴款期限
	public String fbrq = ""; //公告发布日期

	public JSONObject toJSONObject(){
		JSONObject json = new JSONObject();
		try {
			json.put("TYPE", TYPE);
			json.put("nsrmc", nsrmc);
			json.put("nsrsbh", nsrsbh);
			json.put("swjgMc", swjgMc);
			json.put("zsxmMc", zsxmMc);
			json.put("ssqq", ssqq);
			json.put("ssqz", ssqz);
			json.put("sk", sk);
			json.put("jkqx", jkqx);
			json.put("fbrq", fbrq);
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
	public String getSwjgMc() {
		return swjgMc;
	}
	public void setSwjgMc(String swjgMc) {
		this.swjgMc = swjgMc;
	}
	public String getZsxmMc() {
		return zsxmMc;
	}
	public void setZsxmMc(String zsxmMc) {
		this.zsxmMc = zsxmMc;
	}
	public String getSsqq() {
		return ssqq;
	}
	public void setSsqq(String ssqq) {
		this.ssqq = ssqq;
	}
	public String getSsqz() {
		return ssqz;
	}
	public void setSsqz(String ssqz) {
		this.ssqz = ssqz;
	}

	public String getSk() {
		return sk;
	}
	public void setSk(String sk) {
		this.sk = sk;
	}
	public String getJkqx() {
		return jkqx;
	}
	public void setJkqx(String jkqx) {
		this.jkqx = jkqx;
	}
	public String getFbrq() {
		return fbrq;
	}
	public void setFbrq(String fbrq) {
		this.fbrq = fbrq;
	}
	@Override
	public String toString() {
		return "TaxationResult_XQNSGG [TYPE=" + TYPE + ", nsrmc=" + nsrmc + ", nsrsbh=" + nsrsbh + ", swjgMc=" + swjgMc
				+ ", zsxmMc=" + zsxmMc + ", ssqq=" + ssqq + ", ssqz=" + ssqz + ", sk=" + sk + ", jkqx=" + jkqx
				+ ", fbrq=" + fbrq + "]";
	}	
}