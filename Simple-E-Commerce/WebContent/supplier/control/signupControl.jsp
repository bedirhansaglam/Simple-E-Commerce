<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ page import="java.util.Date" %>
<%@page import="java.sql.ResultSet"%>
<%
request.setCharacterEncoding("ISO-8859-9");
%>
<!DOCTYPE html>
<jsp:useBean id="storeDao" class="com.ecommerce.dao.StoreDAO"></jsp:useBean>
<jsp:useBean id="store" class="com.ecommerce.object.Store"></jsp:useBean>
<jsp:setProperty property="*" name="store" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-9" />

<%out.println(store.getStoreName()); %>
<title> Türkçe Karakter Sorunu</title>
</head>
<body>
<%

String logoUrl="default.png";
store.setLogoUrl(logoUrl);

if(storeDao.createStore(store)) out.print("basarili");//response.sendRedirect("../signup.jsp?sonuc=1");
else response.sendRedirect("../signup.jsp?sonuc=0");

%>

</body>
</html>
