<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alta</title>
</head>

<jsp:useBean id="depart" scope="request" class="control.Departamento"></jsp:useBean>
<jsp:setProperty property="*" name="depart" />

<%
	if (request.getParameter("deptno") != null) {
%>
<jsp:forward page="/Controlador?accion=insertar"></jsp:forward>
<%
	}
%>
<body>
	<div align="center">
		<h2>Entrada</h2>
		<form method="post">
			<p>
				Num departamento: <input name="deptno" required type="number"
					min="1" max="99" />
			</p>
			<p>
				Nombre: <input name="dnombre" required type="text" size="15"
					maxlength="15" />
			</p>
			<p>
				localidad: <input name="loc" required type="text" size="15"
					maxlength="15" />
			</p>
			<input type="submit" name="insertar" value="insertar" />
		</form>
		<a href="index.html"> Inicio</a>
	</div>
</body>
</html>