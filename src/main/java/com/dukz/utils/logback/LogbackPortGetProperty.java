package com.dukz.utils.logback;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.core.PropertyDefinerBase;

/**
 * logback端口的属性给值
 * LogbackPortGetProperty
 * @author dukz
 * @version 1.0
 *
 */
public class LogbackPortGetProperty extends PropertyDefinerBase {
    /**LOGGER*/
    private static final Logger LOGGER = LoggerFactory.getLogger(LogbackPortGetProperty.class);

    private static final String HTTP_PROTOCOL = "HTTP/1.1";

    @Override
    public String getPropertyValue() {
        return getTomcatPortValue();
    }

    /**
     * 
     * @return
     */
    public String getTomcatPortValue() {
        try {
            List<MBeanServer> serverList = MBeanServerFactory.findMBeanServer(null);
            for (MBeanServer server : serverList) {
                Set<ObjectName> names = new HashSet<ObjectName>();
                names.addAll(server.queryNames(new ObjectName("Catalina:type=Connector,*"), null));
                Iterator<ObjectName> it = names.iterator();
                while (it.hasNext()) {
                    ObjectName oname = (ObjectName) it.next();
                    String pvalue = (String) server.getAttribute(oname, "protocol");
                    if (StringUtils.equals(HTTP_PROTOCOL, pvalue)) {
                        return ObjectUtils.toString(server.getAttribute(oname, "port"));
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("获取port失败,影响logback的文件拼接", e);
        }
        return StringUtils.EMPTY;
    }

}
