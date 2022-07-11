package com.example.commonclass;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;

@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD})

public @interface MyAnnotations {
    MyAnnotation[] value();
}
