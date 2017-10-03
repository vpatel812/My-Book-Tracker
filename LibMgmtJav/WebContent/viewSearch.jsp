<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<link rel="stylesheet" type="text/css" href="bookstore.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<br><br><br><br><br><br>
<table width="700px" align="center" 
style="border:1px solid #FFFFFF;">
<tr>
<td colspan=8 align="center" 
style="background-color:ffeeff">
<b><font color="white">Book Records</font><br></b></td>
</tr>

<tr style="background-color:efefef;">

<td><b><font color="white">ISBN</font></b></td>
<td><b><font color="white">Title</font></b></td>
<td><b><font color="white">Author</font></b></td>
<td><b><font color="white">Publication Date</font></b></td>
<td><b><font color="white">Genre</font></b></td>
<td><b><font color="white">Price</font></b></td>
</tr>
<%
int count=0;
String color = "#F9EBB3";


if(request.getAttribute("bookList")!=null)
{
ArrayList al = (ArrayList)request.getAttribute("bookList");
Iterator itr = al.iterator();


while(itr.hasNext()){

if((count%2)==0){ 
color = "#eeffee"; 
}
else{
color = "#F9EBB3";
}
count++;
ArrayList bookList = (ArrayList)itr.next();
%>
<tr style="background-color:<%=color%>;">
<td><%=bookList.get(1)%></td>
<td><%=bookList.get(2)%></td>
<td><%=bookList.get(6)%></td>
<td><%=bookList.get(4)%></td>
<td><%=bookList.get(9)%></td>
<td><%=bookList.get(5)%></td>
</tr>
<%
}
}
%> 
<%
if(count==0){
%>
<tr>
<td colspan=8 align="center" 
style="background-color:eeffee"><b>No Record</b></td>
</tr>
<%
}
%>
</table>
</body>
</html>