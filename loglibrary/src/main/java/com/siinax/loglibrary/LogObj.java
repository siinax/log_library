package com.siinax.loglibrary;

import android.util.Log;

/**
 * Created by siinax on 2017/11/7.今天是充满希望的一天!! w(ﾟДﾟ)w (╯°Д°)╯︵ ┻━┻
 */

class LogObj implements LogGradeListener {

    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARING = 4;
    public static final int ERROR = 5;
    private static final int NOTING = 6;

    private static boolean SHUTDOWN = true;

    private static int level = VERBOSE;


    public void NOTING(){
        level = NOTING;
    }

    public void RESET(){
        level = VERBOSE;
    }

    public void setLevel(int type){
        level = type;
    }


    @Override
    public void shutdownLog() {
        SHUTDOWN = false;
    }

    @Override
    public void v(String tag, String msg) {
        if (level <= VERBOSE && SHUTDOWN) {
            Log.v(tag, msg);
        }

    }

    @Override
    public void d(String tag, String msg) {
        if (level <= DEBUG && SHUTDOWN) {
            Log.d(tag, msg);
        }

    }

    @Override
    public void w(String tag, String msg) {
        if (level <= WARING && SHUTDOWN) {
            Log.w(tag, msg);
        }

    }

    @Override
    public void e(String tag, String msg) {
        if (level <= ERROR && SHUTDOWN) {
            Log.e(tag, msg);
        }

    }

    @Override
    public void i(String tag, String msg) {
        if (level <= INFO && SHUTDOWN) {
            Log.i(tag, msg);
        }

    }

    @Override
    public void v(String tag_msg) {
        if (level <= VERBOSE && SHUTDOWN) {
            new UtilsLog() {
                @Override
                public void log(String tag, String msg) {
                    Log.v(tag, msg);
                }
            }.Case(tag_msg);
        }

    }

    @Override
    public void i(String tag_msg) {
        if (level <= INFO && SHUTDOWN) {
            new UtilsLog() {
                @Override
                public void log(String tag, String msg) {
                    Log.i(tag, msg);
                }
            }.Case(tag_msg);
        }

    }

    @Override
    public void d(String tag_msg) {
        if (level <= DEBUG && SHUTDOWN) {
            new UtilsLog() {
                @Override
                public void log(String tag, String msg) {
                    Log.d(tag, msg);
                }
            }.Case(tag_msg);
        }

    }

    @Override
    public void w(String tag_msg) {
        if (level <= WARING && SHUTDOWN) {
            new UtilsLog() {
                @Override
                public void log(String tag, String msg) {
                    Log.w(tag, msg);
                }
            }.Case(tag_msg);
        }

    }

    @Override
    public void e(String tag_msg) {
        if (level <= ERROR && SHUTDOWN) {
            new UtilsLog() {
                @Override
                public void log(String tag, String msg) {
                    Log.e(tag, msg);
                }
            }.Case(tag_msg);
        }

    }
}
