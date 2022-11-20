package com.houli.pms.sync.task.dao;

import com.houli.pms.sync.task.entity.PmdEmployees;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 评价人员表 Mapper 接口
 * </p>
 * @author hansy
 * @since 2022-03-28
 */
@Mapper
public interface PmdEmployeesMapper{

    List<PmdEmployees> getList();
}
