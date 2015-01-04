/**
 * 
 */
package web.shop.model.product;

import java.io.Serializable;

/**
 * @author yangsatiago
 *
 */
public class UploadFile implements Serializable {
	// 编号
	private Integer id;
	// 文件路径
	private String path;
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
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
