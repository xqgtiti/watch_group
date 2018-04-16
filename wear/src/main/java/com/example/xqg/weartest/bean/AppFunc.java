package com.example.xqg.weartest.bean;

/**
 * Created by xqg on 2017/9/1.
 */

//应用功能 呈现在MainActivity中的功能列表中

public class AppFunc {

    private String funcName;
    private int funcIcon;

    public AppFunc(String name, int icon){
        this.funcName = name;
        this.funcIcon = icon;
    }
    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public int getFuncIcon() {
        return funcIcon;
    }

    public void setFuncIcon(int funcIcon) {
        this.funcIcon = funcIcon;
    }




}
