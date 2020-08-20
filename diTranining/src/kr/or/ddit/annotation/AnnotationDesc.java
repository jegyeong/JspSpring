package kr.or.ddit.annotation;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.annotation.sample.Sample1WithAnnotation;
import kr.or.ddit.annotation.stereotype.CommandHandler;
import kr.or.ddit.annotation.stereotype.SecondSingleValueAnnotation;
import kr.or.ddit.annotation.stereotype.URIMapping;
import kr.or.ddit.annotation.stereotype.URIMapping.HttpMethod;
import kr.or.ddit.utils.ReflectionUtils;

/**
 * comment : 인간
 * annotation : system + 인간
 * 	 - 코드에 대한 메타 데이터를 대상에게 전달하기 위한 특수한 주석. 
 * 1. Marker annotation : 어노테이션이 부착된 타겟을 그룹핑 할때 사용.
 * 2. SingleValue annotation : value 라는 이름의 속성 하나를 가진 경우.
 * 3. MultiValue annotation : 여러개의 속성을 가진 경우.
 */
public class AnnotationDesc {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String basePackage = "kr.or.ddit.annotation.sample";
		Class<? extends Annotation> annotationType = CommandHandler.class;
		Map<Class<?>, Annotation> targets = ReflectionUtils.getClassesWithAnnotationAtBasePackages(annotationType, basePackage);
		System.out.println(targets);
		for(Entry<Class<?>, Annotation> entry : targets.entrySet()) {
			Class<?> target = entry.getKey();
			Object targetObj = target.newInstance(); 
			annotationType = URIMapping.class;
			Map<Method, Annotation> mtdMap = 
					ReflectionUtils.getMethodsWithAnnotationAtClass(target, annotationType, 
							String.class, HttpServletRequest.class, HttpServletResponse.class);
			System.err.println(mtdMap);
			for(Entry<Method, Annotation> tmp : mtdMap.entrySet()) {
				URIMapping annotation = (URIMapping) tmp.getValue();
				
				HttpServletRequest req = null;
				HttpServletResponse resp = null;
				
				String result = (String) tmp.getKey().invoke(targetObj, req, resp);
				System.out.println(result);
			}
		}
//		Class<?>[] targets = makerAnntotationTracing(basePackage, annotationType);
//		System.out.println(Arrays.toString(targets));
//		for(Class<?> target : targets) {
//			Class<? extends Annotation> mtdType = ThirdMultiValueAnnotation.class;
//			Method[] methods = annotationTracingForMethod(target, mtdType);
//			for(Method mtd : methods) {
//				ThirdMultiValueAnnotation mtdAnno = (ThirdMultiValueAnnotation) mtd.getAnnotation(mtdType);
//				System.out.println(mtdAnno.value() + ":" +mtdAnno.number());
//			}
//		}
	}

	private static Method[] annotationTracingForMethod(Class<?> target, Class<? extends Annotation> mtdType) {
		Method[] methods = null;
		List<Method> mtdList = new ArrayList<>();
		for(Method tmp : target.getDeclaredMethods()) {
			Annotation anno = tmp.getAnnotation(mtdType);
			if(anno!=null) {
				mtdList.add(tmp);
			}
		}
		methods = new Method[mtdList.size()];
		return mtdList.toArray(methods);
	}

	private static Class<?>[] makerAnntotationTracing(String basePackage, Class<? extends Annotation> annotationType) throws ClassNotFoundException {
		Class<?>[] targets = null;
		String classPath = '/'+basePackage.replace('.', '/');
		String systemPath= AnnotationDesc.class.getResource(classPath).getFile();
		File baseFolder =  new File(systemPath);
		String[] children = baseFolder.list((dir, name)->{ 
								return name.endsWith(".class");	
							});
		List<Class<?>> targetList = new ArrayList<>();
		for(String name : children) {
			int lastIdx = name.lastIndexOf(".class");
			String qualifiedName = basePackage +"." + name.substring(0, lastIdx);
			Class<?> target = Class.forName(qualifiedName);
			Annotation annotation = target.getAnnotation(annotationType);
			if(annotation!=null) {
				targetList.add(target);
			}
		}
		targets = new Class<?>[targetList.size()];
		return targetList.toArray(targets);
	}
}









