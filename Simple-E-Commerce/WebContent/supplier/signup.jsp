<?xml version="1.0" encoding="ISO-8859-9" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-9" />
<link rel="stylesheet" href="css/style.css"/>
<title>Sign Up - Simple E-commerce</title>
</head>
<body>

<%
//mesaj bölümü başlangıç
boolean sonucVarmi=false;
boolean olumlumu=false;
String mesaj="Store ";
if(request.getParameter("sonuc")!=null)
{	sonucVarmi=true;
	String sonuc=request.getParameter("sonuc");
	if(sonuc.equals("1")) //yeni kayit başarılı
		{mesaj+=" Ekleme İşlemi Başarıyla Gerçekleşti";
		olumlumu=true;}
	else if(sonuc.equals("0"))//yeni kayit başarısız
		mesaj+="Ekleme İşlemi Başarısız";
}

%>
<%if(sonucVarmi && olumlumu) { %>
<div class="alert-success">
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
<%=mesaj %>
</div>
<%}else if(sonucVarmi && !olumlumu) { %>
<div class="alert-unsuccess">
 <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
<%=mesaj %>
</div>
<%}//mesaj Bölümü son %>


<div id="form-main">
  <div id="form-div">
    <form class="form" id="form1" action="control/signupControl.jsp" method="post">
      
      <p>
        <input name="storeName" type="text" class="feedback-input" placeholder="Store Name"  />
      </p>
      <p >
        <input name="taxNumber" type="text" class="feedback-input" placeholder="Tax Number"  />
      </p>
      <p >
        <input name="address" type="text" class="feedback-input" placeholder="Adress"  />
      </p>
      <p >
        <input name="phone" type="text" class="feedback-input" placeholder="Phone"  />
      </p>
      <div class="submit">
        <input type="submit" value="Sign Up" id="button-blue"/>
        <div class="ease"></div>
      </div>
    </form>
  </div>
  </div>
</body>
</html>