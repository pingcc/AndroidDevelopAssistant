package com.user.fun.library.presenter;


import com.user.fun.library.functions.Presenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created on 2017/6/29.
 * author chen_ping
 * Email yy_cping@163.com
 * Edit androidStudio
 */

public abstract class DisposablePresenter implements Presenter {
    private CompositeDisposable mCompositeDisposable;

    /**
     * 添加RxJava(RxBus处理的事件)所产生的订阅
     *
     * @param disposable
     */
    public void addDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        dispose();
    }

    private void dispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
            mCompositeDisposable.clear();
            mCompositeDisposable = null;
        }
    }


}
