package com.yonghu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yonghu.gongneng.Service;
import com.yonghu.gongnenginter.Serviceinter;
import com.yonghu.user.User;

/**
 * Servlet implementation class Loginservlet1
 */
@WebServlet("/Loginservlet1")
public class Loginservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println(request.getParameter("login"));
		// TODO Auto-generated method stub
		if("0".equals(request.getParameter("login")))
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");		
			//��ȡ��������������ݴ���
			Service us = new Serviceinter();		
			User user = us.nameAndPwd(username, password);
			if(user!=null)
			{	//�ʺ������Ƿ���ȷ		
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				int power = 0;	//Ĭ������ͨ�û�
				String p = request.getParameter("power");
				if("1".equals(p))
				{
					power = 1;
				}
			//�û�����				
				if(power==user.getPower() && user.getPower()==1)
				{
					Service us1 = new Serviceinter();
					List<User> list = us1.findbyall();
					request.setAttribute("list", list);
					request.getRequestDispatcher("/main.jsp").forward(request, response);			
				}
				else if(power==0 && user.getPower() == power)
				{
					//��Ϊ����ͨ�û�������ֱ����ת����ʾ�Լ�ȫ����Ϣ��ҳ�档
					List<User> list = new ArrayList<User>();
					list.add(user);
					request.setAttribute("list", list);
					request.getRequestDispatcher("/main.jsp").forward(request, response);
					
				}
				else if(power == 1 && user.getPower() == 0 )
				{//����ļ����ʵ�ʼ��𲻷���
					String msg = "�㲻�ǹ���Ա��������ѡ����ȷ�ļ���";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				else if(power == 0 && user.getPower() ==1)
				{
					String msg = "�㲻����ְͨԱ��������ѡ����ȷ�ļ���";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}

			}
			else
			{//�ʺ����벻��ȷ
				String msg = "�ʺ����벻ƥ��";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}
}


