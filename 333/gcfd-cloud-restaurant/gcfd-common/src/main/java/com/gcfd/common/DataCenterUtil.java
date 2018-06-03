package com.gcfd.common;

/**
 * Created by ygx on 2017/9/18.
 */
public class DataCenterUtil {

    /**
     * 执行成功,不返回参数
     * @author YGX
     * @return
     */
    public static DataCenter success(){
        return success(null);
    }

    /**
     * 执行成功，返回参数
     * @author YGX
     * @param object
     * @return
     */
    public static DataCenter success(Object object){
        DataCenter dataCenter = new DataCenter();
        dataCenter.setNetMessage("成功");
        dataCenter.setNetCode(EnumNetCode.C1000);
        dataCenter.setData(object);
        return dataCenter;
    }

    /**
     * 执行成功，返回参数
     * @param object
     * @param code
     * @return
     */
    public static DataCenter success(Object object,EnumNetCode code){
        DataCenter dataCenter = new DataCenter();
        dataCenter.setNetMessage("成功");
        dataCenter.setNetCode(code);
        dataCenter.setData(object);
        return dataCenter;
    }

    /**
     * 执行成功，返回参数
     * @param object
     * @param code
     * @return
     */
    public static DataCenter success(Object object,EnumNetCode code,String message){
        DataCenter dataCenter = new DataCenter();
        dataCenter.setNetMessage(message);
        dataCenter.setNetCode(code);
        dataCenter.setData(object);
        return dataCenter;
    }

    /**
     * 执行成功，返回参数
     * @param code
     * @return
     */
    public static DataCenter success(EnumNetCode code){
        DataCenter dataCenter = new DataCenter();
        dataCenter.setNetMessage("成功");
        dataCenter.setNetCode(code);
        return dataCenter;
    }

    public static DataCenter error(EnumNetCode code){
        DataCenter dataCenter = new DataCenter();
        dataCenter.setNetCode(code);
        dataCenter.setNetMessage("执行失败");
        return dataCenter;
    }

    public static DataCenter error(EnumNetCode code,String message){
        DataCenter dataCenter = new DataCenter();
        dataCenter.setNetCode(code);
        dataCenter.setNetMessage(message);
        return dataCenter;
    }


}
