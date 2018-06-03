package com.gcfd.service.contorller;

import com.gcfd.common.DataCenter;
import com.gcfd.common.EnumNetCode;
import com.gcfd.common.util.ConnectionFactory;
import com.gcfd.service.UserUtil;
import com.gcfd.storage.dao.OrderMapper;
import com.gcfd.storage.entity.Order;
import com.gcfd.storage.entity.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 智慧云餐厅产品应用
 */
@RestController
@RequestMapping(value = "/service/scr/app/waiter")
public class ScrAppWaiterController {
    private static final Logger logger = LoggerFactory.getLogger(ScrAppSysController.class);
    /**
     * 获取服务员未完成列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/getWaiteringOrderList",method = {RequestMethod.GET})
    public DataCenter<Object> getWaiteringOrderList(HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            OrderMapper orderMapper = sqlsession.getMapper(OrderMapper.class);
            List<Order> orderList= orderMapper.getWaiteringOrderList();
            netData.setData(orderList);
            netData.setNetCode(EnumNetCode.Q1001);
        }catch (Exception e) {
            netData.setNetCode(EnumNetCode.Q1002);
            logger.error("发生异常，异常信息如下：" + e.getLocalizedMessage());
            e.printStackTrace();
        }finally {
            if(sqlsession != null){
                sqlsession.close();
            }
        }
        return netData;
    }
    /**
     * 获取服务员已完成列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/getWaiteredOrderList",method = {RequestMethod.POST})
    public DataCenter<Object> getWaiteredOrderList(@RequestBody DataCenter<Order> dataCenter, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        DataCenter<Object> queryResult = new DataCenter<>();
        if (dataCenter==null) {
            queryResult.setNetCode(EnumNetCode.C3002);
        }else {
            queryResult.setPageNum(dataCenter.getPageNum());
            queryResult.setPageSize(dataCenter.getPageSize());
            SqlSession sqlsession = null;
            try{
                sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
                OrderMapper orderMapper = sqlsession.getMapper(OrderMapper.class);
                queryResult.setData(orderMapper.getWaiteredOrderList(dataCenter));
                queryResult.setRowCount(orderMapper.getWaiteredOrderCount());
                queryResult.setNetCode(EnumNetCode.Q1001);
            }catch (Exception e) {
                queryResult.setNetCode(EnumNetCode.Q1002);
                logger.error("发生异常，异常信息如下：" + e.getLocalizedMessage());
                e.printStackTrace();
            }
            finally {
                if(sqlsession != null){
                    sqlsession.close();
                }
            }
        }
        return queryResult;
    }
}
