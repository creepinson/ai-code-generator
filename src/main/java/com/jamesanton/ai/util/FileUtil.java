package com.jamesanton.ai.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class FileUtil {
	private static final Logger LOG = Logger.getLogger(FileUtil.class);
	
	/**
	 * Creates a file if it doesn't exist.
	 * Then returns the file specified
	 * @param path
	 * @return
	 */
	public static File createFileIfNotExists(File f){
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				LOG.error("Could not create new file.", e);
			}
		}		
		return f;
	}
	
	/**
	 * Creates a file if it doesn't exist.
	 * Then returns the file specified at the path.
	 * @param path
	 * @return
	 */
	public static File createFileIfNotExists(String path) {
		File f = new File(path);		
		return createFileIfNotExists(f);
	}
	
	/**
	 * A simple file destroyer
	 * @param paths
	 * @throws IOException
	 */
	public static void removeFilesAndFolder(String... paths) throws IOException {
		for (String path : paths) {
			File f = new File(path);
			if (f != null && f.exists()) {
				FileUtils.forceDelete(f);
			}
		}
	}
	
	/**
	 * A simple file destroyer
	 * @param paths
	 * @throws IOException
	 */
	public static void removeFilesAndFolders(File... files) throws IOException {
		for (File f : files) {			
			if (f != null && f.exists()) {
				FileUtils.forceDelete(f);
			}
		}
	}
}
