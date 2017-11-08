package com.siinax.loglibrary.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by siinax on 2017/11/4.今天是充满希望的一天!! w(ﾟДﾟ)w (╯°Д°)╯︵ ┻━┻
 */

public class DispalyImageHelper {

    public static final int THUMB_WIDTH = 256;
    public static final int THUMB_HEIGHT = 256;
    private Context context;
    private long mTotalMemory;

    public boolean isCompress = true;
    public int value = 8;//可用内存的1/8

    public void setisCompress(boolean isCompress){
        this.isCompress = isCompress;
    }

    public void setMemory(int value){
        this.value = value;
    }




    private DispalyImageHelper(){}

    private DispalyImageHelper(Context context){
        this.context = context;
    }

    private static DispalyImageHelper mDispalyImageHelper;

    public static DispalyImageHelper getIstance(Context context){

        if (mDispalyImageHelper == null) {
            synchronized (DispalyImageHelper.class) {
                mDispalyImageHelper = new DispalyImageHelper(context);
            }
        }
        return mDispalyImageHelper;
    }

    public void displayImage(ImageView iv, String path){

        if (TextUtils.isEmpty(path) || (iv.getTag() != null && iv.getTag().equals(path))) {
            return;
        }

        refresh(iv, path);
    }

    {
        Runtime runtime = Runtime.getRuntime();
        mTotalMemory = runtime.totalMemory();
    }

    private LruCache<String, Bitmap> cacheImg = new LruCache<String, Bitmap>((int) (mTotalMemory / value));

    private Handler mHandler = new Handler();

    private void put(String path, Bitmap bt) {
        if (!TextUtils.isEmpty(path) && bt != null) {
            cacheImg.put(path, bt);
        }
    }

    private void refresh(final ImageView iv, final String path) {

        Bitmap bitmap = cacheImg.get(path);
        if (bitmap != null) {
            showimg(iv, bitmap, path);
            return;
        }

        new Thread(){
            @Override
            public void run() {
                Bitmap bitmap = null;
                try {
                    bitmap = compressImg(path);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {

                    put(path, bitmap);

                    final Bitmap finalBitmap = bitmap;
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            showimg(iv, finalBitmap, path);
                        }
                    });
                }
            }
        }.start();
    }

    private void showimg(ImageView iv, Bitmap bt, String path) {
        if (bt != null && !TextUtils.isEmpty(path)) {
            iv.setImageBitmap(bt);
            iv.setTag(path);
        }
    }


    /**
     * 压缩图片
     * @param path
     * @return
     * @throws Exception
     */
    private Bitmap compressImg(String path) throws Exception {

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(path)));
        BitmapFactory.Options op = new BitmapFactory.Options();
        op.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeStream(in, null, op);
        in.close();
        //对图进行压缩，
        if (isCompress) {
            int i = 0;
            while (true) {
                if ((op.outWidth >> i <= THUMB_WIDTH) && (op.outHeight >> i <= THUMB_HEIGHT)) {
                    in = new BufferedInputStream(new FileInputStream(new File(path)));
                    op.inSampleSize = (int) Math.pow(2.0D, i);
                    op.inJustDecodeBounds = false;
                    bitmap = BitmapFactory.decodeStream(in, null, op);
                    break;
                }
                i += 1;
            }
        }
        in.close();
        return bitmap;
    }

}

