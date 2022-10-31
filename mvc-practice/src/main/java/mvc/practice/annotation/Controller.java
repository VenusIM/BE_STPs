package mvc.practice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE}) // TYPE : Class, Interface, Enum ...
@Retention(RetentionPolicy.RUNTIME) //유지기간은 Runtime 기간까지
public @interface Controller {
}
