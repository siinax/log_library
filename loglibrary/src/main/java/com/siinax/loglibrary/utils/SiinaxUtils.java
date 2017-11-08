package com.siinax.loglibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextPaint;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import java.util.List;

/**
 * Created by siinax on 2017/11/1.今天是充满希望的一天!! w(ﾟДﾟ)w (╯°Д°)╯︵ ┻━┻
 */

public class SiinaxUtils {

    public static void translucentStatusBar(Activity context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = context.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            context.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = context.getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int dip2px(Context context,float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 获取文字的宽高
     * @param textPaint
     * @param text
     * @return
     */
    public static Pair<Integer,Integer> getTextWH(TextPaint textPaint, String text) {
        Rect bounds = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), bounds);
        return Pair.create(bounds.width(), bounds.height());
    }

    public static boolean listIsEmpty(List<String> list) {
        return list == null || list.size() == 0;
    }


    public static int getValue(Activity activity){
        WindowManager mWindowManager = activity.getWindowManager();
        int width = mWindowManager.getDefaultDisplay().getWidth();
        return width;
    }

    public static boolean isGif(String data){
        if (data.length() < 4) {
            return false;
        }
        int start = data.length() - 4;
        return data.substring(start).equals(".gif");
    }
}
