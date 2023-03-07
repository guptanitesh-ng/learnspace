package com.manifest.concept.concurrency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.manifest.concept.LoggerFactory;

/**
 * Write a program WordCount that counts the words in one or more files. Start a
 * new thread for each file. For example, if you call java WordCount report.txt
 * address.txt Homework.java then the program might print address.txt: 1052
 * Homework.java: 445 report.txt: 2099
 * 
 * Enhance the program of Exercise P20.7 so that the last active thread also
 * prints a combined count. Use locks to protect the combined word count and a
 * counter of active threads.
 * 
 * @author nitesh.gupta
 *
 */
public class WordCounter {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	private AtomicLong totalWordCount = new AtomicLong(0);

	private AtomicLong totalFileCount;

	public void readFilesToPrintWordCount(String path) {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		File[] files = new File(path).listFiles();
		totalFileCount = new AtomicLong(Arrays.stream(files).filter(f -> f.isFile()).count());
		Arrays.stream(files).forEach(f -> {
			if (f.isFile()) {
				Runnable runnable = () -> {
					logger.log(Level.FINE, "Parsing: " + f);

					try (BufferedReader bufferedReader = new BufferedReader(new FileReader(f))) {
						int wordCount = 0;
						String line = bufferedReader.readLine();
						while (line != null) {
							wordCount += line.split("\\s+").length;
							line = bufferedReader.readLine();
						}
						logger.log(Level.INFO, f.getName() + " word count: " + wordCount);
						totalWordCount.addAndGet(wordCount);
						totalFileCount.decrementAndGet();
						if (totalFileCount.get() == 0)
							logger.log(Level.INFO, f.getName() + " total word count: " + totalWordCount);

					} catch (FileNotFoundException fnfe) {
						logger.log(Level.SEVERE, "", fnfe);
					} catch (IOException ioe) {
						logger.log(Level.SEVERE, "", ioe);
					}
				};
				// new Thread(runnable).start();
				threadPool.execute(runnable);
			}
		});

		try {
			threadPool.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
