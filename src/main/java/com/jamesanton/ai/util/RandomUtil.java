package com.jamesanton.ai.util;

import java.util.Random;

public class RandomUtil {
	private static final Random R = new Random();
	
	public static int getRandomNumberStartingFromZero(int maximumExclusive){
		return R.nextInt(maximumExclusive);
	}
	
	public static String getRandomAsStringStartingFromZero(int maxNumberExclusive) {
		return String.valueOf(R.nextInt(maxNumberExclusive));
	}
	
	public static int getRandomNumberBetween(int lower, int max) {
		return R.nextInt((max - lower) + 1) + lower;
	}
}
