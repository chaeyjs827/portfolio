package com.pf.utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtilsController extends Utils {

	final private String[] 	FILEUPLOAD_ALLOW_FILE			 = {"jpg", "jpeg", "png", "txt", "log", "doc", "docx", "pdf"};
	final private long 		FILEUPLOAD_MAX_SIZE_PER_A_FILE 	 = 1024 * 1024 *  3;
	
	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView fileupload(MultipartHttpServletRequest request) {
		System.out.println("request : " + request);
		
		String returnFileName = StringUtils.EMPTY;
		int returnCode = (request.getFileMap() != null) ? 1 : 10001;
		String returnMsg = "success";
		
		if(returnCode == 1) {
			Set set = request.getFileMap().entrySet();
			Iterator i = set.iterator();
			
			String fileName = StringUtils.EMPTY;
			MultipartFile multipartFile = null;
			while(i.hasNext()) {
				Map.Entry me = (Map.Entry)i.next();
				String fileId = (String)me.getKey();

	            System.out.println("fileId : " + fileId + ", value : " + me.getValue());
	            
	            if (StringUtils.isNotEmpty(fileId) && me.getValue() != null) {
	            	multipartFile = (MultipartFile)me.getValue();
	            	fileName = multipartFile.getOriginalFilename();
	            	
	                System.out.println("Original fileName - " +  multipartFile.getOriginalFilename());
	                System.out.println("fileName - " + fileName);
	                
	                if(StringUtils.isNotEmpty(fileName)) {
	                	String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		                // 1. file extension check
	                	if(!UtilFileupload.chkFileExtention(FILEUPLOAD_ALLOW_FILE, fileExt.toLowerCase())) {
	                		returnCode = -1;
	                		returnMsg = "invalid file extention";
	                	}
	                	// 2. file size check
	                	if(returnCode == 1) {
	                		if(!(multipartFile.getSize() <= FILEUPLOAD_MAX_SIZE_PER_A_FILE)) {
	                			returnCode = -2;
	                			returnMsg = "invalid file size";
	                		}
	                	}
	                	// 3. file meta tag check
	                	if(returnCode == 1) {
	                		try {
	                			if(!UtilFileupload.chkFileSign(fileExt,  multipartFile.getInputStream())) {
	                				returnCode = -3;
	                				returnMsg = "invalid file meta tag";
	                			}
	                		} catch(IOException e) {
	                			e.printStackTrace();
	                			returnCode = -4;
	                			returnMsg = "file meta tag check error";
	                		}
	                	}
	                }

	                System.out.println("resultCode : " + returnCode + ", msg : " + returnMsg);
	         
	                //file upload
	                if(StringUtils.isNotEmpty(fileName) && returnCode == 1) {
	                	String path = "/testDir";
	                	String userNo = "123123";
	    				String filename = String.format("%s%s", path, userNo+"_"+multipartFile.getOriginalFilename());

						String attachFilePaths = filename;

	                    UtilsFTPUploader ftpUploader = null;
	                    File tempFileNeedUpload = null;
	                    try {
	                    	ftpUploader = new UtilsFTPUploader("ftp://localhost", 21, "Jun_FTP", "dudwns12");
//	                    	ftpUploader = new UtilsFTPUploader("ftp://::1", 21, "Jun_FTP", "dudwns12");
//	                    	ftpUploader = new UtilsFTPUploader("ftp://127.0.0.0/8", 21, "Jun_FTP", "dudwns12");
	                    	tempFileNeedUpload = UtilFileupload.multipartToFile(multipartFile);
		                    System.out.println("tempFileNeedUpload : " + tempFileNeedUpload);
		                    ftpUploader.uploadFile(tempFileNeedUpload, attachFilePaths, "/service/customer/");
		                    System.out.println("finish fileupload >> ");
	                    } catch(Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
	                    } finally {
							if (ftpUploader != null) {
			                    ftpUploader.disconnect();							
			                    //after upload to ftp delete file in system
			                    tempFileNeedUpload.delete();
							}
	                    }
	                    returnFileName = filename;
	                }
	                
	            }
			}
		}
		
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("fileName", returnFileName);
			jsonObj.put("returnCode",  returnCode);
			jsonObj.put("returnMsg", returnMsg);
		} catch (net.sf.json.JSONException e) {
			e.printStackTrace();
		}
		
		
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("returnObj", jsonObj);
		return mav;
	}
	
}
