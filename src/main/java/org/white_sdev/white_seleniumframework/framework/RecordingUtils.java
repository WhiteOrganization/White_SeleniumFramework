package org.white_sdev.white_seleniumframework.framework;


import io.github.bonigarcia.seljup.SeleniumJupiter;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.white_sdev.white_seleniumframework.exceptions.White_SeleniumFrameworkException;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@lombok.extern.slf4j.Slf4j
public class RecordingUtils {
	
	public static String startRecording(SeleniumJupiter seleniumJupiter, WebDriver driver,  String displayName){
		return startRecording(seleniumJupiter, driver, displayName, true);
	}
	
	public static String startRecording(SeleniumJupiter seleniumJupiter, WebDriver driver,  String displayName, boolean waitForRecordingToStart){
		return startRecording(seleniumJupiter, driver, displayName, Duration.ofMillis(waitForRecordingToStart?1500:0));
	}
	
	public static String startRecording(SeleniumJupiter seleniumJupiter, WebDriver driver, String displayName, Duration waitForRecordingToStart){
		String logID="::startRecording([seleniumJupiter, displayName]): ";
		log.trace("{}Start ", logID);
		Objects.requireNonNull(seleniumJupiter);
		if(displayName == null) displayName = "recorded";
		if(waitForRecordingToStart == null) waitForRecordingToStart = Duration.ofMillis(1500);
		try{
			if(!forceBrowserStateForRecording(driver)) throw new IllegalStateException(
					"Unable to open 'enable-recording.html' file, please ensure you have either an open page (commonly your scenario focus page) "+
					"with a proper URL or this file in your project: 'src/test/resources/enable-recording.html'. "+
					"The recording will probably fail when saving at the end of the execution.");
			String recordedFileName = getFileName(displayName);
			seleniumJupiter.startRecording(recordedFileName);
			if(waitForRecordingToStart.toMillis() > 0){
				log.info("{}Waiting ({}} milliseconds) for the recording to start ", logID, waitForRecordingToStart.toMillis());
				Thread.sleep(waitForRecordingToStart.toMillis());
			}
			log.trace("{}Finish", logID);
			return recordedFileName;
			
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Impossible to start the recording", ex);
		}
	}
	
	public static Optional<File> saveRecording(SeleniumJupiter seleniumJupiter, String displayName){
		return saveRecording(seleniumJupiter, displayName, null, null);
	}
	
	@SneakyThrows
	@SuppressWarnings("All")
	public static Optional<File> saveRecording(SeleniumJupiter seleniumJupiter, String displayName, String filePath, String fileName){
		String logID="::saveRecording([seleniumJupiter, displayName, filePath, fileName]): ";
		log.trace("{}Start ", logID);
		Objects.requireNonNull(seleniumJupiter);
		if(displayName == null) displayName = "recorded";
		if(filePath == null) filePath = "target/test-reports/recorded/";
		try {
			
			final int REC_TIMEOUT_SEC = 4;
			final int POLL_TIME_MSEC = 100;
			
			seleniumJupiter.stopRecording();
			
			long timeoutMs = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(REC_TIMEOUT_SEC);
			
			File recFile;
			do {
				recFile = getRecordedFile(displayName);
				if (System.currentTimeMillis() > timeoutMs) {
					log.error("Timeout of " + REC_TIMEOUT_SEC + " seconds waiting for recording " + recFile);
					break;
				}
				Thread.sleep(POLL_TIME_MSEC);
				
			} while (!recFile.exists());
			
			log.debug("{}Recorded File Status: {}", logID, recFile.exists());
			log.debug("{}File Name: {}", logID, recFile.getAbsolutePath());
			if (recFile.exists()) {
				File movedFile =new File(filePath + (fileName!=null? fileName: recFile.getName()));
				try {
					log.trace("{}Removing file if a previous one was already in the directory.", logID);
					FileUtils.delete(movedFile);
				} catch (NoSuchFileException ex) {
					log.trace("{}No previous file found, proceeding with happy path.", logID);
				}
				FileUtils.moveFile(recFile, movedFile);
				return Optional.of(movedFile);
			}else{
				log.error(logID+"Impossible to save the file. Are you '@Watch'ing your WebDriver and was already open when the recording started?");
				return Optional.empty();
			}
		}catch(Exception ex){
			throw new White_SeleniumFrameworkException("An error occurred when saving the video recording.", ex);
		}
	}
	
	public static File getRecordedFile(String displayName){
		final String RECORDED_EXT = ".webm";
		String recordedFileName = getFileName(displayName) + RECORDED_EXT;
		final String RECORDED_FOLDER_PATH = System.getProperty("user.home") + "/Downloads"; //TODO this will probably throw an exception in other SO out of Windows.
		File targetFolder = new File(RECORDED_FOLDER_PATH);
		
		return new File(targetFolder, recordedFileName);
	}
	
	public static String getFileName(String displayName){
		return displayName + " " + LocalDate.now().toString().replace(":| ", "_");
	}
	
	public static boolean forceBrowserStateForRecording(WebDriver driver) {
		String logID = "::forceBrowserStateForRecording([driver]): ";
		log.trace("{}Start ", logID);
		RemoteWebDriver remoteDriver = (RemoteWebDriver) driver;
		try {
			remoteDriver.getWindowHandles();
			if (!driver.getCurrentUrl().matches("https?://.*"))
				throw new IllegalStateException("The opened URL (or the absence of it) might not allow to start recording.");
		} catch (NullPointerException | NoSuchSessionException | IllegalStateException ex) {
			log.warn("{}Window is not opened or has a potentially problematic URL, looking for 'enable-recording.html' to launch recording", logID, ex);
			java.nio.file.Path enableRecordingFile = Paths.get("src/test/resources/enable-recording.html");
			if(!enableRecordingFile.toFile().exists())
				return false;
			driver.get(enableRecordingFile.toUri().toString());
		}
		return true;
	}
}