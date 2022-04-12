package com.xz.basemvvm.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/**
 * @ClassName: ProxyDrawable
 * @Author: 于学智
 * @Description: 使用DataBinding时使用该库 https://github.com/whataa/noDrawable
 * * 只需要复制核心类 ProxyDrawable，Drawables至项目中即可
 * * 可以减少大量的drawable.xml文件
 * @CreateDate: 2022/4/12 11:53
 * @Version: 1.0
 * @E-mail:18722650553@139.com
 * @Link:https://github.com/18722650553
 */
public class ProxyDrawable extends StateListDrawable {

    private Drawable originDrawable;

    @Override
    public void addState(int[] stateSet, Drawable drawable) {
        if (stateSet != null && stateSet.length == 1 && stateSet[0] == 0) {
            originDrawable = drawable;
        }
        super.addState(stateSet, drawable);
    }

    Drawable getOriginDrawable() {
        return originDrawable;
    }
}
