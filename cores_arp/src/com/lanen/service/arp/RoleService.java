package com.lanen.service.arp;

import java.util.List;
import java.util.Map;

import com.lanen.base.BaseLongDao;
import com.lanen.model.Privilege;
import com.lanen.model.Role;
import com.lanen.model.Security_er;

public interface RoleService extends BaseLongDao<Role> {

	Map<String,Object> getRoles(String page,String rows);
	
	String getPrivilegeByModule(String name);
	String getPrivilegeById(Long id);
	//根据权限id查询该角色是否有该权限
	boolean checkRolePrivilegeById(String roleid,Long id);
	List<Map<String, String>> getAllRoles();
	List<?> getRolesById(String id);
	void updateRoleById(Security_er er);
	void updateEmployeeRole(String old,String newss);
	void saveRoleById(Security_er er);
	Integer getRoleId(String employeeid);
	List<?> getRoleById(Integer id);
	//List<?> getRoleById(Long id);
	//获取角色权限
	List<?> getPrivilegeByRoleid(String roleid);
	//所有权限
	List<Privilege> getAllPrivileges();
	List<?> getRoleByIds(Long id);
	boolean deleteRolePrivileges(String roleid);
	boolean insertRolePrivileges(String roleid,String privilegeid);
	Map<String,Object> getRoles(String page,String rows,String name);
	/**
	 * 系统功能
	 */
	List<?> getSysPrivilege();
	/**
	 * 
	 */
	boolean checkRolePrivilege(String roleid,String privilegeid);
}
