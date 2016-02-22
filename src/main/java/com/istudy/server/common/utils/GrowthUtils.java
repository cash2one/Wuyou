package com.istudy.server.common.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class GrowthUtils {
	private static final AtomicInteger FILE_GROW = new AtomicInteger(0);
	
	public static String getFileGrowthStr(){
		FILE_GROW.compareAndSet(10, 0);
		int current = FILE_GROW.getAndIncrement();
		return String.valueOf(current);
	}
}
