package com.training.spring.ioc.generator.sequence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSystemSequenceRepoImpl implements SequenceRepository {

	private String fileLocation;

	private String fileName;

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	@Override
	public void storeSequence(String sequenceValue) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		File file = new File(fileLocation, fileName);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter(file, true));
			writer.write(sequenceValue);
			writer.println();
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
		//return false;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
