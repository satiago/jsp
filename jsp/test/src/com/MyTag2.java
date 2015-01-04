/**
 * 
 */
package com;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author yangsatiago
 *
 */
public class MyTag2 extends SimpleTagSupport {

	private String title;
	private String man;
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		this.getJspContext().getOut().write("this is jsp 2.x tag" + title + man);
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the man
	 */
	public String getMan() {
		return man;
	}
	/**
	 * @param man the man to set
	 */
	public void setMan(String man) {
		this.man = man;
	}
}
