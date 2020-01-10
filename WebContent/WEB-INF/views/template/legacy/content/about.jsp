<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<section class="hero-wrap js-fullheight">
	<div class="overlay"></div>
	<div class="container">
		<div
			class="row no-gutters slider-text js-fullheight justify-content-center align-items-center">
			<div class="col-lg-8 col-md-6 ftco-animate d-flex align-items-center">
				<div class="text text-center">
					<span class="subheading">Hey! Wandering world </span>
					<h1>Young-Jun CHAE</h1>
<!-- 					<h1>&nbsp;&nbsp;채&nbsp;&nbsp;&nbsp;&nbsp;영&nbsp;&nbsp;&nbsp;&nbsp;준 </h1> -->
<!-- 					<h1>&nbsp;&nbsp;蔡&nbsp;&nbsp;&nbsp;&nbsp;榮&nbsp;&nbsp;&nbsp;&nbsp;俊</h1> -->
				</div>
			</div>
			<div class="col-lg-8 col-md-6 ftco-animate d-flex align-items-center">
				<div class="text text-center">
					<span class="subheading">message properties test</span>
					<span class="subheading"><spring:message code="site.test"/></span>
				</div>
				<div class="text text-center">
					<span class="subheading">file upload test</span>
					<form action="/Index/Content/WriteJSON/Test" id="fileUploadForm" name="fileUploadForm" enctype="multipart/form-data">
						<input type="file" id="fileUpload1" name="fileUpload">
						<input type="file" id="fileUpload2" name="fileUpload">
						<input type="submit" name="submitBtn" value="전송">
					</form>
				</div>
			</div>
			<div class="col-lg-8 col-md-6 ftco-animate d-flex align-items-center">
			</div>
		</div>
	</div>
	</div>
<!-- 	<div class="mouse"> -->
<!-- 		<a href="#" class="mouse-icon"> -->
<!-- 			<div class="mouse-wheel"> -->
<!-- 				<span class="ion-ios-arrow-round-down"></span> -->
<!-- 			</div> -->
<!-- 		</a> -->
<!-- 	</div> -->
</section>
<section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb"
	id="about-section">
	<div class="container">
		<div class="row d-flex no-gutters">
			<div class="col-md-6 col-lg-6 d-flex">
				<div class="img-about img d-flex align-items-stretch">
					<div class="overlay"></div>
<!-- 					<div class="img d-flex align-self-stretch align-items-center" -->
<!-- 						style="background-image: url(/resources/images/about.jpg);"> -->
<!-- 					</div> -->
				</div>
			</div>
			<div class="col-md-6 col-lg-6 pl-md-5 py-5">
				<div class="row justify-content-start pb-3">
					<div class="col-md-12 heading-section ftco-animate">
						<h1 class="big">About</h1>
						<h2 class="mb-4">About Me</h2>
						<p>I am Jun who strives and works to become a Fullstack developer</p>
						<ul class="about-info mt-4 px-md-0 px-2">
							<li class="d-flex"><span>Name:</span> <span>CHAE Young-Jun (채영준)</span></li>
							<li class="d-flex"><span>Date of birth:</span> <span>August 27, 1992</span></li>
							<li class="d-flex"><span>Location:</span> <span>Taiwan</span></li>
							<li class="d-flex"><span>Email:</span> <span>chaeyjs827@gmail.com</span></li>
							<li class="d-flex"><span>Phone: </span> <span>(+886)917099095 / (+82)1058010403</span></li>
						</ul>
					</div>
				</div>
				<div class="counter-wrap ftco-animate d-flex mt-md-3">
					<div class="text">
						<p class="mb-4">
							<span class="number" data-number="120">0</span> <span>Project
								complete</span>
						</p>
						<p>
							<a href="#" class="btn btn-primary py-3 px-3">Download CV</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script>

    
	$(function() {
		function validateFile(fileObj) {
	    	var extension = fileObj.name.toLowerCase().substring(fileObj.name.lastIndexOf('.') + 1);
	    	var allowExt = ['jpg', 'gif', 'png', 'txt', 'log', 'docx', 'doc', 'pdf'];
	    	
	    	if (fileObj.size > 3145728) {	// CHECK FILE SIZE
	    		alert('請檢查文件大小（3MB）。');
	    		return false;
	    	}
	    	
	    	if($.inArray(extension, allowExt) < 0) { // CHECK FILE EXTENSION
	    		alert('請檢查文件類型。');
	    		return false;
	    	} 	
	    	return true;
		}

	    function uploadFile(event, fileIdx) {	
	    	event.stopPropagation();
	    	event.preventDefault();

	    	var formData = new FormData();
			var files = event.target.files;
				
			$.each(files, function(key, value){
					formData.append(key, value);
			});
			
			console.log(formData)
			
	    	$.ajax({
	    		url 		: '/utils/fileupload.json',
	    		method 		: 'post',
	    	    contentType	: false,
	    		data 		: formData,
	    		processData	: false,
	    		success 	: function (data, textStatus, jqXhr) {
	    			console.log(data)
	    			var errorString = JSON.stringify(jqXhr.responseText);
// 	    			$("#attachFilePath" + fileIdx).val((data.result.resultCode == '1') ? data.result.fileName : "");
// 	    			var returnCode = data.result.resultCode;
// 	    			if (returnCode != '1') {
// 	    				var resultMsg = data.result.msg;
// 	    				if (returnCode == '-1') {
// 	    					resultMsg = '請檢查文件類型。';
// 	    				}
// 	    				alert("["+ returnCode +"] " + resultMsg);
// 	    				$("#inquiryFile" + fileIdx).focus();
// 	    			}
	    		}
	    	});
	    }
		
		$("input[name=fileUpload]").on("change", function(event) {
			console.log(this.files)
			if(this.files[0] != undefined && this.files[0] != '' && this.files[0] != null) {
				if(validateFile(this.files[0])) {
		    		uploadFile(event, 1);
				} else {
					$(this).val('');
				}
			}
		})
	})
</script>