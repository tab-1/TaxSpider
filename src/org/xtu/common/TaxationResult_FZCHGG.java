package org.xtu.common;

import org.json.JSONException;
import org.json.JSONObject;
public class TaxationResult_FZCHGG {
	public String TYPE = "非正常户公告";
	public String qymc = ""; //企业名称
	public String nsrsbh = ""; //纳税人识别号
	public String fddbrmc = ""; //法人姓名
	public String sfzjhm = ""; //身份证号码
	public String jydz = ""; //经营地址
	public String rddw = ""; //认定单位
	public String rdsj = ""; //认定时间
	public String gsnsrzt = ""; //纳税人状态
	public JSONObject toJSONObject(){
		JSONObject json = new JSONObject();
		try {
			json.put("TYPE", TYPE);
			json.put("qymc", qymc);
			json.put("nsrsbh", nsrsbh);
			json.put("fddbrmc", fddbrmc);
			json.put("sfzjhm", sfzjhm);
			json.put("jydz", jydz);
			json.put("rddw", rddw);
			json.put("rdsj", rdsj);
			json.put("gsnsrzt", gsnsrzt);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public String getRdsj() {
		return rdsj;
	}

	public void setRdsj(String rdsj) {
		this.rdsj = rdsj;
	}

	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getQymc() {
		return qymc;
	}
	public void setQymc(String qymc) {
		this.qymc = qymc;
	}
	public String getNsrsbh() {
		return nsrsbh;
	}
	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}
	public String getFddbrmc() {
		return fddbrmc;
	}
	public void setFddbrmc(String fddbrmc) {
		this.fddbrmc = fddbrmc;
	}
	public String getSfzjhm() {
		return sfzjhm;
	}
	public void setSfzjhm(String sfzjhm) {
		this.sfzjhm = sfzjhm;
	}
	public String getJydz() {
		return jydz;
	}
	public void setJydz(String jydz) {
		this.jydz = jydz;
	}
	public String getRddw() {
		return rddw;
	}
	public void setRddw(String rddw) {
		this.rddw = rddw;
	}

	public String getGsnsrzt() {
		return gsnsrzt;
	}

	public void setGsnsrzt(String gsnsrzt) {
		this.gsnsrzt = gsnsrzt;
	}

	@Override
	public String toString() {
		return "TaxationResult_FZCHGG [TYPE=" + TYPE + ", qymc=" + qymc + ", nsrsbh=" + nsrsbh + ", fddbrmc=" + fddbrmc
				+ ", sfzjhm=" + sfzjhm + ", jydz=" + jydz + ", rddw=" + rddw + ", rdsj=" + rdsj + ", gsnsrzt=" + gsnsrzt
				+ "]";
	}
}