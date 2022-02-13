package Ex3.FourInRow;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Aspect
@Component
public class LoggingAspect {

    private final String logFilePath= System.getProperty("user.dir")+"\\logFile_Aspectj.txt";
    private LogFile logfile;


    @After("execution(* Ex3.FourInRow.Board.printBoard(..))")
    public void loggerPrintBoard(JoinPoint jp) throws IOException {
        logfile= new LogFile();
        logfile.CreateLogFile(logFilePath);
        logfile.writeToFile("Printboard()" + jp.getSignature());
        jp.getThis();
        var target =jp.getTarget();
        logfile= new LogFile();
        logfile.CreateLogFile(logFilePath);
        Board b = ((Board)target);
        printBoard(b.board,b.ROWS,b.getBoard().COLUMNS);
    }



    @Before("execution(* Ex3.FourInRow.IBoard.*(..))")
    public void loggerBoard(JoinPoint jp) throws IOException {
        // System.out.println("Loggers aspect userChoice()");
        var args = jp.getArgs();
        String arguments = getArgsValues(args);
        if(arguments!=""){
            arguments="arguments="+arguments;
        }
        var sign = jp.getSignature();
        var t = jp.getThis();
        var target =jp.getTarget();
        logfile= new LogFile();
        logfile.CreateLogFile(logFilePath);
        logfile.writeToFile("Function name: "+sign+" ;" +arguments);
    }

    private String getArgsValues(Object[] args) {
        String argsStr = "";
        for (Object arg : args) {
            try {
                argsStr += arg.toString()+"  ;   ";
            } catch (Exception e) {
                //do nothing
            }
        }
        return argsStr;
    }

    public void printBoard(char[][] board, int ROWS, int COLUMNS) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        logfile.writeToFile("Printed board after player choice at "+ dtf.format(now)+ ":");
        logfile.writeToFile("");
        String tmpRow="";
        for (int j = 0; j <ROWS; j++) {
            tmpRow+=("|");
            for (int k = 0; k < COLUMNS; k++)
                tmpRow+=(board[j][k] + "|");
            logfile.writeToFile(tmpRow);
            logfile.writeToFile("");
            tmpRow="";
        }
        tmpRow="";
        for (int k = 0; k < 2* COLUMNS+1; k++) {
            tmpRow+=("-");
        }
        logfile.writeToFile(tmpRow);
        logfile.writeToFile("");
        logfile.writeToFile("");
    }
}
