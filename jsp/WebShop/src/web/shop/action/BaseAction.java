/**
 * 
 */
package web.shop.action;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import web.shop.dao.product.ProductCategoryDaoImp;
import web.shop.dao.product.ProductDao;
import web.shop.dao.product.ProductDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

import web.shop.dao.product.ProductCategoryDao;

/**
 * @author yangsatiago
 *
 */
//实现RequestAware,SessionAware, ApplicationAware来获取相应的上下文对象，Ioc
//再利用set方法注入变量

public class BaseAction extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware {

	protected Integer id;
	protected Integer[] ids;
	protected int pageNo = 1;
	protected int pageSize = 3;
	
	// Map类型的request
	protected Map<String, Object> request;
	// Map类型的session
	protected Map<String, Object> session;
	// Map类型的application
	protected Map<String, Object> application;
	
	public static final String LIST = "list";
	public static final String EDIT = "edit";
	public static final String ADD = "add";
	public static final String SELECT = "select";
	public static final String QUERY = "query";
	public static final String LEFT = "left";
	public static final String RIGHT = "right";
	public static final String INDEX = "index";
	public static final String MAIN = "main";
	public static final String MANAGER = "manager";
	public static final String TOP = "top";
	public static final String REG = "reg";
	public static final String USER_LOGIN = "userLogin";
	public static final String CUSTOMER_LOGIN = "customerLogin";
	public static final String LOGOUT = "logout";
	
	// 注入Dao
	@Autowired
	protected ProductCategoryDao categoryDao;
	@Autowired
	protected ProductDao productDao;
	
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.ApplicationAware#setApplication(java.util.Map)
	 */
	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.application = arg0;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.RequestAware#setRequest(java.util.Map)
	 */
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
	// 处理方法
	public String index() throws Exception {
		return INDEX;
	}
	public String manager() throws Exception {
		return MANAGER;
	}
	public String main() throws Exception {
		return MAIN;
	}
	public String add() throws Exception {
		return ADD;
	}
	public String select() throws Exception {
		return SELECT;
	}
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String top() throws Exception {
		return TOP;
	}
	public String left() throws Exception {
		return LEFT;
	}
	public String right() throws Exception {
		return RIGHT;
	}
	public String reg() throws Exception{
		return REG;
	}
	public String query() throws Exception{
		return QUERY;
	}
	// getter和settter方法
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
