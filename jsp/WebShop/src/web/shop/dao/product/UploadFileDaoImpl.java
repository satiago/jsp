/**
 * 
 */
package web.shop.dao.product;

import org.springframework.stereotype.Repository;

import web.shop.dao.DaoSupport;
import web.shop.model.product.UploadFile;

/**
 * @author yangsatiago
 *
 */
@Repository("uploadFileDao")
public class UploadFileDaoImpl extends DaoSupport<UploadFile> implements UploadFileDao {

}
