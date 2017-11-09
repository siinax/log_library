package com.siinax.loglibrary.log;

import android.util.Log;

import com.siinax.loglibrary.BuildConfig;

/**
 * Created by siinax on 2017/11/9.今天是充满希望的一天!! w(ﾟДﾟ)w (╯°Д°)╯︵ ┻━┻
 */

public class Mlogg {

    private Mlogg(){
        /* Protect from instantiations */
    }

    public static boolean isDebuggable() {
        return BuildConfig.DEBUG;
    }



    public static void e(String message){
        if (!isDebuggable())
            return;

        new UtilsLog() {
            @Override
            public void log(String classname, String msg) {
                Log.e(classname, msg);
            }
        }.createLog(message,new Throwable().getStackTrace());
    }

    public static void i(String message){
        if (!isDebuggable())
            return;

        new UtilsLog() {
            @Override
            public void log(String classname, String msg) {
                Log.i(classname, msg);
            }
        }.createLog(message,new Throwable().getStackTrace());

    }

    public static void d(String message){
        if (!isDebuggable())
            return;

        new UtilsLog() {
            @Override
            public void log(String classname, String msg) {
                Log.d(classname, msg);
            }
        }.createLog(message,new Throwable().getStackTrace());
    }

    public static void v(String message){
        if (!isDebuggable())
            return;

        new UtilsLog() {
            @Override
            public void log(String classname, String msg) {
                Log.v(classname, msg);
            }
        }.createLog(message,new Throwable().getStackTrace());
    }

    public static void w(String message){
        if (!isDebuggable())
            return;

        new UtilsLog() {
            @Override
            public void log(String classname, String msg) {
                Log.w(classname, msg);
            }
        }.createLog(message,new Throwable().getStackTrace());
    }
}
