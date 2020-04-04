<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="cstyles.css" />
    <meta name="Description" content="Registration form using html and CSS"/>
</head>
<body>
<div class="date-header-base">
</div>
<div class="date-header">
<div class="date-body">
    <div id="intro1" class="date-body"> Looking for a date? You're not alone!<br>
        Setup your account<br>And choose the one you want to got out with.
    </div>
    <div id="intro2" class="date-body">DateMe.com</div>
    <div id="img2" class="date-body"><img src="world.png" /></div>
    <div id="intro3" class="date-body">No hassle Dating...</div>
    <form method="POST" action="RegisterAcnt" 
    name="myform">
		<div id="form3" class="date-body">
		<input placeholder="Username" type="text" id="namebox" name="UserID" /><br>
        <input placeholder="First Name" type="text" id="namebox" name="Fname" />
        <input placeholder="Last Name" type="text" id="namebox"  name="Lname"/> <br>
        
        <input placeholder="Email" type="text" id="mailbox"  name="Email"/><br>
        <input placeholder="Password" type="password" id="mailbox" name="Pwd" /><br>
        <input type="date" id="namebox"  name="Dob"/><br><br>
        <input type="radio" id="r-b" name="sex" value="male" />Male
        <input type="radio" id="r-b" name="sex" value="female" />Female<br><br>
        <input type="submit" class="button2" value="Create an account" />
        <br>
        </form> 
    </div>
</div>
</body>
</html>