/**
 * 
 */
package web.shop.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangsatiago
 *
 */
public enum Sex {
	BOY{
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "男";
		}
	},
	GIRL{
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "女";
		}
	},
	ALL{
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "不限";
		}
	};
	/**
	 * 获取名称的抽象方法
	 * @return 名称
	 */
	public abstract String getName();
	
	public static List<String> getValues(){
		List<String> list = new ArrayList<String>();
		for(Sex sex : Sex.values())
		{
			list.add(sex.getName());
		}
		return list;
	}
}

