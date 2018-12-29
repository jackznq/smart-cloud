package com.schoolassistant.homework.api.pojo;

import com.peng.common.pojo.BaseRequestPojo;

import java.io.Serializable;
import java.util.Date;

public class ClassStudentListRequest extends BaseRequestPojo implements Serializable {

    private Long id;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学号
     */
    private String studentNo;

    /**
     * 班级ID
     */
    private Long classId;

    /**
     * 学生信息登记人的id
     */
    private Long creatorId;

    private Date createTime;

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
     * 获取学生姓名
     *
     * @return student_name - 学生姓名
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * 设置学生姓名
     *
     * @param studentName 学生姓名
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * 获取学号
     *
     * @return student_no - 学号
     */
    public String getStudentNo() {
        return studentNo;
    }

    /**
     * 设置学号
     *
     * @param studentNo 学号
     */
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    /**
     * 获取班级ID
     *
     * @return class_id - 班级ID
     */
    public Long getClassId() {
        return classId;
    }

    /**
     * 设置班级ID
     *
     * @param classId 班级ID
     */
    public void setClassId(Long classId) {
        this.classId = classId;
    }

    /**
     * 获取学生信息登记人的id
     *
     * @return creator_id - 学生信息登记人的id
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置学生信息登记人的id
     *
     * @param creatorId 学生信息登记人的id
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
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}
