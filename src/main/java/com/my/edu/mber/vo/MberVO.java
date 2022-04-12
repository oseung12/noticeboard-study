package com.my.edu.mber.vo;

import java.io.Serializable;

import com.my.edu.commom.ComDefaultVO;

public class MberVO extends ComDefaultVO implements Serializable {   //직렬화

	private static final long serialVersionUID = 1L;
	
	private String mberNo;
	
	private String mberId;
	
	private String mberPw;
	
	private String name;
	
	private String birth;
	
	private String email;
	
	private String mobileTelNo;
	
	private String useYn;
	
	private String regId;
	
	private String regDt;
	
	private String updtId;
	
	private String updtDt;
	
	private String rnum;

	@Override
	public String toString() {
		return "MberVO [mberNo=" + mberNo + ", mberId=" + mberId + ", mberPw=" + mberPw + ", name=" + name + ", birth="
				+ birth + ", email=" + email + ", mobileTelNo=" + mobileTelNo + ", useYn=" + useYn + ", regId=" + regId
				+ ", regDt=" + regDt + ", updtId=" + updtId + ", updtDt=" + updtDt + ", rnum=" + rnum + "]";
	}

	public String getMberNo() {
		return mberNo;
	}

	public void setMberNo(String mberNo) {
		this.mberNo = mberNo;
	}

	public String getMberId() {
		return mberId;
	}

	public void setMberId(String mberId) {
		this.mberId = mberId;
	}

	public String getMberPw() {
		return mberPw;
	}

	public void setMberPw(String mberPw) {
		this.mberPw = mberPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileTelNo() {
		return mobileTelNo;
	}

	public void setMobileTelNo(String mobileTelNo) {
		this.mobileTelNo = mobileTelNo;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getUpdtId() {
		return updtId;
	}

	public void setUpdtId(String updtId) {
		this.updtId = updtId;
	}

	public String getUpdtDt() {
		return updtDt;
	}

	public void setUpdtDt(String updtDt) {
		this.updtDt = updtDt;
	}

	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
}
