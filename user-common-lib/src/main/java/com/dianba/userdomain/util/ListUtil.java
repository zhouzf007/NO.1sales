package com.dianba.userdomain.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dianba.userdomain.util.ConverDataUtil;

/**
 * List集合拓展工具类
 * 
 * @author quan
 * 
 */
public class ListUtil {
	private static Logger LOG = LoggerFactory.getLogger(ListUtil.class);

	/**
	 * 监听List集合列对象
	 * 
	 * @author quan
	 * 
	 */
	public interface ListItemListener<T> {
		/**
		 * List集合列条件监听
		 * 
		 * @param t
		 * @return 返回值为true表示符合条件,否则false表示不符合条件
		 */
		public boolean check( T t );
	}

	/**
	 * 判断List集合是否是非Null或者非空
	 * 
	 * @param list
	 * @return
	 */
	public static <T> boolean isNotNullOrEmpty( List<T> list ) {
		return list != null && list.size() > 0;
	}

	/**
	 * 根据监听条件获取符合条件的List集合列数据
	 * 
	 * @param list
	 * @param listItemListener
	 * @return 返回符合条件的List数据集合
	 */
	public static <T> List<T> findAll( List<T> list, ListItemListener<T> listItemListener ) {
		if( isNotNullOrEmpty( list ) ) {
			List<T> newList = new ArrayList<T>();
			for( T t : list ) {
				if( listItemListener.check( t ) ) {
					newList.add( t );
				}
			}
			return newList;
		}
		return null;
	}

	public static <T> T findOne( List<T> list, ListItemListener<T> listItemListener ) {
		if( isNotNullOrEmpty( list ) ) {
			for( T t : list ) {
				if( listItemListener.check( t ) ) {
					return t;
				}
			}
		}
		return null;
	}

	/**
	 * 根据监听条件移除符合条件的List集合列数据
	 * 
	 * @param list
	 * @param listItemListener
	 */
	public static <T> void removeAll( List<T> list, ListItemListener<T> listItemListener ) {
		if( isNotNullOrEmpty( list ) ) {
			int size = list.size();
			for( int i = 0; i < size; i++ ) {
				if( listItemListener.check( list.get( i ) ) ) {
					list.remove( i );
					size = list.size();
				}
			}
		}
	}

	/**
	 * 对List中的对象按照某个成员变量的值进行排序
	 * 
	 * @param list List对象
	 * @param sortField 排序对象的属性名称，如："name"、"age"
	 * @param sortMode 排序方式：ASC，DESC 任选其一(null则默认为ASC)
	 */
	@SuppressWarnings("rawtypes")
	public static <T> void sortList( List<T> list, final String sortField, final String sortMode ) {
		Collections.sort( list, new Comparator<T>() {
			@Override
			public int compare( T o1, T o2 ) {
				try {
					Class clazz = o1.getClass();
					Field field = clazz.getDeclaredField( sortField ); // 获取成员变量
					field.setAccessible( true ); // 设置成可访问状态
					String typeName = field.getType().getName().toLowerCase(); // 转换成小写

					Object v1 = field.get( o1 ); // 获取field的值
					Object v2 = field.get( o2 ); // 获取field的值

					boolean ASC_order = (sortMode == null || "ASC".equalsIgnoreCase( sortMode ));

					// 判断字段数据类型，并比较大小
					if( typeName.endsWith( "string" ) ) {
						String value1 = v1.toString();
						String value2 = v2.toString();
						return ASC_order ? value1.compareTo( value2 ) : value2.compareTo( value1 );
					}
					else if( typeName.endsWith( "short" ) ) {
						Short value1 = Short.parseShort( v1.toString() );
						Short value2 = Short.parseShort( v2.toString() );
						return ASC_order ? value1.compareTo( value2 ) : value2.compareTo( value1 );
					}
					else if( typeName.endsWith( "byte" ) ) {
						Byte value1 = Byte.parseByte( v1.toString() );
						Byte value2 = Byte.parseByte( v2.toString() );
						return ASC_order ? value1.compareTo( value2 ) : value2.compareTo( value1 );
					}
					else if( typeName.endsWith( "char" ) ) {
						Integer value1 = (int)(v1.toString().charAt( 0 ));
						Integer value2 = (int)(v2.toString().charAt( 0 ));
						return ASC_order ? value1.compareTo( value2 ) : value2.compareTo( value1 );
					}
					else if( typeName.endsWith( "int" ) || typeName.endsWith( "integer" ) ) {
						Integer value1 = Integer.parseInt( v1.toString() );
						Integer value2 = Integer.parseInt( v2.toString() );
						return ASC_order ? value1.compareTo( value2 ) : value2.compareTo( value1 );
					}
					else if( typeName.endsWith( "long" ) ) {
						Long value1 = Long.parseLong( v1.toString() );
						Long value2 = Long.parseLong( v2.toString() );
						return ASC_order ? value1.compareTo( value2 ) : value2.compareTo( value1 );
					}
					else if( typeName.endsWith( "float" ) ) {
						Float value1 = Float.parseFloat( v1.toString() );
						Float value2 = Float.parseFloat( v2.toString() );
						return ASC_order ? value1.compareTo( value2 ) : value2.compareTo( value1 );
					}
					else if( typeName.endsWith( "double" ) ) {
						Double value1 = Double.parseDouble( v1.toString() );
						Double value2 = Double.parseDouble( v2.toString() );
						return ASC_order ? value1.compareTo( value2 ) : value2.compareTo( value1 );
					}
					else if( typeName.endsWith( "boolean" ) ) {
						Boolean value1 = Boolean.parseBoolean( v1.toString() );
						Boolean value2 = Boolean.parseBoolean( v2.toString() );
						return ASC_order ? value1.compareTo( value2 ) : value2.compareTo( value1 );
					}
					else if( typeName.endsWith( "date" ) ) {
						Date value1 = (Date)(v1);
						Date value2 = (Date)(v2);
						return ASC_order ? value1.compareTo( value2 ) : value2.compareTo( value1 );
					}
					else if( typeName.endsWith( "timestamp" ) ) {
						Timestamp value1 = (Timestamp)(v1);
						Timestamp value2 = (Timestamp)(v2);
						return ASC_order ? value1.compareTo( value2 ) : value2.compareTo( value1 );
					}
					else {
						// 调用对象的compareTo()方法比较大小
						Method method = field.getType().getDeclaredMethod( "compareTo", new Class[] { field.getType() } );
						method.setAccessible( true ); // 设置可访问权限
						int result = (Integer)method.invoke( v1, new Object[] { v2 } );
						return ASC_order ? result : result * (-1);
					}
				}
				catch( Exception e ) {
					e.printStackTrace();
				}

				return 0; // 未知类型，无法比较大小
			}
		} );
	}
	

	
	/**
	 * list转换字符串，用分割符分割
	 * @param list
	 * @param separator
	 * @return
	 */
	public static String toStrings(List<?> list, String separator){
		if (list == null) return "null";
        int iMax = list.size() - 1;
        if (iMax == -1) return "";
        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(list.get(i));
            if (i == iMax) return b.toString();
            b.append(", ");
        }
	}
	
	/**
	 * 逗号分割list内对象的key字段值
	 * @param list 
	 * @param fieldName 需要分割的字段名称（只支持1级对象）
	 * @return
	 */
	public static String toStringsByField(List<?> list, String fieldName){
		try {
			String separatorValues = "";
			for (Object obj : list) {
				try {
					Field field = obj.getClass().getField(fieldName);
					Object keyVal = field.get(obj);
					separatorValues += "," + String.valueOf(keyVal);
				} catch (Exception e) {
//					e.printStackTrace();
					try {
						String methodName = "get" + fieldName.substring(0, 1).toUpperCase() +fieldName.substring(1);
						Object keyVal = obj.getClass().getMethod(methodName).invoke(obj);
						separatorValues += "," + String.valueOf(keyVal);
					} catch (Exception e2) {
//						e.printStackTrace();
						if(LOG.isWarnEnabled()) LOG.warn("无法找到字段:" + fieldName + "的get方法");
					}
				}
			}
			if(separatorValues.length() > 1) separatorValues = separatorValues.substring(1); 
			return separatorValues;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * list转换字符串，用逗号","分割
	 * @param list
	 * @return
	 */
	public static String toStrings(List<?> list){
		return toStrings(list, ",");
	}
	
	/**
	 * list转换为hash
	 * @param targets 需要转换的list
	 * @param key 提取用作key的字段值（会强制转为String）,属性字段只能使用public的字段
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <F,T> Map<F,T> toHashMap(Collection<T> targets, String fieldName, Class<?> f){
		Map<F, T> map = new HashMap<>();
		try {
			for (T t : targets) {
				try {
					Field field = t.getClass().getField(fieldName);
					Object keyVal = field.get(t);
					map.put((F)keyVal, t);
				} catch (Exception e) {
//					e.printStackTrace();
					try {
						String methodName = "get" + fieldName.substring(0, 1).toUpperCase() +fieldName.substring(1);
						Object keyVal = t.getClass().getMethod(methodName).invoke(t);
						map.put((F)ConverDataUtil.forceToBaseType(keyVal, f), t);
					} catch (Exception e2) {
//						e.printStackTrace();
						if(LOG.isWarnEnabled()) LOG.warn("无法找到字段:" + fieldName + "的get方法");
					}
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
