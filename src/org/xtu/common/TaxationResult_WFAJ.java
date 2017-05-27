package org.xtu.common;

import org.json.JSONException;
import org.json.JSONObject;

public class TaxationResult_WFAJ {
	public String TYPE = "违法案件公告";
	public String nsrmc = ""; //纳税人名称
	public String nsrsbh = ""; //纳税人识别号
	public String zzjgdm = "";//组织机构代码
	public String zcdz = "";//注册地址
	public String frzjhm = "";//法定代表人或者负责人姓名、性别、证件名称及号码
	public String fzzjhm = "";//负有直接责任的财务负责人姓名、性别、证件名称及号码
	public String zjryxx = "";//负有直接责任的中介机构信息及其从业人员信息
	public String ajxz = "";//案件性质
	public String wfss = "";//主要违法事实
	public String flqk = "";//相关法律依据及税务处理处罚情况
	public JSONObject toJSONObject(){
		JSONObject json = new JSONObject();
		try {
			json.put("TYPE", TYPE);
			json.put("zzjgdm", zzjgdm);
			json.put("zcdz", zcdz);
			json.put("frzjhm", frzjhm);
			json.put("nsrmc", nsrmc);
			json.put("fzzjhm", fzzjhm);
			json.put("zjryxx", zjryxx);
			json.put("ajxz", ajxz);
			json.put("wfss", wfss);
			json.put("flqk", flqk);
			json.put("nsrsbh", nsrsbh);
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
	public String getZzjgdm() {
		return zzjgdm;
	}
	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}
	public String getZcdz() {
		return zcdz;
	}
	public void setZcdz(String zcdz) {
		this.zcdz = zcdz;
	}
	public String getFrzjhm() {
		return frzjhm;
	}
	public void setFrzjhm(String frzjhm) {
		this.frzjhm = frzjhm;
	}
	public String getFzzjhm() {
		return fzzjhm;
	}
	public void setFzzjhm(String fzzjhm) {
		this.fzzjhm = fzzjhm;
	}
	public String getZjryxx() {
		return zjryxx;
	}
	public void setZjryxx(String zjryxx) {
		this.zjryxx = zjryxx;
	}
	public String getAjxz() {
		return ajxz;
	}
	public void setAjxz(String ajxz) {
		this.ajxz = ajxz;
	}
	public String getWfss() {
		return wfss;
	}
	public void setWfss(String wfss) {
		this.wfss = wfss;
	}
	public String getFlqk() {
		return flqk;
	}
	public void setFlqk(String flqk) {
		this.flqk = flqk;
	}
	@Override
	public String toString() {
		return "TaxationResult_WFAJ [TYPE=" + TYPE + ", nsrmc=" + nsrmc + ", nsrsbh=" + nsrsbh + ", zzjgdm=" + zzjgdm
				+ ", zcdz=" + zcdz + ", frzjhm=" + frzjhm + ", fzzjhm=" + fzzjhm + ", zjryxx=" + zjryxx + ", ajxz="
				+ ajxz + ", wfss=" + wfss + ", flqk=" + flqk + "]";
	}	
}