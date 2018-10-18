package com.qiniu.hugo.qnlive.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.qiniu.hugo.qnlive.QNApplication;
import jp.wasabeef.glide.transformations.CropCircleTransformation;


public class ImgUtils {

    public static void load(String url, ImageView targetView) {
        Glide.with(QNApplication.getContext())
                .load(url)
                .into(targetView);
    }

    public static void load(int resId, ImageView targetView) {
        Glide.with(QNApplication.getContext())
                .load(resId)
                .into(targetView);
    }

    public static void loadRound(String url, ImageView targetView) {
        Glide.with(QNApplication.getContext())
                .load(url)
                .bitmapTransform(new CropCircleTransformation(QNApplication.getContext()))
                .into(targetView);
    }

    public static void loadRound(int resId, ImageView targetView) {
        Glide.with(QNApplication.getContext())
                .load(resId)
                .bitmapTransform(new CropCircleTransformation(QNApplication.getContext()))
                .into(targetView);
    }
}
