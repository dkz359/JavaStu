package com.dukz.sqlparser.node;

import org.dom4j.Element;
import java.util.Map;

/**
 * sql node
 *
 * @author Arvin Du
 * @version 1.0
 * @date 2025/03/18
 */
public class SqlNode extends BaseNode{

    @Override
    public boolean parse(Map<String, Object> currParams, Map<String, Object> globalParams, Element ele,StringBuilder sb) throws Exception {
        return true;
    }

}
