package com.dukz;

import java.util.*;

/**
 * @author dukezheng
 * @ClassName Test
 * @Description TODO
 * @date 2020/11/3 21:40
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
    	Map<String, List<String>> amap = new HashMap<>();
    	Map<String, List<String>> bmap = new HashMap<>();
    	List<String> alist = new ArrayList<>();
    	List<String> blist = new ArrayList<>();
    	alist.addAll(Arrays.asList("1","2","3"));
    	blist.addAll(Arrays.asList("4","5","6"));
    	amap.put("map", alist);
    	bmap.put("map", blist);
    	amap.forEach((key, value)->{
		    List<String> list = bmap.get(key);
		    value.addAll(list);
	    });
	    System.out.println(amap);
	    System.out.println(bmap);
    }

}


