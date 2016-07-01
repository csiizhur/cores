package com.lanen.model.schedule;

import java.io.Serializable;
import java.util.Date;

	/**
	 * 常规任务负责人
	 * @author Administrator
	 *
	 */
public class TblTaskLeader implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8897535174241120817L;

	private String id;
	private String taskTypeID;	//系统任务ID
	private String taskLeader;	//负责人
	private Date startDate;		
	private Date endDate;		
	private String signId;		
	private String endDateSignId;	//结束日期签字Id
	
	public String getEndDateSignId() {
		return endDateSignId;
	}
	public void setEndDateSignId(String endDateSignId) {
		this.endDateSignId = endDateSignId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTaskTypeID() {
		return taskTypeID;
	}
	public void setTaskTypeID(String taskTypeID) {
		this.taskTypeID = taskTypeID;
	}
	public String getTaskLeader() {
		return taskLeader;
	}
	public void setTaskLeader(String taskLeader) {
		this.taskLeader = taskLeader;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getSignId() {
		return signId;
	}
	public void setSignId(String signId) {
		this.signId = signId;
	}
	
	
}
