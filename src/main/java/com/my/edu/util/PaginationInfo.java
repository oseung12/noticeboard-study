package com.my.edu.util;

import java.util.ListResourceBundle;

public class PaginationInfo {

	/**
	 * 현재 페이지
	 */
	private int currentPage; 
	
	/**
	 * 페이지당 출력할 목록 갯수
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
	
	public PaginationInfo(int currentPage, int cntPerPage, int pageSize) {
		if(currentPage < 1 ) {
			currentPage = 1;  //강제 입력 방지
		}
		if(cntPerPage != 10 && cntPerPage !=20 && cntPerPage !=30) {
			cntPerPage = 10; // 10개 20개 30 단위 이외에 처리 방지 이조건에 부합하지 않으면 cntPerPage는 10개 
		}
		if(pageSize != 10) {
			pageSize = 10; // 하단 페이지 10개 제한
		}
		this.currentPage = currentPage;  // 값을 세팅해준다 (세터기능)
		this.cntPerPage = cntPerPage;
		this.pageSize = pageSize;
	}
	
	// 실제 계산식
	private void calculation() {
		// 전체 페이지수 
		totalPageCount = ((totalRecordCount -1) / this.getCntPerPage()) +1;
		if(this.getCurrentPage() > totalPageCount) {
			this.setCurrentPage(totalPageCount);
		}
		
		// 첫페이지 구하기  
		firstPage = ((this.getCurrentPage() -1) / this.getPageSize()) * this.getPageSize() +1;
		
		// 마지막 페이지 구하기
		lastPage = firstPage + this.getPageSize() -1;
		if(lastPage > totalPageCount) {
			lastPage = totalPageCount;
		}
		
		// SQL 조건절에 사용되는 첫 로우NUM
		firstRecordIndex = (this.getCurrentPage() -1) * this.getCntPerPage();
		
		// SQL 조건절에 사용되는 마지막 로우NUM
		lastRecordIndex = this.getCurrentPage() * this.getCntPerPage();
		
		//삼항연산자 
		hasPreviousPage = firstPage == 1 ? false : true;  
//		 if(firstPage == 1) {
//			 false;
//		 } else {
//			 true;
//		 }
		// 이전페이지가 존재하는 지 여부 
		if(hasPreviousPage == false) {
			if(currentPage != firstPage) {
				hasPreviousPage = true;
			} else {
				hasPreviousPage = false;
			}
		}
		// 다음페이지 존재하는 지 여부
		hasNextPage = (lastPage * this.getCntPerPage()) >= totalRecordCount ? false : true;
		if(hasNextPage == false) {
			if(currentPage != lastPage) { 
				hasNextPage = true;  // 마지막 페이지에서 현재페이지가 마지막 페이지가 아닐때 next 처리
			} else {
				hasNextPage = false;
			}
		}		
			
	}
	


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
		
		// 0보다 클때 계산식을 사용한다.
		if(totalRecordCount > 0 ) {
			calculation();
		}
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


























