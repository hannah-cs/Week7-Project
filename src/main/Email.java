package src.main;

public @interface Email {
    String message() default "Invalid email address";
}
