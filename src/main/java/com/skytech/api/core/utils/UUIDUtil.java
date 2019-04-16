package com.skytech.api.core.utils;/**
 * Created by Administrator on 2018/7/11.
 */

import java.util.*;

/**
 * uuid生成工具
 *
 * @author :leeyahweh
 * @date 2018-07-11 16:06
 */
public class UUIDUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static String getRandom(int length){
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

    /**
     * 把list里的对象遍历一遍，用list.contain()，如果不存在就放入到另外一个list集合中
     * @param list
     * @return
     */
    public static List removeDuplicate(List list){
        List listTemp = new ArrayList();
        for(int i=0;i<list.size();i++){
            if(!listTemp.contains(list.get(i))){
                listTemp.add(list.get(i));
            }
        }
        return listTemp;
    }
    // 删除ArrayList中重复元素，保持顺序
    public static void removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
        System.out.println( " remove duplicate " + list);
    }

    public static List removeDuplicateHashSet(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

}
