package com.pf.data.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;

//@Entity(name="")	객체 세상에서 이름
//@Table(name="")	실제 테이블 이름
@Data
@Entity
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userNo;
	
	private String userId;
	private String userPw;
	
	private String sessionkey;
	private Date sessionlimit;
	
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long userId; 
//	private String password;
//	
//	private String userNickname;
//	private String userEmail;
//	private String userType;
//	private String createdIp;
//	private String lastUpdatedIp;
//	private String thumnail;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date createdTime = new Date();
//	private Date lastUpdatedTime;
//	
//	private Date lastLoginTime;
//
//	// db에는 맵핑 하지 않음(칼럼 생성 안 함)
//	@Transient
//	private String checkSum;
//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
//
//	public String getUserNickname() {
//		return userNickname;
//	}
//
//	public void setUserNickname(String userNickname) {
//		this.userNickname = userNickname;
//	}
//
//	public String getUserEmail() {
//		return userEmail;
//	}
//
//	public void setUserEmail(String userEmail) {
//		this.userEmail = userEmail;
//	}
//
//	public String getUserType() {
//		return userType;
//	}
//
//	public void setUserType(String userType) {
//		this.userType = userType;
//	}
//
//	public String getCreatedIp() {
//		return createdIp;
//	}
//
//	public void setCreatedIp(String createdIp) {
//		this.createdIp = createdIp;
//	}
//
//	public String getLastUpdatedIp() {
//		return lastUpdatedIp;
//	}
//
//	public void setLastUpdatedIp(String lastUpdatedIp) {
//		this.lastUpdatedIp = lastUpdatedIp;
//	}
//
//	public String getThumnail() {
//		return thumnail;
//	}
//
//	public void setThumnail(String thumnail) {
//		this.thumnail = thumnail;
//	}
//
//	public Date getCreatedTime() {
//		return createdTime;
//	}
//
//	public void setCreatedTime(Date createdTime) {
//		this.createdTime = createdTime;
//	}
//
//	public Date getLastUpdatedTime() {
//		return lastUpdatedTime;
//	}
//
//	public void setLastUpdatedTime(Date lastUpdatedTime) {
//		this.lastUpdatedTime = lastUpdatedTime;
//	}
//
//	public Date getLastLoginTime() {
//		return lastLoginTime;
//	}
//
//	public void setLastLoginTime(Date lastLoginTime) {
//		this.lastLoginTime = lastLoginTime;
//	}
//
//	public String getCheckSum() {
//		return checkSum;
//	}
//
//	public void setCheckSum(String checkSum) {
//		this.checkSum = checkSum;
//	}
	
}
