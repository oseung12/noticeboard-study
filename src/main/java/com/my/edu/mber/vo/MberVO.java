package com.my.edu.mber.vo;

import java.io.Serializable;

import com.my.edu.commom.ComDefaultVO;

public class MberVO extends ComDefaultVO implements Serializable {   
		// Serializable => 우리가 만든 클래스가 파일에 읽거나 쓸 수 있도록 하거나, 다른 서버로 보내거나 받을 수 있도록 하려면 반드시 구현하는 인터페이스
		// Serializable 인터페이스를 구현하면 JVM에서 해당 객체는 저장하거나 다른 서버로 전송할 수 있도록 해준다.
		
		/**
		 * 반드시 static final long 으로 선언해야한다.
		 * 직렬화, 역직렬화 시 serialVersionUID 상수가 없으면 JVM에서 만들어 넣어준다.
		 */
	private static final long serialVersionUID = 1L;
		// private => 같은 클래스 내부에서만 사용이 가능하다.
		// static  => 메모리가 JVM의 static메모리에 올라간다.(application이 실행되면 모두 메모리에 할당되고, 종료되면 삭제된다.) => 객체를 생성하지 않는다.
		// final   => 재할당할 수 없도록 만든다.
		// private static final을 선언한 변수를 사용하면 재할당 하지 못하며, 메모리에 한 번 올라가면 같은 값을 클래스 내부의 전체 필드, 메서드에서 공유한다.
	
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