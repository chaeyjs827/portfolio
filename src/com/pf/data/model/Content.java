package com.pf.data.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Content {
	@Id
	Integer Id;
	String MainCategory;
	String SubCategory;
	
	String title;
	String subTitle;
	String contents;
	String subContents;
	
	String filePath;
	
	String projectName;
	Date beginDate;
	Date finishedDate;
	Date DateCreated;
	Date LastUpdated;
	
}
