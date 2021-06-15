package 算法algo.马士兵_反射.TestReflect.com.zhaoss.test3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 @Target :定义当前的注解可以修饰程序的哪些元素;
 @Retenton :定义注解的周期

 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation {
    String value();//属性
}
