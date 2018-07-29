package com.users.db;

import java.lang.reflect.Field;
import java.sql.ResultSet;

public class ORM {
	public static String toSql(Object obj)
	{
		Class cobj=obj.getClass();
		String tablename=cobj.getSimpleName(); //表名
		StringBuffer stf=new StringBuffer("insert into ");
		stf.append(tablename).append("(");
		Field[] fields=cobj.getDeclaredFields();
		for(int i=0;i<fields.length-1;i++){
			stf.append(fields[i].getName()).append(",");
		}
		stf.append(fields[fields.length-1].getName());
		stf.append(") values ('");
		try{
			for(int i=0;i<fields.length-1;i++){
				fields[i].setAccessible(true);
				stf.append(fields[i].get(obj)).append("','");
			}
			fields[fields.length-1].setAccessible(true);
			stf.append(fields[fields.length-1].get(obj)).append("')");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return stf.toString();
		
	}
	
	public static Object toObject(ResultSet rs,Class cobj)
	{
			Object obj=null;
			try{
				obj=cobj.newInstance();//调用类的无参构造方法
				Field[] fields=cobj.getDeclaredFields();
				
				for(Field field:fields){//for-each循环 
					field.setAccessible(true);
					field.set(obj,rs.getObject(field.getName()));
				}
			}
			catch (Exception ex){
				ex.getMessage();
			}
			return obj;
	}
}
