package net.somta.matecoder.model;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Permission {

    /**
     * default module  name
     *
     */
    String module() default "";

    /**
     * default Permission  name
     *
     */
    String key() default "";

    /**
     * default Permission  description
     *
     */
    String description() default "";
}