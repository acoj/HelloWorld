package com.example.dbutils;

import com.example.bean.Entertainers;
import com.example.pool.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author cxf
 * @create 2022-07-13 4:08 PM
 */

public class QueryRunnerTest {
    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "insert into entertainers(ename,password) values(?,?)";
            int insertCount = runner.update(conn, sql, "cxf2", "abc232");
            System.out.println("insertCount = " + insertCount);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            com.example.connnection.JDBCUtils.close(null,conn);
        }
    }

    @Test
    public void testSelect1() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select * from entertainers where eid = ?";
            BeanHandler<Entertainers> handler = new BeanHandler<>(Entertainers.class);
            Entertainers e = runner.query(conn, sql, handler, 18);
            System.out.println("e = " + e);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            com.example.connnection.JDBCUtils.close(null,conn);
        }
    }

    @Test
    public void testSelect2() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select * from entertainers where eid < ?";
            BeanListHandler<Entertainers> handler = new BeanListHandler<>(Entertainers.class);
            List<Entertainers> es = runner.query(conn, sql, handler, 18);
            es.forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            com.example.connnection.JDBCUtils.close(null,conn);
        }

    }

    @Test
    public void testSelect3() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select * from entertainers where eid = ?";
            MapHandler handler = new MapHandler();
            Map<String, Object> e = runner.query(conn, sql, handler, 18);
            System.out.println("e = " + e);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            com.example.connnection.JDBCUtils.close(null,conn);
        }
    }

    @Test
    public void testSelect4() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select * from entertainers where eid < ?";
            MapListHandler handler = new MapListHandler();
            List<Map<String, Object>> list = runner.query(conn, sql, handler, 18);
            list.forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            com.example.connnection.JDBCUtils.close(null,conn);
        }
    }

    @Test
    public void testSelect5() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select count(*) from entertainers";
            ScalarHandler<Long> handler = new ScalarHandler<>();
            Long count = runner.query(conn, sql, handler);
            System.out.println("count = " + count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            com.example.connnection.JDBCUtils.close(null,conn);
        }
    }
}
