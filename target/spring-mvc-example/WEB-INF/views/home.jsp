<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.<br>and tomorrow is the date ${tomorrow}.</p>

	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
		Nam non tellus pulvinar, pharetra mi vel, blandit tortor.
		Duis sit amet nibh eget dolor hendrerit eleifend quis et velit.
		Nam ultricies lorem magna, sit amet tempus metus luctus quis.
		Cras vestibulum imperdiet pharetra. Morbi eu sem urna.
		Ut cursus ante et tortor vehicula, non porta massa fringilla.
		Sed ornare erat suscipit risus gravida euismod.
		Quisque in accumsan neque, non facilisis ex.
		Maecenas tincidunt velit nec diam aliquam sodales.
		Vestibulum vitae gravida lectus.</p>
	<form action="user" method="post">
		USERNAME:<input type="text" name="userName"   ><br>
		USERID:<input type="text" name="userID"  ><br>
			EMAILID:<input type="email" name="emailID"><br>
		<input type="submit" value="Login">

	</form>
</body>
</html>