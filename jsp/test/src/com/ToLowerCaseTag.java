/**
 * 
 */
package com;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * @author yangsatiago
 *
 */
public class ToLowerCaseTag extends BodyTagSupport
{

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		String content = this.getBodyContent().getString();
		try {
			this.pageContext.getOut().println(content.toLowerCase());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
}
