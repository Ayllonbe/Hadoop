package com.phd.bioinfo.lesson1;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper 
extends Mapper<LongWritable, Text,Text , IntWritable>{ //Mapper<KEYIN, VALUEIN, KEYOUT, VALUEOUT>
	/*
	 * Les structure de donnée comme string et int c'est different en hadoop à la forme java. exemple String c'est Text
	 */

	// La function map c'est la plus important. L'essentiel!

	@Override
	protected void map(
			LongWritable key,
			Text value,
			Mapper<LongWritable, Text, Text, IntWritable>.Context context
			)
					throws IOException, InterruptedException
	{
		StringTokenizer itr = new StringTokenizer(value.toString());
		
		while (itr.hasMoreTokens()) {
			Text newKey = new Text(itr.nextToken());
			IntWritable newValue = new IntWritable(1);
			context.write(newKey, newValue); // pour chaque instance key:value
			
		}
	}
}
