package com.siinax.loglibrary.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.siinax.loglibrary.R;


/**
 * Created by siinax on 2018/9/8.今天是充满希望的一天!! w(ﾟДﾟ)w (╯°Д°)╯︵ ┻━┻
 */

public class ViewUtils {

    public static final int LEV_NORMAL = R.drawable.toast_bg_normal;
    public static final int LEV_WARNING = R.drawable.toast_bg_warning;
    public static final int LEV_ERROR = R.drawable.toast_bg_error;

    public static final int toast_bg_01 = R.drawable.toast_bg_01;
    public static final int toast_bg_02 = R.drawable.toast_bg_02;
    public static final int toast_bg_03 = R.drawable.toast_bg_03;
    public static final int toast_bg_04 = R.drawable.toast_bg_04;
    public static final int toast_bg_05 = R.drawable.toast_bg_05;
    public static final int toast_bg_06 = R.drawable.toast_bg_06;
    public static final int toast_bg_07 = R.drawable.toast_bg_07;
    public static final int toast_bg_08 = R.drawable.toast_bg_08;
    public static final int toast_bg_09 = R.drawable.toast_bg_09;
    public static final int toast_bg_10 = R.drawable.toast_bg_10;
    public static final int toast_bg_11 = R.drawable.toast_bg_11;
    public static final int toast_bg_12 = R.drawable.toast_bg_12;
    public static final int toast_bg_13 = R.drawable.toast_bg_13;
    public static final int toast_bg_14 = R.drawable.toast_bg_14;
    public static final int toast_bg_15 = R.drawable.toast_bg_15;
    public static final int toast_bg_16 = R.drawable.toast_bg_16;
    public static final int toast_bg_17 = R.drawable.toast_bg_17;
    public static final int toast_bg_18 = R.drawable.toast_bg_18;
    public static final int toast_bg_19 = R.drawable.toast_bg_19;

    public static final int toast_bg_gradual_01 = R.drawable.toast_bg_gradual_01;
    public static final int toast_bg_gradual_02 = R.drawable.toast_bg_gradual_02;
    public static final int toast_bg_gradual_03 = R.drawable.toast_bg_gradual_03;

    /**
     * @param context  上下文
     * @param content  内容
     * @param level    级别
     */
    public static void makeToast(Context context, String content, int level) {
        makeToast(context, content, 1500, level);
    }

    /**
     * @param context  上下文
     * @param content  内容
     * @param duration 时长
     * @param level    级别
     */
    public static void makeToast(Context context, String content, int duration, int level) {
        Toast toast = new Toast(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View toast_layout = inflater.inflate(R.layout.toast_layout, null);
        TextView toast_tv = toast_layout.findViewById(R.id.toast_tv);
        LinearLayout toast_bg = toast_layout.findViewById(R.id.toast_bg);
        toast_tv.setText(content);
        toast_bg.setBackgroundResource(level);
        toast.setView(toast_layout);
        toast.setDuration(duration);
//        toast.setGravity();
//        toast.setText(content);
        toast.show();
    }
}
