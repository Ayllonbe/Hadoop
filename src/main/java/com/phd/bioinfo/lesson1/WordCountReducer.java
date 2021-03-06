package com.phd.bioinfo.lesson1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> { //Reducer<KEYIN, VALUEIN, KEYOUT, VALUEOUT>

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context ctx) throws IOException, InterruptedException {
		
			int sum = 0;
			for (IntWritable val : values) {
				sum += val.get();
			}

			ctx.write(key, new IntWritable(sum));
		
	}
}
