package com.day22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Properties;

public class ReadProperties {
    /**
     * @param path
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T coverBean(String path, Class<?> cls) {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        Object object = null;
        try {
            object = cls.newInstance();
            fileInputStream = new FileInputStream(path);
            if (fileInputStream != null) {
                properties.load(fileInputStream);
                //变量属性文件类中的所有Key和value
            }
            for (Map.Entry<Object, Object> objectObjectEntry : properties.entrySet()) {
                Field field = cls.getDeclaredField(objectObjectEntry.getKey().toString());
                //获取field的参数类型 比如 int、long、double...
                String name = field.getGenericType().getTypeName();
                if (name.equalsIgnoreCase("int")) {
                    field.setAccessible(true);
                    field.setInt(object, Integer.parseInt(objectObjectEntry.getValue().toString()));
                } else if(name instanceof Object) {
                    field.setAccessible(true);
                    field.set(object, objectObjectEntry.getValue().toString());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return (T) object;
    }

    public static void main(String[] args) {
//        Map<String, Object> map = new HashMap<String, Object>();
        Class cls;
        try {
            cls = Class.forName("com.myreflect.Employee");
            Employee employee = (Employee) coverBean("E:\\employee.properties", cls);
            System.out.println(employee);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
