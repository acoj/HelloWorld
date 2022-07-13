package com.example.connnection;

import com.example.bean.Engagements;
import com.example.bean.Entertainers;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cxf
 * @create 2022-07-12 11:34 AM
 */

public class Select {
    @Test
    public void testGetForList(){
        String sql = "select enID id, encontractprice price from engagements where eid = ?";
        List<Engagements> list = getForList(Engagements.class, sql, 6);
        list.forEach(System.out::println);
    }
    public <T> List<T> getForList(Class<T> clazz, String sql, Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<T> list = null;
        try {
            conn = JDBCUtils.getConnection();
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
            JDBCUtils.close(ps, conn, rs);
        }
        return list;
    }

    @Test
    public void testGetInstance(){
        String sql = "select * from Entertainers where eid = ?";
        Entertainers e1 = getInstance(Entertainers.class, sql, 4);
        System.out.println("e1 = " + e1);

        sql = "select enID id, encontractprice price from engagements where eid = ?";
        Engagements e2 = getInstance(Engagements.class, sql, 6);
        System.out.println("e2 = " + e2);

    }
    public <T> T getInstance(Class<T> clazz, String sql, Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
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
            JDBCUtils.close(ps, conn, rs);
        }
        return null;
    }
}
