package com.manifest.concept.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

/**
 * This is a pool of threads which reuses a fixed number of threads to execute
 * tasks.
 * 
 * At any point, at most nThreads threads will be active processing tasks. If
 * additional tasks are submitted when all threads are active, they will wait in
 * the queue until a thread is available.
 * 
 * @author nitesh.gupta
 *
 */
public class CustomThreadPool {

	private BlockingQueue<Runnable> runnableTasks = new LinkedBlockingQueue<Runnable>();
	private AtomicBoolean shutdown = new AtomicBoolean(false);
	private Collection<Worker> threadPool = new ArrayList<Worker>();

	public CustomThreadPool(int threadCount) {
		// TODO - instead of creating the threads at the time of construction a lazy
		// creation approach could be adopted at the time of submission of runnable for
		// execution.
		IntStream.rangeClosed(1, threadCount).forEach(i -> threadPool.add(new Worker(runnableTasks)));
	}

	public void execute(Runnable runnable) {
		runnableTasks.offer(runnable);
	}

	public boolean shutdown() {
		boolean isShutdown = shutdown.compareAndSet(false, true);
		if (isShutdown) {
			threadPool.stream().forEach(w -> w.interrupt());
		} else {
			// log pool already shutdown
		}
		return isShutdown;
	}

	private class Worker implements Runnable {

		private BlockingQueue<Runnable> runnableTasks;
		private Thread thread;
		private AtomicBoolean stopped = new AtomicBoolean(false);

		public Worker(BlockingQueue<Runnable> runnableTasks) {
			this.runnableTasks = runnableTasks;
			this.thread = new Thread(this);
			this.thread.start();
		}

		public void interrupt() {
			if (this.thread.isAlive()) {
				thread.interrupt();
			}
		}

		@Override
		public void run() {
			while (!stopped.get()) {
				try {
					Runnable task = runnableTasks.take();
					task.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
