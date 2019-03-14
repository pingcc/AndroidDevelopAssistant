package com.user.fun.library.repository;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created on 2017/6/26.
 * author chen_ping
 * Email yy_cping@163.com
 * Edit androidStudio
 */

public class BaseServerHelper {
    public <T> FlowableTransformer<T, T> handleResult() {
        return rxFlowable -> rxFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private <T> Flowable<T> rxSchedulers(Flowable<T> rxFlowable) {
        return rxFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }



 /*  example :
  public Flowable<BaseModel<LoginUserInfo>> loginPost(LoginBody loginBody) {
        return RetrofitManager.getInstance().getNetApiService().login(loginBody).compose(handleResult());
    }
    public Flowable<BaseModel<String>> sendCodePost(SendVCodeBody sendVCodeBody) {
        sendVCodeBody.Application = 1;
        return rxSchedulers(RetrofitManager.getInstance().getNetApiService().sendVCode(sendVCodeBody));
    }
   */

}
