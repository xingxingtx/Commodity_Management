package com.wei.mapper.syslog;/**
 * Created by Administrator on 2018/11/29.
 */

import com.wei.mapper.base.BaseMapper;
import com.wei.model.syslog.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
/**
 * @ClassName:SyslogMapper
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/11/29 11:34
 * @Version: 1.0
 */
@Mapper
@Component
public interface SyslogMapper extends BaseMapper<SysLog>{

}
