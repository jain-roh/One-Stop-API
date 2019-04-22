<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="org.json.simple.JSONObject" %>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Add Api</title>


</head>

<body id="page-top">

  <!-- Page Wrapper -->
 <%
 JSONObject obj=new JSONObject();
 obj.put("Result","success");
 out.print(obj.toString());
 out.flush();
 %>
  
</body>

</html>
