package com.lanen.service.contract;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lanen.base.BaseDao;
import com.lanen.model.contract.TblStudyItem;
import com.lanen.model.contract.TblStudyItemHis;

/**
 * 委托项目service
 * @author 黄国刚
 *
 */
public interface TblStudyItemService extends BaseDao<TblStudyItem> {

	/**判断课题编号的唯一性
	 * @param studyNo
	 * @return
	 */
	boolean isExistByStudyNo(String studyNo);

	/**查询 CoresStudy.dbo.dictAnimalType      id，typeName字段
	 * 
	 * @return
	 */
	List<Map<String, String>> findDictAnimalTypeOrderByOrderNo();

	/**查询 CoresStudy.dbo.dictAnimalStrain    strainName,strainName字段
	 * @param animalTypeId
	 * @return
	 */
	List<Map<String, String>> findDictAnimalStrainByTypeId(String animalTypeId);
	
    /**
	 * 综合查询中加载委托项目信息
     * @param type
     * @param start
     * @param end
     * @param name
     * @param readAll
     * @param reader
     * @return
     */
    List<TblStudyItem> loadStudyItemsByCondition(String type,Date start,Date end,String name,boolean readAll,String reader);

	/**根据供试品编号查询委托试验列表
	 * @param tiNo
	 * @return
	 */
	List<TblStudyItem> getListByTiNo(String tiNo);

	/**根据Id ，判断是否任命  SD
	 * @param id
	 * @return
	 */
	boolean isHasSDById(String id);
	/**
	 * 根据项目状态分组统计项目的数量
	 * */
	Map<Integer, Integer> getCountStudyItemsByState(Date startDate,Date endDate,String tiCode,String name);

	/**打印任命书用到的数据源
	 * @param studyNo
	 * @return
	 */
	List<Map<String, Object>> getMapListForImprot(String studyNo);
	
	/**
	 * 根据课题编号查询实体
	 * @param studyNo
	 * @return
	 */
	TblStudyItem getByStudyNoStudyItem(String studyNo);
	/**
	 * 获取多个studyItem
	 * @param studyNo
	 * @return
	 */
	List<TblStudyItem> getByStudyNos(String[] studyNo);
	
	/**打印任命书用到的数据源
	 * @param studyNo
	 * @return
	 */
	List<Map<String, Object>> getMapMoreListForImprot(List<String> studyNoList);
	/**
	 * 增加打印次数
	 * @param studyNoList
	 */
	void addPrintNumber(List<String> studyNoList);
	
	//获得大于0 的打印次数的课题编号的list
	List<String>  selectPrintNumber(List<String> studyNoList);

	/**根据课题编号查询课题类别编码
	 * @param studyNo
	 * @return
	 */
	String getStudyTypeCodeByStudyNo(String studyNo);

	/**根据合同编号查询 项目列表
	 * @param contractCode
	 * @return
	 */
	List<TblStudyItem> getByContractCode(String contractCode);

	/**判断该公式品是否添加该类型委托项目
	 * @param tiNo
	 * @param studyTypeCode
	 * @return
	 */
	boolean isExistByTiNoStudyTypeCode(String tiNo, String studyTypeCode);

	/**判断该公式品是否添加该类型委托项目
	 * @param tiNo
	 * @param studyTypeCode
	 * @return
	 */
	boolean isExistByTiNostudyName(String tiNo, String studyName);
	
	/**判断该公式品是否添加该类型委托项目
	 * @param tiNo
	 * @param studyTypeCode
	 * @param animalType
	 * @return
	 */
	boolean isExistByTiNostudyName(String tiNo, String studyName,String animalType);
	
	/**
	 * 查询委托项目列表(已任命SD,SD==自己,且还未建专题的,studyCode(studyNo),studyName,sponsorName,tiName,tiCode)
	 * @param userName
	 * @return
	 */
	List<Map<String, Object>> getMapListByuserName(String userName);
	
	/**通过编号查询  供试品类别
	 * @param studyNo
	 * @return
	 */
	String getTiCodeByStudyNo(String studyNo);
	
	/**
	 * 通过专题类别编号，以及供试品编号生成专题编号
	 * @param StudyCodes
	 * @param tiNo
	 * @return
	 */
	List<Map<String, Object>> getByStudyCodesAndTiNo(String studyCodes,String tiNo);
	
	/**
	 * 通过专题类别编号，以及供试品编号生成专题编号（2014-12-22第二种）
	 * @param StudyCodes
	 * @param tiNo
	 * @return
	 */
	List<Map<String, Object>> getByStudyCodesAndTiNo2(String studyCodes,String tiNo);
	
	String getSDByStudyNo(String studyNo);

	/**在合同再编辑状态下，  保存之前建立的委托项目
	 * @param tblStudyItem
	 * @param tblStudyItemHis
	 * @param realName
	 */
	void update(TblStudyItem tblStudyItem, TblStudyItemHis tblStudyItemHis,
			String realName);
}
