package com.siinax.loglibrary.log;


/**
 * Created by siinax on 2017/11/7.今天是充满希望的一天!! w(ﾟДﾟ)w (╯°Д°)╯︵ ┻━┻
 */

class LogManager {

    private static LogShow mLog;

    public static LogShow Log(){
        return mLog = mLog == null ? new LogShow() : mLog;
    }

    /*public static void shutdownLog() {
        if (mLog != null) {
            mLog.shutdownLog();
        }else{
            throw new IllegalArgumentException("异常:mLog == null");
        }
    }*/

    public static void recycle(){
        mLog = mLog != null ? null : null;
    }
}
