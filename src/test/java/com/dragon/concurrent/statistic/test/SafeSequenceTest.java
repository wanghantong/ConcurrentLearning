package com.dragon.concurrent.statistic.test;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.dragon.concurrent.statistic.SafeSequence;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Oct 5, 2017
 * 
 *         <Specification> : 对使用同步synchronize的方法进行测试
 * 
 *         <Result>: 57000q/s ; 48685q/s ; 52600q/s ; 49700q/s
 * 
 */
public class SafeSequenceTest extends AbstractJavaSamplerClient {

	SafeSequence safeSequence = SafeSequence.getInstance();

	@Override
	public SampleResult runTest(JavaSamplerContext context) {
		SampleResult sampleResult = new SampleResult();
		sampleResult.sampleStart();
		long nextInt = safeSequence.getNextInt();
		System.err.println(nextInt);
		sampleResult.setSuccessful(true);
		sampleResult.setResponseCode("200");
		sampleResult.setResponseData("hints = " + nextInt + "-", null);
		sampleResult.sampleEnd();
		return sampleResult;

	}

}
