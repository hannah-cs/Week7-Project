package src.main;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//custom annotation for ISBN validation
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ISBN {
    String message() default "Invalid ISBN";
}
