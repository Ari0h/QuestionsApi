package com.testquiz.api;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.criteria.CriteriaQuery;

public class PageUtils {

    public static void addSortToCriteria(CriteriaQuery critera, Pageable pageble){
        Sort sort = pageble.getSort();
    }

}
