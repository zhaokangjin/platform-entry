package entry.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanUtils {
	private final static Logger logger = LoggerFactory.getLogger(BeanUtils.class);

	/**
	 * 循环向上转型, 获取对象的 DeclaredMethod
	 * 
	 * @Title: getDeclaredMethod
	 * @Description: TODO
	 * @param object
	 * @param methodName
	 * @param parameterTypes
	 * @return
	 */
	public static Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes) {
		Method method = null;
		for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				method = clazz.getDeclaredMethod(methodName, parameterTypes);
				return method;
			} catch (Exception e) {
				// 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。如果这里的异常打印或者往外抛，则就不会执行clazz =
				// clazz.getSuperclass(),最后就不会进入到父类中了
			}
		}
		return null;
	}

	/**
	 * 直接调用对象方法, 而忽略修饰符(private, protected, default)
	 * 
	 * @Title: invokeMethod
	 * @Description: TODO
	 * @param object
	 * @param methodName
	 * @param parameterTypes
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] parameters) throws Exception {
		// 根据 对象、方法名和对应的方法参数 通过反射 调用上面的方法获取 Method 对象
		Method method = getDeclaredMethod(object, methodName, parameterTypes);
		// 抑制Java对方法进行检查,主要是针对私有方法而言
		method.setAccessible(true);
		try {
			return method.invoke(object, parameters);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			logger.error("BeanUtils>>>invokeMethod>>>error:" + e);
			throw e;
		}

	}

	/**
	 * 循环向上转型, 获取对象的 DeclaredMethod
	 * 
	 * @Title: getDeclaredMethod
	 * @Description: TODO
	 * @param object
	 * @param methodName
	 * @param parameterTypes
	 * @return
	 */
	public static List<Method> getDeclaredMethodList(Object object) {
		List<Method> methodList = new ArrayList<Method>();
		for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				Method[] methods = clazz.getDeclaredMethods();
				List<Method> list = new ArrayList<Method>(Arrays.asList(methods));
				methodList.addAll(list);
			} catch (Exception e) {
				// 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。如果这里的异常打印或者往外抛，则就不会执行clazz =
				// clazz.getSuperclass(),最后就不会进入到父类中了
			}
		}
		return methodList;
	}

	public static Object invokeMethod(Object object, String methodName, Object[] parameters) throws Exception {
		List<Method> methodList = getDeclaredMethodList(object);
		for (int i = 0; i < methodList.size(); i++) {
			if (methodList.get(i).getName().equals(methodName) && methodList.get(i).getParameterCount() == parameters.length) {
				int k = 0;
				for (int j = 0; j < parameters.length; j++) {
					if (methodList.get(i).getParameters()[j].getType().isAssignableFrom(parameters[j].getClass())) {
						k++;
					}
				}
				if (k == parameters.length) {
					methodList.get(i).setAccessible(true);
					return methodList.get(i).invoke(object, parameters);
				}
			}
		}
		return null;
	}

	public static Class<?>[] getClassType(Object[] parameters) {
		Class<?>[] classes = null;

		if (null != parameters && parameters.length > 0) {
			classes = new Class<?>[parameters.length];
			for (int i = 0; i < parameters.length; i++) {
				classes[i] = parameters[i].getClass();
			}
			return classes;
		}
		return classes;
	}

	/**
	 * 循环向上转型, 获取对象的 DeclaredField
	 * 
	 * @Title: getDeclaredField
	 * @Description:
	 * @param object
	 * @param fieldName
	 * @return
	 */
	public static Field getDeclaredField(Object object, String fieldName) {
		Field field = null;
		Class<?> clazz = object.getClass();
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				field = clazz.getDeclaredField(fieldName);
				return field;
			} catch (Exception e) {
				// 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
				// 如果这里的异常打印或者往外抛，则就不会执行clazz =
				// clazz.getSuperclass(),最后就不会进入到父类中了
			}
		}
		return null;
	}

	/**
	 * 直接设置对象属性值, 忽略 private/protected 修饰符, 也不经过 setter
	 * 
	 * @Title: setFieldValue
	 * @Description: TODO
	 * @param object
	 * @param fieldName
	 * @param value
	 * @throws Exception
	 */
	public static void setFieldValue(Object object, String fieldName, Object value) throws Exception {
		// 根据 对象和属性名通过反射 调用上面的方法获取 Field对象
		Field field = getDeclaredField(object, fieldName);
		// 抑制Java对其的检查
		field.setAccessible(true);
		try {
			// 将 object 中 field 所代表的值 设置为 value
			field.set(object, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			logger.error("BeanUtils>>>setFieldValue>>>error:" + e);
			throw e;
		}
	}

	/**
	 * 直接读取对象的属性值, 忽略 private/protected 修饰符, 也不经过 getter
	 * 
	 * @Title: getFieldValue
	 * @Description: TODO
	 * @param object
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public static Object getFieldValue(Object object, String fieldName) throws Exception {
		// 根据 对象和属性名通过反射 调用上面的方法获取 Field对象
		Field field = getDeclaredField(object, fieldName);
		// 抑制Java对其的检查
		field.setAccessible(true);
		try {
			// 获取 object 中 field 所代表的属性值
			return field.get(object);
		} catch (Exception e) {
			logger.error("BeanUtils>>>setFieldValue>>>error:" + e);
			throw e;
		}
	}

}
