<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav
	class="navbar navbar-expand-lg navbar-dark ftco_navbar ftco-navbar-light site-navbar-target"
	id="ftco-navbar">
	<div class="container">
		<h2 class="heading">
			<a href="/Index/Main">Wandering JUN</a>
		</h2>
		<button class="navbar-toggler js-fh5co-nav-toggle fh5co-nav-toggle"
			type="button" data-toggle="collapse" data-target="#ftco-nav"
			aria-controls="ftco-nav" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="oi oi-menu"></span> Menu
		</button>

		<div class="collapse navbar-collapse" id="ftco-nav">
			<ul class="navbar-nav nav ml-auto">
				<li class="nav-item"><a href="#home-section" class="nav-link"><span>Home</span></a></li>
				<li class="nav-item"><a href="#about-section" class="nav-link"><span>About</span></a></li>
				<li class="nav-item"><a href="#resume-section" class="nav-link"><span>Resume</span></a></li>
				<li class="nav-item"><a href="#services-section"
					class="nav-link"><span>Services</span></a></li>
				<li class="nav-item"><a href="#projects-section"
					class="nav-link"><span>Projects</span></a></li>
				<li class="nav-item"><a href="#blog-section" class="nav-link"><span>My
							Blog</span></a></li>
				<li class="nav-item"><a href="#contact-section"
					class="nav-link"><span>Contact</span></a></li>
				<li class="nav-item"><a id="navLoginBtn" href="#" class="nav-link"
					onclick="loginDivBtn()"><span>Login</span></a></li>
			</ul>
		</div>
	</div>
</nav>






<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

/* Button used to open the contact form - fixed at the bottom of the page */
.open-button {
	background-color: #555;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	opacity: 0.8;
	position: fixed;
	bottom: 23px;
	right: 28px;
	width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
	display: none;
	position: fixed;
	bottom: 0;
	right: 15px;
	border: 3px solid #f1f1f1;
	z-index: 9;
}

/* Add styles to the form container */
.form-container {
	max-width: 300px;
	padding: 10px;
	background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	border: none;
	background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus
	{
	background-color: #ddd;
	outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	margin-bottom: 10px;
	opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
	background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
	opacity: 1;
}
</style>

<!-- <button class="open-button" onclick="openForm()">Open Form</button> -->

<div class="form-popup" id="myForm">
	<form id="loginForm" class="form-container">
		<h1>Login</h1>
		<label for="email"><b>User ID</b></label> <input type="text" placeholder="Enter User ID" name="userID" required> 
		<label for="psw"><b>Password</b></label> <input type="password" placeholder="Enter Password" name="userPW" required>
		<button id="loginSubmit" type="button" class="btn">Login</button>
		<button type="button" class="btn cancel" onclick="loginDivBtn()">Close</button>
	</form>
</div>
<script>
	function loginDivBtn() {
		var a = document.getElementById("myForm").style.display
		if(a=='' || a=='none') {
			document.getElementById("myForm").style.display = "block";
// 			document.getElementById("navLoginBtn").childNodes[0].innerHTML = 'Logout'
		} else if(a=='block') {
			document.getElementById("myForm").style.display = "none";
// 			document.getElementById("navLoginBtn").childNodes[0].innerHTML = 'hoho'
		}
	}
	
	$(function() {
		$("#loginSubmit").on("click", function() {
			var query = $("#loginForm").serialize()
			$.ajax({
				url : "/Index/Member/LoginJSON?"+query,
				type : "POST",
				success : function(data) {
					if(data.jsonObject.returnCode == 1) {
						console.log("login success")
					} else {
						console.log("login failed")
					}
				}
			})
		})
	})
</script>