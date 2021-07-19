package org.lilaco.domain;

public class Criteria {

	private int pageNum;
	private int amount;
	
	// 검색 기능을 위해 다음 멤버변수 추가.
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", type=" + type + ", keyword=" + keyword + "]";
	}
	
	//getTypeArr은 검색 조건이 각 글자(T,W,C)로 구성되어 있으므로 검색 조건을 배열로 만들어서 한번에 처리
	public String[] getTypeArr() {
		return type == null? new String[] {}: type.split("");
	}
	
	
}
