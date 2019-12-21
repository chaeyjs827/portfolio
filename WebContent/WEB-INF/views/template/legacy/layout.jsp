<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
  <head>
	<tiles:insertAttribute name="header" />
  </head>
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
	  
	<tiles:insertAttribute name="navigation" />
	
	<tiles:insertAttribute name="about" />

	<tiles:insertAttribute name="resume" />

	<tiles:insertAttribute name="projects" />
	
	<tiles:insertAttribute name="sns" />
 
	<tiles:insertAttribute name="contact" />
		
	<tiles:insertAttribute name="footer" />
	
	<tiles:insertAttribute name="loader" />
    
  </body>
</html>