package com.schoolassistant.homework.api.mapper.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "item_member")
public class ItemMember {
    @Id
    private Long id;

    /**
     * 作业ID 关联work_item表
     */
    @Column(name = "work_item_id")
    private Long workItemId;

    /**
     * 班级id 关联 class_info
     */
    @Column(name = "class_id")
    private Long classId;

    /**
     * 小组id 关联group_info
     */
    @Column(name = "group_id")
    private Long groupId;

    /**
     * 学生id 关联class_student_list
     */
    @Column(name = "student_id")
    private Long studentId;

    /**
     * 当前登录用户的id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 作业状态：0 未提交 1 已提交
     */
    @Column(name = "submit_state")
    private Integer submitState;

    /**
     * 提交日期
     */
    @Column(name = "submit_date")
    private Date submitDate;

    @Column(name = "create_time")
    private Date createTime;

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
     * 获取作业ID 关联work_item表
     *
     * @return work_item_id - 作业ID 关联work_item表
     */
    public Long getWorkItemId() {
        return workItemId;
    }

    /**
     * 设置作业ID 关联work_item表
     *
     * @param workItemId 作业ID 关联work_item表
     */
    public void setWorkItemId(Long workItemId) {
        this.workItemId = workItemId;
    }

    /**
     * 获取班级id 关联 class_info
     *
     * @return class_id - 班级id 关联 class_info
     */
    public Long getClassId() {
        return classId;
    }

    /**
     * 设置班级id 关联 class_info
     *
     * @param classId 班级id 关联 class_info
     */
    public void setClassId(Long classId) {
        this.classId = classId;
    }

    /**
     * 获取小组id 关联group_info
     *
     * @return group_id - 小组id 关联group_info
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置小组id 关联group_info
     *
     * @param groupId 小组id 关联group_info
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取学生id 关联class_student_list
     *
     * @return student_id - 学生id 关联class_student_list
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * 设置学生id 关联class_student_list
     *
     * @param studentId 学生id 关联class_student_list
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * 获取当前登录用户的id
     *
     * @return user_id - 当前登录用户的id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置当前登录用户的id
     *
     * @param userId 当前登录用户的id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取作业状态：0 未提交 1 已提交
     *
     * @return submit_state - 作业状态：0 未提交 1 已提交
     */
    public Integer getSubmitState() {
        return submitState;
    }

    /**
     * 设置作业状态：0 未提交 1 已提交
     *
     * @param submitState 作业状态：0 未提交 1 已提交
     */
    public void setSubmitState(Integer submitState) {
        this.submitState = submitState;
    }

    /**
     * 获取提交日期
     *
     * @return submit_date - 提交日期
     */
    public Date getSubmitDate() {
        return submitDate;
    }

    /**
     * 设置提交日期
     *
     * @param submitDate 提交日期
     */
    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
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