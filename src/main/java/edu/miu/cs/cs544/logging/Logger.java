package edu.miu.cs.cs544.logging;

public class Logger implements ILogger{

	public void log(String logstring) {

		java.util.logging.Logger.getLogger("Enrollment Logger").info(logstring);
	}

}
