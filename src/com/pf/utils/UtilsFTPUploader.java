package com.pf.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import com.pf.config.ProjectConstants;

public class UtilsFTPUploader extends ProjectConstants {
	   FTPClient ftp = null;

	    public UtilsFTPUploader(String host, int port, String user, String pwd) throws Exception{
	        ftp = new FTPClient();
	        ftp.setDefaultPort(port);
	        ftp.setControlEncoding("UTF-8");

	       //ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
	        int reply;
	        ftp.connect(host);
	        reply = ftp.getReplyCode();
	        if (!FTPReply.isPositiveCompletion(reply)) {
	            ftp.disconnect();
	            throw new Exception("Exception in connecting to FTP Server");
	        }
	        ftp.login(user, pwd);
	        ftp.setFileType(FTP.BINARY_FILE_TYPE);
	        ftp.enterLocalPassiveMode();
	    }
	    public void uploadFile(String localFileFullName, String fileName, String hostDir) throws Exception {
	        try(InputStream input = new FileInputStream(new File(localFileFullName))){
	        	this.ftp.storeFile(hostDir + fileName, input);
	        }
	    }
	    public void uploadFile(File localFile, String fileName, String hostDir) throws Exception {
	        try(InputStream input = new FileInputStream(localFile)){
		    	//this.ftp.deleteFile(hostDir + fileName);
	        	System.out.println("[uploadFile] hostDir : " + hostDir + ", fileName : " + fileName +", input : " + input);
		        this.ftp.storeFile(hostDir + fileName, input);
	        }
	    }

	    public void disconnect(){
	        if (this.ftp.isConnected()) {
	            try {
	                this.ftp.logout();
	                this.ftp.disconnect();
	            } catch (IOException f) {
//	            	logger.error("",f);
	                // do nothing as file is already saved to server
	            }
	        }
	    }
	    public static void main(String[] args) throws Exception {
	        System.out.println("Start");
	        UtilsFTPUploader ftpUploader = new UtilsFTPUploader("ftp://127.0.0.0/8", 21, "Jun_FTP", "dudwns12");
	        //FTP server path is relative. So if FTP account HOME directory is "/home/pankaj/public_html/" and you need to upload
	        // files to "/home/pankaj/public_html/wp-content/uploads/image2/", you should pass directory parameter as "/wp-content/uploads/image2/"
	        ftpUploader.uploadFile("D:\\k4844.tbm.jpg", "k4844.tbm.jpg", "/test/");
	        ftpUploader.disconnect();
	        System.out.println("Done");
	    }
}
