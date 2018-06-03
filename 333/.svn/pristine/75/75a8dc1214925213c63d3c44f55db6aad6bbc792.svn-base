package com.gcfd.service.contorller;


import com.gcfd.common.DataCenter;
import com.gcfd.common.EnumNetCode;
import com.gcfd.common.util.BigDecimalUtil;
import com.gcfd.common.util.ConnectionFactory;
import com.gcfd.common.util.UUIDUtil;
import com.gcfd.storage.dao.*;
import com.gcfd.storage.entity.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 智慧云餐厅消费场景
 */
@RestController
@RequestMapping(value = "/service/scr/scence/consume")
public class ScrScenceConsumeController {


    private static final Logger logger = LoggerFactory.getLogger(ScrScenceConsumeController.class);

    /**
     * 根据桌号获得用户标示和当前桌的订单信息
     * @param branchId
     * @param tableNo
     * @return
     */
    @RequestMapping(value = "/getUserSignAndOrderInfo/{branchId}/{tableNo}",method = RequestMethod.GET)
    public DataCenter<Object> getUserSignAndOrderInfo(@PathVariable("branchId") String branchId,@PathVariable("tableNo") String tableNo){
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            OrderInfo orderInfo = new OrderInfo();
            String userSign = null;
             //检查当前桌号是否有未完成的订单，若有，返回userId
            sqlsession = ConnectionFactory.getSessionFactory(branchId).openSession();
            OrderMapper orderMapper = sqlsession.getMapper(OrderMapper.class);
            Order order = orderMapper.selectByBranchIdAndTableNo(branchId,tableNo);
            if(order != null){
                userSign =  order.getClientId();
                orderInfo.setOrder(order);
                //根据orderId获得订单配送信息
                OrderDispatchingMapper orderDispatchingMapper = sqlsession.getMapper(OrderDispatchingMapper.class);
                orderInfo.setOrderDispatching(orderDispatchingMapper.getOrderDispatchingInfo(order.getOrderNo()));
                //根据orderId获得订单产品信息
                OrderProductDetailMapper orderProductDetailMapper = sqlsession.getMapper(OrderProductDetailMapper.class);
                orderInfo.setOrderProductDetailList(orderProductDetailMapper.getOrderProductList(order.getOrderNo()));
                //根据orderId获得订单费用信息
                OrderFeeDetailMapper orderFeeDetailMapper = sqlsession.getMapper(OrderFeeDetailMapper.class);
                orderInfo.setOrderFeeDetailList(orderFeeDetailMapper.getOrderFeeList(order.getOrderNo()));
                //此时没有支付信息，不获取支付信息
            }else{
                userSign = UUIDUtil.getUUID32();
            }
            orderInfo.setUserSign(userSign);
            netData.setData(orderInfo);
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
     * 获取机构的详细信息
     * @param branchId
     * @return
     */
    @RequestMapping(value = "/getBranchAndTableInfo/{branchId}/{tableNo}",method = RequestMethod.GET)
    public DataCenter<Object> getBranchAndTableInfo(@PathVariable("branchId") String branchId,@PathVariable("tableNo") String tableNo) {
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(branchId).openSession();
            SysBranchMapper sysBranchMapper = sqlsession.getMapper(SysBranchMapper.class);
            SysBranch sysBranch = sysBranchMapper.selectByBranchId(branchId);
            SrcTableMapper srcTableMapper = sqlsession.getMapper(SrcTableMapper.class);
            SrcTable srcTable = srcTableMapper.getSrcTableInfoByTableNo(tableNo);
            Map<String,Object> dataMap = new HashMap<String,Object>();
            dataMap.put("branch",sysBranch);
            dataMap.put("table",srcTable);
            netData.setData(dataMap);
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
     *
     * 下单
     * @return
     */
    @RequestMapping(value="/order",method = RequestMethod.POST)
    public DataCenter<Object> order(String branchId, String userSign, String origOrderNo,String orderProductListStr,String tableNo, String tableName ,String orderFeeDetailListStr,String memo){
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(branchId).openSession(false);
            //1.处理订单产品列表
            String[] orderProductArr = orderProductListStr.split(";");
            List<OrderProductDetail> orderProductDetailList = new ArrayList<OrderProductDetail>();
            Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();
            for(int i = 0;i < orderProductArr.length;i ++){
               String[] tempStr = orderProductArr[i].split(",");
               OrderProductDetail orderProductDetail = new OrderProductDetail();
               orderProductDetail.setProductId(Integer.parseInt(tempStr[0]));
               orderProductDetail.setProductNo(tempStr[1]);
               orderProductDetail.setProductName(tempStr[2]);
               orderProductDetail.setOrigPrice(new BigDecimal(tempStr[3]));
               orderProductDetail.setSpecPrice(new BigDecimal(tempStr[4]));
               orderProductDetail.setAmount(Integer.parseInt(tempStr[5]));
               orderProductDetail.setIsPreferentialInOrder(tempStr[6]);
               orderProductDetailList.add(orderProductDetail);
               if(countMap.get(orderProductDetail.getProductId()) != null){
                   countMap.put(orderProductDetail.getProductId(),countMap.get(orderProductDetail.getProductId()) + orderProductDetail.getAmount());
               }else{
                   countMap.put(orderProductDetail.getProductId(),orderProductDetail.getAmount());
               }
            }
            //2.判断产品是否超出库存
            if(countMap != null){
                ProductMapper productMapper = sqlsession.getMapper(ProductMapper.class);
                for (Integer key:countMap.keySet()){
                    Product product = productMapper.getProductInfo(key);
                    if(product == null || countMap.get(key) > product.getMaxAmount()) {
                        netData.setNetCode(EnumNetCode.Q1001);
                        netData.setNetMessage(product.getProductName() + "已被点完！");
                        return netData;
                    }
                }
            }
            //3.获取订单编号
            String orderNo = null;
            boolean isAddProduct = false;
            if(origOrderNo != null && !"".equals(origOrderNo.trim())){
                orderNo = origOrderNo;
                isAddProduct = true;
            }else{
                orderNo = getNo();
            }
            //4.构建订单配送信息并插入
            if(! isAddProduct) {
                OrderDispatching orderDispatching = new OrderDispatching();
                orderDispatching.setOrderNo(orderNo);
                orderDispatching.setClientId(userSign);
                orderDispatching.setTableCode(tableNo);
                orderDispatching.setTableName(tableName);
                orderDispatching.setCreateTime(new Date());
                orderDispatching.setIsDel("F");
                OrderDispatchingMapper orderDispatchingMapper = sqlsession.getMapper(OrderDispatchingMapper.class);
                orderDispatchingMapper.insert(orderDispatching);
            }
            //5.构建订单产品明细和任务单信息并插入
            BigDecimal total = new BigDecimal(0);
            BigDecimal discountTotal = new BigDecimal(0);
            OrderProductDetailMapper orderProductDetailMapper = sqlsession.getMapper(OrderProductDetailMapper.class);
            WorkOrderMapper workOrderMapper = sqlsession.getMapper(WorkOrderMapper.class);
            for (OrderProductDetail orderProductDetail: orderProductDetailList) {
                orderProductDetail.setOrderNo(orderNo);
                orderProductDetail.setCreateTime(new Date());
                orderProductDetail.setRealTotal(BigDecimalUtil.multiply(orderProductDetail.getSpecPrice(),new BigDecimal(orderProductDetail.getAmount())));
                orderProductDetail.setIsDel("F");
                orderProductDetailMapper.insert(orderProductDetail);
                total = BigDecimalUtil.add(total,orderProductDetail.getRealTotal());
                if("T".equals(orderProductDetail.getIsPreferentialInOrder())){
                    discountTotal =  BigDecimalUtil.add(total,orderProductDetail.getRealTotal());
                }
                //创建任务单
                //后厨工作单
                WorkOrder workOrder = new WorkOrder();
                workOrder.setOrderNo(orderNo);
                workOrder.setProductId(orderProductDetail.getProductId());
                workOrder.setProductNo(orderProductDetail.getProductNo());
                workOrder.setProductAmount(orderProductDetail.getAmount());
                workOrder.setWorkOrderType("1");
                workOrder.setCreateTime(new Date());
                workOrder.setWorkOrderStatus("1");
                workOrder.setWorkOrderNo("C" + getNo());
                workOrder.setIsDel("F");
                workOrderMapper.insert(workOrder);
                //服务员工作单
                WorkOrder _workOrder = new WorkOrder();
                _workOrder.setOrderNo(orderNo);
                _workOrder.setProductId(orderProductDetail.getProductId());
                _workOrder.setProductNo(orderProductDetail.getProductNo());
                _workOrder.setProductAmount(orderProductDetail.getAmount());
                _workOrder.setWorkOrderType("2");
                _workOrder.setCreateTime(new Date());
                _workOrder.setWorkOrderStatus("1");
                _workOrder.setWorkOrderNo("W" + getNo());
                _workOrder.setIsDel("F");
                workOrderMapper.insert(_workOrder);
            }
            //7.构建费用明细并插入
            OrderFeeDetailMapper orderFeeDetailMapper = sqlsession.getMapper(OrderFeeDetailMapper.class);
            if(orderFeeDetailListStr != null && !"".equals(orderFeeDetailListStr.trim())){
                String[] orderFeeArr = orderFeeDetailListStr.split(";");
                for(int i = 0;i < orderFeeArr.length;i ++){
                    String[] tempStr = orderFeeArr[i].split(",");
                    OrderFeeDetail orderFeeDetail = new OrderFeeDetail();
                    orderFeeDetail.setFeeId(Integer.parseInt(tempStr[0]));
                    orderFeeDetail.setFeeNo(tempStr[1]);
                    orderFeeDetail.setFeeName(tempStr[2]);
                    orderFeeDetail.setOrigPrice(new BigDecimal(tempStr[3]));
                    orderFeeDetail.setSpecPrice(orderFeeDetail.getOrigPrice());
                    orderFeeDetail.setAmount(Integer.parseInt(tempStr[4]));
                    orderFeeDetail.setRealTotal(BigDecimalUtil.multiply(orderFeeDetail.getSpecPrice(),new BigDecimal(orderFeeDetail.getAmount())));
                    orderFeeDetail.setOrderNo(orderNo);
                    orderFeeDetail.setIsDel("F");
                    orderFeeDetailMapper.insert(orderFeeDetail);
                    total = BigDecimalUtil.add(total,orderFeeDetail.getRealTotal());
                }
            }
            //如果有折扣活动,构建折扣费用
            ActivityMapper activityMapper = sqlsession.getMapper(ActivityMapper.class);
            Activity activity = activityMapper.getOrderDiscountActivity(branchId);
            if(activity != null){
                OrderFeeDetail orderFeeDetail = new OrderFeeDetail();
                orderFeeDetail.setFeeId(2);
                orderFeeDetail.setFeeNo("F002");
                orderFeeDetail.setFeeName("订单折扣");
                orderFeeDetail.setOrigPrice(BigDecimalUtil.subtract(BigDecimalUtil.multiply(discountTotal,activity.getDiscount()),discountTotal));
                orderFeeDetail.setSpecPrice(orderFeeDetail.getOrigPrice());
                orderFeeDetail.setAmount(1);
                orderFeeDetail.setRealTotal(orderFeeDetail.getOrigPrice());
                orderFeeDetail.setOrderNo(orderNo);
                orderFeeDetail.setIsDel("F");
                orderFeeDetailMapper.insert(orderFeeDetail);
                total = BigDecimalUtil.add(total,orderFeeDetail.getRealTotal());
            }
            //8.如果是加菜，更新订单，否则，插入订单
            OrderMapper orderMapper = sqlsession.getMapper(OrderMapper.class);
            if(isAddProduct) {
                Order order = orderMapper.selectByOrderNo(orderNo);
                order.setLstModifyTime(new Date());
                order.setTotal( BigDecimalUtil.add(order.getTotal(),total));
                order.setMemo(memo);
                orderMapper.updateByPrimaryKey(order);
            }else{
                Order order = new Order();
                order.setBranchId(branchId);
                order.setOrderNo(orderNo);
                order.setMemo(memo);
                order.setClientId(userSign);
                order.setOrderType("1");
                order.setTotal(total);
                order.setOrderStatus("1");
                order.setCreateTime(new Date());
                order.setIsDel("F");
                orderMapper.insert(order);
            }
            netData.setNetCode(EnumNetCode.I1000);
            sqlsession.commit();
        }catch (Exception e) {
            netData.setNetCode(EnumNetCode.I1002);
            logger.error("发生异常，异常信息如下：" + e.getLocalizedMessage());
            e.printStackTrace();
            if(sqlsession != null){
                sqlsession.rollback();
            }
        }finally {
            if(sqlsession != null){
                sqlsession.close();
            }
        }
        return netData;

    }

    /**
     * 获取机构的活动信息
     * @param branchId
     * @return
     */
    @RequestMapping(value = "/getBranchActivityInfo/{branchId}",method = RequestMethod.GET)
    public DataCenter<Object> getBranchActivityInfo(@PathVariable("branchId") String branchId) {
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(branchId).openSession();
            ActivityMapper activityMapper = sqlsession.getMapper(ActivityMapper.class);
            List<Activity> activityList = activityMapper.getCurActivity(branchId);
            netData.setData(activityList);
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
     * 获取机构的固定费用信息
     * @param branchId
     * @return
     */
    @RequestMapping(value = "/getBranchFixedFeeList/{branchId}",method = RequestMethod.GET)
    public DataCenter<Object> getBranchFixedFeeList(@PathVariable("branchId") String branchId) {
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(branchId).openSession();
            FeeMapper feeMapper = sqlsession.getMapper(FeeMapper.class);
            List<Fee> feeList = feeMapper.getBranchFixedFeeList(branchId);
            netData.setData(feeList);
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
     * 获取机构的订单标签信息
     * @param branchId
     * @return
     */
    @RequestMapping(value = "/getBranchLabelInfo/{branchId}",method = RequestMethod.GET)
    public DataCenter<Object> getBranchLabelInfo(@PathVariable("branchId") String branchId) {
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(branchId).openSession();
            OrderLabelMapper orderLabelMapper = sqlsession.getMapper(OrderLabelMapper.class);
            List<OrderLabel> orderLabelList = orderLabelMapper.getCurLabel(branchId);
            netData.setData(orderLabelList);
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
     * 获得机构的菜单信息
     * @param branchId
     * @param keyWords
     * @return
     */
    @RequestMapping(value = "/getProductMenu",method = RequestMethod.POST)
    public DataCenter<Object> getProductMenu(String branchId,String keyWords){
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(branchId).openSession();
            //获得机构的产品信息
            ProductMapper productMapper = sqlsession.getMapper(ProductMapper.class);
            if("ALL".equals(keyWords)){
                keyWords = null;
            }
            List<Product> productList = productMapper.getBranchProductList(branchId,keyWords == null ? null : keyWords.trim());
            //获得机构产品的定价信息
            ProductPriceMapper productPriceMapper = sqlsession.getMapper(ProductPriceMapper.class);
            List<ProductPrice> productPriceList = productPriceMapper.getBranchProfuctPriceList();
            //构建菜单
            netData.setData(generateMenu(productList,productPriceList));
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
     * 构建菜单，考虑产品的区间定价
     * @param productList
     * @param productPriceList
     * @return
     */
    private List<ProductMenuInfo> generateMenu(List<Product> productList,List<ProductPrice> productPriceList){
       List<ProductMenuInfo> productMenuInfoList = new ArrayList<ProductMenuInfo>();
       //1.将产品价格清单列表转换为list
        Map<Integer,List<ProductPrice>> productPriceMap = new HashMap<Integer,List<ProductPrice>>();
        for (ProductPrice productPrice:productPriceList){
            if(productPriceMap.get(productPrice.getProductId()) == null){
                productPriceMap.put(productPrice.getProductId(),new ArrayList<ProductPrice>());
            }
            productPriceMap.get(productPrice.getProductId()).add(productPrice);
        }
        //遍历产品列表构建完整产品信息
        Integer counter;
        for (Product product:productList) {
            counter = 1;
            List<ProductPrice> productPriceListTemp = productPriceMap.get(product.getId());
            if(productPriceListTemp != null && productPriceListTemp.size() > 0) {
                for (int i = 0; i < productPriceListTemp.size() && counter < product.getMaxAmount(); i++) {
                    //如果计数器小于价格数量区间构建区间之下的价格
                    if (productPriceListTemp.get(i).getStartAmount() > counter) {
                        int startAmount = counter.intValue();
                        if (productPriceListTemp.get(i).getStartAmount() <= product.getMaxAmount()) {
                            counter = productPriceListTemp.get(i).getStartAmount() - 1;
                        } else {
                            counter = product.getMaxAmount();
                        }
                        productMenuInfoList.add(generateMenuInfo(product,startAmount,counter.intValue(),product.getProdcutPrice()));
                    }
                    //如果数量达到上线，退出本产品价格的区间构建
                    if (counter == product.getMaxAmount()) {
                        continue;
                    }
                    //构建价格区间内的价格
                    if (productPriceListTemp.get(i).getEndAmount() <= product.getMaxAmount()) {
                        counter = productPriceListTemp.get(i).getEndAmount();
                    } else {
                        counter = product.getMaxAmount();
                    }
                    productMenuInfoList.add(generateMenuInfo(product,productPriceListTemp.get(i).getStartAmount().intValue(),counter.intValue(),productPriceListTemp.get(i).getPrice()));
                    counter++;
                }
                //循环完还没有到上限
                if(counter < product.getMaxAmount()){
                    productMenuInfoList.add(generateMenuInfo(product,counter.intValue(),product.getMaxAmount().intValue(),product.getProdcutPrice()));
                }
            }else{
                //没有特殊定价，以原价为最终定价
                productMenuInfoList.add(generateMenuInfo(product,1,product.getMaxAmount().intValue(),product.getProdcutPrice()));
            }

        }
        return productMenuInfoList;
    }

    /**
     * 构建菜单
     * @param product
     * @param startAmount
     * @param endAmount
     * @param realPrice
     * @return
     */
    private ProductMenuInfo generateMenuInfo(Product product, int startAmount, int endAmount, BigDecimal realPrice){
        ProductMenuInfo productMenuInfo = new ProductMenuInfo();
        productMenuInfo.setStartAmount(startAmount);
        productMenuInfo.setEndAmount(endAmount);
        productMenuInfo.setProdcutRealPrice(realPrice);
        productMenuInfo.setId(product.getId());
        productMenuInfo.setIsPreferentialInOrder(product.getIsPreferentialInOrder());
        productMenuInfo.setProductAttributeType(product.getProductAttributeType());
        productMenuInfo.setProductBussinessType(product.getProductBussinessType());
        productMenuInfo.setProdcutPrice(product.getProdcutPrice());
        productMenuInfo.setProductDesc(product.getProductDesc());
        productMenuInfo.setProductName(product.getProductName());
        productMenuInfo.setProductNo(product.getProductNo());
        productMenuInfo.setProductSpecification(product.getProductSpecification());
        productMenuInfo.setProductUnit(product.getProductUnit());
        productMenuInfo.setProductAttributeTypeName(product.getProductAttributeTypeName());
        productMenuInfo.setProductCover(product.getProductCover());
        return productMenuInfo;
    }

    /**
     * 获取订单编号
     * @return
     */
    private String getNo(){
        return (new StringBuffer().append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())).append(new Random().nextInt(9999))).toString();

    }

}
