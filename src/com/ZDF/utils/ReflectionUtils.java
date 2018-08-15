package com.ZDF.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtils {
	/**
	 * 通过反射, 获得定义 Class 时声明的父类的泛型参数的类型 如: public EmployeeDao extends
	 * BaseDao<Employee, String>
	 * 
	 * @param clazz:子类对应的Class对象
	 * @param index：子类继承父类时，传入的泛型的索引，从0开始
	 * @return
	 */
	public static Class getSuperClassGenericType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();// 获取 带泛型的父类
													// eg：com.sram.dao.DAO<com.sram.beans.Book>
		// System.out.println("genType : " + genType);
		if (!(genType instanceof ParameterizedType)) {
			return null;
		}
		ParameterizedType paramType = (ParameterizedType) genType;
		Type[] types = paramType.getActualTypeArguments();// 返回 带泛型的父类 的泛型参数数组
															// eg: [class
															// com.sram.beans.Book]
		// System.out.println("types : " + Arrays.toString(types));
		if (index < 0 || index > types.length) {
			return null;
		}
		if (!(types[index] instanceof Class)) {
			return null;
		}
		return (Class) types[index];
	}

	/**
	 * 循环向上转型，获取对象的 DeclaredField
	 * 
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public static Field getDeclaredField(Object obj, String fieldName) {
		Field field = null;
		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				field = superClass.getDeclaredField(fieldName);
				return field;// 子类得到此名字的属性，若不返回，若父类中也有同名属性，不悲催了？
			} catch (NoSuchFieldException e) {
				// 没有这个Field 继续向上转型
			}
		}
		return field;
	}

	public static void makeAccessible(Field field) {
		if (!Modifier.isPublic(field.getModifiers())) {
			field.setAccessible(true);
		}
	}

	/**
	 * 给指定对象的属性赋值
	 * 
	 * @param obj
	 *            指定的对象
	 * @param fieldName
	 *            字段名称
	 */
	public static void setFieldValue(Object obj, String fieldName, Object value) {
		Field field = getDeclaredField(obj, fieldName);
		if (field == null) {
			throw new IllegalArgumentException("Can not find field[" + fieldName + "] on target [" + obj + "]");
		}
		makeAccessible(field);
		try {
			field.set(obj, value);
		} catch (IllegalAccessException e) {
			System.out.println("不可能抛出的异常");
		}
	}

	/**
	 * 通过setter方法为给定对象的属性赋值
	 * 
	 * @param obj
	 *            给定对象
	 * @param fieldName
	 *            字段名
	 * @param value
	 */
	public static void setterValue(Object obj, String fieldName, Object value) {
		Field field = getDeclaredField(obj, fieldName);
		if (field == null) {
			throw new IllegalArgumentException("Can not find field[" + fieldName + "] on target [" + obj + "]");
		}
		String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
		invokeMethod(obj, methodName, new Class<?>[]{field.getType()}, value);
	}

	/**
	 * 获取指定对象的属性值
	 * 
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public static Object getFieldValue(Object obj, String fieldName) {
		Object result = null;
		Field field = getDeclaredField(obj, fieldName);
		if (field == null) {
			throw new IllegalArgumentException("Can not find field[" + fieldName + "] on target [" + obj + "]");
		}
		makeAccessible(field);
		try {
			result = field.get(obj);
		} catch (IllegalAccessException e) {
			System.out.println("不可能抛出的异常");
		}
		return result;
	}

	/**
	 * 循环向上转型, 获取对象的 DeclaredMethod
	 * 
	 * @param object:方法执行的对象
	 * @param methodName：类的一个方法的方法名，该方法可能是私有方法,还可能是父类中的方法
	 * @param parameterTypes：调用该方法需要传入的Class参数
	 * @return 调用方法后的返回值
	 */
	public static Method getDeclaredMethod(Object object, String methodName, Class<?>...parameterTypes) {
		Method method = null;
		for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				method = clazz.getDeclaredMethod(methodName, parameterTypes);
			} catch (Exception e) {
				// Method 不在当前类定义, 继续向上转型
			}
		}
		return method;
	}

	/**
	 * 
	 * 直接调用对象方法, 而忽略修饰符(private, protected)
	 * 
	 * @param object:方法执行的对象
	 * @param methodName：类的一个方法的方法名，该方法可能是私有方法,还可能是父类中的方法
	 * @param parameterTypes：调用该方法需要传入的Class参数
	 * @param parameters:调用该方法需传入的参数
	 * @return
	 */
	public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes,
			Object...parameters) throws IllegalArgumentException{
		Method method = getDeclaredMethod(object, methodName, parameterTypes);
		method.setAccessible(true);// 忽略修饰符(private, protected)
			try {
				return method.invoke(object, parameters);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		return null;
	}
}
