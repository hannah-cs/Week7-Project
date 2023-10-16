package src.main;

public @interface ValidateUser {
    int minimumAge() default 12;
    int maximumBooks() default 4;
}
