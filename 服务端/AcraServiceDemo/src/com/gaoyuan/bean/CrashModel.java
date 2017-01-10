package com.gaoyuan.bean;

/**
 * @author 高远</n>
 * 编写日期   2017-1-10上午10:59:16</n>
 * 邮箱  wgyscsf@163.com</n>
 * 博客  http://blog.csdn.net/wgyscsf</n>
 * TODO</n>
 */
// 本类是数据库存储表
public class CrashModel {
	private String id;
	private String ANDROID_VERSION;
	private String APP_VERSION_CODE;
	private String APP_VERSION_NAME;
	private String AVAILABLE_MEM_SIZE;
	private String BRAND;
	private String STACK_TRACE;
	private String TOTAL_MEM_SIZE;
	private String USER_APP_START_DATE;
	private String USER_CRASH_DATE;
	private String PACKAGE_NAME;
	private String PHONE_MODEL;
	private String PRODUCT;
	private String CPU_ABI;
	private String CPU_ABI2;
	private String FINGERPRINT;
	private String USER_COMMENT;
	private String createTime;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUSER_COMMENT() {
		return USER_COMMENT;
	}

	public void setUSER_COMMENT(String uSER_COMMENT) {
		USER_COMMENT = uSER_COMMENT;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getANDROID_VERSION() {
		return ANDROID_VERSION;
	}

	public void setANDROID_VERSION(String aNDROID_VERSION) {
		ANDROID_VERSION = aNDROID_VERSION;
	}

	public String getAPP_VERSION_CODE() {
		return APP_VERSION_CODE;
	}

	public void setAPP_VERSION_CODE(String aPP_VERSION_CODE) {
		APP_VERSION_CODE = aPP_VERSION_CODE;
	}

	public String getAPP_VERSION_NAME() {
		return APP_VERSION_NAME;
	}

	public void setAPP_VERSION_NAME(String aPP_VERSION_NAME) {
		APP_VERSION_NAME = aPP_VERSION_NAME;
	}

	public String getAVAILABLE_MEM_SIZE() {
		return AVAILABLE_MEM_SIZE;
	}

	public void setAVAILABLE_MEM_SIZE(String aVAILABLE_MEM_SIZE) {
		AVAILABLE_MEM_SIZE = aVAILABLE_MEM_SIZE;
	}

	public String getBRAND() {
		return BRAND;
	}

	public void setBRAND(String bRAND) {
		BRAND = bRAND;
	}

	public String getSTACK_TRACE() {
		return STACK_TRACE;
	}

	public void setSTACK_TRACE(String sTACK_TRACE) {
		STACK_TRACE = sTACK_TRACE;
	}

	public String getTOTAL_MEM_SIZE() {
		return TOTAL_MEM_SIZE;
	}

	public void setTOTAL_MEM_SIZE(String tOTAL_MEM_SIZE) {
		TOTAL_MEM_SIZE = tOTAL_MEM_SIZE;
	}

	public String getUSER_APP_START_DATE() {
		return USER_APP_START_DATE;
	}

	public void setUSER_APP_START_DATE(String uSER_APP_START_DATE) {
		USER_APP_START_DATE = uSER_APP_START_DATE;
	}

	public String getUSER_CRASH_DATE() {
		return USER_CRASH_DATE;
	}

	public void setUSER_CRASH_DATE(String uSER_CRASH_DATE) {
		USER_CRASH_DATE = uSER_CRASH_DATE;
	}

	public String getPACKAGE_NAME() {
		return PACKAGE_NAME;
	}

	public void setPACKAGE_NAME(String pACKAGE_NAME) {
		PACKAGE_NAME = pACKAGE_NAME;
	}

	public String getPHONE_MODEL() {
		return PHONE_MODEL;
	}

	public void setPHONE_MODEL(String pHONE_MODEL) {
		PHONE_MODEL = pHONE_MODEL;
	}

	public String getPRODUCT() {
		return PRODUCT;
	}

	public void setPRODUCT(String pRODUCT) {
		PRODUCT = pRODUCT;
	}

	public String getCPU_ABI() {
		return CPU_ABI;
	}

	public void setCPU_ABI(String cPU_ABI) {
		CPU_ABI = cPU_ABI;
	}

	public String getCPU_ABI2() {
		return CPU_ABI2;
	}

	public void setCPU_ABI2(String cPU_ABI2) {
		CPU_ABI2 = cPU_ABI2;
	}

	public String getFINGERPRINT() {
		return FINGERPRINT;
	}

	public void setFINGERPRINT(String fINGERPRINT) {
		FINGERPRINT = fINGERPRINT;
	}

	@Override
	public String toString() {
		return "CrashModel [id=" + id + ", ANDROID_VERSION=" + ANDROID_VERSION
				+ ", APP_VERSION_CODE=" + APP_VERSION_CODE
				+ ", APP_VERSION_NAME=" + APP_VERSION_NAME
				+ ", AVAILABLE_MEM_SIZE=" + AVAILABLE_MEM_SIZE + ", BRAND="
				+ BRAND + ", STACK_TRACE=" + STACK_TRACE + ", TOTAL_MEM_SIZE="
				+ TOTAL_MEM_SIZE + ", USER_APP_START_DATE="
				+ USER_APP_START_DATE + ", USER_CRASH_DATE=" + USER_CRASH_DATE
				+ ", PACKAGE_NAME=" + PACKAGE_NAME + ", PHONE_MODEL="
				+ PHONE_MODEL + ", PRODUCT=" + PRODUCT + ", CPU_ABI=" + CPU_ABI
				+ ", CPU_ABI2=" + CPU_ABI2 + ", FINGERPRINT=" + FINGERPRINT
				+ "]";
	}

}
