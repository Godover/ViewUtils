package com.ziker.spiderman;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.StyleRes;

import com.ziker.easynavigationbar.R;

public class SpiderMan implements Thread.UncaughtExceptionHandler {

    public static int mThemeId = R.style.SpiderManTheme_Light;
    private static SpiderMan spiderMan;
    private static boolean isDebug = false;
    private static Context mContext;

    private SpiderMan() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    protected static void init(Context context) {
        mContext = context;
        spiderMan = new SpiderMan();
    }

    public static void setTheme(@StyleRes int themeId) {
        mThemeId = themeId;
    }

    private static void handleException(CrashModel model) {
        Intent intent = new Intent(getContext(), CrashActivity.class);
        intent.putExtra(CrashActivity.CRASH_MODEL, model);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    public static void show(Throwable e) {
        CrashModel model = Utils.parseCrash(e);
        handleException(model);
    }

    public static void isDebug(boolean isDebug) {
        SpiderMan.isDebug = isDebug;
    }

    public static Context getContext() {
        if (mContext == null) {
            throw new NullPointerException("Please call init method in Application onCreate");
        }
        return mContext;
    }

    @Override
    public void uncaughtException(Thread t, Throwable ex) {
        if (isDebug) {
            CrashModel model = Utils.parseCrash(ex);
            handleException(model);
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}