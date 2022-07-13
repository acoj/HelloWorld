package com.example.connnection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author cxf
 * @create 2022-07-12 6:07 PM
 */

public class BatchInsert {
    @Test
    public void testBatchInsert(){
        long start = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 1000000; i++) {
                ps.setObject(1,"name_" + i);
                ps.addBatch();
                if(i % 5000 == 0){
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps,conn);
        }
        long stop = System.currentTimeMillis();
        System.out.println("time = " + (stop - start));

    }
}
