/**
 * 
 */
package com.demo.hibernate.service;

import com.demo.hibernate.beans.User;
import com.demo.hibernate.dao.UserDAO;

/**
 * @author yangsatiago
 *
 */
public class UserService {
	
	public static void main(String[] args)
	{
		UserService service = new UserService();
		UserDAO test = new UserDAO();
		User user = test.getUser("luopan");
		System.out.println("username=" + user.getUsername());
		System.out.println("username=" + user.getPwd());
		System.out.println("username=" + user.getEmail());
		System.out.println("username=" + user.getQq());
		System.out.println("username=" + user.getTel());
		System.out.println("username=" + user.getAvatar());
		System.out.println("username=" + user.getSex());
		System.out.println("username=" + user.getBirthday().toString());
	}
}
