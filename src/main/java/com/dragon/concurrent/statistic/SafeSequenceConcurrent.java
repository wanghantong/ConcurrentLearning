package com.dragon.concurrent.statistic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Oct 5, 2017
 * 
 *         <Specification> : 测试线程安全的计数器,采用Concurrent的AtomicLong进行统计
 * 
 *         <Result>: 线程安全,并发环境下计数无误
 * 
 */
public class SafeSequenceConcurrent {
	// private static Logger logger = LogManager.getLogger(SafeSequence.class);

	private final AtomicLong count = new AtomicLong(0);

	public Long getCount() {
		long incrementAndGet = count.incrementAndGet();
		return incrementAndGet;
	}

	private static SafeSequenceConcurrent safeSequence = new SafeSequenceConcurrent();

	public static SafeSequenceConcurrent getInstance() {
		if (safeSequence == null) {
			safeSequence = new SafeSequenceConcurrent();
		}
		return safeSequence;
	}

}
