/**
 * 
 */
package web.shop.model.product;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import web.shop.model.product.ProductCategory;
import web.shop.model.product.ProductInfo;

/**
 * @author yangsatiago
 *
 */
public class ProductCategory implements Serializable {
	private Integer id;// 类别编号
	private String name;// 类别名称
	private int level = 1;// 层次
	private Set<ProductCategory> children;// 子产品类别
	private ProductCategory parent;// 父类别
	private Set<ProductInfo> products = new TreeSet<ProductInfo>();// 包含商品
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the children
	 */
	public Set<ProductCategory> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(Set<ProductCategory> children) {
		this.children = children;
	}
	/**
	 * @return the parent
	 */
	public ProductCategory getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(ProductCategory parent) {
		this.parent = parent;
	}
	/**
	 * @return the products
	 */
	public Set<ProductInfo> getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<ProductInfo> products) {
		this.products = products;
	}
	
}
