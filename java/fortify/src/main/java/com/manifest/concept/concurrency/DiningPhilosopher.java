package com.manifest.concept.concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.manifest.concept.LoggerFactory;

/**
 * Problem statement
 * 
 * Imagine you have five philosophers sitting around a roundtable. The
 * philosophers do only two kinds of activities. One: they contemplate, and two:
 * they eat.
 * 
 * However, they have only five forks between themselves to eat their food with.
 * Each philosopher requires both the fork to his left and the fork to his right
 * to eat his food.
 * 
 * Design a solution where each philosopher gets a chance to eat his food
 * without causing a deadlock.
 * 
 * 
 * Tips to help solve the problem
 * 
 * Think about the circular wait condition and how to prevent it. You could
 * impose ordering on your condition variables to help prevent deadlocks
 * 
 * Think of each fork as a resource that two of the philosophers on either side
 * can attempt to acquire. This intuitively suggests using a semaphore with a
 * permit value of 1 to represent a fork. Each philosopher can then be thought
 * of as a thread that tries to acquire the forks to the left and right of it.
 * 
 * When a philosopher wants to eat, he needs the fork to the left and right of
 * him. So:
 * 
 * Philosopher A(0) needs forks 4 and 0 Philosopher B(1) needs forks 0 and 1
 * Philosopher C(2) needs forks 1 and 2 Philosopher D(3) needs forks 2 and 3
 * Philosopher E(4) needs forks 3 and 4 Each thread (philosopher) will need to
 * tell you what ID it is before you can attempt to lock the appropriate forks.
 * 
 * 
 * Common pitfalls
 * 
 * A common pitfall that developers run into here is circular wait, which is one
 * of the four Coffman conditions. Circular wait describes a condition where two
 * or more processes are waiting for resources held by one of the other
 * processes.
 * 
 * To avoid this pitfall, you should impose ordering on the condition variables
 * (i.e. number the forks 0-4) and tell each of the philosophers to pick up the
 * lower number fork except one which picks higher number fork first.
 * 
 * Starvation is also another common pitfall.
 * 
 * Imagine that you are trying to starve Philosopher 0. Initially, 2 and 4 are
 * at the table and 1 and 3 are hungry. Imagine that 2 gets up and 1 sits down;
 * then 4 gets up and 3 sits down.
 * 
 * Now you are in a mirror image of the starting position. If 3 gets up and 4
 * sits down, and then 1 gets up and 2 sits down, we are back where we started.
 * We could repeat the cycle indefinitely and Philosopher 0 would starve.
 * 
 * @author nitesh.gupta
 *
 */
public class DiningPhilosopher implements Runnable {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private String name;
	private Object leftFork;
	private Object rightFork;

	public DiningPhilosopher(String name, Object leftFork, Object rightFork) {
		super();
		this.name = name;
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (leftFork) {
				synchronized (rightFork) {
					// start eating
					logger.log(Level.INFO, name + " eating now.");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			logger.log(Level.INFO, name + " thinking now.");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
