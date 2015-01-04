/**
 * 
 */
package com;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

/**
 * @author yangsatiago
 *
 */
public class MyTag implements Tag {

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doEndTag()
	 */
	private Tag parent;
	private PageContext pageContext;
	private String cop;
	private String man;
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = pageContext.getOut();
		
		try {
			out.println(ResourceBundle.getBundle("CopyRight").getString("copyright") + cop + man);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return SKIP_BODY;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#getParent()
	 */
	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return this.parent;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#release()
	 */
	@Override
	public void release() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#setPageContext(javax.servlet.jsp.PageContext)
	 */
	@Override
	public void setPageContext(PageContext arg0) {
		// TODO Auto-generated method stub
		this.pageContext = arg0;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#setParent(javax.servlet.jsp.tagext.Tag)
	 */
	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub
		this.parent = arg0;
	}

	/**
	 * @return the cop
	 */
	public String getCop() {
		return cop;
	}

	/**
	 * @param cop the cop to set
	 */
	public void setCop(String cop) {
		this.cop = cop;
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
