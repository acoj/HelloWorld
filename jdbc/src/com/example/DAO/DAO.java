package com.example.DAO;

import com.example.connnection.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cxf
 * @create 2022-07-13 9:59 AM
 */

public abstract class DAO<T> {
    private Class<T> clazz;
    {
        System.out.println("this.getClass = " + this.getClass());
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        System.out.println("genericSuperclass = " + genericSuperclass);
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        System.out.println("parameterizedType = " + parameterizedType);
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        clazz = (Class<T>) actualTypeArguments[0];
        System.out.println("clazz = " + clazz);
    }

    // update, insert, delete
    public int update(Connection conn, String sql, Object ... args){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps,null);
        }
        return 0;
    }

    // select a line
    public T getInstance(Connection conn, String sql, Object ... args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,  args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            if(rs.next()){
                T t = clazz.getDeclaredConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object o2 = rs.getObject(i + 1);
                    String columnLabel = md.getColumnLabel(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, o2);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps, null, rs);
        }
        return null;
    }

    // select multiple lines
    public List<T> getForList(Connection conn, String sql, Object ... args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<T> list = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            list = new ArrayList<>();
            while(rs.next()){
                T t = clazz.getDeclaredConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object o1 = rs.getObject(i + 1);
                    String columnLabel = md.getColumnLabel(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, o1);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps, null, rs);
        }
        return list;
    }

    // count(*), max(...), ...
    public <E> E getScalar(Connection conn, String sql, Object ... args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                return (E) rs.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps, null, rs);
        }
        return null;
    }
}
