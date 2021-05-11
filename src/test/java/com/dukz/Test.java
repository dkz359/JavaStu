package com.dukz;

import com.google.common.collect.ArrayListMultimap;
import org.apache.commons.lang3.Conversion;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.sql.Timestamp;
import java.text.ParseException;
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
	    ArrayListMultimap<Object, Object> multimap = ArrayListMultimap.create();
	    multimap.put("1", "a");
	    multimap.put("1", "b");
	    multimap.put("2", "c");
	    Map<Object, Collection<Object>> map = multimap.asMap();
	    System.out.println(map.size());
	    Set<Map.Entry<Object, Collection<Object>>> entries = map.entrySet();
	    Iterator<Map.Entry<Object, Collection<Object>>> iterator = entries.iterator();
	    Collection<Object> baseValue = iterator.next().getValue();
	    while (iterator.hasNext()){
		    Collection<Object> value = iterator.next().getValue();
		    for (Object o : baseValue) {
			    for (Object o1 : value) {

			    }
		    }
	    }
    }

}


