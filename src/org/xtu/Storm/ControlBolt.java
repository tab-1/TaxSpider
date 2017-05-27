package org.xtu.Storm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.xtu.common.MyLog;

public class ControlBolt extends BaseRichBolt{

	private static final long serialVersionUID = 1L;
	public OutputCollector _collector;
	public String CrawlClass = "";

	@Override
	public void execute(Tuple tuple) {
		
		CrawlClass = tuple.getString(0);
		long Time = tuple.getLong(1);
		long currentTime = System.currentTimeMillis();
		long diff= currentTime - Time;
		long day = diff / (24 * 60 * 60 * 1000);  
		long hour = (diff / (60 * 60 * 1000) - day * 24);
		if(hour < 6){
			System.err.println("时间差小于6小时  丢弃");
		}else{
			this._collector.emit(tuple,new Values(CrawlClass));
		}
		
		
	}

	@Override
	public void prepare(Map conf, TopologyContext context, OutputCollector collection) {
		this._collector = collection;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("Location"));
	}

}
