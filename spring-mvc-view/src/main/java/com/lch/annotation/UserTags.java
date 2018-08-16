package com.lch.annotation;

import java.lang.annotation.*;

/**
 * @createby: lichanghong on 2018-07-23 21:08
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface UserTags {
    UserTag [] value();
}
