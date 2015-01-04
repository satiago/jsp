/**
 * 
 */
package web.shop.dao.product;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import web.shop.dao.DaoSupport;
import web.shop.model.product.ProductCategory;

/**
 * @author yangsatiago
 *
 */
@Repository("productCategoryDao")
public class ProductCategoryDaoImp extends DaoSupport<ProductCategory> implements
		ProductCategoryDao {
}
