package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Manager;
import service.ManagerService;

public class ManagerAction extends ActionSupport implements ModelDriven<Manager>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private ManagerService managerService;
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	private Manager manager=new Manager();
	public Manager getModel() {
		return manager;
	}
	
	//到登录页面
	public String toLogin() {
		return "login";
	}
	
	//登录
	public String login() {
//		HttpServletRequest request=ServletActionContext.getRequest();
//		List<Manager> list = managerService.findOne(manager);
//		if(list !=null && list.size()>0) {
//			Manager manager2=list.get(0);
//			request.getSession().setAttribute("managerName", manager2.getName());
//			request.getSession().setAttribute("managerLevel", manager2.getLevel());
//			return "index";
//		}
//		request.setAttribute("error", "登陆账号或登录密码错误！");
//		return "login";
		
		HttpServletRequest request=ServletActionContext.getRequest();
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(manager.getName(), manager.getPassword());
		try {
			subject.login(token);
			List<Manager> list = managerService.findOne(manager);
			Manager manager2=list.get(0);
			request.getSession().setAttribute("managerName", manager2.getName());
			request.getSession().setAttribute("managerLevel", manager2.getLevel());
			return "index";
		} catch (Exception e) {
			request.setAttribute("error", "登陆账号或登录密码错误！");
			return "login";
		}
	}
	
	//退出登录
	public String logout() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().removeAttribute("managerName");
		request.getSession().removeAttribute("managerLevel");
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}
	
	//到添加管理员的页面
	public String toAdd() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/manager/managerAdd.jsp");
		return "index";
	}
	
	//添加
	public String add() {
		managerService.addOne(manager);
		return "backToAdd";
	}
	
	//到管理员列表页面
	public String toList() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/manager/managerList.jsp");
		return "index";
	}
	
	//获取管理员列表
	private Map<String, Object> managerList;
	public Map<String, Object> getManagerList() {
		return managerList;
	}
	public void setManagerList(Map<String, Object> managerList) {
		this.managerList = managerList;
	}
	public String getList() {
		HttpServletRequest request=ServletActionContext.getRequest();
		int page=Integer.parseInt(request.getParameter("page"));
		int rows=Integer.parseInt(request.getParameter("rows"));
		List<Manager> list=managerService.getAll();
		List<Manager> list2=managerService.getAllByLimit(page,rows);
		int total=list.size();
		Map<String, Object> map=new HashMap<>();
		map.put("total", total);
		map.put("rows", list2);
		this.setManagerList(map);
		return "managerList";
	}
	
	//删除
	public String deleteOne() {
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Manager manager2 = managerService.getOne(id);
		managerService.deleteOne(manager2);
		return "backToList";
	}
	
	//到修改页面
	public String toUpdateOne() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String id= request.getParameter("id");
		request.setAttribute("myurl", request.getContextPath()+"/manager/managerUpdate.jsp?id="+id);
		return "index";
	}
	
	//获取修改的初始数据
	private Manager prevInfo;
	public Manager getPrevInfo() {
		return prevInfo;
	}
	public void setPrevInfo(Manager prevInfo) {
		this.prevInfo = prevInfo;
	}
	public String getPrevUpdate() {
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Manager manager2 = managerService.getOne(id);
		this.setPrevInfo(manager2);
		return "prevInfo";
	}
	
	//更新一条数据
	public String updateOne() {
		managerService.updateOne(manager);
		return "backToList";
	}
}
