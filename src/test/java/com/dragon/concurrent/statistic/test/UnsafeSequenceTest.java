package com.dragon.concurrent.statistic.test;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.dragon.concurrent.statistic.UnsafeSequence;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Oct 5, 2017
 * 
 *         <Specification> : 对线程不安全的方法进行测试类
 * 
 */
public class UnsafeSequenceTest extends AbstractJavaSamplerClient {
	/**
	 * 获取唯一实例进行测试
	 */
	UnsafeSequence unsafeSequence = UnsafeSequence.getInstance();

	@Override
	public SampleResult runTest(JavaSamplerContext context) {
		SampleResult sampleResult = new SampleResult();
		sampleResult.sampleStart();
		int nextInt = unsafeSequence.getNextInt();
		System.err.println(nextInt);
		sampleResult.setSuccessful(true);
		sampleResult.setResponseCode("200");
		sampleResult.setResponseData("hints = " + nextInt + "-", null);
		sampleResult.sampleEnd();
		return sampleResult;

	}

}
