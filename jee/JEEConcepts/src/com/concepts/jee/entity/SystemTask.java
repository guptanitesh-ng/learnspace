package com.concepts.jee.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class SystemTask implements Serializable {

	/**
	 * Represents serial version identification number.
	 */
	private static final long serialVersionUID = -3879167997384139724L;

	/**
	 * Id of the synchronization process.
	 */
	private Integer processId;

	/**
	 * processing status of this synchronization.
	 */
	private String processingStatus;

	/**
	 * start time of the process.
	 */
	private Date startTime;

	/**
	 * log file name.
	 */
	private String logFileName;

	/**
	 * Contents of log.
	 */
	private byte[] logContents;

	/**
	 * pid of the user updating the data.
	 */
	private String lastUpdateBy;

	/**
	 * date time of last update.
	 */
	private Date lastUpdateTime;

	/**
	 * writer object for writing log information.
	 */
	private transient StringBuffer logWriter;

	/**
	 * @return Returns the fileName.
	 */
	public String getLogFileName() {
		return logFileName;
	}

	/**
	 * @param fileName
	 *            The fileName to set.
	 */
	public void setLogFileName(final String fileName) {
		this.logFileName = fileName;
	}

	/**
	 * @return Returns the lastUpdateBy.
	 */
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	/**
	 * @param lastUpdateBy
	 *            The lastUpdateBy to set.
	 */
	public void setLastUpdateBy(final String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	/**
	 * @return Returns the lastUpdateTime.
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * @param lastUpdateTime
	 *            The lastUpdateTime to set.
	 */
	public void setLastUpdateTime(final Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * @return Returns the logContents.
	 */
	public byte[] getLogContents() {
		return logContents;
	}

	/**
	 * @param logContents
	 *            The logContents to set.
	 */
	public void setLogContents(final byte[] logContents) {
		this.logContents = logContents;
	}

	/**
	 * @return Returns the logWriter.
	 */
	public StringBuffer getLogWriter() {
		if (logWriter == null) {
			logWriter = new StringBuffer();
			logWriter.append("Starting synchronization process at "
					+ Calendar.getInstance().getTime() + "\n");
		}
		return logWriter;
	}

	/**
	 * @param logWriter
	 *            The logWriter to set.
	 */
	public void setLogWriter(final StringBuffer logWriter) {
		this.logWriter = logWriter;
	}

	/**
	 * @return Returns the processId.
	 */
	public Integer getProcessId() {
		return processId;
	}

	/**
	 * @param processId
	 *            The processId to set.
	 */
	public void setProcessId(final Integer processId) {
		this.processId = processId;
	}

	/**
	 * @return Returns the processingStatus.
	 */
	public String getProcessingStatus() {
		return processingStatus;
	}

	/**
	 * @param processingStatus
	 *            The processingStatus to set.
	 */
	public void setProcessingStatus(final String processingStatus) {
		this.processingStatus = processingStatus;
	}

	/**
	 * @return Returns the startTime.
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            The startTime to set.
	 */
	public void setStartTime(final Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * Overloaded to print the values of the fields encapsulated in a particular
	 * object. In case of collections, it makes recursive calls to the
	 * overloaded toString methods of the inner object, in turn printing value
	 * of every field.
	 * 
	 * @return the String with the values of encapsulated fields
	 */
	public String toString() {
		final StringBuffer buffer = new StringBuffer(102);
		buffer.append("\n GEDSyncProcessDetails: \n processId: ");
		buffer.append(processId);
		buffer.append("\n processingStatus: ");
		buffer.append(processingStatus);
		buffer.append("\n startTime: ");
		buffer.append(startTime);
		buffer.append("\n logFileName: ");
		buffer.append(logFileName);
		return buffer.toString();
	}

	/**
	 * writes a new line to the writer object.
	 * 
	 * @param logInformation
	 *            the information to log.
	 */
	public void writeLogLine(final String logInformation) {
		writeLog(logInformation);
		writeLog("\n");
	}

	/**
	 * writes the log info to the writer object.
	 * 
	 * @param logInformation
	 *            the information to log.
	 */
	public void writeLog(final String logInformation) {
		getLogWriter().append(logInformation);
	}

	/**
	 * This method is used for capturing changes related info of System Task Log
	 */
	private void captureLog() {
		lastUpdateBy = "111111";
		lastUpdateTime = new Date();
		if (logContents == null && logWriter != null) {
			logContents = logWriter.toString().getBytes();
		}
	}
}