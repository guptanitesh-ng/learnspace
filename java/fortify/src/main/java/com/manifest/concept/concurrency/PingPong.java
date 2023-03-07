package com.manifest.concept.concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.manifest.concept.LoggerFactory;

/**
 * Print ping pong using two threads.
 * 
 * @author nitesh.gupta
 *
 */
public class PingPong implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(PingPong.class.getName());

	private String name;

	private Object lock;

	public PingPong(String name, Object lock) {
		this.name = name;
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			int count = 0;
			while (true) {
				logger.log(Level.INFO, name + "---> " + ++count);
				// System.out.println( name + "---> " + ++count);
				lock.notify();
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
			}
		}

	}

}
