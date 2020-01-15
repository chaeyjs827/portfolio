<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<section class="hero-wrap js-fullheight">
	<div class="overlay"></div>
	<div class="container">
		<div
			class="row no-gutters slider-text js-fullheight justify-content-center align-items-center">
			<div class="col-lg-8 col-md-6 ftco-animate d-flex align-items-center">
				<div class="text text-center">
					<span class="subheading"><spring:message code="about.intro.title1"/></span>
					<h5><spring:message code="about.intro.title2"/></h5>
					<h5><spring:message code="about.intro.title3"/></h5>
					<h5><spring:message code="about.intro.title4"/></h5>
					<h5><spring:message code="about.intro.title5"/></h5>
					<h5><spring:message code="about.intro.title6"/></h5>
					<h5><spring:message code="about.intro.title7"/></h5>
					<h1>Young-Jun CHAE</h1>
				</div>
			</div>
			<div class="col-lg-8 col-md-6 ftco-animate d-flex align-items-center">
			</div>
		</div>
	</div>
</section>
<section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb"
	id="about-section">
	<div class="container">
		<div class="row d-flex no-gutters">
			<div class="col-md-6 col-lg-6 d-flex">
				<div class="img-about img d-flex align-items-stretch">
					<div class="overlay"></div>
					<div class="img d-flex align-self-stretch align-items-center"
						style="background-image: url(/resources/images/jun.jpg);">
					</div>
				</div>
			</div>
			<div class="col-md-6 col-lg-6 pl-md-5 py-5">
				<div class="row justify-content-start pb-3">
					<div class="col-md-12 heading-section ftco-animate">
						<h1 class="big">About</h1>
						<h2 class="mb-4">About Me</h2>
						<ul class="about-info mt-4 px-md-0 px-2">
							<li class="d-flex"><span><spring:message code="about.me.name"/>:</span> <span><spring:message code="about.me.nameAns"/></span></li>
							<li class="d-flex"><span><spring:message code="about.me.birth"/>:</span> <span><spring:message code="about.me.birthAns"/></span></li>
							<li class="d-flex"><span><spring:message code="about.me.location"/>:</span> <span><spring:message code="about.me.locationAns"/></span></li>
							<li class="d-flex"><span><spring:message code="about.me.email"/>:</span> <span><span><spring:message code="about.me.emailAns"/></span></li>
							<li class="d-flex"><span><spring:message code="about.me.phone"/>:</span> <span><spring:message code="about.me.phoneAns"/></span></li>
							<li class="d-flex"><span><spring:message code="about.me.criminal"/>:</span> <span><spring:message code="about.me.criminalAns"/></span></li>
							<li class="d-flex"><span><spring:message code="about.me.disability"/>:</span> <span><spring:message code="about.me.disabilityAns"/></span></li>
							<li class="d-flex"><span><spring:message code="about.me.abroad"/>:</span> <span><spring:message code="about.me.abroadAns"/></span></li>
							<li class="d-flex"><span><spring:message code="about.me.language"/>:</span> <span><spring:message code="about.me.languageAns"/></span></li>
						</ul>
					</div>
				</div>
				<div class="counter-wrap ftco-animate d-flex mt-md-3">
					<div class="text">
						<p class="mb-4">
							<span class="number" data-number="10">0</span> <span>Project complete</span>
						</p>
						<p>
							<a href="javascript:alert('resume is being preparing')" class="btn btn-primary py-3 px-3">Download CV</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>