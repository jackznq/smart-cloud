package com.schoolassistant.homework.api.mapper.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "class_info")
public class ClassInfo {
    @Id
    private Long id;

    /**
     * 班级名称
     */
    @Column(name = "class_name")
    private String className;

    /**
     * 学校名称
     */
    @Column(name = "school_name")
    private String schoolName;

    /**
     * 创建班级的用户的联系电话
     */
    @Column(name = "contact_tel")
    private String contactTel;

    /**
     * 班级所在的省市信息，如：浙江省-杭州市/江苏省-南京市
     */
    private String location;

    /**
     * 班级的学生人数
     */
    @Column(name = "student_num")
    private Integer studentNum;

    /**
     * 班级创建人的ID，首个创建班级的用户为班级管理员
     */
    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "class_status")
    private Integer classStatus;

    /**
     * 班级状态：1 有效 0 无效
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取班级名称
     *
     * @return class_name - 班级名称
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置班级名称
     *
     * @param className 班级名称
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取学校名称
     *
     * @return school_name - 学校名称
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 设置学校名称
     *
     * @param schoolName 学校名称
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * 获取创建班级的用户的联系电话
     *
     * @return contact_tel - 创建班级的用户的联系电话
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * 设置创建班级的用户的联系电话
     *
     * @param contactTel 创建班级的用户的联系电话
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    /**
     * 获取班级所在的省市信息，如：浙江省-杭州市/江苏省-南京市
     *
     * @return location - 班级所在的省市信息，如：浙江省-杭州市/江苏省-南京市
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置班级所在的省市信息，如：浙江省-杭州市/江苏省-南京市
     *
     * @param location 班级所在的省市信息，如：浙江省-杭州市/江苏省-南京市
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取班级的学生人数
     *
     * @return student_num - 班级的学生人数
     */
    public Integer getStudentNum() {
        return studentNum;
    }

    /**
     * 设置班级的学生人数
     *
     * @param studentNum 班级的学生人数
     */
    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    /**
     * 获取班级创建人的ID，首个创建班级的用户为班级管理员
     *
     * @return creator_id - 班级创建人的ID，首个创建班级的用户为班级管理员
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置班级创建人的ID，首个创建班级的用户为班级管理员
     *
     * @param creatorId 班级创建人的ID，首个创建班级的用户为班级管理员
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return class_status
     */
    public Integer getClassStatus() {
        return classStatus;
    }

    /**
     * @param classStatus
     */
    public void setClassStatus(Integer classStatus) {
        this.classStatus = classStatus;
    }

    /**
     * 获取班级状态：1 有效 0 无效
     *
     * @return update_time - 班级状态：1 有效 0 无效
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置班级状态：1 有效 0 无效
     *
     * @param updateTime 班级状态：1 有效 0 无效
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}