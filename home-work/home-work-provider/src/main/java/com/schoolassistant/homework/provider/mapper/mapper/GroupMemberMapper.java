package com.schoolassistant.homework.provider.mapper.mapper;

import com.schoolassistant.homework.api.mapper.model.GroupMember;
import org.springframework.data.repository.query.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface GroupMemberMapper extends Mapper<GroupMember> {


    List<GroupMember> getGroupMember(@Param("groupId") Long groupId);

}
