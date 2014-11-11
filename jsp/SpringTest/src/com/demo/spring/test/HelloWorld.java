/**
 * 
 */
package com.demo.spring.test;

/**
 * @author yangsatiago
 *
 */
public class HelloWorld {
	private String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute()
	{
		return "hello" + getMessage();
	}
}
