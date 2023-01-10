//package com.docmatter.ims.mapred.ctxmessage;
//
//import org.apache.hadoop.conf.Configured;
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapreduce.Job;
//import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
//import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
//import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
//import org.apache.hadoop.util.Tool;
//
//
///**
// * The entry point for the CtxMessageMapredDriver example,
// * which setup the Hadoop job with Map and Reduce Class
// *
// */
//public class CtxMessageMapredDriver extends Configured implements Tool{
//
//	/**
//	 * Run method which schedules the Hadoop Job
//	 * @param args Arguments passed in main function
//	 */
//	public int run(String[] args) throws Exception {
//		if (args.length != 2) {
//			System.err.printf("Usage: %s needs two arguments <input> <output> files\n",
//					getClass().getSimpleName());
//			return -1;
//		}
//
//		//Initialize the Hadoop job and set the jar as well as the name of the Job
//		Job job = new Job();
//		job.setJarByClass(CtxMessageMapredDriver.class);
//		job.setJobName("CtxMessageJob");
//
//		//Add input and output file paths to job based on the arguments passed
//		FileInputFormat.addInputPath(job, new Path(args[0]));
//		FileOutputFormat.setOutputPath(job, new Path(args[1]));
//
//		job.setOutputKeyClass(Text.class);
//		job.setOutputValueClass(IntWritable.class);
//		job.setOutputFormatClass(TextOutputFormat.class);
//
//		//Set the CtxMessageMapperClass and CtxMessageReducerClass in the job
//		job.setMapperClass(CtxMessageMapperClass.class);
//		job.setReducerClass(CtxMessageReducerClass.class);
//
//		//Wait for the job to complete and print if the job was successful or not
//		int returnValue = job.waitForCompletion(true) ? 0:1;
//
//		if(job.isSuccessful()) {
//			System.out.println(job.getJobName() + " job was successful");
//		} else if(!job.isSuccessful()) {
//			System.out.println(job.getJobName() + " job was not successful");
//		}
//
//		return returnValue;
//	}
//}
