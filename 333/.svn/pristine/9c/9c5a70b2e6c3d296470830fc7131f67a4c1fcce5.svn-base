package com.gcfd.service.contorller;


import com.gcfd.common.DataCenter;
import com.gcfd.common.EnumNetCode;
import com.gcfd.common.util.ConnectionFactory;
import com.gcfd.common.util.UUIDUtil;
import com.gcfd.storage.dao.*;
import com.gcfd.storage.entity.*;
import com.gcfd.service.UserUtil;
import com.gcfd.storage.entity.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 智慧云餐厅订单应用
 */
@RestController
@RequestMapping(value = "/service/scr/app/order")
public class ScrAppOrderController {

    private static final Logger logger = LoggerFactory.getLogger(ScrAppOrderController.class);

    /**
     * 新增桌号信息
     * @param tableName
     * @param seq
     * @param request
     * @return
     */
    @RequestMapping(value = "/insertTable",method = {RequestMethod.POST})
    public DataCenter<Object> insertTable(String tableName,Integer seq, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession(false);
            SrcTable srcTable = new SrcTable();
            srcTable = new SrcTable();
            srcTable.setBranchId(sysUser.getBranchId());
            srcTable.setCreateTime(new Date());
            srcTable.setCreateUserId(sysUser.getUserId());
            srcTable.setIsDel("F");
            srcTable.setSeq(seq);
            srcTable.setTableName(tableName);
            srcTable.setTableCode(UUIDUtil.getUUID32());
            SrcTableMapper srcTableMapper = sqlsession.getMapper(SrcTableMapper.class);
            srcTableMapper.insert(srcTable);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.I1000);
        }catch (Exception e) {
            sqlsession.rollback();
            netData.setNetCode(EnumNetCode.I1002);
            logger.error("发生异常，异常信息如下：" + e.getLocalizedMessage());
            e.printStackTrace();
        }finally {
            if(sqlsession != null){
                sqlsession.close();
            }
        }
        return netData;
    }

//
//    @RequestMapping(value = "/getTableList",method = {RequestMethod.GET})
//    public DataCenter<Object> getTableList(HttpServletRequest request) {
//
//    }
//


}
