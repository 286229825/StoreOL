package action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Goods;
import entity.GoodsType;
import service.GoodsService;
import service.GoodsTypeService;

public class GoodsManageAction extends ActionSupport implements ModelDriven<Goods>{
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
	private GoodsTypeService goodsTypeService;
	public void setGoodsTypeService(GoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}
	private Goods goods=new Goods();
	public Goods getModel() {
		return goods;
	}
	
	//到添加商品的页面
	public String toAddGoods() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/manager/goodsAdd.jsp");
		return "index";
	}
	
	//添加商品
	private File upload;
	private String uploadFileName;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String addGoods() throws IOException {
		if(upload != null) {
			File serverFile=new File("D:\\workspace\\StoreOL\\WebContent\\image"+"/"+uploadFileName);
			org.apache.commons.io.FileUtils.copyFile(upload, serverFile);
		}
		goods.setPictrue(uploadFileName);
		float salePrice=goods.getSalePrice();
		if(salePrice == 0) {
			goods.setIfSale(2);
		}else {
			goods.setIfSale(1);
		}
		Timestamp timestamp=new Timestamp(new Date().getTime());
		goods.setCreatTime(timestamp);
		goods.setBuyTimes(0);
		goodsService.addOne(goods);
		return "backToAdd";
	}
	
	//获取所有的商品类别
	private List<GoodsType> allGoodsTypes;
	public List<GoodsType> getAllGoodsTypes() {
		return allGoodsTypes;
	}
	public void setAllGoodsTypes(List<GoodsType> allGoodsTypes) {
		this.allGoodsTypes = allGoodsTypes;
	}
	public String getAllTypes() {
		List<GoodsType> list = goodsTypeService.getAll();
		this.setAllGoodsTypes(list);
		return "allGoodsTypes";
	}
	
	//到商品列表页面
	public String toGoodsList() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/manager/goodsList.jsp");
		return "index";
	}
	
	//获取所有的商品并分页
	private Map<String, Object> allGoods;
	public Map<String, Object> getAllGoods() {
		return allGoods;
	}
	public void setAllGoods(Map<String, Object> allGoods) {
		this.allGoods = allGoods;
	}
	public String getGoodsList() {
		HttpServletRequest request=ServletActionContext.getRequest();
		int page=Integer.parseInt(request.getParameter("page"));
		int rows=Integer.parseInt(request.getParameter("rows"));
		List<Goods> list = goodsService.getAll();
		List<Goods> list2=goodsService.getAllByDataGrid(page,rows);
		int total=list.size();
		Map<String, Object> map=new LinkedHashMap<>();
		map.put("rows", list2);
		map.put("total", total);
		this.setAllGoods(map);
		return "allGoods";
	}
	
	//删除一条记录
	public String deleteOne() throws IOException {
		int id = goods.getId();
		Goods goods=goodsService.getOne(id);
		String pictrue=goods.getPictrue();
		File file=new File("D:\\workspace\\StoreOL\\WebContent\\image"+"/"+pictrue);
		file.delete();
		goodsService.deleteOne(goods);
		return "backToGoodsList";
	}
	
	//到修改页面
	public String toUpdateOne() {
		int id=goods.getId();
		Goods goods4 = goodsService.getOne(id);
		int typeid=goods4.getGoodsType().getId();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/manager/goodsUpdate.jsp?id="+id+"&typeid="+typeid);
		return "index";
	}
	
	//获取修改的原始信息
	private Goods goods2;
	public Goods getGoods2() {
		return goods2;
	}
	public void setGoods2(Goods goods2) {
		this.goods2 = goods2;
	}
	public String getPrevInfo() {
		Goods goods3 = goodsService.getOne(goods.getId());
		this.setGoods2(goods3);
		return "goods2";
	}
	
	//修改一条记录
	public String updateGoods() throws IOException {
		int id=goods.getId();
		Goods goods5=goodsService.getOne(id);
		if(upload != null) {
			String pictrue=goods5.getPictrue();
			File file=new File("D:\\workspace\\StoreOL\\WebContent\\image"+"/"+pictrue);
			file.delete();
			File file2=new File("D:\\workspace\\StoreOL\\WebContent\\image"+"/"+uploadFileName);
			org.apache.commons.io.FileUtils.copyFile(upload, file2);
			goods5.setPictrue(uploadFileName);
		}
		if(goods.getSalePrice() == 0) {
			goods5.setIfSale(2);
		}else {
			goods5.setIfSale(1);
		}
		goods5.setName(goods.getName());
		goods5.setGoodFrom(goods.getGoodFrom());
		goods5.setIntroduce(goods.getIntroduce());
		goods5.setNowPrice(goods.getNowPrice());
		goods5.setSalePrice(goods.getSalePrice());
		goodsService.updateOne(goods5);
		return "backToGoodsList";
	}
	
	//到查询页面
	public String toQueryList() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/manager/goodsQuery.jsp");
		return "index";
	}
	
	//查询
	private Map<String, Object> limitgoods;
	public Map<String, Object> getLimitgoods() {
		return limitgoods;
	}
	public void setLimitgoods(Map<String, Object> limitgoods) {
		this.limitgoods = limitgoods;
	}
	public String queryGoodsList() throws ParseException {
		HttpServletRequest request=ServletActionContext.getRequest();
		int page=Integer.parseInt(request.getParameter("page"));
		int rows=Integer.parseInt(request.getParameter("rows"));
		String goodsname = request.getParameter("goodsname");
		String goodsfrom = request.getParameter("goodsfrom");
		String goodstypeid = request.getParameter("goodstypeid");
		String price1 = request.getParameter("price1");
		String price2 = request.getParameter("price2");
		String begindate = request.getParameter("begindate");
		String lastdate = request.getParameter("lastdate");
		List<Goods> list = goodsService.queryGoods(goodsname,goodsfrom,goodstypeid,price1,price2,begindate,lastdate);
		List<Goods> list2 = goodsService.queryGoodsByLimit(page,rows,goodsname,goodsfrom,goodstypeid,price1,price2,begindate,lastdate);
		int total=list.size();
		Map<String, Object> map=new LinkedHashMap<>();
		map.put("rows", list2);
		map.put("total", total);
		this.setLimitgoods(map);
		return "limitgoods";
	}
	
}
