package com.houli.pms.sync.utils;

import org.springframework.util.ObjectUtils;

import java.util.Map;

public interface ExportVo {
    abstract String conditionExplain(Map<String,String> additional);
    public static StringBuffer additional(StringBuffer buffer,Map<String,String> additional){
        if(ObjectUtils.isEmpty(additional)){return buffer;}
        for (Map.Entry<String, String> entry : additional.entrySet()) {
            buffer.append(entry.getKey());
            buffer.append(":");
            buffer.append(entry.getValue());
            buffer.append(";");
        }
        return buffer;
    }
}
