package top.b0x0.sample.tracespringboot.logback.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author tanglinghan Created By 2022-08-01 9:26
 **/
public class LogUtils {
    public static Logger log = LoggerFactory.getLogger(LogUtils.class);


    public static void error(String format, Object... arguments) {
        log.error(getLogIdFormat(format), arguments);
    }

    public static void warn(String format, Object... arguments) {
        log.warn(getLogIdFormat(format), arguments);
    }

    public static void info(String format, Object... arguments) {
        log.info(getLogIdFormat(format), arguments);
    }

    public static String getLogIdFormat(String format) {
        return "logId:{}" + format;
    }

    /**
     * 打印警告
     *
     * @param obj
     */
    public static void warn(Object obj) {
        try {
            // 获取输出信息的代码的位置 
            String location = getCodeLocation();

            // 是否是异常  
            if (obj instanceof Exception) {
                Exception e = (Exception) obj;
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw, true));
                String str = sw.toString();
                log.warn(location + str);
            } else {
                log.warn(location + obj.toString());
            }
        } catch (Exception e) {
            LogUtils.error("LogUtils", e.toString(), e);
        }
    }

    /**
     * 打印信息
     *
     * @param obj
     */
    public static void info(Object obj) {
        try {
            // 获取输出信息的代码的位置 
            String location = getCodeLocation();

            // 是否是异常  
            if (obj instanceof Exception) {
                Exception e = (Exception) obj;
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw, true));
                String str = sw.toString();
                log.info(location + str);
            } else {
                log.info(location + obj.toString());
            }
        } catch (Exception e) {
            LogUtils.error(e);
        }
    }


    /**
     * 打印错误
     *
     * @param obj
     */
    public static void error(Object obj) {
        try {
            // 获取输出信息的代码的位置 
            String location = getCodeLocation();

            // 是否是异常  
            if (obj instanceof Exception) {
                Exception e = (Exception) obj;
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw, true));
                String str = sw.toString();
                log.error(location + str);
            } else {
                log.error(location + obj.toString());
            }
        } catch (Exception e) {
            LogUtils.error(e);
        }
    }


    /**
     * 获取调用此函数的代码的位置
     *
     * @return 包名.类名.方法名(行数)
     */
    public static String getCodeLocation() {
        try {
            // 获取输出信息的代码的位置
            String location = "";
            StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
            location = stacks[2].getClassName() + "." + stacks[2].getMethodName()
                    + "(" + stacks[2].getLineNumber() + ")";
            return location;
        } catch (Exception e) {
            LogUtils.error(e);
            return "";
        }
    }
}
