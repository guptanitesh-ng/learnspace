package com.manifest.concept;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class LoggerFactory {

	public enum HandlerType {
		STREAM, CONSOLE, FILE, MEMORY, SOCKET;
	}
	
	public static Logger getLogger(String clazzName) {
		return getLogger(clazzName, HandlerType.STREAM);
	}
	
	public static Logger getLogger(String clazzName, HandlerType handler) {
		// TODO use handler type to return logger instance with appropriate handler implementation.
		Logger logger = Logger.getLogger(clazzName);
		StreamHandler streamHandler = new StreamHandler(System.out, new Formatter() {

			@Override
			public String format(LogRecord record) {
				return record.getInstant() + "::" + Thread.currentThread().getName() + "::" + record.getSourceClassName() + "::"
						+ record.getSourceMethodName() + "::"
						+ LocalDateTime.ofInstant(Instant.ofEpochMilli(record.getMillis()), ZoneId.systemDefault())
						+ "::" + record.getMessage() + "\n";
			}
		});
		logger.setUseParentHandlers(false);
		logger.addHandler(streamHandler);
		return logger;
	}
}
