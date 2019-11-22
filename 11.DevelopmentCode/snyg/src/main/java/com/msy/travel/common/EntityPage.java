package com.msy.travel.common;

import java.io.Serializable;

public class EntityPage implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7998675868274396707L;

	/**
	 * 总记录数
	 */
	private int totalSize = 0;

	/**
	 * 每页显示行数（默认为10条）
	 */
	private int rowsPerPage = 20;

	/**
	 * 当前页
	 */
	private int currentPage = 0;

	/**
	 * 当前页第一条数据的索引
	 */
	private int pageBegin;

	/**
	 * 当前页最后一条数据的索引
	 */
	private int pageEnd;

	/**
	 * 排序字段标识
	 */
	private String sortField;

	/**
	 * 排序顺序标识
	 */
	private String sortOrder;

	/**
	 * 总页数
	 */
	private int totalPages = 0;

	public EntityPage() {
	}

	public EntityPage(int totalSize, int rowsPerPage, int currentPage, int totalPages) {
		this.totalSize = totalSize;
		this.rowsPerPage = rowsPerPage;
		this.currentPage = currentPage;
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRowsPerPage() {
		return this.rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public int getTotalSize() {
		return this.totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

}
