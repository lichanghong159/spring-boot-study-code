package com.lch.mvc.rest.aiasFor;

import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.StringUtils;

/**
 * @author: lichanghong on 2018-07-24
 **/
@ContextConfiguration(locations = "bb.xml",value = "bb.xml")
public class AnnotationUtilsTest {
    @Test
    public void testAliasFor(){
        ContextConfiguration cc = AnnotationUtils.findAnnotation(getClass(),ContextConfiguration.class);
        System.out.println(StringUtils.arrayToCommaDelimitedString(cc.locations()));
        System.out.println(StringUtils.arrayToCommaDelimitedString(cc.value()));
    }
}
