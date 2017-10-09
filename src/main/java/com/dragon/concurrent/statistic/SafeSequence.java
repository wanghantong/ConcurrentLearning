package com.dragon.concurrent.statistic;

import javax.annotation.concurrent.GuardedBy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Oct 5, 2017
 * 
 *         <Specification> :
 *         测试当前统计功能,采用线程安全的synchronized关键字进行同步取值的方法,但是对于属性没有使用@GuardedBy("this")
 *         注解进行,需要和属性带 @GuardedBy("this")的进行比较
 * 
 *         <Result>:测试发现没有使用@GuardedBy("this")和使用@GuardedBy("this")测试过程中没区别,
 * 
 *         但是可能是因为当前方法体的问题,至少在本次测试中没发现问题
 */
public class SafeSequence {

	private static Logger logger = LogManager.getLogger(SafeSequence.class);

	@GuardedBy("this")
	private int value;

	private static SafeSequence safeSequence = new SafeSequence();

	public synchronized int getNextInt() {
		++value;
		// logger.error(this.getClass().getName() + value);
		return value;
	}

	public static SafeSequence getInstance() {
		return safeSequence;
	}
}
