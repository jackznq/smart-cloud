package com.schoolassistant.homework.api.pojo;

import com.peng.common.pojo.BaseRequestPojo;

import java.io.Serializable;
import java.util.Date;

//客户端发请求的参数对象
public class ClassInfoRequest extends BaseRequestPojo implements Serializable {

    private Long id;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 学校名称
     */
    private String schoolName;

    /**
     * 创建班级的用户的联系电话
     */
    private String contactTel;

    /**
     * 班级所在的省市信息，如：浙江省-杭州市/江苏省-南京市
     */
    private String location;

    /**
     * 班级的学生人数
     */
    private Integer studentNum;

    /**
     * 班级创建人的ID，首个创建班级的用户为班级管理员
     */
    private Long creatorId;

    private Date createTime;

    private Integer classStatus;

    /**
     * 班级状态：1 有效 0 无效
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(Integer classStatus) {
        this.classStatus = classStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
