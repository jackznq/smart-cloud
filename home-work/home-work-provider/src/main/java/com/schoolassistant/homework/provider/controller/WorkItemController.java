package com.schoolassistant.homework.provider.controller;

import com.github.pagehelper.PageInfo;
import com.schoolassistant.homework.api.constant.SimpleConst;
import com.schoolassistant.homework.api.mapper.model.ItemMember;
import com.schoolassistant.homework.api.mapper.model.WorkItem;
import com.schoolassistant.homework.api.pojo.WorkItemRequest;
import com.schoolassistant.homework.provider.service.ItemMemberService;
import com.schoolassistant.homework.provider.service.WorkItemService;
import com.smartcloud.auth.spring.boot.autoconfigure.utils.AccessTokenUtils;
import com.smartcloud.common.pojo.ResponseCode;
import com.smartcloud.common.pojo.ResponseData;
import com.smartcloud.common.pojo.TableData;
import com.smartcloud.db.spring.boot.autoconfigure.controller.CrudController;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@RestController
public class WorkItemController extends CrudController<WorkItem, WorkItemRequest> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WorkItemService workItemService;

    @Autowired
    private ItemMemberService itemMemberService;

    @Autowired
    private AccessTokenUtils accessTokenUtils;


    @GetMapping("/workitem/table")
    @Override
    protected ResponseData<TableData<WorkItem>> queryRecord(WorkItemRequest query) {
        log.debug("分页查询作业");
        try {
            Example example = new Example(WorkItem.class);
            Example.Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(query.getSubject())) {
                criteria.andLike("subject", "%" + query.getSubject() + "%");
            }
            if (!StringUtils.isEmpty(query.getDetail())) {
                criteria.andLike("detail", "%" + query.getDetail() + "%");
            }
            PageInfo<WorkItem> pageInfo = workItemService.selectByExampleList(example, query.getPageNum(), query.getPageSize());
            return getTableData(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), pageInfo);
        } catch (Exception e) {
            log.error("分页查询作业失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
    }

    @PostMapping("/workitem")
    @Override
    protected ResponseData<WorkItem> addRecord(@RequestBody WorkItem record) {
        log.debug("新增作业");
        try {
            record.setCreateTime(new Date());
            record.setCreatorId(accessTokenUtils.getUserInfo().getId());
            workItemService.addWorkItem(record);
            return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("新增作业失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
    }

    @DeleteMapping("/workitem")
    @Override
    protected ResponseData<WorkItem> deleteRecord(@RequestBody List<WorkItem> record) {
        log.debug("删除作业");
        try {
            workItemService.deleteWorkItem(record);
            return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("删除作业失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
    }

    @PutMapping("/workitem")
    @Override
    protected ResponseData<WorkItem> updateRecord(@RequestBody WorkItem record) {
        log.debug("修改作业");
        try {
            record.setUpdateTime(new Date());
            workItemService.updateByPrimaryKey(record);
            return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("修改作业失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
    }

    @PutMapping("/workitem/submit")
    public ResponseData<ItemMember> submitItem(@RequestBody ItemMember record) {
        log.debug("提交作业");
        try {
            record.setSubmitState(SimpleConst.one.getValue());
            record.setSubmitDate(new Date());
            itemMemberService.updateByPrimaryKeySelective(record);
            return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("提交作业失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
    }
}
