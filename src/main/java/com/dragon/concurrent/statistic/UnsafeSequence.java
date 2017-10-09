package com.dragon.concurrent.statistic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Oct 5, 2017
 * 
 *         <Specification> : 线程不安全的统计功能
 * 
 *         采用jmeter进行压力测试,为了使压测的所有线程都能获得相同的实例,直接静态初始化属性和提供一个静态的方法获得实例
 * 
 */
public class UnsafeSequence {

	private static Logger logger = LogManager.getLogger(UnsafeSequence.class);

	// @GuardedBy("this")
	private int value;

	private static UnsafeSequence unsafeSequence = new UnsafeSequence();

	public int getNextInt() {
		++value;
		return value;
	}

	public static UnsafeSequence getInstance() {
		return unsafeSequence;
	}
}
