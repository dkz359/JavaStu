package com.dukz.utils.logback;

import java.io.File;
import org.apache.commons.lang3.StringUtils;
import ch.qos.logback.core.PropertyDefinerBase;

/**
 * LogbackHomeGetProperty
 * @author dukz
 * @version 1.0
 *
 */
public class LogbackHomeGetProperty extends PropertyDefinerBase {
    /**jetty.home*/
    private static final String JETTY_HOME = "jetty.home";

    /**catalina.home*/
    private static final String CATALINA_HOME = "catalina.home";

    /**np日志路径*/
    private static final String APPLOG = "applog";

    @Override
    public String getPropertyValue() {
        String jettyPath = System.getProperty(JETTY_HOME);
        String catalinaPath = System.getProperty(CATALINA_HOME);
        String path = StringUtils.defaultString(jettyPath, catalinaPath);
        if (StringUtils.isBlank(path)) {
            return APPLOG;
        }
        File file = new File(path);
        if (file.exists()) {
            File parentFile = file.getParentFile();
            return (parentFile != null ? parentFile.getPath() : file.getPath()) + File.separator + APPLOG;
        }
        return APPLOG;
    }

}
