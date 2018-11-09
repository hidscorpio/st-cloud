package com.st.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * BeanUtils
 *
 * @author 枫竹
 * @version V1.0.0
 * @Title: BeanUtils
 * @Package com.st.web.util
 * @date 2018/11/9 15:09
 */
public class ObjectUtils {
    private final static Logger logger = LoggerFactory.getLogger(ObjectUtils.class);

    /**
     * change objects to map.
     */
    public static HashMap<String, String> objects2Map(Object... objects) {
        return objects2Map(Arrays.asList(objects));
    }

    /**
     * change objects to map
     */
    public static HashMap<String, String> objects2Map(List<Object> objects) {
        HashMap<String, String> paramas = new HashMap<String, String>();
        try {
            for (Object object : objects) {
                Field[] fields = object.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    String fieldValue = field.get(object) == null ? null : String.valueOf(field.get(object));
                    if (!StringUtils.isEmpty(fieldValue)) {
                        paramas.put(fieldName, fieldValue);
                    }
                }
            }
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        return paramas;
    }

    /**
     * change object to map
     */
    public static HashMap<String, String> object2Map(Object object) {
        HashMap<String, String> paramas = new HashMap<String, String>();
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                String fieldValue = field.get(object) == null ? null : String.valueOf(field.get(object));
                if (!StringUtils.isEmpty(fieldValue)) {
                    paramas.put(fieldName, fieldValue);
                }
            }
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        return paramas;
    }
    /**
     * change object to map
     */
    public static HashMap<String, Object> object2ObjectMap(Object object) {
        HashMap<String, Object> paramas = new HashMap<String, Object>();
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object fieldValue = field.get(object);
                if (Objects.nonNull(fieldValue)) {
                    paramas.put(fieldName, fieldValue);
                }
            }
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        return paramas;
    }

    /**
     * change objects fileds to string
     */
    public static String objectFieldToString(String connection, String split, List<Object> objects) {
        StringBuilder sb = new StringBuilder();
        try {

            HashMap<String, String> fieldValueMap = objects2Map(objects);
            Set<String> keySet = fieldValueMap.keySet();
            for (String key : keySet) {
                sb.append(split).append(key).append("=").append(fieldValueMap.get(key));
            }
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        if (sb.length() > 1) {
            return connection + sb.substring(split.length());
        }
        return "";

    }

    /**
     * change objects fileds to string
     */
    public static String objectFieldToString(String connection, String split, Object... objects) {
        return objectFieldToString(connection, split, Arrays.asList(objects));
    }

    /**
     * build objects to query parameters
     *
     * @return "?a=b&c=d" or ""
     */
    public static String buildQueryParameter(Object... objects) {
        return objectFieldToString("?", "&", Arrays.asList(objects));
    }

    /**
     * build objects to query parameters
     *
     * @return "&a=b&c=d" or ""
     */
    public static String buildPathParameters(Object... objects) {
        return objectFieldToString("&", "&", Arrays.asList(objects));
    }
}
