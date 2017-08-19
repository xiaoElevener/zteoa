package com.ncu.oa.common.entity;

import java.util.List;

public class Page<T> {
	private int pageNo; //

	private int pageSize = 10; // 默认值

	private int totalRecords; //

	private int totalPage;

	private List<?> list; //

	public Page() {
	}

	public Page(int pageNo, int pageSize, int totalRecords, List list) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalRecords = totalRecords;
		this.totalPage = getTotalPages();
		this.list = list;
	}

	/**
	 * 
	 * @return
	 */
	public int getTotalPages() {
		return (totalRecords + pageSize - 1) / pageSize;
	}

	/**
	 * 
	 * @return
	 */
	public int getTopPage() {
		return 1;
	}

	/**
	 * 
	 * @return
	 */
	public int getUpPage() {
		if (pageNo <= 1) {
			return 1;
		}
		return pageNo - 1;
	}

	/**
	 * 
	 * @return
	 */
	public int getNextPage() {
		if (pageNo > getTotalPages()) {
			return getTotalPages() == 0 ? 1 : getTotalPages();
		}
		return pageNo + 1;
	}

	/**
	 * 
	 * @return
	 */
	public int getBottomPage() {
		return getTotalPages() == 0 ? 1 : getTotalPages();
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", totalRecords=" + totalRecords + ", totalPage=" + totalPage
				+ ", list=" + list + "]";
	}
}
