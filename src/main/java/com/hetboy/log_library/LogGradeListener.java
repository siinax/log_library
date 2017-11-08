package com.hetboy.log_library;

/**
 * Created by siinax on 2017/11/7.今天是充满希望的一天!! w(ﾟДﾟ)w (╯°Д°)╯︵ ┻━┻
 */

public interface LogGradeListener {

    void shutdownLog();

    void v(String tag, String msg);
    void d(String tag, String msg);
    void w(String tag, String msg);
    void e(String tag, String msg);
    void i(String tag, String msg);

    void v(String tag_msg);
    void i(String tag_msg);
    void d(String tag_msg);
    void w(String tag_msg);
    void e(String tag_msg);

}
