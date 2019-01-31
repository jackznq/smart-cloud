package com.schoolassistant.homework.api.pojo;

import com.smartcloud.common.pojo.BaseRequestPojo;

import java.io.Serializable;
import java.util.Date;

public class GroupInfoRequest extends BaseRequestPojo implements Serializable {

    private Long id;

    /**
     * 小组名称
     */
    private String groupName;

    /**
     * 小组状态 :1 正常 0:停用
     */
    private Integer groupStatus;

    /**
     * 小组创建人的ID
     */
    private Long creatorId;

    /**
     * 班级id
     */
    private Long classId;

    /**
     * 小组信息表
     */
    private Date createTime;

    /**
     * 小组所在的班级ID
     */
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
     * 获取小组名称
     *
     * @return group_name - 小组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置小组名称
     *
     * @param groupName 小组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 获取小组状态 :1 正常 0:停用
     *
     * @return group_status - 小组状态 :1 正常 0:停用
     */
    public Integer getGroupStatus() {
        return groupStatus;
    }

    /**
     * 设置小组状态 :1 正常 0:停用
     *
     * @param groupStatus 小组状态 :1 正常 0:停用
     */
    public void setGroupStatus(Integer groupStatus) {
        this.groupStatus = groupStatus;
    }

    /**
     * 获取小组创建人的ID
     *
     * @return creator_id - 小组创建人的ID
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置小组创建人的ID
     *
     * @param creatorId 小组创建人的ID
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取班级id
     *
     * @return class_id - 班级id
     */
    public Long getClassId() {
        return classId;
    }

    /**
     * 设置班级id
     *
     * @param classId 班级id
     */
    public void setClassId(Long classId) {
        this.classId = classId;
    }

    /**
     * 获取小组信息表
     *
     * @return create_time - 小组信息表
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置小组信息表
     *
     * @param createTime 小组信息表
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取小组所在的班级ID
     *
     * @return update_time - 小组所在的班级ID
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置小组所在的班级ID
     *
     * @param updateTime 小组所在的班级ID
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
