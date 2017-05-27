package org.xtu.common;


public abstract class TaxationFactory {
	public NewMongo mongo ;
	
	public TaxationFactory() {
		super();
		this.mongo = new NewMongo("test","Taxation");
	}
	/**
	 * 从税务网站获取A级别纳税人数据
	 * @return
	 */
	public abstract TaxationResult_A GetTaxation_A();
	
	public abstract TaxationResult_A GetTaxation_A(String keyword);
	/**
	 * 从税务网站获取违法案件公告数据
	 * @return
	 */
	public abstract TaxationResult_WFAJ GetTaxation_WFAJ();
	
	public abstract TaxationResult_WFAJ GetTaxation_WFAJ(String keyword);
	
	
	/**
	 * 从税务网站获取欠税公告数据
	 * @param _id
	 * @param Taxation_QSGG
	 */
	public abstract TaxationResult_QSGG GetTaxation_QSGG();
	
	public abstract TaxationResult_QSGG GetTaxation_QSGG(String keyword);
	
	/**
	 * 从税务网站获取委托代征协议书公告数据
	 * @param _id
	 * @param Taxation_DZXYSGG
	 */
	public abstract TaxationResult_DZXYSGG GetTaxation_DZXYSGG();
	
	public abstract TaxationResult_DZXYSGG GetTaxation_DZXYSGG(String keyword);
	
	/**
	 * 从税务网站获取委托代征协议书终止公告数据
	 * @param _id
	 * @param Taxation_DZXYSZZGG
	 */
	public abstract TaxationResult_DZXYSZZGG GetTaxation_DZXYSZZGG();
	
	public abstract TaxationResult_DZXYSZZGG GetTaxation_DZXYSZZGG(String keyword);
	
	/**
	 * 从税务网站获取非正常户公告数据
	 * @param _id
	 * @param Taxation_FZCHGG
	 */
	public abstract TaxationResult_FZCHGG GetTaxation_FZCHGG();
	
	public abstract TaxationResult_FZCHGG GetTaxation_FZCHGG(String keyword);
	/**
	 * 从税务网站获取个体工商户定额公告数据
	 * @param _id
	 * @param Taxation_GTHDEGG
	 */
	public abstract TaxationResult_GTHDEGG GetTaxation_GTHDEGG();
	
	public abstract TaxationResult_GTHDEGG GetTaxation_GTHDEGG(String keyword);
	
	/**
	 * 从税务网站获取个体工商户定额公示数据
	 * @param _id
	 * @param Taxation_GTHDEGS
	 */
	public abstract TaxationResult_GTHDEGS GetTaxation_GTHDEGS();
	
	public abstract TaxationResult_GTHDEGS GetTaxation_GTHDEGS(String keyword);
	
	/**
	 * 从税务网站获取个体工商户定额历史公示数据
	 * @param _id
	 * @param Taxation_GTHDELSGS
	 */
	public abstract TaxationResult_GTHDELSGS GetTaxation_GTHDELSGS();
	
	public abstract TaxationResult_GTHDELSGS GetTaxation_GTHDELSGS(String keyword);
	
	/**
	 * 从税务网站获取限期申报公告数据
	 * @param _id
	 * @param Taxation_XQSBGG
	 */
	public abstract TaxationResult_XQSBGG GetTaxation_XQSBGG();
	
	public abstract TaxationResult_XQSBGG GetTaxation_XQSBGG(String keyword);
	
	/**
	 * 从税务网站获取限期纳税公告数据
	 * @param _id
	 * @param Taxation_XQNGSG
	 */
	public abstract TaxationResult_XQNSGG GetTaxation_XQNSGG();
	
	public abstract TaxationResult_XQNSGG GetTaxation_XQNSGG(String keyword);
	
	/**
	 * 从税务网站获取税务证件登记失效公告数据
	 * @param _id
	 * @param Taxation_ZJSXGG
	 */
	public abstract TaxationResult_ZJSXGG GetTaxation_ZJSXGG();
	
	public abstract TaxationResult_ZJSXGG GetTaxation_ZJSXGG(String keyword);
	
	public synchronized void inseartMongo(String _id , TaxationResult_XQSBGG Taxation_XQSBGG){
		mongo.saveWhenNotEist(_id, Taxation_XQSBGG.toJSONObject());
	}
	
	public synchronized void inseartMongo(String _id , TaxationResult_XQNSGG Taxation_XQNSGG){
		mongo.saveWhenNotEist(_id, Taxation_XQNSGG.toJSONObject());
	}
	
	public synchronized void inseartMongo(String _id , TaxationResult_DZXYSZZGG Taxation_DZXYSZZGG){
		mongo.saveWhenNotEist(_id, Taxation_DZXYSZZGG.toJSONObject());
	}
	
	public synchronized void inseartMongo(String _id , TaxationResult_DZXYSGG Taxation_DZXYSGG){
		mongo.saveWhenNotEist(_id, Taxation_DZXYSGG.toJSONObject());
	}
	public synchronized void inseartMongo(String _id , TaxationResult_GTHDEGS Taxation_GTHDEGS){
		mongo.saveWhenNotEist(_id, Taxation_GTHDEGS.toJSONObject());
	}
	public synchronized void inseartMongo(String _id , TaxationResult_GTHDEGG Taxation_GTHDEGG){
		mongo.saveWhenNotEist(_id, Taxation_GTHDEGG.toJSONObject());
	}
	public synchronized void inseartMongo(String _id , TaxationResult_A Taxation_A){
		mongo.saveWhenNotEist(_id, Taxation_A.toJSONObject());
	}
	public synchronized void inseartMongo(String _id , TaxationResult_ZJSXGG Taxation_ZJSXGG){
		mongo.saveWhenNotEist(_id, Taxation_ZJSXGG.toJSONObject());
	}
	public synchronized void inseartMongo(String _id , TaxationResult_FZCHGG Taxation_FZCHGG){
		mongo.saveWhenNotEist(_id, Taxation_FZCHGG.toJSONObject());
//		mongo.saveOrReplaceOneDocument(_id, Taxation_FZCHGG.toJSONObject());
	}
	public synchronized void inseartMongo(String _id , TaxationResult_QSGG Taxation_QSGG){
		mongo.saveWhenNotEist(_id, Taxation_QSGG.toJSONObject());
	}
	public synchronized void inseartMongo(String _id , TaxationResult_WFAJ Taxation_WFAJ){
		mongo.saveWhenNotEist(_id, Taxation_WFAJ.toJSONObject());
//		mongo.saveOrReplaceOneDocument(_id, Taxation_WFAJ.toJSONObject());
	}
	/**
	 * 判断此条数据是否在mongo中
	 * @param _id
	 * @return
	 */
	public synchronized boolean ask_exist(String _id){
		return mongo.ask_exist(_id);
	}
	public void release() {
		mongo.close();
	}
}