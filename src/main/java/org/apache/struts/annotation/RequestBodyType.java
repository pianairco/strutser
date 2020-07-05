package org.apache.struts.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;
import java.util.Map;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
public @interface RequestBodyType {
    Class type() default Map.class;
}
