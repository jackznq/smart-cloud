package com.schoolassistant.homework.api.mapper.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "group_member")
public class GroupMember {
    /**
     * 小组成员表
     */
    @Id
    private Long id;

    /**
     * 小组ID
     */
    @Column(name = "group_id")
    private Long groupId;

    /**
     * 学生信息表 关联 class_student_list 的id
     */
    @Column(name = "student_id")
    private Long studentId;

    @Transient
    private String studentName;

    /**
     * 班级ID
     */
    @Column(name = "class_id")
    private Long classId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "creator_id")
    private Long creatorId;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * 获取小组成员表
     *
     * @return id - 小组成员表
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置小组成员表
     *
     * @param id 小组成员表
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取小组ID
     *
     * @return group_id - 小组ID
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置小组ID
     *
     * @param groupId 小组ID
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取学生信息表 关联 class_student_list 的id
     *
     * @return student_id - 学生信息表 关联 class_student_list 的id
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * 设置学生信息表 关联 class_student_list 的id
     *
     * @param studentId 学生信息表 关联 class_student_list 的id
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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
     * @return creator_id
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }
}