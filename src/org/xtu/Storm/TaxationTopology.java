package org.xtu.Storm;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

public class TaxationTopology {

	public static void main(String[] args) throws InterruptedException {
		TopologyBuilder builder = new TopologyBuilder();
		Config config = new Config();
		builder.setSpout("InputTuple", new MySpout(), 1);
		builder.setBolt("Location", new ControlBolt(), 3).shuffleGrouping("InputTuple");
		builder.setBolt("work", new workBolt(), 12).fieldsGrouping("Location",
				new Fields("Location"));
		config.setDebug(false);
		if (args != null && args.length > 0) {
			System.out.println(
					"-----------------------集群模式------------------------");
			try {
				config.setNumWorkers(2);
				StormSubmitter.submitTopology(args[0], config,
						builder.createTopology());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(
					"-----------------------本地模式------------------------");
			config.setMaxTaskParallelism(1);
			LocalCluster cluster = new LocalCluster();
			cluster.submitTopology("TaxationTopology", config,
					builder.createTopology());
			Thread.sleep(1000000);
			cluster.killTopology("TaxationTopology");
			cluster.shutdown();
		}
	}
}
