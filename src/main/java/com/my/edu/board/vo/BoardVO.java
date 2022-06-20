package com.my.edu.board.vo;

import java.io.Serializable;

import com.my.edu.commom.ComDefaultVO;

public class BoardVO extends ComDefaultVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String boardNo;
	
	private String title;
	
	private String content;
	
	private String boardPw;
	
	private String boardOpenYn;
	
	private String hits;
	
	private String useYn;
	
	private String regId;
	
	private String regDate;
	
	private String updtId;
	
	private String updtDate;
	
	private String mberId;
	
	private String rnum;

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBoardPw() {
		return boardPw;
	}

	public void setBoardPw(String boardPw) {
		this.boardPw = boardPw;
	}

	public String getBoardOpenYn() {
		return boardOpenYn;
	}

	public void setBoardOpenYn(String boardOpenYn) {
		this.boardOpenYn = boardOpenYn;
	}

	public String getHits() {
		return hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUpdtId() {
		return updtId;
	}

	public void setUpdtId(String updtId) {
		this.updtId = updtId;
	}

	public String getUpdtDate() {
		return updtDate;
	}

	public void setUpdtDate(String updtDate) {
		this.updtDate = updtDate;
	}

	public String getMberId() {
		return mberId;
	}

	public void setMberId(String mberId) {
		this.mberId = mberId;
	}

	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}

}
