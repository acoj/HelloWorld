package com.example.commonclass;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

//@Inherited
@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD, METHOD, CONSTRUCTOR, TYPE_PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "hello";
}
