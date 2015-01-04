/**
 * 
 */
package web.shop.action;



import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import web.shop.model.product.ProductCategory;
import web.shop.model.product.ProductInfo;

import com.opensymphony.xwork2.Action;

/**
 * @author yangsatiago
 *
 */

@Scope("prototype")
@Controller("indexAction")
public class IndexAction extends BaseAction {

	/* (non-Javadoc)
	 * @see web.shop.action.BaseAction#execute()
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// 查询所有类别
		String where = "where parent is null";
		categories = categoryDao.find(-1, -1, where, null).getList();
		// 查询推荐的商品
		product_commend = productDao.findCommend();
		// 查询销量最高的商品
		product_sellCount = productDao.findSellCount();
		// 查询人气高的商品
		product_clickcount = productDao.findClickcount();
		
		return Action.SUCCESS;
	}
	
	// 所有类别
	private List<ProductCategory> categories;
	// 推荐商品
	private List<ProductInfo> product_commend;
	// 销售最好的商品
	private List<ProductInfo> product_sellCount;
	// 人气最高的商品
	private List<ProductInfo> product_clickcount;
	/**
	 * @return the categories
	 */
	public List<ProductCategory> getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<ProductCategory> categories) {
		this.categories = categories;
	}
	/**
	 * @return the product_commend
	 */
	public List<ProductInfo> getProduct_commend() {
		return product_commend;
	}
	/**
	 * @param product_commend the product_commend to set
	 */
	public void setProduct_commend(List<ProductInfo> product_commend) {
		this.product_commend = product_commend;
	}
	/**
	 * @return the product_sellCount
	 */
	public List<ProductInfo> getProduct_sellCount() {
		return product_sellCount;
	}
	/**
	 * @param product_sellCount the product_sellCount to set
	 */
	public void setProduct_sellCount(List<ProductInfo> product_sellCount) {
		this.product_sellCount = product_sellCount;
	}
	/**
	 * @return the product_clickcount
	 */
	public List<ProductInfo> getProduct_clickcount() {
		return product_clickcount;
	}
	/**
	 * @param product_clickcount the product_clickcount to set
	 */
	public void setProduct_clickcount(List<ProductInfo> product_clickcount) {
		this.product_clickcount = product_clickcount;
	}
	
}
