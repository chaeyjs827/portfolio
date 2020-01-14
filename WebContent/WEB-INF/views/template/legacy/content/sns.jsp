<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <section class="ftco-section" id="blog-section">
      <div class="container">
        <div class="row justify-content-center mb-5 pb-5">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <h1 class="big big-2">Blog</h1>
            <h2 class="mb-3">STAYED TO WORK</h2>
			<p><spring:message code="been.main.title"/></p>
          </div>
        </div>
        <div class="row d-flex">
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry justify-content-end">
              <a href="javascript:void(0);" class="block-20" style="background-image: url('/resources/images/flag_tw.png');">
              </a>
              <div class="text mt-3 float-right d-block">
                <h3 class="heading"><a href="javascript:void(0);"><spring:message code="been.tw"/></a></h3>
                <div class="d-flex align-items-center mb-3 meta">
	                <p class="mb-0">
	                	<span class="mr-2">Sep.2019 ~ current</span>
	                	<a href="#" class="mr-2">(+16 months)</a>
	                </p>
                </div>
                <p><spring:message code="been.tw.title"/></p> 
              </div>
            </div>
          </div>
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry justify-content-end">
              <a href="javascript:void(0);" class="block-20" style="background-image: url('/resources/images/flag_aus.png');">
              </a>
              <div class="text mt-3 float-right d-block">
                <h3 class="heading"><a href="javascript:void(0);"><spring:message code="been.aus"/></a></h3>
                <div class="d-flex align-items-center mb-3 meta">
	                <p class="mb-0">
	                	<span class="mr-2">June.2016 ~ Sep.2017</span>
	                	<a href="#" class="mr-2">(16 months)</a>
	                </p>
                </div>
                <p><spring:message code="been.aus.title"/></p>
              </div>
            </div>
          </div>
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry justify-content-end">
              <a href="javascript:void(0);" class="block-20" style="background-image: url('/resources/images/flag_kr.png');">
              </a>
              <div class="text mt-3 float-right d-block">
                <h3 class="heading"><a href="javascript:void(0);"><spring:message code="been.kr"/></a></h3>
                <div class="d-flex align-items-center mb-3 meta">
	                <p class="mb-0">
	                	<span class="mr-2">Korean Native</span>
	                </p>
                </div>
                <p><spring:message code="been.kr.title"/></p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>