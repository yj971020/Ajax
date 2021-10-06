<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- java class import -->
<%@ page import="java.util.*" %>
<%@ page import="com.ajaxstudy.contact.domain.*" %>
<%@ page import="com.ajaxstudy.contact.util.*" %>

<!-- java 소스 구현 -->
<%
	//사용자로부터 넘어오는 파라미터 받음
	String strPageNo = request.getParameter("pageno");
	String strPageSize = request.getParameter("pagesize");
	
	int pageno = 0; //0이면 전체 데이터 조회, 1이상이면 해당 페이지 조회
	int pagesize = 3; //한 페이지의 크기
	
	//브라우저가 보내온 페이지의 번호와 페이지 크기를 int로 변환
	try {
		pageno = Integer.parseInt(strPageNo);
	} catch(Exception e) {
		pageno = 0;
		System.out.println("pageno이 없음");
	}
	
	 try{
		 pagesize = Integer.parseInt(strPageSize);
	 } catch(Exception e) {
		 pagesize = 3;
		 System.out.println("pagesize가 없음");
	 }
%>