package com.schoolassistant.homework.api.mapper.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "work_item")
public class WorkItem {
    @Id
    private Long id;

    /**
     * 科目
     */
    @Column(name = "subject")
    private String subject;

    /**
     * 提交日期
     */
    @Column(name = "submit_date")
    private Date submitDate;

    /**
     * 日期描述
     */
    @Column(name = "date_desc")
    private String dateDesc;

    /**
     * 确认方式：签名确认、拍照确认、语音确认、视频确认
     */
    @Column(name = "confirm_type")
    private String confirmType;

    /**
     * 评分制：等第制、十分制、百分制
     */
    @Column(name = "score_type")
    private String scoreType;

    /**
     * 详细描述
     */
    @Column(name = "detail")
    private String detail;

    /**
     * 是否发布到班级或小组中
     */
    @Column(name = "release")
    private Integer release;

    /**
     * 作业类型：0 班级作业 1 小组作业
     */
    @Column(name = "work_type")
    private Integer workType;

    /**
     * 作业发布人的ID
     */
    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 状态:0 无效 1: 有效
     */
    @Column(name = "state")
    private Integer state;

    @Column(name = "update_time")
    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

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
     * 获取科目
     *
     * @return subject - 科目
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置科目
     *
     * @param subject 科目
     */
    public void setSubject(String subject) {
        this.subject = subject;
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
     * 获取日期描述
     *
     * @return date_desc - 日期描述
     */
    public String getDateDesc() {
        return dateDesc;
    }

    /**
     * 设置日期描述
     *
     * @param dateDesc 日期描述
     */
    public void setDateDesc(String dateDesc) {
        this.dateDesc = dateDesc;
    }

    /**
     * 获取确认方式：签名确认、拍照确认、语音确认、视频确认
     *
     * @return confirm_type - 确认方式：签名确认、拍照确认、语音确认、视频确认
     */
    public String getConfirmType() {
        return confirmType;
    }

    /**
     * 设置确认方式：签名确认、拍照确认、语音确认、视频确认
     *
     * @param confirmType 确认方式：签名确认、拍照确认、语音确认、视频确认
     */
    public void setConfirmType(String confirmType) {
        this.confirmType = confirmType;
    }

    /**
     * 获取评分制：等第制、十分制、百分制
     *
     * @return score_type - 评分制：等第制、十分制、百分制
     */
    public String getScoreType() {
        return scoreType;
    }

    /**
     * 设置评分制：等第制、十分制、百分制
     *
     * @param scoreType 评分制：等第制、十分制、百分制
     */
    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    /**
     * 获取详细描述
     *
     * @return detail - 详细描述
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置详细描述
     *
     * @param detail 详细描述
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获取是否发布到班级或小组中
     *
     * @return release - 是否发布到班级或小组中
     */
    public Integer getRelease() {
        return release;
    }

    /**
     * 设置是否发布到班级或小组中
     *
     * @param release 是否发布到班级或小组中
     */
    public void setRelease(Integer release) {
        this.release = release;
    }

    /**
     * 获取作业类型：0 班级作业 1 小组作业
     *
     * @return work_type - 作业类型：0 班级作业 1 小组作业
     */
    public Integer getWorkType() {
        return workType;
    }

    /**
     * 设置作业类型：0 班级作业 1 小组作业
     *
     * @param workType 作业类型：0 班级作业 1 小组作业
     */
    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    /**
     * 获取作业发布人的ID
     *
     * @return creator_id - 作业发布人的ID
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置作业发布人的ID
     *
     * @param creatorId 作业发布人的ID
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
     * 获取状态:0 无效 1: 有效
     *
     * @return state - 状态:0 无效 1: 有效
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态:0 无效 1: 有效
     *
     * @param state 状态:0 无效 1: 有效
     */
    public void setState(Integer state) {
        this.state = state;
    }
}