package com.lch.annotation;

import java.lang.annotation.*;

/**
 * @createby: lichanghong on 2018-07-23 21:06
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Repeatable(UserTags.class)
public @interface UserTag {
    String id();
}
