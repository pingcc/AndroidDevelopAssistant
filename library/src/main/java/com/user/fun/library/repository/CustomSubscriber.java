package com.user.fun.library.repository;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created on 2017/6/26.
 * author chen_ping
 * Email yy_cping@163.com
 * Edit androidStudio
 */
//Subscriber<T>, FlowableSubscriber<T> ResourceSubscriber<T>
public abstract class CustomSubscriber<T> extends ResourceSubscriber<T> {
    private static final String TAG = "CustomSubscriber";


    @Override
    protected void onStart() {
        super.onStart();
    }



    public void cancelNetRequest() {
        if (!isDisposed())
            dispose();
    }

}
