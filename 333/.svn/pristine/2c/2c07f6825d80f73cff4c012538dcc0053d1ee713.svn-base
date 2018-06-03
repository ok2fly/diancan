package com.gcfd.service.contorller;

import com.gcfd.common.DataCenter;
import com.gcfd.common.EnumNetCode;
import com.gcfd.common.util.ConnectionFactory;
import com.gcfd.common.util.UUIDUtil;
import com.gcfd.common.util.UploadFileUtil;
import com.gcfd.service.UserUtil;
import com.gcfd.storage.dao.*;
import com.gcfd.storage.entity.*;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value = "/service/scr/app/product")
public class ScrAppProductController {
    private static final Logger logger = LoggerFactory.getLogger(ScrAppSysController.class);
    /**
     * 获取产品限单列表
     * @param isDel
     * @param keywords
     * @param request
     * @return
     */
    @RequestMapping(value = "/getProductLimitList",method = {RequestMethod.GET})
    public DataCenter<Object> getProductLimitList(String isDel,String keywords,HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            ProductMapper productMapper = sqlsession.getMapper(ProductMapper.class);
            List<Product> productList= productMapper.getProductLimitList(isDel,keywords);
            netData.setData(productList);
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
     * 修改产品数量限制
     * @param productAmountLimit
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateProductAmountLimit",method = {RequestMethod.GET})
    public DataCenter<Object> updateProductAmountLimit(ProductAmountLimit productAmountLimit,HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);

        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            productAmountLimit.setLstModifyUserId(sysUser.getUserId());
            ProductAmountLimitMapper limitMapper=sqlsession.getMapper(ProductAmountLimitMapper.class);
            limitMapper.updateByPrimaryKey(productAmountLimit);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.UP1001);
        }catch (Exception e) {
            netData.setNetCode(EnumNetCode.UP1002);
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
     * 获取产品列表
     * @param productBussinessType
     * @param keywords
     * @param request
     * @return
     */
    @RequestMapping(value = "/getProductList",method = {RequestMethod.GET})
    public DataCenter<Object> getProductList(String productBussinessType,String keywords,HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            System.err.println(sysUser.getBranchId());
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            ProductMapper productMapper = sqlsession.getMapper(ProductMapper.class);
            List<Product> productList= productMapper.getProductList(productBussinessType,keywords);
            netData.setData(productList);
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
     * 根据id获取产品信息
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/getProductById",method = {RequestMethod.GET})
    public DataCenter<Object> getProductById(int id,HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            ProductMapper productMapper = sqlsession.getMapper(ProductMapper.class);
            Product product= productMapper.selectByPrimaryKey(id);
            netData.setData(product);
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
     * 修改产品信息
     * @param product
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateProduct",method = {RequestMethod.POST})
    public DataCenter<Object> updateProduct(Product product,HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            ProductMapper productMapper = sqlsession.getMapper(ProductMapper.class);
            product.setLstModifyUserId(sysUser.getUserId());
            productMapper.updateByPrimaryKeySelective(product);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.UP1001);
        }catch (Exception e) {
            netData.setNetCode(EnumNetCode.UP1002);
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
     * 新增产品信息
     * @param product
     * @param request
     * @return
     */
    @RequestMapping(value = "/insertProduct",method = {RequestMethod.POST})
    public DataCenter<Object> insertProduct(Product product,HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        String fileName=UUIDUtil.getUUID32()+"jpg";
        //上传产品图片
        UploadFileUtil.uploadFile(request,fileName);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession(false);
            ProductMapper productMapper = sqlsession.getMapper(ProductMapper.class);
            product.setProductNo("P"+String.format("%019d",productMapper.getMaxProductNo()));
            if (null==product.getIsPreferentialInOrder()||"".equals(product.getIsPreferentialInOrder())){
                product.setIsPreferentialInOrder("F");
            }
            product.setCreateUserId(sysUser.getUserId());
            product.setProductCover(fileName);
            product.setLstModifyUserId(sysUser.getUserId());
            productMapper.insertSelective(product);

            ProductAmountLimit limit=new ProductAmountLimit();
            limit.setProductId(product.getId());
            limit.setProductNo(product.getProductNo());
            limit.setCreateUserId(sysUser.getUserId());
            limit.setLimitAmount(100);
            limit.setLstModifyUserId(sysUser.getUserId());
            ProductAmountLimitMapper limitMapper=sqlsession.getMapper(ProductAmountLimitMapper.class);
            limitMapper.insert(limit);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.I1000);
        }catch (Exception e) {
            sqlsession.rollback();
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
     * 新增产品区间价格
     * @param productPrice
     * @param request
     * @return
     */
    @RequestMapping(value = "/insertProductPrice",method = {RequestMethod.GET})
    public DataCenter<Object> insertProductPrice(ProductPrice productPrice,HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);

        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            productPrice.setCreateUserId(sysUser.getUserId());
            productPrice.setLstModifyUserId(sysUser.getUserId());
            ProductPriceMapper productPriceMapper=sqlsession.getMapper(ProductPriceMapper.class);
            productPriceMapper.insert(productPrice);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.I1000);
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
     * 修改产品区间价格
     * @param productPrice
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateProductPrice",method = {RequestMethod.GET})
    public DataCenter<Object> updateProductPrice(ProductPrice productPrice,HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);

        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            productPrice.setLstModifyUserId(sysUser.getUserId());
            ProductPriceMapper productPriceMapper=sqlsession.getMapper(ProductPriceMapper.class);
            productPriceMapper.updateByPrimaryKey(productPrice);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.UP1001);
        }catch (Exception e) {
            netData.setNetCode(EnumNetCode.UP1002);
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
     * 获得产品区间价格列表
     * @param productId
     * @param request
     * @return
     */
    @RequestMapping(value = "/getProductPriceListByProductId",method = {RequestMethod.GET})
    public DataCenter<Object> getProductPriceListByProductId(Integer productId,HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);

        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            ProductPriceMapper productPriceMapper=sqlsession.getMapper(ProductPriceMapper.class);
            netData.setData(productPriceMapper.getProductPriceListByProductId(productId));
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
     * 获取产品商业属性列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/getProductBussinessTypeList",method = {RequestMethod.GET})
    public DataCenter<Object> getProductBussinessTypeList(HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            SysDictMapper sysDictMapper = sqlsession.getMapper(SysDictMapper.class);
            List<SysDict> sysDictList= sysDictMapper.getAllSysDictByCode("productBussinessType");
            netData.setData(sysDictList);
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
     * 获取产品商业属性
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/getProductBussinessTypeById",method = {RequestMethod.GET})
    public DataCenter<Object> getProductBussinessTypeById(String id, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            SysDictMapper sysDictMapper = sqlsession.getMapper(SysDictMapper.class);
            SysDict sysDict=sysDictMapper.selectByPrimaryKey("productBussinessType",id);
            netData.setData(sysDict);
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
     * 新增产品商业属性
     * @param name
     * @param description
     * @param num
     * @param request
     * @return
     */
    @RequestMapping(value = "/insertProductBussinessType",method = {RequestMethod.POST})
    public DataCenter<Object> insertProductBussinessType(String name,String description,int num, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            SysDict sysDict=new SysDict();
            sysDict.setName(name);
            sysDict.setDescription(description);
            sysDict.setNum(num);
            sysDict.setCode("productBussinessType");
            sysDict.setCreateUserId(sysUser.getUserId());
            sysDict.setLstModifyUserId(sysUser.getUserId());
            sysDict.setBranchId(sysUser.getBranchId());

            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            SysDictMapper sysDictMapper = sqlsession.getMapper(SysDictMapper.class);
            sysDictMapper.insert(sysDict);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.I1000);
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
     * 修改产品商业属性
     * @param id
     * @param name
     * @param description
     * @param num
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateProductBussinessTypeById",method = {RequestMethod.POST})
    public DataCenter<Object> updateProductBussinessTypeById(String id,String name,String description,int num,String isDel, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            SysDict sysDict=new SysDict();
            sysDict.setId(id);
            sysDict.setIsDel(isDel);
            sysDict.setName(name);
            sysDict.setDescription(description);
            sysDict.setNum(num);
            sysDict.setCode("productBussinessType");
            sysDict.setLstModifyUserId(sysUser.getUserId());
            sysDict.setBranchId(sysUser.getBranchId());

            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            SysDictMapper sysDictMapper = sqlsession.getMapper(SysDictMapper.class);
            sysDictMapper.updateByPrimaryKeySelective(sysDict);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.UP1001);
        }catch (Exception e) {
            netData.setNetCode(EnumNetCode.UP1002);
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
     * 获取产品属性列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/getProductAttributeTypeList",method = {RequestMethod.GET})
    public DataCenter<Object> getProductAttributeTypeList(HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            SysDictMapper sysDictMapper = sqlsession.getMapper(SysDictMapper.class);
            List<SysDict> sysDictList= sysDictMapper.getAllSysDictByCode("productAttributeType");
            netData.setData(sysDictList);
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
     * 获取产品属性
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/getProductAttributeTypeById",method = {RequestMethod.GET})
    public DataCenter<Object> getProductAttributeTypeById(String id, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            SysDictMapper sysDictMapper = sqlsession.getMapper(SysDictMapper.class);
            SysDict sysDict=sysDictMapper.selectByPrimaryKey("productAttributeType",id);
            netData.setData(sysDict);
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
     * 新增产品属性
     * @param name
     * @param description
     * @param num
     * @param request
     * @return
     */
    @RequestMapping(value = "/insertProductAttributeType",method = {RequestMethod.POST})
    public DataCenter<Object> insertProductAttributeType(String name,String description,int num, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            SysDict sysDict=new SysDict();
            sysDict.setName(name);
            sysDict.setDescription(description);
            sysDict.setNum(num);
            sysDict.setCode("productAttributeType");
            sysDict.setCreateUserId(sysUser.getUserId());
            sysDict.setLstModifyUserId(sysUser.getUserId());
            sysDict.setBranchId(sysUser.getBranchId());

            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            SysDictMapper sysDictMapper = sqlsession.getMapper(SysDictMapper.class);
            sysDictMapper.insert(sysDict);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.I1000);
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
     * 修改产品属性
     * @param id
     * @param name
     * @param description
     * @param num
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateProductAttributeTypeById",method = {RequestMethod.POST})
    public DataCenter<Object> updateProductAttributeTypeById(String id,String name,String description,int num,String isDel, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            SysDict sysDict=new SysDict();
            sysDict.setId(id);
            sysDict.setIsDel(isDel);
            sysDict.setName(name);
            sysDict.setDescription(description);
            sysDict.setNum(num);
            sysDict.setCode("productAttributeType");
            sysDict.setLstModifyUserId(sysUser.getUserId());
            sysDict.setBranchId(sysUser.getBranchId());

            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            SysDictMapper sysDictMapper = sqlsession.getMapper(SysDictMapper.class);
            sysDictMapper.updateByPrimaryKeySelective(sysDict);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.UP1001);
        }catch (Exception e) {
            netData.setNetCode(EnumNetCode.UP1002);
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
     * 获取费用列表
     * @param dataCenter
     * @param request
     * @return
     */
    @RequestMapping(value = "/getFeeList",method = {RequestMethod.POST})
    public DataCenter<Object> getFeeList(@RequestBody DataCenter<Fee> dataCenter, HttpServletRequest request){
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
                FeeMapper feeMapper = sqlsession.getMapper(FeeMapper.class);
                queryResult.setData(feeMapper.getFeeList(dataCenter));
                queryResult.setRowCount(feeMapper.getFeeCount());
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
    /**
     * 获取费用
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/getFeeById",method = {RequestMethod.GET})
    public DataCenter<Object> getFeeById(Integer id, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            FeeMapper feeMapper = sqlsession.getMapper(FeeMapper.class);
            netData.setData(feeMapper.selectByPrimaryKey(id));
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
     * 新增费用
     * @param fee
     * @param request
     * @return
     */
    @RequestMapping(value = "/insertFee",method = {RequestMethod.POST})
    public DataCenter<Object> insertFee(Fee fee, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            fee.setCreateUserId(sysUser.getUserId());
            fee.setLstModifyUserId(sysUser.getUserId());
            fee.setBranchId(sysUser.getBranchId());
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            FeeMapper feeMapper = sqlsession.getMapper(FeeMapper.class);
            feeMapper.insert(fee);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.I1000);
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
     * 修改费用
     * @param fee
     * @return
     */
    @RequestMapping(value = "/updateFeeById",method = {RequestMethod.POST})
    public DataCenter<Object> updateFeeById(Fee fee, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            fee.setLstModifyUserId(sysUser.getUserId());
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            FeeMapper feeMapper = sqlsession.getMapper(FeeMapper.class);
            feeMapper.updateByPrimaryKeySelective(fee);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.UP1001);
        }catch (Exception e) {
            netData.setNetCode(EnumNetCode.UP1002);
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
     * 获取订单费用类型
     * @param request
     * @return
     */
    @RequestMapping(value = "/getFeeTypeList",method = {RequestMethod.GET})
    public DataCenter<Object> getFeeTypeList(HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            SysDictMapper sysDictMapper = sqlsession.getMapper(SysDictMapper.class);
            List<SysDict> sysDictList= sysDictMapper.getAllSysDictByCode("orderFeeType");
            netData.setData(sysDictList);
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
     * 获取活动列表
     * @param dataCenter
     * @param request
     * @return
     */
    @RequestMapping(value = "/getActivityList",method = {RequestMethod.POST})
    public DataCenter<Object> getActivityList(@RequestBody DataCenter<Activity> dataCenter, HttpServletRequest request){
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
                ActivityMapper activityMapper = sqlsession.getMapper(ActivityMapper.class);
                queryResult.setData(activityMapper.getActivityList(dataCenter));
                queryResult.setRowCount(activityMapper.getActivityCount());
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
    /**
     * 获取活动
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/getActivityById",method = {RequestMethod.GET})
    public DataCenter<Object> getActivityById(Long id, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            ActivityMapper activityMapper = sqlsession.getMapper(ActivityMapper.class);
            netData.setData(activityMapper.selectByPrimaryKey(id));
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
     * 新增活动
     * @param activity
     * @param request
     * @return
     */
    @RequestMapping(value = "/insertActivity",method = {RequestMethod.POST})
    public DataCenter<Object> insertActivity(Activity activity, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            activity.setCreateUserId(sysUser.getUserId());
            activity.setLstModifyUserId(sysUser.getUserId());
            activity.setBranchId(sysUser.getBranchId());
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            ActivityMapper activityMapper = sqlsession.getMapper(ActivityMapper.class);
            activityMapper.insert(activity);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.I1000);
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
     * 修改活动
     * @param activity
     * @return
     */
    @RequestMapping(value = "/updateActivityById",method = {RequestMethod.POST})
    public DataCenter<Object> updateActivityById(Activity activity, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            activity.setLstModifyUserId(sysUser.getUserId());
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            ActivityMapper activityMapper = sqlsession.getMapper(ActivityMapper.class);
            activityMapper.updateByPrimaryKeySelective(activity);
            sqlsession.commit();
            netData.setNetCode(EnumNetCode.UP1001);
        }catch (Exception e) {
            netData.setNetCode(EnumNetCode.UP1002);
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
     * 获取活动类型
     * @param request
     * @return
     */
    @RequestMapping(value = "/getActivityTypeList",method = {RequestMethod.GET})
    public DataCenter<Object> getActivityTypeList(HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            SysDictMapper sysDictMapper = sqlsession.getMapper(SysDictMapper.class);
            List<SysDict> sysDictList= sysDictMapper.getAllSysDictByCode("activityType");
            netData.setData(sysDictList);
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
}
