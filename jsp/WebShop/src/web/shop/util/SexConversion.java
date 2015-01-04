/**
 * 
 */
package web.shop.util;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import web.shop.model.Sex;

/**
 * @author yangsatiago
 *
 */
public class SexConversion extends StrutsTypeConverter {

	/* (non-Javadoc)
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		Sex sexs[] = Sex.values();
		for (Sex sex : sexs) {
			if(sex.getName().equals(arg1[0])){
				return sex;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		Sex sex = (Sex) arg1;
		return sex.getName();
	}

}
