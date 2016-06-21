package com.road.crawler.meizitu.exec;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.log4j.Logger;

public class AbstractActionQueue implements ActionQueue {

	protected final static Logger LOG = Logger.getLogger(AbstractActionQueue.class);

	private Queue<Action> queue;
	private Executors executor;

	public AbstractActionQueue(Executors executor) {
		super();
		this.queue = new LinkedList<Action>();
		this.executor = executor;
	}

	@Override
	public ActionQueue getActionQueue() {
		return this;
	}

	@Override
	public void enqueue(Action action) {
		boolean canExecute = false;
		synchronized (queue) {
			queue.add(action);
			if (queue.size() == 1) {
				canExecute = true;
			} else if (queue.size() > 1000) {
				LOG.warn(action.toString() + " queue size : " + queue.size());
			}
		}

		if (canExecute) {
			executor.execute(action);
		}
	}

	@Override
	public void dequeue(Action action) {
		Action nextAction = null;
		synchronized (queue) {
			if (queue.size() == 0) {
				LOG.error("queue.size() is 0.");
			}
			Action temp = queue.remove();
			if (temp != action) {
				LOG.error("action queue error. temp " + temp.toString() + ", action : " + action.toString());
			}
			if (queue.size() != 0) {
				nextAction = queue.peek();
			}
		}
		if (nextAction != null) {
			executor.execute(nextAction);
		}
	}

	@Override
	public void clear() {
		synchronized (queue) {
			queue.clear();
		}
	}

	@Override
	public Queue<Action> getQueue() {
		return this.queue;
	}

}
