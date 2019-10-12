package com.schoolassistant.homework.provider.controller;

import com.github.pagehelper.PageInfo;
import com.schoolassistant.homework.api.mapper.model.ClassInfo;
import com.schoolassistant.homework.api.mapper.model.ClassStudentList;
import com.schoolassistant.homework.api.pojo.ClassInfoRequest;
import com.schoolassistant.homework.provider.service.ClassInfoService;
import com.schoolassistant.homework.provider.service.ClassStudentListService;
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
public class ClassInfoController extends CrudController<ClassInfo, ClassInfoRequest> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClassInfoService classInfoService;

    @Autowired
    private ClassStudentListService classStudentListService;

    @Autowired
    private AccessTokenUtils accessTokenUtils;

    @GetMapping("/classinfo/studentlist/{classId}")
    public ResponseData<List<ClassStudentList>> getStudentListByClassId(@PathVariable Long classId) {
        logger.debug("按班级ID查询班级学生名单");
        try{
            Example example = new Example(ClassStudentList.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("classId", classId);
            return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), classStudentListService.selectByExample(example));
        }catch (Exception e) {
            logger.error("按班级ID查询班级学生名单失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
    }

    @DeleteMapping("/classinfo/studentlist")
    public ResponseData<ClassStudentList> deleteStudentList(@RequestBody List<ClassStudentList> record) {
        logger.debug("删除班级学生名单");
        try {
            classStudentListService.deleteBatchByPrimaryKey(record);
        } catch (Exception e) {
            logger.error("删除学生名单出错：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    @PutMapping("/classinfo/studentlist")
    public ResponseData<ClassStudentList> updateStudentList(@RequestBody ClassStudentList record) {
        logger.debug("修改班级学生名单");
        try {
            record.setUpdateTime(new Date());
            classStudentListService.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            logger.error("更新班级学生名单出错：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    @PostMapping("/classinfo/studentlist")
    public ResponseData<ClassStudentList> addStudentList(@RequestBody List<ClassStudentList> record) {
        logger.debug("添加班级学生名单");
        try {
            record.forEach(r -> {
                r.setCreateTime(new Date());
                r.setCreatorId(accessTokenUtils.getUserInfo().getId());
            });
            classStudentListService.batchInsertSelective(record);
        } catch (Exception e) {
            logger.error("添加班级学生名单失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    @GetMapping("/classinfo/table")
    @Override
    protected ResponseData<TableData<ClassInfo>> queryRecord(@RequestBody ClassInfoRequest query) {
        logger.debug("分页查询班级信息");
        Example example = new Example(ClassInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(query.getSchoolName())) {
            criteria.andLike("schoolName", "%" + query.getSchoolName() + "%");
        }
        if (!StringUtils.isEmpty(query.getContactTel())) {
            criteria.andLike("contactTel", "%" + query.getContactTel() + "%");
        }
        PageInfo<ClassInfo> pageInfo = classInfoService.selectByExampleList(example, query.getPageNum(), query.getPageSize());
        return getTableData(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), pageInfo);
    }

    @PostMapping("/classinfo")
    @Override
    protected ResponseData<ClassInfo> addRecord(@RequestBody ClassInfo record) {
        logger.debug("添加班级信息");
        try {
            record.setCreateTime(new Date());
            record.setCreatorId(accessTokenUtils.getUserInfo().getId());
            classInfoService.insertSelective(record);
        } catch (Exception e) {
            logger.error("添加班级信息失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }


    @DeleteMapping("/classinfo")
    @Override
    protected ResponseData<ClassInfo> deleteRecord(@RequestBody List<ClassInfo> record) {
        logger.debug("删除班级信息");
        try {
            classInfoService.deleteBatchByPrimaryKey(record);
        } catch (Exception e) {
            logger.error("删除班级信息失败", e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    @PutMapping("/classinfo")
    @Override
    protected ResponseData<ClassInfo> updateRecord(@RequestBody ClassInfo record) {
        logger.debug("修改班级信息");
        try {
            record.setUpdateTime(new Date());
            classInfoService.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            logger.error("修改班级信息失败", e.getMessage());
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    @GetMapping("/classinfo/list/{userId}")
    public ResponseData<List<ClassInfo>> getClassInfoByUserId(@PathVariable("userId") Long userId) {
        logger.debug("查询用户创建的班级列表");
        try {
            Example example = new Example(ClassInfo.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("creatorId", userId);
            return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), classInfoService.selectByExample(example));
        } catch (Exception e) {
            logger.error("查询用户创建的班级列表失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
    }
}
