package com.phd.bioinfo.lesson1;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class WordCountHomeMade {
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		Configuration conf = new Configuration();// c'est mieux le mêttre et là on charge la conf default de hadoop
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs(); //C'est une parser de la configuration hadoop et le args ajouté pour faire marcher le job
		
		Job job = Job.getInstance(conf); // Begin Job
		
		/*
		 * .setOutputKeyClass(Object.class) and setOutputValueClass(IntWritable)
		 * are very important to export these object in Mapper and Reducer class. 
		 * 
		 * Some errors are related if we don't use them.
		 */
		
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);

		for (int i = 0; i < otherArgs.length - 1; ++i) { // Pour parcourir tous les argument sauf le dernière que doit être le output folder
			FileInputFormat.addInputPath(job, new Path(otherArgs[i])); // le path c'est propre a Hadoop et peut être referencier a tout (internet, local...).
		}
		FileOutputFormat.setOutputPath(job,
				new Path(otherArgs[otherArgs.length - 1]));

		int res = job.waitForCompletion(true) ? 0 : 1; // verify if job is complete
		System.exit(res); //
	}
}
