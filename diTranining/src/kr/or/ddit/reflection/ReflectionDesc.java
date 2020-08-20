package kr.or.ddit.reflection;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

import kr.or.ddit.reflect.ReflectionTest;

public class ReflectionDesc {
	public static void main(String[] args) {
		Object obj = ReflectionTest.getObject();
		Class<?> objType = obj.getClass();
		Field[] fields = objType.getDeclaredFields();
		for( Field fld : fields) {
			String name = fld.getName();
			Class<?> fldType = fld.getType();
			Object value;
			try {
//				fld.setAccessible(true);
//				value = fld.get(obj);
//				mem_id, getMem_id
//				String getterName = "get"+name.toUpperCase().substring(0, 1)+name.substring(1);
//				Method getter = objType.getDeclaredMethod(getterName);
//				value = getter.invoke(obj);
				PropertyDescriptor pd = new PropertyDescriptor(name, objType);
				Method getter = pd.getReadMethod();
				Method setter = pd.getWriteMethod();
//				"abc", 'a', 14, true
				
				if(fldType.isAssignableFrom(String.class)) {
					setter.invoke(obj, "abc");
				}else if(fldType.isAssignableFrom(Character.class)) {
					setter.invoke(obj, 'a');
				}else if(Number.class.isAssignableFrom(fldType)) {
					setter.invoke(obj, 14);
				}else if(fldType.isAssignableFrom(Boolean.class)) {
					setter.invoke(obj, true);					
				}
				
				value = getter.invoke(obj);
				System.out.printf("%s %s=%s;\n", fldType, name, value);
			} catch (IntrospectionException e) {
				// TODO: handle exception
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
 		Method[] methods = objType.getMethods();
 		for(Method mtd : methods) {
 			String name = mtd.getName();
 			Class<?>[] pTypes = mtd.getParameterTypes();
 			Class<?> retType = mtd.getReturnType();
 			System.out.printf("%s %s(%s);\n", retType, name, Arrays.toString(pTypes));
 		}
	}
}










