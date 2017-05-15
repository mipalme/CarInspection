
package se.kth.iv1350.inspection.util;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.LocalDateTime;


/**
 *  This class handles and takes care of the log.
 * 
 */
public class LogHandler {
    private static final String LOG_FILE_NAME = "logfile.txt";
    
    private PrintWriter logFile;
    /**
     * Creates a new instance of the type printwriter.
     * @throws IOException If the file was unable to be written for example.
     */
    public LogHandler() throws IOException{
        logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME),true);
    }
    /**
     * Logs information about the parameter exception, such as the time of the exception.
     * @param exception The exception that is to be logged.
     */
    public void logException(Exception exception){
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(", Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
        logFile.println(logMsgBuilder);
        exception.printStackTrace(logFile);
    }
    /**
     * Checks the current time on the computer and saves it in a nice format.
     * @return The current time as a string.
     */
    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
