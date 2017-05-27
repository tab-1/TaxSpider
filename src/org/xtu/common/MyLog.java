package org.xtu.common;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.qdcz.spider.utils.MyConfig;

/**
 * Created by Adminstration on 17/2/28 0028.
 */
public class MyLog {
    private static SimpleDateFormat dateFormat;
    private static String			host		= "unknown host";
    private static String			ip			= "unknown ip";
    private static boolean			kafkaEnable	= true;
    public static String 			defaultTopic = "TaxationLog";
    private static final int		LOG_INFO	= 0x1;
    private static final int		LOG_WARN	= 0x2;
    private static final int		LOG_ERROR	= 0x3;
    private static final int		LOG_DEBUG	= 0x4;
    private static final int		LOG_TRACE	= 0x5;
    public static MyKafkaProducer producer;

    static{
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        InetAddress netAddress = getInetAddress();
        host = getHostName(netAddress);
        ip = getHostIp(netAddress);
        kafkaEnable = true;
        producer = MyKafkaProducer.getInstance();
        netAddress = null;
    }

    public static InetAddress getInetAddress(){
        try{
            return InetAddress.getLocalHost();
        }catch(UnknownHostException e){
        }
        return null;

    }

    public static String getHostIp(InetAddress netAddress){
        if(null == netAddress){
            return "unknown ip";
        }
        return netAddress.getHostAddress();
    }

    public static String getHostName(InetAddress netAddress){
        if(null == netAddress){
            return "unknown host";
        }
        return netAddress.getHostName();
    }

    public static void info(Class<?> c,String message){
        writeLog(MyLog.LOG_INFO, c, message);
    }
    public static void info(Class<?> c,String message,String customizeTopic){
        writeLog(MyLog.LOG_INFO, c, message,customizeTopic);
    }
    public static void warn(Class<?> c,String message){
        writeLog(MyLog.LOG_WARN, c, message);
    }

    public static void error(Class<?> c,String message){
        writeLog(MyLog.LOG_ERROR, c, message);
    }

    public static void debug(Class<?> c,String message){
        if (MyConfig.DEBUG_MODE) {
            writeLog(MyLog.LOG_DEBUG, c, message);
        }
    }

    public static void trace(Class<?> c,String message,Throwable ex){
        String traceStr = "";
        if (ex != null) {
            StringWriter writer = new StringWriter(256);
            ex.printStackTrace(new PrintWriter(writer));
            traceStr = writer.toString().trim();
        }else{
            traceStr = "null";
        }
        writeLog(MyLog.LOG_TRACE, c, message + "\n" + traceStr);
    }

    public static void trace(Class<?> c,Throwable ex){
        String traceStr = "";
        if (ex != null) {
            StringWriter writer = new StringWriter(256);
            ex.printStackTrace(new PrintWriter(writer));
            traceStr = writer.toString().trim();
        }else{
            traceStr = "null";
        }
        writeLog(MyLog.LOG_TRACE, c, "\n" + traceStr);
    }

    private static void writeLog(int type, Class<?> c, String msg){
        writeLog(type,c,msg,defaultTopic);
    }

    private static void writeLog(int type, Class<?> c, String msg,String topic) {
        Date date = new Date(System.currentTimeMillis());
        /**
         * 获取调用栈，0表示最里层，依次往外为调用层
         */
        StackTraceElement ste = new Throwable().getStackTrace()[2];
        StringBuilder sb = new StringBuilder("[" + dateFormat.format(date)
                + "] ["
                + host + "/" + ip + "]");
        switch (type) {
            case MyLog.LOG_INFO:
                sb.append(" [INFO] - ");
                break;
            case MyLog.LOG_WARN:
                sb.append(" [WARN] - ");
                break;
            case MyLog.LOG_ERROR:
                sb.append(" [ERROR] - ");
                break;
            case MyLog.LOG_DEBUG:
                sb.append(" [DEBUG] - ");
                break;
            case MyLog.LOG_TRACE:
                sb.append(" [TRACE] - ");
                break;
        }
        sb.append(c.getName()).append(":").append(ste.getLineNumber());
        sb.append(" - ").append(msg);
        String log = sb.toString();
        System.out.println(log);
        if(kafkaEnable){
            producer.send(topic, log);
        }
        ste = null;
        sb = null;
    }

    public static void main(String args[]) {
        for(int i = 0 ;i < 10000 ; i++){
            send(""+i,defaultTopic);
        }
    }

    private static void send(String msg,String topic){
        MyLog.info(MyLog.class,msg,topic);
    }
}

