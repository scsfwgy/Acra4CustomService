package com.gaoyuan.action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.io.IOUtils;

import com.gaoyuan.bean.Crash;
import com.gaoyuan.bean.CrashModel;
import com.gaoyuan.utils.C3p0Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author 高远</n>
 * 编写日期   2017-1-9下午8:59:36</n>
 * 邮箱  wgyscsf@163.com</n>
 * 博客  http://blog.csdn.net/wgyscsf</n>
 * TODO</n>
 */
@WebServlet("/CrashApiAction")
public class CrashApiAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	// Control
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print("begin");
		ServletInputStream inputStream = request.getInputStream();
		String str = IOUtils.toString(inputStream, "UTF-8");
		System.out.println(str);
		System.out.println("开始解析");
		processModel(str);
	}

	/**
	 * Service: 生成表需要的model
	 */
	private void processModel(String str) {
		Gson gson=new Gson();
		Crash crash = gson.fromJson(str, new TypeToken<Crash>() {
		}.getType());

		// 开始转换
		CrashModel crashModel = new CrashModel();
		crashModel.setId(UUID.randomUUID().toString());
		crashModel.setANDROID_VERSION(aovidNull(crash.getANDROID_VERSION()));
		crashModel.setAPP_VERSION_CODE(aovidNull(crash.getAPP_VERSION_CODE()
				+ ""));
		crashModel.setAPP_VERSION_NAME(aovidNull(crash.getAPP_VERSION_NAME()));
		crashModel.setAVAILABLE_MEM_SIZE(aovidNull(crash
				.getAVAILABLE_MEM_SIZE() + ""));
		crashModel.setBRAND(aovidNull(crash.getBRAND()));
		crashModel.setSTACK_TRACE(aovidNull(crash.getSTACK_TRACE()));
		crashModel.setTOTAL_MEM_SIZE(aovidNull(crash.getTOTAL_MEM_SIZE() + ""));
		crashModel.setUSER_APP_START_DATE(aovidNull(crash
				.getUSER_APP_START_DATE()));
		crashModel.setUSER_CRASH_DATE(aovidNull(crash.getUSER_CRASH_DATE()));

		crashModel
.setPACKAGE_NAME(aovidNull(crash.getPACKAGE_NAME()));
		crashModel.setPHONE_MODEL(aovidNull(crash.getPHONE_MODEL()));
		crashModel.setPRODUCT(aovidNull(crash.getPRODUCT()));
		crashModel.setCPU_ABI(aovidNull(crash.getBUILD().getCPU_ABI()));
		crashModel.setCPU_ABI2(aovidNull(crash.getBUILD().getCPU_ABI2()));
		crashModel.setFINGERPRINT(aovidNull(crash.getBUILD().getFINGERPRINT()));
		crashModel.setUSER_COMMENT(aovidNull(crash.getUSER_COMMENT()));
		crashModel.setCreateTime(getCurrentDateTime());
		// System.out.println("--->" + crashModel);
		boolean isSave = saveDB(crashModel);
		System.out.println("操作结果：" + isSave);
	}

	/**
	 * DAO:保存数据
	 */
	private boolean saveDB(CrashModel crashModel) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into CrashModel(" +
				"id,ANDROID_VERSION,APP_VERSION_CODE,APP_VERSION_NAME,AVAILABLE_MEM_SIZE," +
				"BRAND,STACK_TRACE,TOTAL_MEM_SIZE,USER_APP_START_DATE,USER_CRASH_DATE," +
				"PACKAGE_NAME,PHONE_MODEL,PRODUCT,CPU_ABI,CPU_ABI2," +
 "FINGERPRINT,USER_COMMENT,createTime) value(" +
				"?,?,?,?,?," +
				"?,?,?,?,?," +
				"?,?,?,?,?," +
 "?,?,?)";

		String[] param = { crashModel.getId(), crashModel.getANDROID_VERSION(),
				crashModel.getAPP_VERSION_CODE(),
				crashModel.getAPP_VERSION_NAME(),
				crashModel.getAVAILABLE_MEM_SIZE(), crashModel.getBRAND(),
				crashModel.getSTACK_TRACE(), crashModel.getTOTAL_MEM_SIZE(),
				crashModel.getUSER_APP_START_DATE(),
				crashModel.getUSER_CRASH_DATE(), crashModel.getPACKAGE_NAME(),
				crashModel.getPHONE_MODEL(), crashModel.getPRODUCT(),
				crashModel.getCPU_ABI(), crashModel.getCPU_ABI2(),
				crashModel.getFINGERPRINT(), crashModel.getUSER_COMMENT(),
				crashModel.getCreateTime() };
		try {
			int flag = runner.update(sql, param);
			if (flag > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	// Utils:避免值为空
	private String aovidNull(String str) {
		if (str == null)
			return "";
		return str;
	}

	// 生成当前时间
	public static String getCurrentDateTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String str = simpleDateFormat.format(date);
		return str;
	}

}
