package com.my.edu.commom;

public class ComDefaultVO {
	
	/**
	 * 현재 페이지
	 */
	private int currentPage; 
	
	/**
	 * 페이지당 출력할 갯수
	 */
	private int cntPerPage;
	
	/**
	 * 화면 하단 페이지 사이즈
	 */
	private int pageSize;
	
	/**
	 * 전체 데이터 갯수
	 */
	private int totalRecordCount;
	
	/**
	 * 전체 페이지 갯수
	 */
	private int totalPageCount;
	
	/**
	 * 페이지 목록의 첫페이지 번호
	 */
	private int firstPage;
	
	/**
	 * 페이지 목록의 마지막페이지 번호
	 */
	private int lastPage;
	
	/**
	 * SQL조건절의 사용하는 첫 번호(RNUM)
	 */
	private int firstRecordIndex;
	
	/**
	 * SQL조건절의 사용하는 마지막 번호(RNUM)
	 */
	private int lastRecordIndex;
	
	/**
	 * 이전페이지 존재 여부
	 */
	private boolean hasPreviousPage;
	
	/**
	 * 다음페이지 존재 여부
	 */
	private boolean hasNextPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getFirstRecordIndex() {
		return firstRecordIndex;
	}

	public void setFirstRecordIndex(int firstRecordIndex) {
		this.firstRecordIndex = firstRecordIndex;
	}

	public int getLastRecordIndex() {
		return lastRecordIndex;
	}

	public void setLastRecordIndex(int lastRecordIndex) {
		this.lastRecordIndex = lastRecordIndex;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	
}
