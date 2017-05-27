package org.xtu.Storm;

import java.lang.reflect.Method;
import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.xtu.common.MyLog;

public class workBolt extends BaseRichBolt{
	private static final long serialVersionUID = 1L;
	public String location = "";
	public OutputCollector _collector;
	@Override
	public void execute(Tuple tuple) {
		try {
			String crawlClass = tuple.getString(0);
			Class<?> sClazz = Class.forName(crawlClass);
			Object sObj = sClazz.newInstance();//子类实例
			//1.反射调用子类父类的重载方法
			Method sMethod = getMethod(crawlClass,sClazz);
			sMethod.invoke(sObj);
			this._collector.emit(tuple,new Values("success"));
		} catch (Exception e) {
			MyLog.error(this.getClass(), e.getMessage());
		}
	}
	@Override
	public void prepare(Map conf, TopologyContext context, OutputCollector collector) {
		this._collector = collector;
	}
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("work"));
	}
	
	
	
	public Method getMethod(String crawlClass,Class<?> sClazz){
		Method sMethod = null;
		try {
			System.out.println(crawlClass);
			String location = crawlClass.split("\\.")[2];
			switch (location) {
				case "ajnsr" :
					sMethod = sClazz.getDeclaredMethod("GetTaxation_A");
					break;
				case "qsgg" :
					sMethod = sClazz.getDeclaredMethod("GetTaxation_QSGG");
					break;
				case "zjsxgg" :
					sMethod = sClazz.getDeclaredMethod("GetTaxation_ZJSXGG");
					break;
				default :
					break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return sMethod;
	}
}
