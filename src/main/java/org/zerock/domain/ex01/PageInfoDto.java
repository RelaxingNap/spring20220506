package org.zerock.domain.ex01;

// 페이징 처리시 DTO하나 더 추가하는게 관리가 편함
public class PageInfoDto {
	private int current;
	private int end;
	
	public void setCurrent(int current) {
		this.current = current;
	}
	
	public int getCurrent() {
		return current;
	}
	
	public int getLeft() {
		return Math.max(1, current - 3);
	}
	
	public int getRight() {
		return Math.min(end, current + 3);
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	public int getEnd() {
		return end;
	}
	
}
