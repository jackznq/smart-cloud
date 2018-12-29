package com.schoolassistant.homework.provider.service;

import com.peng.db.spring.boot.autoconfigure.service.BaseService;
import com.schoolassistant.homework.api.constant.SimpleConst;
import com.schoolassistant.homework.api.mapper.model.ClassStudentList;
import com.schoolassistant.homework.api.mapper.model.GroupMember;
import com.schoolassistant.homework.api.mapper.model.ItemMember;
import com.schoolassistant.homework.api.mapper.model.WorkItem;
import com.schoolassistant.homework.provider.mapper.mapper.ClassStudentListMapper;
import com.schoolassistant.homework.provider.mapper.mapper.GroupMemberMapper;
import com.schoolassistant.homework.provider.mapper.mapper.ItemMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class WorkItemService extends BaseService<WorkItem> {

    @Autowired
    private ClassStudentListMapper classStudentListMapper;

    @Autowired
    private GroupMemberMapper groupMemberMapper;

    @Autowired
    private ItemMemberMapper itemMemberMapper;

    @Transactional
    public void addWorkItem(WorkItem workItem) {
        this.insertSelective(workItem);
        Example example = new Example(ClassStudentList.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("creatorId", workItem.getCreatorId());
        Long classId = classStudentListMapper.selectByExample(example).get(0).getId();
        example = new Example(GroupMember.class);
        criteria = example.createCriteria();
        criteria.andEqualTo("creatorId", workItem.getCreatorId());
        Long groupId = groupMemberMapper.selectByExample(example).get(0).getGroupId();
        Long userId = workItem.getCreatorId();
        //如果作业要发布到班级或小组中
        if (workItem.getRelease().equals(SimpleConst.one.getValue())) {
            //如果发布到班级中
            if (workItem.getWorkType().equals(SimpleConst.one.getValue()) && classId != null) {
                example = new Example(ClassStudentList.class);
                criteria = example.createCriteria();
                criteria.andEqualTo("classId", classId);
                List<ClassStudentList> classStudentList = classStudentListMapper.selectByExample(example);
                classStudentList.forEach(c -> {
                    ItemMember member = new ItemMember();
                    member.setClassId(classId);
                    member.setCreateTime(new Date());
                    member.setStudentId(c.getId());
                    member.setUserId(userId);
                    member.setSubmitState(SimpleConst.zero.getValue());
                    member.setWorkItemId(workItem.getId());
                    itemMemberMapper.insertSelective(member);
                });
            } else if (workItem.getWorkType().equals(SimpleConst.zero.getValue()) && groupId != null) {
                //如果发布到小组中
                example = new Example(GroupMember.class);
                criteria = example.createCriteria();
                criteria.andEqualTo("groupId", groupId);
                List<GroupMember> groupMembers = groupMemberMapper.selectByExample(example);
                groupMembers.forEach(g -> {
                    ItemMember member = new ItemMember();
                    member.setWorkItemId(workItem.getId());
                    member.setUserId(userId);
                    member.setStudentId(g.getStudentId());
                    member.setGroupId(g.getGroupId());
                    member.setSubmitState(SimpleConst.zero.getValue());
                    member.setCreateTime(new Date());
                    itemMemberMapper.insertSelective(member);
                });
            }
        } else {
            //仅记录下来作为自己的作业
            ClassStudentList classStudentList = new ClassStudentList();
            classStudentList.setCreatorId(userId);
            classStudentList.setClassId(classId);
            classStudentList = classStudentListMapper.selectOne(classStudentList);
            ItemMember member = new ItemMember();
            member.setWorkItemId(workItem.getId());
            member.setUserId(userId);
            member.setStudentId(classStudentList.getId());
            member.setSubmitState(SimpleConst.zero.getValue());
            member.setCreateTime(new Date());
            itemMemberMapper.insertSelective(member);
        }
    }

    @Transactional
    public void deleteWorkItem(List<WorkItem> record) {
        record.forEach(r -> {
            Long workItemId = r.getId();
            Example example = new Example(ItemMember.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("workItemId", workItemId);
            itemMemberMapper.deleteByExample(example);
            this.delete(r);
        });
    }
}
