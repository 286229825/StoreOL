package action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import entity.Goods;
import service.GoodsService;

public class GoodsAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private GoodsService goodsService;
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	private Map<String, Object> goodsList;
	public Map<String, Object> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(Map<String, Object> goodsList) {
		this.goodsList = goodsList;
	}
	public String getAllByLimit() throws ParseException {
		HttpServletRequest request=ServletActionContext.getRequest();
		int page=Integer.parseInt(request.getParameter("page"));
		String ifsale = request.getParameter("ifsale");
		String buyTimes=request.getParameter("buytimes");
		String typeId=request.getParameter("typeId");
		String ifNew=request.getParameter("ifNew");
		List<Goods> list = null;
		List<Goods> list2=null;
		if(ifsale != null) {
			list = goodsService.getAllBySale(ifsale);
			list2=goodsService.getByLimitBySale(page,ifsale);
		}else if(buyTimes != null) {
			list = goodsService.getAllBySale(buyTimes);
			list2=goodsService.getByLimitBySale(page,buyTimes);
		}else if(typeId != null){
			list = goodsService.getAllBySale(typeId);
			list2=goodsService.getByLimitBySale(page,typeId);
		}else if(ifNew != null){
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			String dateStr=dateFormat.format(date);
			long time=dateFormat.parse(dateStr).getTime();
			long days=10;
			long time2=time-days*24*60*60*1000;
			Timestamp date2=new Timestamp(time2); 
			list = goodsService.getAllByDate(date2);
			list2=goodsService.getByLimitByDate(page,date2);
		}else {
			list = goodsService.getAll();
			list2=goodsService.getByLimit(page);
		}
		
		Map<String, Object> map=new HashMap<String, Object>();
		Integer total=list.size();
		Integer totalPage=null;
		if(total % 8 != 0) {
			totalPage=total/8+1;
		}else {
			totalPage=total/8;
		}
		map.put("totalPage", totalPage);
		map.put("rows", list2);
		this.setGoodsList(map);
		return "goodsList";
	}
	
	//newGoods
	//到新品上架页面
	public String toNewGoods() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/newGoods/newGoods.jsp?page=1");
		return "index";
	}
	public String toNextPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		int page2=Integer.parseInt(page);
		page2=page2+1;
		request.setAttribute("myurl", request.getContextPath()+"/newGoods/newGoods.jsp?page="+page2);
		return "index";
	}
	public String toPrevPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		int page2=Integer.parseInt(page);
		page2=page2-1;
		request.setAttribute("myurl", request.getContextPath()+"/newGoods/newGoods.jsp?page="+page2);
		return "index";
	}
	public String toWhichPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		request.setAttribute("myurl", request.getContextPath()+"/newGoods/newGoods.jsp?page="+page);
		return "index";
	}
	
	//saleGoods
	public String toSalePage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/saleGoods/saleGoods.jsp?page=1");
		return "index";
	}
	public String toNextSalePage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		int page2=Integer.parseInt(page);
		page2=page2+1;
		request.setAttribute("myurl", request.getContextPath()+"/saleGoods/saleGoods.jsp?page="+page2);
		return "index";
	}
	public String toPrevSalePage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		int page2=Integer.parseInt(page);
		page2=page2-1;
		request.setAttribute("myurl", request.getContextPath()+"/saleGoods/saleGoods.jsp?page="+page2);
		return "index";
	}
	public String toWhichSalePage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		request.setAttribute("myurl", request.getContextPath()+"/saleGoods/saleGoods.jsp?page="+page);
		return "index";
	}
	
	//rankGoods
	public String toRankPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/saleRank/saleRank.jsp?page=1");
		return "index";
	}
	public String toNextRankPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		int page2=Integer.parseInt(page);
		page2=page2+1;
		request.setAttribute("myurl", request.getContextPath()+"/saleRank/saleRank.jsp?page="+page2);
		return "index";
	}
	public String toPrevRankPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		int page2=Integer.parseInt(page);
		page2=page2-1;
		request.setAttribute("myurl", request.getContextPath()+"/saleRank/saleRank.jsp?page="+page2);
		return "index";
	}
	public String toWhichRankPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		request.setAttribute("myurl", request.getContextPath()+"/saleRank/saleRank.jsp?page="+page);
		return "index";
	}
	
	//goodsType
	public String toTypePage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String typeId = request.getParameter("typeId");
		request.setAttribute("myurl", request.getContextPath()+"/goodsType/goodsType.jsp?page=1&typeId="+typeId);
		return "index";
	}
	public String toNextTypePage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		int page2=Integer.parseInt(page);
		page2=page2+1;
		request.setAttribute("myurl", request.getContextPath()+"/goodsType/goodsType.jsp?page="+page2);
		return "index";
	}
	
	public String toPrevTypePage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		int page2=Integer.parseInt(page);
		page2=page2-1;
		request.setAttribute("myurl", request.getContextPath()+"/goodsType/goodsType.jsp?page="+page2);
		return "index";
	}
	public String toWhichTypePage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		request.setAttribute("myurl", request.getContextPath()+"/goodsType/goodsType.jsp?page="+page);
		return "index";
	}
	
	//allGoods
	public String toAllGoodsPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/indexGoods/allGoods.jsp?page=1");
		return "index";
	}
	public String toNextAllGoodsPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		int page2=Integer.parseInt(page);
		page2=page2+1;
		request.setAttribute("myurl", request.getContextPath()+"/indexGoods/allGoods.jsp?page="+page2);
		return "index";
	}
	
	public String toPrevAllGoodsPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		int page2=Integer.parseInt(page);
		page2=page2-1;
		request.setAttribute("myurl", request.getContextPath()+"/indexGoods/allGoods.jsp?page="+page2);
		return "index";
	}
	public String toWhichAllGoodsPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String page = request.getParameter("page");
		request.setAttribute("myurl", request.getContextPath()+"/indexGoods/allGoods.jsp?page="+page);
		return "index";
	}
}
