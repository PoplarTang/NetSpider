package com.xiaomaoguai.gecco.entity;

import java.io.Serializable;
import java.util.Date;

public class Picture implements Serializable {
    private Integer id;

    private Integer picinfoId;

    private String url;

    private String path;

    private Date createDate;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPicinfoId() {
        return picinfoId;
    }

    public void setPicinfoId(Integer picinfoId) {
        this.picinfoId = picinfoId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        return "PictureBean{" +
                "id=" + id +
                ", picinfoId=" + picinfoId +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}