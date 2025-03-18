package com.dukz.sqlparser.node;

import java.util.Map;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import ognl.Ognl;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;


/**
 * if node
 * @author Arvin Du
 * @version 1.0
 * @date 2025/03/18
 */
@Slf4j
public class IfNode extends BaseNode{

    @Override
    public boolean parse(Map<String, Object> currParams, Map<String, Object> globalParams, Element ele,StringBuilder sb) throws Exception {
        //得到if节点的test属性
        String testStr = ele.attributeValue("test");
        boolean test = false;
        try {
            if(StringUtils.isNotEmpty(testStr)) {
                //合并全局变量和局部变量
                Map<String, Object> allParams = getAllParams(currParams,globalParams);
                //使用ognl判断true或者false
                Object value = Ognl.getValue(testStr, allParams);
                test = Objects.isNull(value) ? Boolean.FALSE : (Boolean) value;
            }
        } catch (Exception e) {
            log.error("判断操作参数{}不合法", testStr, e);
            throw new Exception("判断操作参数"+testStr+"不合法");
        }

        if(ele.content() != null && ele.content().size()==0) {
            test = true;
        }

        return test;
    }

}
