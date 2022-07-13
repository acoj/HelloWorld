package com.example.connnection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author cxf
 * @create 2022-07-12 9:49 PM
 */

public class Transcation {
    @Test
    public void testTranscation(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            System.out.println(conn.getTransactionIsolation());
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            System.out.println(conn.getTransactionIsolation());


            conn.setAutoCommit(false);
            String sql = "update engagements set encontractprice = encontractprice-100 where enID = ?";
            update(conn,sql,1);

            System.out.println(10/0);

            sql = "update engagements set encontractprice = encontractprice+100 where enID = ?";
            update(conn, sql, 2);

            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true);       // for database connection pool
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            JDBCUtils.close(null,conn);
        }

    }
    public void update(Connection conn, String sql, Object ... args){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(ps,null);
        }
    }
}
