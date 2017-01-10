package com.gaoyuan.acraclientdemo;

import android.app.Application;
import android.content.Context;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.HttpSender;

/**
 * 作者：wgyscsf on 2017/1/9 20:17
 * 邮箱：wgyscsf@163.com
 * 博客：http://blog.csdn.net/wgyscsf
 */
//发送到服务器，Toast形式
//@ReportsCrashes(formUri = "http://192.168.1.160/AcraServiceDemo/CrashApiAction",
////        formUriBasicAuthLogin = "yourlogin", // optional
////        formUriBasicAuthPassword = "y0uRpa$$w0rd", // optional
//        mode = ReportingInteractionMode.TOAST,
//        reportType= HttpSender.Type.JSON,//配置以json形式发送
//      resToastText=R.string.crash_toast_text)//配置异常时弹出的信息

//// 发送到服务器，对话框形式形式,会提醒用户输入上报信息。
@ReportsCrashes(formUri = "http://192.168.1.160/AcraServiceDemo/CrashApiAction",
        mode = ReportingInteractionMode.DIALOG,
        resToastText = R.string.crash_toast_text2, // optional, displayed as soon as the crash occurs, before collecting data which can take a few seconds
        resDialogText = R.string.crash_dialog_text,
        resDialogIcon = android.R.drawable.ic_dialog_info, //optional. default is a warning sign
        resDialogTitle = R.string.crash_dialog_title, // optional. default is your application name
        resDialogCommentPrompt = R.string.crash_dialog_comment_prompt, // optional. When defined, adds a user text field input with this text resource as a label
        resDialogOkToast = R.string.crash_dialog_ok_toast, // optional. displays a Toast message when the user accepts to send a report.
        resDialogTheme = R.style.AppTheme_Dialog, //optional. default is Theme.Dialog
        reportType = HttpSender.Type.JSON//配置以json形式发送
       )

//// 发送到服务器，通知栏形式,点击跳进对话框形式收集用户输入的信息，会提醒用户输入上报信息。官方已不再提倡使用：This is a legacy feature, as Dialog mode is generally preferred.
//@ReportsCrashes(formUri = "http://192.168.1.160/AcraServiceDemo/CrashApiAction",
//       mode = ReportingInteractionMode.NOTIFICATION,
//        resToastText = R.string.crash_toast_text2, // optional, displayed as soon as the crash occurs, before collecting data which can take a few seconds
//        resDialogText = R.string.crash_dialog_text,
//        resDialogIcon = android.R.drawable.ic_dialog_info, //optional. default is a warning sign
//        resDialogTitle = R.string.crash_dialog_title, // optional. default is your application name
//        resDialogCommentPrompt = R.string.crash_dialog_comment_prompt, // optional. When defined, adds a user text field input with this text resource as a label
//        resDialogOkToast = R.string.crash_dialog_ok_toast, // optional. displays a Toast message when the user accepts to send a report.
//        resDialogTheme = R.style.AppTheme_Dialog, //optional. default is Theme.Dialog
//        resNotifTickerText = R.string.crash_notif_ticker_text,
//        resNotifTitle = R.string.crash_notif_title,
//        resNotifText = R.string.crash_notif_text,
//        resNotifIcon = android.R.drawable.stat_notify_error, // optional. default is a warning sign
//        reportType = HttpSender.Type.JSON//配置以json形式发送
//)


//发送到指定邮箱。注意：该操作触发时会调起用户客户端邮箱需要用户主动发送。不建议使用。
//@ReportsCrashes(mailTo = "414850132@qq.com",
//        customReportContent = {ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME,
//                ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL, ReportField.CUSTOM_DATA,
//                ReportField.STACK_TRACE, ReportField.LOGCAT},//发送的字段
//        mode = ReportingInteractionMode.TOAST,//异常时弹出信息的类型
//        resToastText = R.string.crash_toast_text)//弹出的文字
public class MyApp extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        // The following line triggers the initialization of ACRA
        ACRA.init(this);
    }
}
