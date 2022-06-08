package com.dukz.utils.logback;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.core.PropertyDefinerBase;

/**
 * 日志ip获取Property
 * LogbackIpGetProperty
 * @author dukz
 * @version 1.0
 */
public class LogbackIpGetProperty extends PropertyDefinerBase {
    /**logger*/
    private static Logger logger = LoggerFactory.getLogger(LogbackIpGetProperty.class);

    /**默认值*/
    private final static String DEFAULT_VALUE = "ip";

    @Override
    public String getPropertyValue() {
        Enumeration<NetworkInterface> netInterfaces = null;
        List<String> ipList = new ArrayList<String>();
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    InetAddress inet = ips.nextElement();
                    if (inet instanceof Inet4Address && (!inet.isLoopbackAddress())) {
                        ipList.add(inet.getHostAddress());
                    }
                }
            }
            if (ipList!=null && !ipList.isEmpty()) {
                InetAddress addr = InetAddress.getLocalHost();
                ipList.add(addr.getHostAddress());
                if (logger.isDebugEnabled()) {
                    logger.debug(String.format("读取到本机IP地址为【%s】", addr.getHostAddress()));
                }
            }
            return StringUtils.join(ipList.toArray(), "_");
        } catch (Exception e) {
            logger.error("获取本级网络IP地址出现异常", e);
        }
        return DEFAULT_VALUE;

    }

}
