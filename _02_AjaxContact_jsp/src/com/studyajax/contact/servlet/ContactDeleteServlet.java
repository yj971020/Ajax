package com.studyajax.contact.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajaxstudy.contact.domain.Contact;
import com.ajaxstudy.contact.util.Converter;
import com.ajaxstudy.contact.util.SampleDAO;
import com.ajaxstudy.contact.domain.Result;
/**
 * Servlet implementation class ContactUpdateServlet
 */
@WebServlet("/delete.do")
public class ContactDeleteServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Get ������� �������� status�� message����
		Result result = new Result("fail", "POST�޼ҵ常 �����մϴ�.");
		//result ��ü�� json ���ڿ��� ��ȯ
		String json = Converter.convertToJson(result);
		//��ȯ�� json ���ڿ� ȭ�鿡 ǥ��
		PrintWriter writer = response.getWriter();
		writer.println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		request.setCharacterEncoding("UTF-8");		
		String status = "ok";
		String message = "";
		
		boolean isDel = false;
		long no = 0;
		
		try{
			//POST ������� ���۵� �Ķ���͸� longŸ������ ����ȯ
			no = Long.parseLong(request.getParameter("no"));
			isDel = true;
		} catch(Exception e) {
			isDel = false;
			status = "fail";
			message = "��ȣ�� ���ڷ� ������ �� �����ϴ�.";
		}
		
		if(isDel) {
			SampleDAO.deleteContact(no);
			status = "ok";
			message = "�Ϸù�ȣ " + no + "�� �����Ͱ� �����Ǿ����ϴ�.";
		}
		
		//JAVA ��ü -> json ��ü�� ��ȯ
		Result result = new Result(status, message);
		String json = Converter.convertToJson(result);
		
		//ȭ�鿡 ǥ��
		PrintWriter writer  = response.getWriter();
		writer.println(json);
	}

}