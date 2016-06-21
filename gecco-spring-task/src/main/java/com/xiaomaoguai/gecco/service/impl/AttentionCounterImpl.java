package com.xiaomaoguai.gecco.service.impl;

import com.geccocrawler.gecco.pipeline.PipelineFactory;
import com.xiaomaoguai.gecco.service.AttentionCounter;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service("attentionCounter")
public class AttentionCounterImpl implements AttentionCounter {

	private final ConcurrentMap<Integer, Counter> counterMap = new ConcurrentHashMap<Integer, Counter>();
	
//	@Autowired
//	private LocationService locationService;

		@Resource
	private PipelineFactory pipelineFactory;

	@Override
	public boolean exists(int locationId)  {
		return counterMap.containsKey(locationId);
	}

	@Override
	public int getCurrentCount(int locationId)  {
		Counter counter = counterMap.get(locationId);
		return counter != null ? counter.getCount() : 0;
	}

	@Override
	public int increaseAndGet(int locationId, int count)  {
		Counter counter = counterMap.putIfAbsent(locationId, new Counter(locationId, 0, true));
		counter = counterMap.get(locationId);
		counter.setModified(true);
		return counter.increase(count);
	}

	@PreDestroy
	@Override
	public void saveToDB()  {
		System.out.println("saveToDB...");
		Collection<Counter> counters = counterMap.values();
		List<Map<String, Integer>> modifiedList = new ArrayList<Map<String, Integer>>();
		for (Counter counter : counters) {
			if (counter.isModified()) {
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("id", counter.getLocationId());
				map.put("count", counter.getCount());
				modifiedList.add(map);
				counter.setModified(false);
			}
		}
//		if (!modifiedList.isEmpty())
//			locationService.updateAttention(modifiedList);
	}

	private class Counter {

		private final int locationId;
		private int count;
		private boolean modified;

		public int getCount() {
			return count;
		}

		public boolean isModified() {
			return modified;
		}

		public void setModified(boolean modified) {
			this.modified = modified;
		}

		public int getLocationId() {
			return locationId;
		}

		public Counter(int locationId, int count, boolean modified) {
			super();
			this.locationId = locationId;
			this.count = count;
			this.modified = modified;
		}

		public synchronized int increase(int n) {
			this.count += n;
			return this.count;
		}
	}
}
