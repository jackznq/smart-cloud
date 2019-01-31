package com.schoolassistant.homework.provider.service;

import com.smartcloud.db.spring.boot.autoconfigure.service.BaseService;
import com.schoolassistant.homework.api.mapper.model.ClassStudentList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassStudentListService extends BaseService<ClassStudentList> {


    @Transactional
    public void batchInsertSelective(List<ClassStudentList> record) {
        record.forEach(r->{
            this.insertSelective(r);
        });

    }
}
