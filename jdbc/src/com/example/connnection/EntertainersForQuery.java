package com.example.connnection;

import com.example.bean.Entertainers;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author cxf
 * @create 2022-07-12 10:19 AM
 */

public class EntertainersForQuery {

    @Test
    public void testQueryForEntertainers(){
        String sql = "select * from entertainers where eid = ?";
        Entertainers e1 = queryForEntertainers(sql, 3);
        System.out.println("e1 = " + e1);

        sql = "select ename from entertainers where eid = ?";
        Entertainers e2 = queryForEntertainers(sql, 5);
        System.out.println("e2 = " + e2);
    }

    public Entertainers queryForEntertainers(String sql, Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            if(rs.next()){
                Entertainers e1 = new Entertainers();
                for (int i = 0; i < columnCount; i++) {
                    Object o1 = rs.getObject(i + 1);
//                    String columnName = md.getColumnName(i + 1);  // not recommend
                    String columnLabel = md.getColumnLabel(i + 1);  // recommend

                    Field field = Entertainers.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(e1, o1);
                }
                return e1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps, conn, rs);
        }
        return null;
    }

    @Test
    public void testQuery1(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select eid, ename, password from entertainers where eid <= ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,2);

            rs = ps.executeQuery();

            while(rs.next()) {
                int eid = rs.getInt(1);
                String ename = rs.getString(2);
                String password = rs.getString(3);

                Entertainers entertainers = new Entertainers(eid, ename, password);
                System.out.println("entertainers = " + entertainers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps,conn,rs);
        }

    }
}
