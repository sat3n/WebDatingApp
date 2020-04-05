<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>This is the user home page</title>
</head>
<body>
<h1>This is your Homepage</h1>
<p>This is where user details will be displayed<p>
<div class="date-body-footer">
<!--     <div id="date-body-footer-base" class="date-body-footer"> WebAppDev(EE417) | Assignment- Online Dating System <br><hr> -->
<!--       www.DateMe.com &nbsp;&nbsp; Satender Kundu | 19211628</div> -->

<c:forEach items="${UserList}" var="user">
						<tr>
							<td style="font-family: cursive;" align="center">${user.FIRST_NAME}</td>
<%-- 							<td style="font-family: cursive;" align="center">${user.price}</td> --%>
<%-- 							<td style="font-family: cursive;" align="center">${user.currency}</td> --%>
<!-- 							<td style="font-family: cursive;" align="center"><input -->
<!-- 								type="submit" id="button" value="Remove"></td> -->
<!-- 							<td> <input type="hidden" name="itemid" value=${menu.itemid}></td> -->
							<%-- 							<td><img alt="${menu.itemName}" --%>
							<%-- 								src="images/${menu.itemid }.jpg " width="400" height="400"> --%>
							<!-- 								<input type="submit" value="add"></td> -->
							<!-- 							<td><input type="submit"></td> -->
							<%-- 							<td>${menu.price}</td> --%>
							<%-- 							<td>${menu.currency}</td> --%>
						</tr>
					</c:forEach>
</div>
</body>
</html>