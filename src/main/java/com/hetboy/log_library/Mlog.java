package com.hetboy.log_library;

/**
 * Created by siinax on 2017/4/7.今天是充满希望的一天!! w(ﾟДﾟ)w (╯°Д°)╯︵ ┻━┻
 */

public class Mlog {

    /**
     * Priority constant for the println method; use Log.v.
     */
    public static final int VERBOSE = 1;

    /**
     * Priority constant for the println method; use Log.d.
     */
    public static final int DEBUG = 2;

    /**
     * Priority constant for the println method; use Log.i.
     */
    public static final int INFO = 3;

    /**
     * Priority constant for the println method; use Log.w.
     */
    public static final int WARING = 4;

    /**
     * Priority constant for the println method; use Log.e.
     */
    public static final int ERROR = 5;

    public static void NOTING() {
        LogManager.Log().NOTING();
    }

    public static void RESET() {
        LogManager.Log().RESET();
    }

    public static void setLevel(int type) {
        LogManager.Log().setLevel(type);
    }

    public static void shutdownLog() {
        LogManager.Log().shutdownLog();
    }

    public static void v(String tag, String msg) {
        LogManager.Log().v(tag, msg);
    }

    public static void d(String tag, String msg) {
        LogManager.Log().d(tag, msg);
    }

    public static void w(String tag, String msg) {
        LogManager.Log().w(tag, msg);
    }

    public static void e(String tag, String msg) {
        LogManager.Log().e(tag, msg);
    }

    public static void i(String tag, String msg) {
        LogManager.Log().i(tag, msg);
    }

    public static void v(String tag_msg) {
        LogManager.Log().v(tag_msg);
    }

    public static void i(String tag_msg) {
        LogManager.Log().i(tag_msg);
    }

    public static void d(String tag_msg) {
        LogManager.Log().d(tag_msg);
    }

    public static void w(String tag_msg) {
        LogManager.Log().w(tag_msg);
    }

    public static void e(String tag_msg) {
        LogManager.Log().e(tag_msg);
    }

    public static void recycle(){
        LogManager.recycle();
    }

}
