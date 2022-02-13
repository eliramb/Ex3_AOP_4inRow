package Ex3.FourInRow;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DebugProxy implements java.lang.reflect.InvocationHandler {

    private final Object obj;
    LogFile logfile;
    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new DebugProxy(obj));
    }

    private DebugProxy(Object obj) {
        this.obj = obj;
        logfile= new LogFile();
        String currentPath = System.getProperty("user.dir")+"\\logFile_Proxy.txt";
       // System.out.println("Current path is:: " + currentPath);
        logfile.CreateLogFile(currentPath);
    }

    public Object invoke(Object proxy, Method m, Object[] args)
            throws Throwable
    {
        var argum = "";
        Object result;
        try {
            if(args !=null) {
                for (int i = 0; i < args.length; i++) {
                    argum += (args[i]).toString() + ",";
                }
            }
           // System.out.println("before method " + m.getName()+ " "+argum);
            var msg = "before method " + m.getName()+ " "+argum;
            logfile.writeToFile(msg);
            result = m.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " +
                    e.getMessage());
        } finally {
           // System.out.println("after method " + m.getName()+ " "+argum);
            var msg="after method " + m.getName()+ " "+argum;
            logfile.writeToFile(msg);
        }
        return result;
    }
}