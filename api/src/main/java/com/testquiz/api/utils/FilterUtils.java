package com.testquiz.api.utils;

import com.testquiz.api.DTOModel.Filter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FilterUtils {

    public static List<Filter> parseFilter(String webFilter){
        if (webFilter == null){
            return Collections.emptyList();
        }
        List<Filter> result = new ArrayList<>();
        if(webFilter.contains(",")){
            String[] splitFilter = StringUtils.split(webFilter, ",");
            for (String splitStr : splitFilter) {
                Filter filter = splitStr.startsWith("+") ? new Filter(splitStr.substring(1), "asc") : new Filter(splitStr.substring(1), "desc");
                result.add(filter);
            }
        } else {
            Filter filter = webFilter.startsWith("+") ? new Filter(webFilter.substring(1), "asc") : new Filter(webFilter.substring(1), "desc");
            result.add(filter);
        }
        return result;
    }
}
