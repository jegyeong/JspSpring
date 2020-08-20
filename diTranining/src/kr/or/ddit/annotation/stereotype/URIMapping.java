package kr.or.ddit.annotation.stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface URIMapping {
	public static enum HttpMethod{ GET, POST, PUT, DELETE }
	public String value();
	public HttpMethod method() default HttpMethod.GET;
}
