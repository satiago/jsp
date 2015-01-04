/**
 * 
 */
package com;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author yangsatiago
 *
 */
public class MultiAttrTag extends SimpleTagSupport {

	private JspFragment body1;
	private JspFragment body2;
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		StringWriter writer1 = new StringWriter();
		StringWriter writer2 = new StringWriter();
		
		body1.invoke(writer1);
		body2.invoke(writer2);
		
		this.getJspContext().getOut().println(writer1.getBuffer().toString() + "<br>");
		this.getJspContext().getOut().println(writer2.getBuffer().toString() + "<br>");
	}
	/**
	 * @return the body1
	 */
	public JspFragment getBody1() {
		return body1;
	}
	/**
	 * @param body1 the body1 to set
	 */
	public void setBody1(JspFragment body1) {
		this.body1 = body1;
	}
	/**
	 * @return the body2
	 */
	public JspFragment getBody2() {
		return body2;
	}
	/**
	 * @param body2 the body2 to set
	 */
	public void setBody2(JspFragment body2) {
		this.body2 = body2;
	}
	
	

}
