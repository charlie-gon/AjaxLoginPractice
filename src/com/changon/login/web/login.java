package com.changon.login.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.login.common.Command;
import com.changon.login.dao.MemberDAO;

public class login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		MemberDAO dao = new MemberDAO();
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String name = dao.loginCheck(userid, passwd);
		String message = "";
		
		if(name == null) {
			message = "아이디 또는 비밀번호가 일치하지 않습니다.";
		}else {
			message = name + "님 환영합니다.";
		}
		
		request.setAttribute("message", message);
		
		String viewPage = "login/loginResult";
		
		return viewPage;
	}

}
