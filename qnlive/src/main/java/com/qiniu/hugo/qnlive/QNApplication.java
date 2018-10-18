package com.qiniu.hugo.qnlive;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.tencent.TIMManager;
import com.tencent.TIMUserProfile;
import com.tencent.ilivesdk.ILiveSDK;


import java.util.ArrayList;
import java.util.List;

import com.qiniu.hugo.qnlive.editprofile.CustomProfile;
import com.qiniu.hugo.qnlive.utils.QnUploadHelper;

/**
 * Created by hugo on 2018/10/18.
 */

public class QNApplication extends Application {

    private static QNApplication app;
    private static Context appContext;


    private TIMUserProfile mSelfProfile;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        appContext = getApplicationContext();
        ILiveSDK.getInstance().initSdk(getApplicationContext(), 1400026811, 11334);
        List<String> customInfos = new ArrayList<String>();
        customInfos.add(CustomProfile.CUSTOM_GET);
        customInfos.add(CustomProfile.CUSTOM_SEND);
        customInfos.add(CustomProfile.CUSTOM_LEVEL);
        customInfos.add(CustomProfile.CUSTOM_RENZHENG);
        TIMManager.getInstance().initFriendshipSettings(CustomProfile.allBaseInfo, customInfos);


        QnUploadHelper.init("",
                "",
                "",
                "hugofortest");

        LeakCanary.install(this);
    }

    public static Context getContext() {
        return appContext;
    }

    public static QNApplication getApplication() {
        return app;
    }

    public void setSelfProfile(TIMUserProfile userProfile) {
        mSelfProfile = userProfile;
    }

    public TIMUserProfile getSelfProfile() {
        return mSelfProfile;
    }

}
