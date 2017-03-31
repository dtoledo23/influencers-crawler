package com.toledo;

import scala.Tuple2;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfluencerCrawler {

	private static final Pattern SPACE = Pattern.compile(" ");
	private static final Logger logger = LoggerFactory.getLogger(InfluencerCrawler.class);

	public static void main(String[] args) throws Exception {

		logger.info("Starting Spark Java application");

		SparkSession spark = SparkSession.builder().master("local[1]").appName("JavaWordCount").getOrCreate();

		String fileName = "/Users/toledo/file.log";

		JavaRDD<String> lines = spark.read().textFile(fileName).javaRDD();

		JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(SPACE.split(s)).iterator());

		JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(s, 1));

		JavaPairRDD<String, Integer> counts = ones.reduceByKey((i1, i2) -> i1 + i2);

		List<Tuple2<String, Integer>> output = counts.collect();
		for (Tuple2<?, ?> tuple : output) {
			System.out.println(tuple._1() + ": " + tuple._2());
		}
		spark.stop();
	}
}
