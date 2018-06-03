package com.gcfd.common.util;

import java.util.*;

/**
 * Created by ygx on 2017/10/20.
 */
public class ListAndStringUtil {
    /**
     * @description 将字符串List 拼接成（'',''）形式
     * @author YGX
     * @param list
     * @return
     */
    public static String getInString(List<String> list){
        if(list == null || list.size() <= 0) return null;
        String id = "(";
        for(int i=0;i<list.size();i++){
            if(i == list.size()-1){
                id+="'"+list.get(i)+"'";
            }else{
                id+="'"+list.get(i)+"',";
            }
        }
        id += ")";
        return id;
    }

    /**
     * @description 比较一个list是否包含另一个list
     * @author YGX
     * @param strSonList 子集合list
     * @param strFatherList	父集合list
     * @return
     */
    public static boolean compareStrList(List<String> strSonList,List<String> strFatherList){
        int account = 0;
        for(String sonStr : strSonList){
            for(String fatherStr : strFatherList){
                if(sonStr.equals(fatherStr)) account++;
            }
        }
        if(account != strSonList.size()){
            return false;
        }else{
            return true;
        }
    }


    /**
     * @description 删除ArrayList中重复元素
     * @author YGX
     * @param list
     */
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    /**
     * @description 删除ArrayList中重复元素，保持顺序
     * @author YGX
     * @param list
     */
    public static List removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
        return list;
    }
}
