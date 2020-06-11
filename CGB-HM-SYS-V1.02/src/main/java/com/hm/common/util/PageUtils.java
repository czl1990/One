package com.hm.common.util;

import java.util.List;

import com.hm.common.vo.PageObject;

public class PageUtils {
	public static <T>PageObject<T> newPageObject(
			  Integer rowCount,
			  List<T> records,
			  Integer pageSize,
			  Integer pageCurrent){
		PageObject<T> pageObject = new PageObject<T>();
		int pageCount = (rowCount-1)/pageSize+1;
		pageObject.setPageCount(pageCount);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(records);
		pageObject.setRowCount(rowCount);
		return pageObject;
	}
}
