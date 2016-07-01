package com.lanen.model.schedule;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 日程安排表
 * @author Administrator
 *
 */
public class TblSchedulePlanVersion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7407450620256988860L;
	private String id;
	private String  scheduleID;//日程ID
	private int taskType;//任务类型
	private String taskCode;//任务识别号
	private int codeType;//识别号类型
	private Date enableDate;//任务生效日期
	private int startDay;//任务开始天数
	private Date startTime;//执行时间开始
	private Date endTime;//执行结束时间
	private int period;//周期
	private int periodUnit;//周期单位
	private int taskEndNum;//结束次数
	private Date taskEndDate;//结束日期
	private int taskEndState;//结束状态
	private int taskEndType;//任务结束类型
	private int taskItemType;//任务项目类型
	private String taskName;//任务名称
	private int validFlag;//有效标志          0,无效  1，有效   （签字时改变）
	private String creater;//创建人
	private Date createDate;//创建日期
	private String remark;//备注
	private int finishFlag;//任务完成标志
	private String signId;//完成签字ID
	private int taskKind;//任务类型 2014-08-25
	private String  revolution;//页面显示周期组合
	private String  dateTime;//页面显示
	private String showstartTime;//执行时间开始页面显示
	private String showendTime;//执行结束时间页面显示
	private Date dateTimeDate;
	private String signName;
	private Integer version;            //版本号
	private String oldid;//源id
	
	public String getOldid() {
		return oldid;
	}
	public void setOldid(String oldid) {
		this.oldid = oldid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public int getTaskKind() {
		return taskKind;
	}
	public void setTaskKind(int taskKind) {
		this.taskKind = taskKind;
	}
	public String getSignName() {
		return signName;
	}
	public void setSignName(String signName) {
		this.signName = signName;
	}
	public Date getDateTimeDate() {
		return dateTimeDate;
	}
	public void setDateTimeDate(Date dateTimeDate) {
		this.dateTimeDate = dateTimeDate;
	}
	
	public String getShowstartTime() {
		return showstartTime;
	}
	public void setShowstartTime(String showstartTime) {
		this.showstartTime = showstartTime;
	}
	public String getShowendTime() {
		return showendTime;
	}
	public void setShowendTime(String showendTime) {
		this.showendTime = showendTime;
	}
	public String getRevolution() {
		return revolution;
	}
	public void setRevolution(String revolution) {
		this.revolution = revolution;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	//日程预期读者
	private Set<TblScheduleReader> tblScheduleReaders = new HashSet<TblScheduleReader>();
	
	public Set<TblScheduleReader> getTblScheduleReaders() {
		return tblScheduleReaders;
	}
	public void setTblScheduleReaders(Set<TblScheduleReader> tblScheduleReaders) {
		this.tblScheduleReaders = tblScheduleReaders;
	}
	
	public String getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}
	public int getTaskType() {
		return taskType;
	}
	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	public int getCodeType() {
		return codeType;
	}
	public void setCodeType(int codeType) {
		this.codeType = codeType;
	}
	public Date getEnableDate() {
		return enableDate;
	}
	public void setEnableDate(Date enableDate) {
		this.enableDate = enableDate;
	}
	public int getStartDay() {
		return startDay;
	}
	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getPeriodUnit() {
		return periodUnit;
	}
	public void setPeriodUnit(int periodUnit) {
		this.periodUnit = periodUnit;
	}
	public int getTaskEndNum() {
		return taskEndNum;
	}
	public void setTaskEndNum(int taskEndNum) {
		this.taskEndNum = taskEndNum;
	}
	public Date getTaskEndDate() {
		return taskEndDate;
	}
	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}
	public int getTaskEndState() {
		return taskEndState;
	}
	public void setTaskEndState(int taskEndState) {
		this.taskEndState = taskEndState;
	}
	public int getTaskEndType() {
		return taskEndType;
	}
	public void setTaskEndType(int taskEndType) {
		this.taskEndType = taskEndType;
	}
	public int getTaskItemType() {
		return taskItemType;
	}
	public void setTaskItemType(int taskItemType) {
		this.taskItemType = taskItemType;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public int getValidFlag() {
		return validFlag;
	}
	public void setValidFlag(int validFlag) {
		this.validFlag = validFlag;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getFinishFlag() {
		return finishFlag;
	}
	public void setFinishFlag(int finishFlag) {
		this.finishFlag = finishFlag;
	}
	public String getSignId() {
		return signId;
	}
	public void setSignId(String signId) {
		this.signId = signId;
	}

	
	

}
