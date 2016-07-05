package com.lanen.view.action.arp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lanen.base.BaseAction;
import com.lanen.jsonAndModel.JsonPluginsUtil;
import com.lanen.model.Employee;
import com.lanen.model.Employee_json;
import com.lanen.model.Privilege;
import com.lanen.model.Role;
import com.lanen.model.RolePrivilege;
import com.lanen.model.Security_er;
import com.lanen.model.Security_role;
import com.lanen.service.arp.DepartmentService;
import com.lanen.service.arp.EducationService;
import com.lanen.service.arp.EmployeeService;
import com.lanen.service.arp.PositionService;
import com.lanen.service.arp.RoleService;
import com.lanen.service.arp.TitleService;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class EmployeeAction extends BaseAction<Employee> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8192421968768059994L;
	@Resource
	private EmployeeService employeeService;
	@Resource
	private PositionService positionService;
	@Resource
	private DepartmentService departmentService;
	@Resource
	private EducationService educationService;
	@Resource
	private TitleService titleService;
	@Resource
	private RoleService roleService;
	private Employee employee;

	private List<Map<String,Object>> listEmployeeRole;
	private List<Role> listAllRole;
	private String roleIds;
	/**
	 * 跳转到员工信息界面
	 * 
	 * @return
	 */
	public String list() {
		return "list";
	}

	/**
	 * 加载员工信息数据
	 */
	public void loadList() {
		String condition = model.getName();
		List<Employee> list = employeeService.getAllEmployees(condition);
		List<Employee_json> jsonList = new ArrayList<Employee_json>();
		for (Employee e : list) {
			Employee_json json = new Employee_json();
			json.setId(e.getId());
			json.setName(e.getName());
			json.setUserid(e.getUserid());
			json.setEmployeeid(e.getEmployeeid());
			//用户必须具备角色.
//			if (!"".equals(e.getRoles1())&&e.getRoles1()!=null) {
//				json.setRoles(e.getRoles1().getName());
//			}
			json.setPhone(e.getPhone());
			json.setMobile(e.getMobile());
			json.setEmail(e.getEmail());
			json.setSex(e.getSex());
			json.setJguan(e.getJguan());
			json.setAddress(e.getAddress());
			json.setBod(e.getBod());
			json.setXueli(e.getXueli());
			json.setMarried(e.getMarried());
			json.setSfz(e.getSfz());
			json.setSchool(e.getSchool());
			json.setNational(e.getNational());
			json.setIntime(e.getIntime());
			json.setDescription(e.getDescription());
			Integer position_id = e.getPositionid();
			if (position_id != null) {
				String name = positionService.getNameById(position_id);
				json.setPosition(name);
			}
			Integer department_id = e.getDepartmentid();
			if (department_id != null) {
				String name = departmentService.getNameById(department_id);
				json.setDepartment(name);
			}
			Integer xueli = e.getXueli();
			if (xueli != null) {
				String name = educationService.getNameById(xueli);
				json.setXueliName(name);
			}
			Integer zhic = e.getZhic();
			if (zhic != null) {
				String name = titleService.getNameById(zhic);
				json.setZhicName(name);
			}
			jsonList.add(json);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", jsonList);
		map.put("total", list.size());
		String jsonStr = JsonPluginsUtil.beanToJson(map, "yyyy-MM-dd");
		writeJson(jsonStr);
	}

	public void add() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Employee e = new Employee();
		e.setName(model.getName());
		e.setEmployeeid(model.getEmployeeid());
		e.setSex(model.getSex());
		e.setUserid(model.getUserid());
		e.setPassword(model.getPassword());
		e.setBod(model.getBod());
		e.setIntime(model.getIntime());
		e.setMarried(model.getMarried());
		e.setSchool(model.getSchool());
		e.setXueli(model.getXueli());
		e.setZye(model.getZye());
		e.setZhic(model.getZhic());
		e.setNational(model.getNational());
		e.setJguan(model.getJguan());
		e.setMobile(model.getMobile());
		e.setPhone(model.getPhone());
		e.setEmail(model.getEmail());
		e.setAddress(model.getAddress());
		e.setDepartmentid(model.getDepartmentid());
		e.setPositionid(model.getPositionid());
		e.setSfz(model.getSfz());
		e.setDescription(model.getDescription());
		Date date = new Date();
		e.setDateentered(date);
		e.setDatemodified(date);
		Employee user = (Employee) ActionContext.getContext().getSession()
				.get("user");
		e.setCreatedby(user.getId() + "");
		e.setModifiedby(user.getId() + "");
		//e.setRoles(model.getRoles());
		//employeeService.save(e);
		//更新security_er
		Set<Role> set=(Set<Role>) roleService.getRoleById(Integer.parseInt(model.getRoles()));
		//Role role= roleService.getById(Integer.parseInt(model.getRoles()));
		Role role=roleService.getById(Long.parseLong(model.getRoles()));
		/*for(Security_role r:list){				
			role.setId(Long.parseLong(r.getId()+""));
			role.setName(r.getName());
			role.setDescription(r.getDescription());
		}*/
//		Security_er er=new Security_er();
//		er.setEmployee_id(model.getEmployeeid());
//		er.setRole_id(Integer.parseInt(model.getRoles()+""));
//		roleService.saveRoleById(er);
//		e.setRoles1(role);
		e.setRoles1(set);
		employeeService.save(e);
		
		map.put("success", true);
		map.put("msg", "添加成功");
		map.put("id", e.getId());
		String jsonStr = JsonPluginsUtil.beanToJson(map);
		writeJson(jsonStr);
	}

	public void todEitEmployee() {
		if (model.getId() != null) {
			Employee e = employeeService.getById(model.getId());
			
//			if (e.getRoles1()!=null) {
//				Set<Role> r = e.getRoles1();
//				String rolesid = r.getId() + "";
//				e.setRoles(rolesid);//角色id
//			}
			e.setRoles1(null);//防止JSON死循环
			String jsonStr = JsonPluginsUtil.beanToJson(e, "yyyy-MM-dd");
			writeJson(jsonStr);
		}

	}

	public void editSave() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (model.getId() != null) {
			Employee e = employeeService.getById(model.getId());
			
			String oldEmployeeId=e.getEmployeeid();
			e.setName(model.getName());
			e.setEmployeeid(model.getEmployeeid());
			e.setSex(model.getSex());
			e.setUserid(model.getUserid());
			e.setPassword(model.getPassword());
			e.setBod(model.getBod());
			e.setIntime(model.getIntime());
			e.setMarried(model.getMarried());
			e.setSchool(model.getSchool());
			e.setXueli(model.getXueli());
			e.setZye(model.getZye());
			e.setZhic(model.getZhic());
			e.setNational(model.getNational());
			e.setJguan(model.getJguan());
			e.setMobile(model.getMobile());
			e.setPhone(model.getPhone());
			e.setEmail(model.getEmail());
			e.setAddress(model.getAddress());
			e.setDepartmentid(model.getDepartmentid());
			e.setPositionid(model.getPositionid());
			e.setSfz(model.getSfz());
			e.setDescription(model.getDescription());
			Date date = new Date();
			e.setDatemodified(date);
			Employee user = (Employee) ActionContext.getContext().getSession()
					.get("user");
			e.setModifiedby(user.getId() + "");
			
			//Set<Role> set=(Set<Role>) roleService.getRoleById(Integer.parseInt(model.getRoles()));
			/*Role role=new Role();
			for(Role r:set){	
				role.setName(r.getName());
				role.setDescription(r.getDescription());
			}*/
//			Role role=roleService.getById(Long.parseLong(model.getRoles()));
			//e.setRoles1(set);
			
			employeeService.update(e);
			
			//Security_er er=new Security_er();
			//er.setEmployee_id(model.getEmployeeid());
			//er.setRole_id(Integer.parseInt(model.getRoles()+""));
			
			roleService.updateEmployeeRole(oldEmployeeId,model.getEmployeeid());
			/*e.setRoles1(role);
			
			employeeService.update(e);*/
			map.put("success", true);
			map.put("msg", "修改成功");
			map.put("id", e.getId());
			String jsonStr = JsonPluginsUtil.beanToJson(map);
			writeJson(jsonStr);
		}
	}

	public void delEmployee() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (model.getId() != null) {
			Employee e = employeeService.getById(model.getId());
			e.setDeleted(-1);
			employeeService.update(e);
			map.put("success", true);
			map.put("msg", "删除成功");
			String jsonStr = JsonPluginsUtil.beanToJson(map);
			writeJson(jsonStr);
		}
	}

	/**
	 * 删除员工信息
	 */
	public void delRealEmployee() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (model.getId() != null) {
			employeeService.delete(model.getId());
			map.put("success", true);
			map.put("msg", "删除成功");
			String jsonStr = JsonPluginsUtil.beanToJson(map);
			writeJson(jsonStr);
		}
	}

	/**
	 * 检查工号是否存在
	 */
	public void checkEmployeeid() {
		if (null != model.getEmployeeid() && !"".equals(model.getEmployeeid())) {
			boolean isExist = employeeService.isExistEmployeeid(model
					.getEmployeeid());
			if (!isExist) {
				writeJson("true");
			} else {
				writeJson("false");
			}
		} else {
			writeJson("false");
		}
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void loadListEmployee() {
		List<Map<String, String>> mapList = employeeService
				.getAllEmployeesMap();
		String jsonStr = JsonPluginsUtil.beanListToJson(mapList);
		writeJson(jsonStr);
	}

	public void loadListEmployeeNo() {
		List<Map<String, String>> mapList = employeeService
				.getAllEmployeesMapNo();
		String jsonStr = JsonPluginsUtil.beanListToJson(mapList);
		writeJson(jsonStr);
	}

	/**
	 * 角色
	 * @return
	 */
	public void loadListRole(){//角色直接从页面加进去.
		if(!"".equals(model.getId())&&model.getId()!=null){
			Employee employee=employeeService.getById(Long.valueOf(model.getId()));
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("name", employee.getName());
			map.put("description", employee.getDescription());
			map.put("id", employee.getId());
			
			//获取该员工的角色.
			List<?> listEmployeeRoles=employeeService.getRoleByEmployeeId(employee.getId().toString());
			listEmployeeRole=new ArrayList<Map<String,Object>>();
			for(Object ob:listEmployeeRoles){
				Map<String,Object> m=new HashMap<String,Object>();
				Object[]objs=(Object[])ob;
				m.put("employeeid", objs[0]);
				m.put("roleis", objs[1]);
				listEmployeeRole.add(m);
			}
			//获取所有权限功能.
			listAllRole =employeeService.getAllRole();
			String strjson=JsonPluginsUtil.beanToJson(map);
			writeJson(strjson);
		}
	}
	public void saveEmployeeRole(){
		Map<String,Object> map=new HashMap<String,Object>();
		String[]str1=roleIds.split(",");
		Employee e=employeeService.getById(model.getId());
		if(model.getId()!=null&&!"".equals(model.getId())){
						
			//roleService.deleteRolePrivileges(model.getId()+"");
			Set<Role> roles=new HashSet<Role>(); 
			for(int i=0;i<str1.length;i++){
				Role role=roleService.getById(Long.valueOf(str1[i]));
				roles.add(role);
				//roleService.insertRolePrivileges(model.getId()+"",str1[i]+"");
			}
			e.setRoles1(roles);
			employeeService.update(e);
			map.put("success", true);
			map.put("msg", "授权成功");
			map.put("id", model.getId());
		}
		String strjson=JsonPluginsUtil.beanToJson(map);
		writeJson(strjson);
	}
	public void loadListRole1(){
		Employee employee=employeeService.getById(Long.valueOf(model.getId()));
		List<Role> listRole=roleService.findAll();
		List<Map<String,Object>> map=new ArrayList<Map<String,Object>>();
		for(Role role:listRole){
			Map m=new HashMap<String,Object>();
			m.put("id", role.getId());
			m.put("name", role.getName());
			m.put("description", role.getDescription());
			//检查还员工是否已有该角色
			boolean b=employeeService.checkEmployeeRole(employee.getEmployeeid()+"", role.getId()+"");
			m.put("ck", b);
			map.add(m);
		}
		String json=JsonPluginsUtil.beanListToJson(map);
		writeJson(json);
	}

	public List<Map<String, Object>> getListEmployeeRole() {
		return listEmployeeRole;
	}

	public void setListEmployeeRole(List<Map<String, Object>> listEmployeeRole) {
		this.listEmployeeRole = listEmployeeRole;
	}

	public List<Role> getListAllRole() {
		return listAllRole;
	}

	public void setListAllRole(List<Role> listAllRole) {
		this.listAllRole = listAllRole;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
}