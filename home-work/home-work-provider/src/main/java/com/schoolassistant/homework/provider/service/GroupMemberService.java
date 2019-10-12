package com.schoolassistant.homework.provider.service;

import com.schoolassistant.homework.api.mapper.model.GroupMember;
import com.schoolassistant.homework.provider.mapper.mapper.GroupMemberMapper;
import com.smartcloud.db.spring.boot.autoconfigure.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMemberService extends BaseService<GroupMember> {

    public List<GroupMember> getGroupMember(Long groupId) {
        return ((GroupMemberMapper)mapper).getGroupMember(groupId);
    }

    public void batchInsertSelective(List<GroupMember> record) {
        record.forEach(r->{
            this.insertSelective(r);
        });
    }
}
