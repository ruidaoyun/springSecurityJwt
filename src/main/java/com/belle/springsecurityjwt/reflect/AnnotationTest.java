package com.belle.springsecurityjwt.reflect;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnotationTest {
}
