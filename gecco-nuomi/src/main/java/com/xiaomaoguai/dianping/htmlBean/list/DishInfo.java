package com.xiaomaoguai.dianping.htmlBean.list;

import java.io.Serializable;

public class DishInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dishName;

	private String dishHref;

	private String dishNum;

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishHref() {
		return dishHref;
	}

	public void setDishHref(String dishHref) {
		this.dishHref = dishHref;
	}

	public String getDishNum() {
		return dishNum;
	}

	public void setDishNum(String dishNum) {
		this.dishNum = dishNum;
	}

	@Override
	public String toString() {
		return "DishInfo [dishName=" + dishName + ", dishHref=" + dishHref + ", dishNum=" + dishNum + "]";
	}

}
