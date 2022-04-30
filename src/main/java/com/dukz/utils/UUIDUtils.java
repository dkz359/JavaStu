package com.dukz.utils;

import java.util.Locale;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

/**
 * 生成UUID
 *
 * @author dukezheng
 * @ClassName UUIDUtils
 * @date 2021/12/13 18:56
 */
public class UUIDUtils {
	public static String getUUID32(){
		return StringUtils.replace(UUID.randomUUID().toString(), "-", "").toLowerCase(Locale.ROOT);
	}
}
