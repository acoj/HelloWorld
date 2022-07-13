package com.example.DAO;

import com.example.bean.Entertainers;
import com.example.connnection.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author cxf
 * @create 2022-07-13 10:50 AM
 */

public class EntertainersDAOImplTest {
    private EntertainersDAOImpl dao = new EntertainersDAOImpl();
    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            dao.insert(conn,new Entertainers(1, "cxf", "abc123"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,conn);
        }
    }

    @Test
    public void testDeleteById(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            dao.deleteById(conn,17);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,conn);
        }
    }

    @Test
    public void testUpdate(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            dao.update(conn,new Entertainers(16, "cxf1", "abc321"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,conn);
        }
    }

    @Test
    public void testGetEntertainersById(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
//            conn = com.example.pool.JDBCUtils.getConnection1();
//            conn = com.example.pool.JDBCUtils.getConnection2();
            conn = com.example.pool.JDBCUtils.getConnection3();
            Entertainers e = dao.getEntertainersById(conn, 16);
            System.out.println("e = " + e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,conn);
        }
    }

    @Test
    public void testGetAll(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            List<Entertainers> es = dao.getAll(conn);
            es.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,conn);
        }
    }

    @Test
    public void testGetCount(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Long count = dao.getCount(conn);
            System.out.println("count = " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,conn);
        }
    }
}
