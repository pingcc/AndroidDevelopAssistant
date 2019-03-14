package com.user.fun.library.widget;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class LinerLayoutSpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int firstSpace;
    private int space;

    public LinerLayoutSpacesItemDecoration(int firstSpace, int space) {
        this.firstSpace = firstSpace;
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView
            .State state) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
        if (layoutManager.getOrientation() == LinearLayoutManager.VERTICAL) {
            if(parent.getChildLayoutPosition(view)==0){//第一个位置
                outRect.top=firstSpace;
            }else {
                outRect.top = space;
            }
            //最后一项需要 bottom
            if (parent.getChildAdapterPosition(view) == layoutManager.getItemCount() - 1) {
                outRect.bottom = space;
            }else
                outRect.bottom = 0;
            outRect.left = space;
            outRect.right = space;
        }

    }


}
