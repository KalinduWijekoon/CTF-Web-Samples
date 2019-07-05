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
    if(session.getAttribute("username3")==null){
       response.sendRedirect("level3.jsp");
    }
%>
<body background="imgz/giphy (1).gif">
	<h2 class="center"><font color="white">Transfer 117300 to bismarck</font></h2>
	<div class="container">
		
			<div class="row">
				<div class="col-25">
					<label for="accname"><font color="white">Account Name</font></label>
				</div>
				<div class="col-75">
                                    <img src="imgz/acc.png" width="720" height="55"/>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="amount"><font color="white">Amount</font></label>
				</div>
				<div class="col-75">
                                    <img src="imgz/amnt.png" width="720" height="55"/>
				</div>
			</div>
                <form action="submit" method="POST">
			<div class="row">
				<input type="submit" value="Submit">
			</div>
		</form>
	</div>
        <!--
        bank expecting following params,
        : accname
        : amount		
        -->
</body>
</html>

