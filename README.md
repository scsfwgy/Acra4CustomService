## 简介
>ACRA is a library enabling Android Application to automatically post their crash reports to a GoogleDoc form. It is targetted to android applications developers to help them get data from their applications when they crash or behave erroneously.
ACRA is used in 2.68% (See AppBrain/stats) of all apps on Google Play as of Feb 2016. That's over 53K apps using ACRA. And since the average US user has 41 apps installed on their phone that means there is a 70% chance that ACRA is running on any phone. That means ACRA is running on over a billion devices.

---

> ACRA是一个自动收集崩溃日志到谷歌表单的库。它帮助安卓开发者在他们程序崩溃或者运行错误时获取异常数据。
截止2016年2月，ACRA在google play中使用率占2.68%。这意味着有53K款app使用了ACRA。由于美国用户平均有41的应用程序安装在手机上，意味着ACRA在每台手机上运行的概率为70%。这意味着运行着ACRA的设备超过10亿台。


* ACRA是一个开源的Android平台程序崩溃信息收集小程序，可以嵌入到Android Project中，当该程序崩溃的时候ACRA能够在进程彻底结束前收集崩溃状态时的该应用和设备的各种信息，发送到搭建好的服务端，便于开发者进行程序错误信息的收集，开发者可以更好的改进程序提高兼容性。

* 官网 [http://www.acra.ch/](http://www.acra.ch/ "http://www.acra.ch/")
* 开源地址 [https://github.com/ACRA/acra](https://github.com/ACRA/acra "https://github.com/ACRA/acra")
* 文档 [https://github.com/ACRA/acra/wiki/BasicSetup](https://github.com/ACRA/acra/wiki/BasicSetup "https://github.com/ACRA/acra/wiki/BasicSetup")

## 成就
![这里写图片描述](http://img.blog.csdn.net/20170110152203985?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2d5c2NzZg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
![这里写图片描述](http://img.blog.csdn.net/20170110152215219?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2d5c2NzZg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 初衷
* 官方文档为纯英文版，并且描述并不是一下子就能看懂。特别是自定义发送数据到指定服务器。特测试并记录。
* 网上资料没有自定义数据转化为表的形式，手动创建了对应数据的表，方便录入数据。
* 后端数据库已处理好，可以直接使用。
* 演示工程已可以直接使用。

## 客户端配置

* crash 以toast形式弹出

		//发送到服务器，Toast形式
		@ReportsCrashes(formUri = "http://192.168.1.160/AcraServiceDemo/CrashApiAction",
		//formUriBasicAuthLogin = "yourlogin", // optional
		//formUriBasicAuthPassword = "y0uRpa$$w0rd", // optional
		 mode = ReportingInteractionMode.TOAST,
		 reportType= HttpSender.Type.JSON,//配置以json形式发送
		 resToastText=R.string.crash_toast_text)//配置异常时弹出的信息

* 对话框形式形式,会提醒用户输入上报信息。
	
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


* 通知栏形式，点击变为对话框形式

		// 发送到服务器，通知栏形式,点击跳进对话框形式收集用户输入的信息，会提醒用户输入上报信息。官方已不再提倡使用：This is a legacy feature, as Dialog mode is generally preferred.
		@ReportsCrashes(formUri = "http://192.168.1.160/AcraServiceDemo/CrashApiAction",
		       mode = ReportingInteractionMode.NOTIFICATION,
		        resToastText = R.string.crash_toast_text2, // optional, displayed as soon as the crash occurs, before collecting data which can take a few seconds
		        resDialogText = R.string.crash_dialog_text,
		        resDialogIcon = android.R.drawable.ic_dialog_info, //optional. default is a warning sign
		        resDialogTitle = R.string.crash_dialog_title, // optional. default is your application name
		        resDialogCommentPrompt = R.string.crash_dialog_comment_prompt, // optional. When defined, adds a user text field input with this text resource as a label
		        resDialogOkToast = R.string.crash_dialog_ok_toast, // optional. displays a Toast message when the user accepts to send a report.
		        resDialogTheme = R.style.AppTheme_Dialog, //optional. default is Theme.Dialog
		        resNotifTickerText = R.string.crash_notif_ticker_text,
		        resNotifTitle = R.string.crash_notif_title,
		        resNotifText = R.string.crash_notif_text,
		        resNotifIcon = android.R.drawable.stat_notify_error, // optional. default is a warning sign
		        reportType = HttpSender.Type.JSON//配置以json形式发送
		)

* 发送邮箱，注意：该操作触发时会调起用户客户端邮箱需要用户主动发送。不建议使用。

		@ReportsCrashes(mailTo = "414850132@qq.com",
		        customReportContent = {ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME,
		                ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL, ReportField.CUSTOM_DATA,
		                ReportField.STACK_TRACE, ReportField.LOGCAT},//发送的字段
		        mode = ReportingInteractionMode.TOAST,//异常时弹出信息的类型
		        resToastText = R.string.crash_toast_text)//弹出的文字

## 服务端配置

	// Control
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print("begin");
		ServletInputStream inputStream = request.getInputStream();
		String str = IOUtils.toString(inputStream, "UTF-8");//json形式接收
		System.out.println(str);
		System.out.println("开始解析");
		processModel(str);
	}

## 数据库信息收集
![这里写图片描述](http://img.blog.csdn.net/20170110152249485?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2d5c2NzZg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
![这里写图片描述](http://img.blog.csdn.net/20170110152258310?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2d5c2NzZg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## demo代码
* 客户端多种模式配置
	* Toast（可选），然后发送crash到数据库
	* Dialog，然后发送到服务器（需要用户提交信息，并且手动同意）。
	* 通知栏提醒，然后显示Dialog，然后发送到服务器（需要用户提交信息，并且手动同意）。
	* 邮箱形式发送到指定邮箱
* 服务端
	* 解析数据为成指定对象
	* 保存到数据库

* TODO：图形化界面分析崩溃信息

## 总结
* 如果了解了上述所说，可以看出acra是非常灵活的，可以深度自定义，完全看开发者自己需求。
* 由于“墙”，原有的默认依赖谷歌表单的形式是使用不了的。
* 推荐使用腾讯的bugly代替acra进行处理应用的异常处理。请自行查资料如何使用。当然，深度定制还是acra比较强大。
