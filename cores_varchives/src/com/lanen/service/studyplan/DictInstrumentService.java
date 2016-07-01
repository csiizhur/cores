package com.lanen.service.studyplan;

import java.util.List;

import com.lanen.base.BaseDao;
import com.lanen.model.clinicaltest.DictInstrument;

public interface DictInstrumentService extends BaseDao<DictInstrument>{

	/**
	 * 查询所有列表
	 * @return
	 */
	List<DictInstrument> getAll();

	/**
	 * 判断设备ID是否存在
	 * @param name
	 * @return
	 */
	boolean isExistByInstrumentId(String instrumentId);

	/**
	 * 根据  检测项目  查询设备列表
	 * @param testItem
	 * @return
	 */
	List<DictInstrument> findByTestItem(int testItem);
	/**
	 * 根据检测项目查询本台机器有关联的仪器
	 * @param testItem
	 * @return
	 */
	
	List<DictInstrument> findSpecInstrByComputerAndTestItem(String computerName,int testItem);
	/**
	 * 根据检测项目查询本台机器有关联的仪器
	 * @param testItem
	 * @return
	 */
	
	List<DictInstrument> findDataInstrByComputerAndTestItem(String computerName,int testItem);
	/**
	 * 查询所有本台机器有关联的仪器
	 * @param testItem
	 * @return
	 */
	List<DictInstrument> getSpecInstrByComputerName(String computerName);
	/**
	 * 根据设备id获取设备的类型
	 * @param instrumentId
	 * @return
	 */
	String getModelNumberByInstrument(String instrumentId);
}
