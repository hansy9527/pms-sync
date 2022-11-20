package com.houli.pms.sync.task.task;

import com.houli.pms.sync.task.dao.PmdEmployeesMapper;
import com.houli.pms.sync.task.dao2.PmdEmployeesMapper2;
import com.houli.pms.sync.task.entity.PmdEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
public class TestTask {
    @Autowired
    private PmdEmployeesMapper pmdEmployeesMapper;
    @Autowired
    private PmdEmployeesMapper2 pmdEmployeesMapper2;

    @Scheduled(cron = "0/5 * * * * ?")
    public void excute(){
        List<PmdEmployees> pmdEmployeesList = pmdEmployeesMapper.getList();
        List<PmdEmployees> pmdEmployeesList2 = pmdEmployeesMapper2.getList();

    }

}