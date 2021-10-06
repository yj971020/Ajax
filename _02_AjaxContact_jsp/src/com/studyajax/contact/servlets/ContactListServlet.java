package com.studyajax.contact.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajaxstudy.contact.domain.ContactList;
import com.ajaxstudy.contact.util.Converter;
import com.ajaxstudy.contact.util.SampleDAO;
/**
 * Servlet implementation class ContactUpdateServlet
 */
//list.do : servlet 
@WebServlet("/list")
public class ContactListServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strPageno = request.getParameter("pageno");
		String strPagesize = request.getParameter("pagesize");
		int pageno = 0;		// 0�̸� ��ü ������ ��ȸ, 1�̻��̸� �ش� ������ ��ȸ
		int pagesize = 3;	// �� �������� ũ��
		// 1) �������� ������ ������ ��ȣ�� ������ ũ�⸦ int�� ��ȯ
		try{
			pageno = Integer.parseInt(strPageno);
		}catch(Exception e){
			pageno = 0;
			System.out.println("pageno �� ����");
		}
		try{
			pagesize = Integer.parseInt(strPagesize);
		}catch(Exception e){
			pagesize = 3;
			System.out.println("pagesize �� ����");
		}
		
		ContactList contactList = null;
		if(pageno==0)	// ��ü �ּҷ� ������
			contactList = SampleDAO.getContacts();
		else			// Ư�� ������ ������
			contactList = SampleDAO.getContacts(pageno, pagesize);
		// java ��ü -> json���ڿ��� ��ȯ
		String json = Converter.convertToJson(contactList);
		
		PrintWriter writer = response.getWriter();
		writer.println(json);
	}

}
