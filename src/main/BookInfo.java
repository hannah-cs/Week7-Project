package src.main;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//custom annotation for book-related information
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BookInfo {
    String title() default "";
    String author() default "";
    int yearPublished() default 0;
}
