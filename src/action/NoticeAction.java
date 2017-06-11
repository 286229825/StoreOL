package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Notice;
import service.NoticeService;

public class NoticeAction extends ActionSupport implements ModelDriven<Notice>{
	private Notice notice=new Notice();
	public Notice getModel() {
		return notice;
	}
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	//到添加页面
	public String toAdd() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/manager/noticeAdd.jsp");
		return "index";
	}
	
	//添加一条公告
	public String addOne() {
		noticeService.addOne(notice);
		return "backToAdd";
	}
	
	//到公告列表页面
	public String toList() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/manager/noticeList.jsp");
		return "index";
	}
	
	//获取公告列表
	private Map<String, Object> notices;
	public Map<String, Object> getNotices() {
		return notices;
	}
	public void setNotices(Map<String, Object> notices) {
		this.notices = notices;
	}
	public String getList() {
		HttpServletRequest request=ServletActionContext.getRequest();
		int page=Integer.parseInt(request.getParameter("page"));
		int rows=Integer.parseInt(request.getParameter("rows"));
		List<Notice> list=noticeService.getAll();
		List<Notice> list2=noticeService.getAllByLimit(page,rows);
		Map<String, Object> map=new HashMap<>();
		map.put("rows", list2);
		int total=list.size();
		map.put("total", total);
		this.setNotices(map);
		return "notices";
	}
	
	//删除一条记录
	public String deleteOne() {
		noticeService.deleteOne(notice);
		return "backToList";
	}
	
	//到修改页面
	public String toUpdateOne() {
		HttpServletRequest request=ServletActionContext.getRequest();
		int id=notice.getId();
		request.setAttribute("myurl", request.getContextPath()+"/manager/noticeUpdate.jsp?id="+id);
		return "index";
	}
	
	//获取修改的初始信息
	private Notice notice2;
	public Notice getNotice2() {
		return notice2;
	}
	public void setNotice2(Notice notice2) {
		this.notice2 = notice2;
	}
	public String getPrevInfo() {
		Notice notice3 = noticeService.getOne(notice.getId());
		this.setNotice2(notice3);
		return "notice2";
	}
	
	//修改
	public String updateOne() {
		noticeService.updateOne(notice);
		return "backToList";
	}
	
	//获取所有的公告json
	private List<Notice> notices2;
	public List<Notice> getNotices2() {
		return notices2;
	}
	public void setNotices2(List<Notice> notices2) {
		this.notices2 = notices2;
	}
	public String getNoticeList() {
		List<Notice> list = noticeService.getAll();
		this.setNotices2(list);
		return "notices2";
	}
	
}
