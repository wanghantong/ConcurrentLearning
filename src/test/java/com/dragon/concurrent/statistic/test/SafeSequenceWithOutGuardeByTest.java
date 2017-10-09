package com.dragon.concurrent.statistic.test;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.dragon.concurrent.statistic.SafeSequenceWithOutGuardeBy;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Oct 5, 2017
 * 
 *         <Specification> : 对使用同步synchronize的方法进行测试
 * 
 */
public class SafeSequenceWithOutGuardeByTest extends AbstractJavaSamplerClient {

	SafeSequenceWithOutGuardeBy safeSequence = SafeSequenceWithOutGuardeBy.getInstance();

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
