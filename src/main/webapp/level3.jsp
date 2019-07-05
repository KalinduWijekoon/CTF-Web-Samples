<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.pen-title {
	padding: 200px 0;
	text-align: center;
	letter-spacing: 2px;
}
.form-module {
	position: relative;
	background: rgba(255, 255, 255, 0.3);
	max-width: 320px;
	width: 100%;
	border-top: 5px solid;
	box-shadow: 0 0 3px rgba(0, 0, 0, 0.1);
	margin: 0 auto;
}
.form-module .form {
	display: none;
	padding: 40px;
}
.form-module .form:nth-child(2) {
	display: block;
}
.form-module h2 {
	margin: 0 0 20px;
	color: #ffffff;
	font-size: 25px;
	font-weight: 400;
	line-height: 1;
}

.form-module input {
	outline: none;
	display: block;
	width: 100%;
	border: 1px solid #d9d9d9;
	margin: 0 0 20px;
	padding: 10px 15px;
	box-sizing: border-box;
	font-wieght: 400;
}

.form-module input:focus {
	border: 1px solid #33b5e5;
	color: #333333;
}

.form-module button {
	cursor: pointer;
	background: #33b5e5;
	width: 100%;
	border: 0;
	padding: 10px 15px;
	color: #ffffff;
}

.form-module button:hover {
	background: #178ab4;
}

.form-module .cta {
	background: #f2f2f2;
	width: 100%;
	padding: 15px 40px;
	box-sizing: border-box;
	color: #666666;
	font-size: 12px;
	text-align: center;
}

.form-module .cta a {
	color: #333333;
	text-decoration: none;
}

.align {
	text-align: center;
}
#myvideo {
        position: fixed;
        right: 0;
        bottom: 0;
        min-width: 100%; 
        min-height: 100%;
}
.content {
        position: fixed;
        bottom: 0;
        color: #f1f1f1;
        width: 100%;
        padding: 20px;
}
</style>
        <title>Bismarck 10</title>
</head>
<body>
    <video autoplay loop id="myvideo">
        <source src="imgz/yourvideo" type="video/mp4">
        Your browser does not support the <code>video</code> tag.
    </video>
    <div class="content">
    <div class="pen-title">
        <div class="module form-module">
            <div class="toggle"></div>
		<div class="form">
                    <h2 class="align"><b>WELCOME Kapitän!</b></h2>
                    <h2 class="align"><b>Level 10</b></h2>
                    <h4 class="align">Press F5 to play ;)</h4>
			<form action="LogonLevel3" method="POST">
                            <input type="text" placeholder="Username" name="username"/>
                            <input type="password" placeholder="Password" name="password"/>
                            <input type="submit" value="Login" />
			</form>
		</div>
	</div
    </div>
    </div>
</body>
</html>
