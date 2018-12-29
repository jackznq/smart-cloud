package com.schoolassistant.homework.provider.controller;

import com.github.pagehelper.PageInfo;
import com.peng.auth.spring.boot.autoconfigure.utils.AccessTokenUtils;
import com.peng.common.pojo.ResponseCode;
import com.peng.common.pojo.ResponseData;
import com.peng.common.pojo.TableData;
import com.peng.db.spring.boot.autoconfigure.controller.CrudController;
import com.schoolassistant.homework.api.mapper.model.GroupInfo;
import com.schoolassistant.homework.api.mapper.model.GroupMember;
import com.schoolassistant.homework.api.pojo.GroupInfoRequest;
import com.schoolassistant.homework.provider.service.GroupInfoService;
import com.schoolassistant.homework.provider.service.GroupMemberService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@RestController
public class GroupInfoController extends CrudController<GroupInfo, GroupInfoRequest> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GroupInfoService groupInfoService;

    @Autowired
    private GroupMemberService groupMemberService;

    @Autowired
    private AccessTokenUtils accessTokenUtils;

    @GetMapping("/groupmember/{groupId}")
    public ResponseData<List<GroupMember>> getGroupMemberByGroupId(@PathVariable Long groupId) {
        log.debug("按照小组ID查询小组成员");
        try {
            return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), groupMemberService.getGroupMember(groupId));
        } catch (Exception e) {
            log.error("查询小组成员失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
    }

    @DeleteMapping("/groupmember")
    public ResponseData<GroupMember> delGroupMember(@RequestBody List<GroupMember> record) {
        log.debug("删除小组成员");
        try {
            groupMemberService.deleteBatchByPrimaryKey(record);
            return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("删除小组成员失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
    }

    @PostMapping("/groupmember")
    public ResponseData<GroupMember> addGroupMember(@RequestBody List<GroupMember> record) {
        log.debug("增加小组成员");
        try {
            record.forEach(r -> {
                r.setCreateTime(new Date());
                r.setCreatorId(accessTokenUtils.getUserInfo().getId());
            });
            groupMemberService.batchInsertSelective(record);
            return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("增加小组成员失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
    }

    @GetMapping("/groupinfo/{classId}")
    public ResponseData<List<GroupInfo>> getGroupInfoByClassId(@PathVariable Long classId) {
        log.debug("按照班级ID查找小组");
        try {
            Example example = new Example(GroupInfo.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("classId", classId);
            return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), groupInfoService.selectByExample(example));
        } catch (Exception e) {
            log.error("按照班级ID查找小组失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
    }

    @GetMapping("/groupinfo/table")
    @Override
    protected ResponseData<TableData<GroupInfo>> queryRecord(@RequestBody GroupInfoRequest query) {
        log.debug("分页查询小组");
        try {
            Example example = new Example(GroupInfo.class);
            Example.Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(query.getGroupName())) {
                criteria.andLike("groupName", "%" + query.getGroupName() + "%");
            }
            PageInfo<GroupInfo> pageInfo = groupInfoService.selectByExampleList(example, query.getPageNum(), query.getPageSize());
            return getTableData(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), pageInfo);
        } catch (Exception e) {
            log.error("查询小组出错：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
    }

    @PostMapping("/groupinfo")
    @Override
    protected ResponseData<GroupInfo> addRecord(@RequestBody GroupInfo record) {
        log.debug("新增小组");
        try {
            record.setCreateTime(new Date());
            record.setCreatorId(accessTokenUtils.getUserInfo().getId());
            groupInfoService.insertSelective(record);
        } catch (Exception e) {
            log.error("新增小组信息失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    @DeleteMapping("/groupinfo")
    @Override
    protected ResponseData<GroupInfo> deleteRecord(@RequestBody List<GroupInfo> record) {
        log.debug("删除小组");
        try {
            groupInfoService.deleteBatchByPrimaryKey(record);
        } catch (Exception e) {
            log.error("删除小组失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    @PutMapping("/groupinfo")
    @Override
    protected ResponseData<GroupInfo> updateRecord(@RequestBody GroupInfo record) {
        log.debug("更新小组");
        try {
            record.setUpdateTime(new Date());
            groupInfoService.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            log.error("更新小组失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }
}
