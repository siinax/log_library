package com.siinax.loglibrary.log;

/**
 * Created by siinax on 2017/11/7.今天是充满希望的一天!! w(ﾟДﾟ)w (╯°Д°)╯︵ ┻━┻
 */

abstract class UtilsLog {

    public void Case(String tv){
        String tag = "---log---";
        String msg = tv;
        int i = tv.indexOf("/");
        if (i != -1) {
            tag = tv.substring(0, i);
            msg = tv.substring(i + 1);
        }
        log(tag, msg);
    }

    public abstract void log(String tag, String msg);


    public void createLog(String msg,StackTraceElement[] sElements){
        String className = sElements[1].getFileName();
        String methodName = sElements[1].getMethodName();
        int lineNumber = sElements[1].getLineNumber();

        StringBuffer buffer = new StringBuffer();
        buffer.append("Mlog");
        buffer.append("[");
        buffer.append(methodName);
        buffer.append(":");
        buffer.append(lineNumber);
        buffer.append("]");
        buffer.append(msg);

        log(className, buffer.toString());
    }
}
