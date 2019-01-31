package com.schoolassistant.homework.api.pojo;

import com.smartcloud.common.pojo.BaseRequestPojo;

import java.io.Serializable;
import java.util.Date;

public class GroupMemberRequest extends BaseRequestPojo implements Serializable {

    /**
     * 小组成员表
     */
    private Long id;

    /**
     * 小组ID
     */
    private Long groupId;

    /**
     * 学生信息表 关联 class_student_list 的id
     */
    private Long studentId;

    /**
     * 班级ID
     */
    private Long classId;

    private Date createTime;

    private Long creatorId;

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
