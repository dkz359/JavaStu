package com.dukz.sqlparser.node;

import org.dom4j.Element;
import java.util.HashMap;
import java.util.Map;

/**
 * base node
 *
 * @author Arvin Du
 * @version 1.0
 * @date 2025/03/18
 */
public abstract class BaseNode {
    public abstract boolean parse(Map<String, Object> currParams, Map<String, Object> globalParams, Element ele,StringBuilder sb) throws Exception;
    public void pre(Map<String, Object> currParams,Map<String, Object> globalParams,Element ele,StringBuilder sb) throws Exception {
    }
    public void after(Map<String, Object> currParams,Map<String, Object> globalParams,Element ele,StringBuilder sb) throws Exception {
    }
    protected Map<String, Object> getAllParams(Map<String, Object> currParams,
                                               Map<String, Object> globalParams) {
        Map<String,Object> allParams = new HashMap<>(2);
        allParams.putAll(globalParams);
        allParams.putAll(currParams);
        return allParams;
    }
}
