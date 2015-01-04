/**
 * 
 */
package web.shop.dao.product;

import java.util.List;

import web.shop.model.product.ProductInfo;

import web.shop.dao.BaseDao;

/**
 * @author yangsatiago
 *
 */
public interface ProductDao extends BaseDao<ProductInfo> {
	public List<ProductInfo> findCommend();
	public List<ProductInfo> findClickcount();
	public List<ProductInfo> findSellCount();
}
