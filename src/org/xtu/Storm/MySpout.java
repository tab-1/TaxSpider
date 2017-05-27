package org.xtu.Storm;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

public class MySpout extends BaseRichSpout{
	private static final long serialVersionUID = 1L;
	public SpoutOutputCollector _collector;
	public KafkaConsumer<String, String> consumer;
	@Override
	public void nextTuple() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long time = System.currentTimeMillis();
		String[] sources = new String[]{"org.xtu.ajnsr.ChongQingDS",
				"org.xtu.ajnsr.FuJianDS","org.xtu.ajnsr.InitCredit",
				"org.xtu.qsgg.BeiJingQSDS","org.xtu.qsgg.ShangHaiQS",
				"org.xtu.qsgg.TianJinGS","org.xtu.zjsxgg.BeiJingZJSXGGDS"};
		for (int i = 0; i < sources.length; i++) {
			_collector.emit(new Values(sources[i],time));
			System.out.println("发射  " + sources[i]);
		}
		
		
	}

	@Override
	public void open(Map conf, TopologyContext context,
			SpoutOutputCollector collector) {
		_collector = collector;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("InputTuple","Time"));
	}

}
