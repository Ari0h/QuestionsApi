package com.testquiz.api.utils;

import com.testquiz.api.DTOModel.Filter;
import org.springframework.util.StringUtils;


public class FilterUtils {

    public static Filter parseFilter(String filter){
        String[] split = StringUtils.split(filter, ",");
        return new Filter(split[0], split[1]);
    }
}
