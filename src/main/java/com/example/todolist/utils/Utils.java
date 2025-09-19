package com.example.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {

    public static void copyNonNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNamesStrings(source));
    }

    public static String[] getNullPropertyNamesStrings(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);

        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNmaes = new HashSet<>();

        for (PropertyDescriptor pd : pds) {
            Object srcValeu = src.getPropertyValue(pd.getName());
            if (srcValeu == null) {
                emptyNmaes.add(pd.getName());
            }
        }

        String[] result = new String[emptyNmaes.size()];
        return emptyNmaes.toArray(result);

    }

}
