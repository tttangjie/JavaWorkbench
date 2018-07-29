package com.yonghu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yonghu.DBdemol.DBdemol;
import com.yonghu.DBdemolinter.DBdemolinter;
import com.yonghu.user.User;

/**
 * Servlet implementation class signupsevlet
 */
@WebServlet("/signupsevlet")
public class signupsevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupsevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       String userName = request.getParameter("userName");
	        String userPassword = request.getParameter("userPassword");
	        int userage= Integer.parseInt(request.getParameter("userage"));
	        String userSex = request.getParameter("userSex");
	        String info = request.getParameter("info");
	        int power= Integer.parseInt(request.getParameter("power"));
	        User user = new User();
	        user.setUserName(userName);
	        user.setPassword(userPassword);
	        user.setAge(userage);
	        user.setSex(userSex);
	        user.setInfo(info);
	        // 实例化一个数据库操作对象
	        DBdemol userDao = new DBdemolinter();
	        // 调用增加用户方法
	        userDao.add(user);
	        // 转到登录页面
	        request.getRequestDispatcher("/login.jsp").forward(request,response);
	        
		}
}

