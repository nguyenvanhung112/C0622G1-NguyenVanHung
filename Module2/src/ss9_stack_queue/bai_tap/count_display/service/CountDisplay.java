package ss9_stack_queue.bai_tap.count_display.service;

import java.util.Map;
import java.util.TreeMap;

public class CountDisplay {
    public static void countDisplay(){
        String str = "mu chu bo doi chu doi chau doi mu chu bo doi chu khong doi chau khong doi";
        String strlow = str.toLowerCase();
        String[] strings = strlow.split(" ");
        Map<String, Integer> treeMap = new TreeMap<>();
        for (String key: strings
             ) {
            if (treeMap.containsKey(key)){
                Integer value = treeMap.get(key);
                value++;
                treeMap.replace(key,value);
            }else {
                treeMap.put(key,1);
            }
        }
        System.out.println(treeMap);
    }
}
