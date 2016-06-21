package com.xiaomaoguai.gecco.service;

/**
 * 小区热度计数器
 * 
 * @author Administrator
 *
 */
public interface AttentionCounter {

	boolean exists(int villageId);

	int getCurrentCount(int villageId);

	int increaseAndGet(int villageId, int count);

	void saveToDB();
}
