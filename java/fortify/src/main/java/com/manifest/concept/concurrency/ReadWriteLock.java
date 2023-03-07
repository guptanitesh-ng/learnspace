package com.manifest.concept.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.manifest.concept.LoggerFactory;


/**
 * Problem statement
 * 
 * Imagine you have an application where you have multiple readers and a single
 * writer. You are asked to design a lock which lets multiple readers read at
 * the same time, but only one writer write at a time.
 * 
 * 
 * Tips to help solve the problem:
 * 
 * Define the APIs your class will expose. In this case you’ll need two for
 * writer and two for reader. These are:
 * 
 * acquireReadLock
 * 
 * releaseReadLock
 * 
 * acquireWriteLock
 * 
 * releaseWriteLock
 * 
 * Think about each use case that you need to satisfy.
 * 
 * Before we allow a reader to enter the critical section, we need to make sure
 * that there’s no writer in progress. It is ok to have other readers in the
 * critical section since they aren’t making any modifications.
 * 
 * Before we allow a writer to enter the critical section, we need to make sure
 * that there’s no reader or writer in the critical section.
 * 
 * Start by examining the Reader use case. You can have multiple readers acquire
 * the read lock, and to keep track of all of them you’ll need a count. You
 * increment this count whenever a reader acquires a read lock and decrement it
 * whenever a reader releases it.
 * 
 * Releasing the read lock is easy, but before you acquire the read lock, you
 * need to be sure that no other writer is currently writing. Again, you’ll need
 * some variable to keep track of whether a writer is writing.
 * 
 * Since only a single writer can write at a given point in time, you can just
 * keep a boolean variable to denote if the write lock is acquired or not.
 * 
 * Additionally, you’ll also need a condition variable for the readers and
 * writers to wait while the other party is in progress. You can use a mutex
 * lock with a condition variable to guard the sections of the code where you
 * manipulate any shared variables.
 * 
 * 
 * Common pitfalls
 * 
 * Avoid splitting the acquisition and release of the mutex variable across two
 * methods. It may seem more efficient since a writer thread only acquires and
 * releases the condition variable once during operation.
 * 
 * But the Achilles’ heel of this approach is that if the writer thread dies
 * between the two method calls, the entire system would enter a deadlock.
 * 
 * Another common pitfall of the ReadWrite Lock problem is starvation. If a
 * writer arrives while there are readers in the critical section, it might wait
 * in queue forever while readers come and go.
 * 
 * As long as a new reader arrives before the last of the current readers
 * departs, there will always be at least one reader in the room. To help avoid
 * this, you could add a mutex for the readers and allow writers to lock it.
 * 
 * @author nitesh.gupta
 *
 */
public class ReadWriteLock {

	private static final int MAX_READERS = 10;

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	private AtomicInteger writersWaiting = new AtomicInteger(0);
	private Semaphore writeLock = new Semaphore(1);
	private Semaphore readerPermits = new Semaphore(MAX_READERS);
	private Thread currentWriteLockHolder;

	public synchronized void acquireReadLock() {
		try {
			while (writeLock.availablePermits() != 1) {
				// writer in progress .. wait until it finishes.
				logger.log(Level.INFO,
						"Waiting to acquire read lock writer in progress " + Thread.currentThread().getName());
				wait();
			}
			readerPermits.acquire();
			logger.log(Level.INFO, "Read Lock acquired by " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void releaseReadLock() {
		readerPermits.release();
		logger.log(Level.INFO, "Read Lock released by " + Thread.currentThread().getName());
		if (readerPermits.availablePermits() == MAX_READERS)
			notifyAll();
	}

	public synchronized void acquireWriteLock() {
		writersWaiting.incrementAndGet();
		try {
			while (readerPermits.availablePermits() != MAX_READERS) {
				// readers in progress .. wait until they finish.
				logger.log(Level.INFO,
						"Waiting to acquire write lock readers in progress " + Thread.currentThread().getName());
				wait();
			}
			if (currentWriteLockHolder != Thread.currentThread()) {
				writeLock.acquire();
				logger.log(Level.INFO, "Write Lock acquired by " + Thread.currentThread().getName());
				currentWriteLockHolder = Thread.currentThread();
				writersWaiting.decrementAndGet();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void releaseWriteLock() {
		writeLock.release();
		logger.log(Level.INFO, "Write Lock released by " + Thread.currentThread().getName());
		currentWriteLockHolder = null;
		if (writersWaiting.get() == 0) // To ensure writers get prioritized over readers.
			notifyAll();
	}
}
