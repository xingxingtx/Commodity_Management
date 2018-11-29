package com.wei.service.syslog.impl;/**
 * Created by Administrator on 2018/11/29.
 */

import com.wei.mapper.syslog.SyslogMapper;
import com.wei.model.syslog.SysLog;
import com.wei.service.base.impl.BaseServiceImpl;
import com.wei.service.syslog.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:SysLogServiceImpl
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/11/29 10:42
 * @Version: 1.0
 */
@Service
public class SysLogServiceImpl extends BaseServiceImpl<SyslogMapper,SysLog> implements ISysLogService {
    @Autowired
    private SyslogMapper mapper;


}
