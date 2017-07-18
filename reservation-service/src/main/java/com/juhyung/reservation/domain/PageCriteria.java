package com.juhyung.reservation.domain;

public class PageCriteria {

	private int page;
	private int perNum;
	
	public PageCriteria(int page){
		perNum = 10;
		this.page = (page-1) * perNum;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerNum() {
		return perNum;
	}
	public void setPerNum(int perNum) {
		this.perNum = perNum;
	}
	
	@Override
	public String toString() {
		return "PageVO [page=" + page + ", perNum=" + perNum + "]";
	}
}