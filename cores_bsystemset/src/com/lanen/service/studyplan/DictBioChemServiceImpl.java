package com.lanen.service.studyplan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lanen.base.BaseDaoImpl;
import com.lanen.model.studyplan.DictBioChem;

@Service
public class DictBioChemServiceImpl extends BaseDaoImpl<DictBioChem> implements DictBioChemService {

	@SuppressWarnings("unchecked")
	public List<DictBioChem> getAll() {
		List<DictBioChem> list=getSession().createQuery("FROM DictBioChem  d ORDER BY d.orderNo ASC").list();
		return list;
	}

	public boolean isExistByName(String name) {
		Object obj =getSession().get(DictBioChem.class, name);
		return obj!=null ? true :false;
	}

	@SuppressWarnings("unchecked")
	public String getIndex2ByAbbr(String indexAbbr) {
		List<DictBioChem> list=getSession().createQuery("FROM DictBioChem  d WHERE  d.abbr = ? ")//
		.setParameter(0, indexAbbr)
		.list();
		if(null!=list&&list.size()>0){
			return list.get(0).getName();
		}
		return "";
	}

	public Map<String, Integer> getMap() {
		Map<String ,Integer> map = new HashMap<String,Integer>();
		List<DictBioChem> list = findAll();
		if(null!=list && list.size()>0){
			for(DictBioChem obj:list){
				map.put(obj.getAbbr(), obj.getOrderNo());
			}
		}
		return map;
	}

	public Map<String, String> geUnittMap() {
		Map<String ,String> map = new HashMap<String,String>();
		List<DictBioChem> list = findAll();
		if(null!=list && list.size()>0){
			for(DictBioChem obj:list){
				map.put(obj.getAbbr(), obj.getUnit());
			}
		}
		return map;
	}

	/**
	 * 通过唯一的排序号查找实体
	 * @param orderNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public DictBioChem getByOrderNo(int orderNo) {
		List<DictBioChem> list=getSession().createQuery("FROM DictBioChem  d WHERE d.orderNo =?").setParameter(0, orderNo).list();
		if(list!=null && !list.isEmpty()){
			return list.get(0);
		}else {
			return null;
		}
	}

	public void moveOeder(int orderNoPara, int orderNoNext) {
		if(orderNoPara!=0 && orderNoNext!=0){
			DictBioChem firster = getByOrderNo(orderNoPara);
			DictBioChem seconder = getByOrderNo(orderNoNext);
			int temp;
			temp = firster.getOrderNo();
			firster.setOrderNo(seconder.getOrderNo());
			seconder.setOrderNo(temp);
			save(firster);
			save(seconder);
		}
	}

	public int getNextOrderNo() {
		int returnValue=0;
		Object ttt = getSession().createQuery("SELECT MAX(orderNo) FROM DictBioChem").uniqueResult();
		if(null!=ttt ){
			returnValue=(Integer)ttt;
		}
		return returnValue+1;
	}

	@SuppressWarnings("unchecked")
	public List<DictBioChem> findAllOrderByOrderNo() {
		List<DictBioChem> list=getSession().createQuery("FROM DictBioChem d ORDER BY d.orderNo asc").list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public boolean isExistByAbbr(String abbr) {
		List<DictBioChem> list=getSession().createQuery("FROM DictBioChem  d WHERE  d.abbr = ? ")//
		.setParameter(0, abbr)
		.list();
		if(null!=list&&list.size()>0){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean isExistByNameAbbr(String name, String abbr) {
		List<DictBioChem> list=getSession().createQuery("FROM DictBioChem  d WHERE  d.abbr = ? and d.name != ?")//
		.setParameter(0, abbr)
		.setParameter(1, name)
		.list();
		if(null!=list&&list.size()>0){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public String getIndexUnit(String indexAbbr) {
		List<DictBioChem> list=getSession().createQuery("FROM DictBioChem  d WHERE  d.abbr = ? ")//
		.setParameter(0, indexAbbr)
		.list();
		String unit = "";
		if(null!=list&&list.size()>0){
			unit = list.get(0).getUnit();
		}
		return unit == null ? "":unit;
	}

}