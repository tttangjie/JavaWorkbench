package com.ymy.pojo;

import java.util.List;
/**
 * EasyUI Data
 * @author ymy
 *
 */
public class EUDataGridResult {

	private long total;
	private List<?> rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
