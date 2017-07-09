/**
 * 
 */
package com.cn.pmqin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.pmqin.imp.UserServiceImp;
import com.cn.pmqin.service.IUserService;


/** 
* @author : pmqin
* @date   : 2016年1月22日 上午10:50:17 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserService userService=new UserServiceImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<com.cn.pmqin.domain.User> lstUsers =userService.getAllUser();
        req.setAttribute("lstUsers", lstUsers);
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
