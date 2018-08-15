package com.ZDF.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtils {
	/**
	 * ͨ������, ��ö��� Class ʱ�����ĸ���ķ��Ͳ��������� ��: public EmployeeDao extends
	 * BaseDao<Employee, String>
	 * 
	 * @param clazz:�����Ӧ��Class����
	 * @param index������̳и���ʱ������ķ��͵���������0��ʼ
	 * @return
	 */
	public static Class getSuperClassGenericType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();// ��ȡ �����͵ĸ���
													// eg��com.sram.dao.DAO<com.sram.beans.Book>
		// System.out.println("genType : " + genType);
		if (!(genType instanceof ParameterizedType)) {
			return null;
		}
		ParameterizedType paramType = (ParameterizedType) genType;
		Type[] types = paramType.getActualTypeArguments();// ���� �����͵ĸ��� �ķ��Ͳ�������
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
	 * ѭ������ת�ͣ���ȡ����� DeclaredField
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
				return field;// ����õ������ֵ����ԣ��������أ���������Ҳ��ͬ�����ԣ��������ˣ�
			} catch (NoSuchFieldException e) {
				// û�����Field ��������ת��
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
	 * ��ָ����������Ը�ֵ
	 * 
	 * @param obj
	 *            ָ���Ķ���
	 * @param fieldName
	 *            �ֶ�����
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
			System.out.println("�������׳����쳣");
		}
	}

	/**
	 * ͨ��setter����Ϊ������������Ը�ֵ
	 * 
	 * @param obj
	 *            ��������
	 * @param fieldName
	 *            �ֶ���
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
	 * ��ȡָ�����������ֵ
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
			System.out.println("�������׳����쳣");
		}
		return result;
	}

	/**
	 * ѭ������ת��, ��ȡ����� DeclaredMethod
	 * 
	 * @param object:����ִ�еĶ���
	 * @param methodName�����һ�������ķ��������÷���������˽�з���,�������Ǹ����еķ���
	 * @param parameterTypes�����ø÷�����Ҫ�����Class����
	 * @return ���÷�����ķ���ֵ
	 */
	public static Method getDeclaredMethod(Object object, String methodName, Class<?>...parameterTypes) {
		Method method = null;
		for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				method = clazz.getDeclaredMethod(methodName, parameterTypes);
			} catch (Exception e) {
				// Method ���ڵ�ǰ�ඨ��, ��������ת��
			}
		}
		return method;
	}

	/**
	 * 
	 * ֱ�ӵ��ö��󷽷�, ���������η�(private, protected)
	 * 
	 * @param object:����ִ�еĶ���
	 * @param methodName�����һ�������ķ��������÷���������˽�з���,�������Ǹ����еķ���
	 * @param parameterTypes�����ø÷�����Ҫ�����Class����
	 * @param parameters:���ø÷����贫��Ĳ���
	 * @return
	 */
	public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes,
			Object...parameters) throws IllegalArgumentException{
		Method method = getDeclaredMethod(object, methodName, parameterTypes);
		method.setAccessible(true);// �������η�(private, protected)
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
