package com.dream.application;

import com.dream.application.di.component.ApplicationComponent;
import com.dream.application.di.component.DaggerApplicationComponent;
import com.dream.application.di.module.ApplicationModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.user.fun.library.functions.CrashHandlerAction;
import com.user.fun.library.global.BaseApp;
import com.user.fun.library.global.CrashHandler;
import com.user.fun.library.helper.ActivityManager;


/**
 * Created  on 2019/3/12.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */
public class App extends BaseApp {
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        //初始化日志
        Logger.addLogAdapter(new AndroidLogAdapter(){
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });

        if (!BuildConfig.DEBUG) { //正式环境打包自定义处理异常
            initCrash();
        }
        initApplicationComponent();
    }

    private void initCrash() {
        //初始化全局捕获异常
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
        crashHandler.setCrashHandlerAction(new CrashHandlerAction() {
            @Override
            public void handleExceptionExecuteAfterSendReport(String fileName) {
                /**捕获的异常信息的日志文件发送给服务端*/
                //  MobclickAgent.reportError(mContext, saveCrashInfo2File(ex));
            }

            @Override
            public void handleExceptionExecuteAfterAppAction() { //退出app
                ActivityManager.getActivityManager().popAllActivityExceptOne();//清除所有栈
//                  android.os.Process.killProcess(android.os.Process.myPid());  //获取PID
                System.exit(1);   //常规java、c#的标准退出法，返回值为0代表正常退出
            }
        });

    }

    /**
     * 初始化dagger 类注解工具
     */
    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
