package com.dragon.concurrent.statistic.test;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.dragon.concurrent.statistic.SafeSequenceConcurrent;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Oct 5, 2017
 * 
 *         <Specification> : 对使用Concurrent包的线程安全的方式进行测试
 *         
 *         <Result>:63542q/s  ; 55681q/s  ; 56000q/s
 * 
 */
public class SafeSequenceConcurrentTest extends AbstractJavaSamplerClient {

	/**
	 * 通过伪单例先获取到被测类的唯一实例
	 */
	SafeSequenceConcurrent safeSequence = SafeSequenceConcurrent.getInstance();

	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
		SampleResult sampleResult = new SampleResult();
		sampleResult.sampleStart();
		long nextInt = safeSequence.getCount();
		System.err.println(nextInt);
		sampleResult.setSuccessful(true);
		sampleResult.setResponseCode("200");
		sampleResult.setResponseData("hints = " + nextInt + "-", null);
		sampleResult.sampleEnd();
		return sampleResult;
	}

}
