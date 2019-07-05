<%-- 
    Document   : level3
    Created on : Jun 20, 2019, 11:09:57 PM
    Author     : Kali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <style>
input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
}
input[type=password], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
}
label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 0px;
	
	padding: 20px;
	margin-left: 10%;
	margin-right: 25%;
}

.col-25 {
	float: left;
	width: 25%;
	margin-top: 10px;
}

.col-75 {
	float: left;
	width: 75%;
	margin-top: 6px;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}

.center {
	text-align: center;
}

@media screen and (max-width: 600px) {
	.col-25, .col-75, input[type=submit] {
		width: 100%;
		margin-top: 0;
	}
}
</style>
        <title>Bismarck 08</title>
    </head>
    <%
    if(session.getAttribute("username")==null){
        response.sendRedirect("level1.jsp");
    }
    %>
<body background="imgz/giphy (1).gif">
    <div class="container">
		<form action="submit2" method="POST">
			<div class="row">
				<div class="col-25">
                                    <label for="uname"><font color="white"> Username </font></label>
				</div>
				<div class="col-75">
					<input type="text" name="username" placeholder="Username">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pw"><font color="white">Password</font></label>
				</div>
				<div class="col-75">
					<input type="password" name="password" placeholder="Password">
				</div>
			</div>

			<div class="row">
				<input type="submit" value="Submit">
			</div>
		</form>
    </div>
    
    <!--
    username = HashPass(get("username"));
    password = HashPass(get("password"));
        if(username.equals("99114FABD06D2C83389C6145A0386A59")&&password.equals("99F8546943B5A5E128EC275018698F2C")){
            [("FLAG")];
            [("someusername")];
    -->
</body>
    
</html>
