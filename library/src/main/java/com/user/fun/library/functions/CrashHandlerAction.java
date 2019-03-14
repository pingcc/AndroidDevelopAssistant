package com.user.fun.library.functions;

/**
 * Created  on 2019/3/12.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */
public interface CrashHandlerAction {
    /**处理异常 后执行可发送日志到umeng 服务器
     * example :
     * MobclickAgent.reportError(mContext, fileName);
     */

    void handleExceptionExecuteAfterSendReport(  String fileName );
    /**处理异常 后app所要执行自定义的的动作
     * example :
     * restartApp();   exitApp();
     */
    void handleExceptionExecuteAfterAppAction();
}
