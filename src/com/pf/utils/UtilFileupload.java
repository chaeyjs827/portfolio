package com.pf.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;
//import org.apache.tika.Tika;
import org.springframework.web.multipart.MultipartFile;

public class UtilFileupload {
	/**
	 *
	 * @param multipart
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		File convFile = new File(multipart.getOriginalFilename());
		System.out.println("[multipartToFile] convFile : " + convFile);
		multipart.transferTo(convFile);
		System.out.println("[multipartToFile] convFile2 : " + convFile);
		return convFile;
	}

	/**
	 * 이미지 파일 용량 체크
	 *
	 * @param maxSize
	 * @param uploadFile
	 * @return boolean
	 */
	public static boolean chkFileSize(long maxSize, MultipartFile uploadFile) {
		long fileSize = uploadFile.getSize();
		if (fileSize > maxSize || fileSize <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * 파일 확장자 체크
	 *
	 * @param fileExtensions
	 * @param uploadFile
	 * @return boolean
	 */
	public static boolean chkFileExtension(String fileExtensions, MultipartFile uploadFile) {
		String fileName = uploadFile.getOriginalFilename().trim();
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();
		if (fileExtensions.indexOf(fileType) == -1) {
			System.out.println("올바른 파일 확장자가 아닙니다. [" + fileType + "," + fileName + "]");
			return false;
		}
		return true;
	}

	/**
	 * @brief 실제 파일 내용과 확장자가 일치하는지 체크
	 * @param fileExtensions
	 * @param fileObj
	 * @return boolean
	 */
	public static boolean chkFileSign(String fileExtensions, File fileObj) {
		try {
			Tika chkFileExt = new Tika();
			String chkFileExtStr = chkFileExt.detect(fileObj).toLowerCase();
			if (fileExtensions.indexOf(chkFileExtStr) == -1) {
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @brief 실제 파일 내용과 확장자가 일치하는지 체크
	 * @param fileExtensions
	 * @param is
	 * @return boolean
	 */
	public static boolean chkFileSign(String fileExtensions, InputStream is) {
		try {
			Tika chkFileExt = new Tika();
			Pattern p = Pattern.compile("[/]+");
			String chkFileExtStr = chkFileExt.detect(is).toLowerCase();
			if (!StringUtils.isEmpty(chkFileExtStr)) {
				chkFileExtStr = p.split(chkFileExtStr)[1];
				System.out.println("chkFileExtStr : " + chkFileExtStr);
				// 문서 파일 (doc, ppt : x-tika-msoffice | docx, pptx, xlsx : x-tika-ooxml)에 대한 체크를
				// 위해 추가
				if ("x-tika-msoffice".equals(chkFileExtStr) || "x-tika-ooxml".equals(chkFileExtStr)
						|| "plain".equals(chkFileExtStr) || "png".equals(chkFileExtStr) || "jpg".equals(chkFileExtStr)
						|| "jpeg".equals(chkFileExtStr) || "gif".equals(chkFileExtStr)) {
					return true;
				}
				// 상위 문서 파일에 해당하지 않는 파일들에 대한 변조 체크
				if (fileExtensions.indexOf(chkFileExtStr) == -1) {
					return false;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static boolean chkFileExtention(String[] fileChkExtArr, String fileExt) {
		boolean isValidExt = false;
		if (fileChkExtArr != null && fileExt != null) {
			for (String fileChkExt : fileChkExtArr) {
				System.out.println("fileChkExt : " + fileChkExt + ", fileExt : " + fileExt);
				if (StringUtils.equals(fileChkExt, fileExt)) {
					isValidExt = true;
				}
			}
		}
		return isValidExt;
	}
}
