package com.road.crawler.meizitu.model;

import java.io.Serializable;
import java.util.Date;

public class PictureInfo implements Serializable {

	private Integer id;

	private String tag;
	
	private String alt;

	private String thumbnail;

	private String href;

	private Date createDate;

	private Date updateDate;

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "PictureInfo{" + "id=" + id + ", tag=" + tag + ", alt='" + alt + '\'' + ", thumbnail='" + thumbnail
				+ '\'' + ", href='" + href + '\'' + ", createDate=" + createDate + ", updateDate=" + updateDate + '}';
	}
}