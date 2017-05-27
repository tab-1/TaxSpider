package org.xtu.common;

import org.json.JSONException;
import org.json.JSONObject;

public class TaxationResult_XQSBGG {
	public String TYPE = "限期申报公告";
	public String nsrmc = ""; //纳税人名称
	public String nsrsbh = ""; //纳税人识别号
	public String swjgMc = "";  //纳税人主管税务机关
	public String zsxmMc = "";  //税种
	public String ssqq = "";  //所属期起
	public String ssqz = ""; //所属期止
	public String sbqx = ""; //申报期限
	public String fbrq = ""; //发布日期


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
			json.put("sbqx", sbqx);
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
	public String getSbqx() {
		return sbqx;
	}
	public void setSbqx(String sbqx) {
		this.sbqx = sbqx;
	}
	public String getFbrq() {
		return fbrq;
	}
	public void setFbrq(String fbrq) {
		this.fbrq = fbrq;
	}
	@Override
	public String toString() {
		return "TaxationResult_XQSBGG [TYPE=" + TYPE + ", nsrmc=" + nsrmc + ", nsrsbh=" + nsrsbh + ", swjgMc=" + swjgMc
				+ ", zsxmMc=" + zsxmMc + ", ssqq=" + ssqq + ", ssqz=" + ssqz + ", sbqx=" + sbqx + ", fbrq=" + fbrq
				+ "]";
	}	
}