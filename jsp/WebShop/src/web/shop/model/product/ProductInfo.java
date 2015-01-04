/**
 * 
 */
package web.shop.model.product;

import java.io.Serializable;
import java.util.Date;

import web.shop.model.Sex;


/**
 * @author yangsatiago
 *
 */
public class ProductInfo implements Serializable {

	private Integer id;// 商品编号
	private String name;// 商品名称
	private String description;// 商品说明
	private Date createTime = new Date();// 上架时间
	private Float baseprice;// 商品采购价格
	private Float marketprice;// 现在市场价格
	private Float sellprice;// 商城销售价格
	private Sex sexrequest;// 所属性别
	private Boolean commend = false;// 是否是推荐商品（默认值为false）
	private Integer clickcount = 1;// 访问量（统计受欢迎的程度）
	private Integer sellCount = 0;// 销售数量（统计热销商品）
	private ProductCategory category;// 所属类别
	private UploadFile uploadFile;// 上传文件
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the baseprice
	 */
	public Float getBaseprice() {
		return baseprice;
	}
	/**
	 * @param baseprice the baseprice to set
	 */
	public void setBaseprice(Float baseprice) {
		this.baseprice = baseprice;
	}
	/**
	 * @return the marketprice
	 */
	public Float getMarketprice() {
		return marketprice;
	}
	/**
	 * @param marketprice the marketprice to set
	 */
	public void setMarketprice(Float marketprice) {
		this.marketprice = marketprice;
	}
	/**
	 * @return the sellprice
	 */
	public Float getSellprice() {
		return sellprice;
	}
	/**
	 * @param sellprice the sellprice to set
	 */
	public void setSellprice(Float sellprice) {
		this.sellprice = sellprice;
	}
	/**
	 * @return the sexrequest
	 */
	public Sex getSexrequest() {
		return sexrequest;
	}
	/**
	 * @param sexrequest the sexrequest to set
	 */
	public void setSexrequest(Sex sexrequest) {
		this.sexrequest = sexrequest;
	}
	/**
	 * @return the commend
	 */
	public Boolean getCommend() {
		return commend;
	}
	/**
	 * @param commend the commend to set
	 */
	public void setCommend(Boolean commend) {
		this.commend = commend;
	}
	/**
	 * @return the clickcount
	 */
	public Integer getClickcount() {
		return clickcount;
	}
	/**
	 * @param clickcount the clickcount to set
	 */
	public void setClickcount(Integer clickcount) {
		this.clickcount = clickcount;
	}
	/**
	 * @return the sellCount
	 */
	public Integer getSellCount() {
		return sellCount;
	}
	/**
	 * @param sellCount the sellCount to set
	 */
	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}
	/**
	 * @return the category
	 */
	public ProductCategory getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	/**
	 * @return the uploadFile
	 */
	public UploadFile getUploadFile() {
		return uploadFile;
	}
	/**
	 * @param uploadFile the uploadFile to set
	 */
	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
}
