/**
 * 
 */
package com.demo.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author yangsatiago
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		HelloWorld hello = (HelloWorld) ctx.getBean("HelloWorld");
		System.out.println(hello.execute());
	}

}
