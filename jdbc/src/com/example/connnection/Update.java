package com.example.connnection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author cxf
 * @create 2022-07-12 8:43 AM
 */

public class Update {
    // sql injection
    // select user, password from user_table where user = '1' or ' and password = '=1 or '1' = '1'

    public void commonUpdate(String sql, Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps,conn);
        }
    }

    @Test
    public void testCommonUpdate(){
//        String sql = "delete from entertainers where eid = ?";
//        commonUpdate(sql,12);

        String sql = "update engagements set encontractprice = ? where enID = ?";
        commonUpdate(sql,10000, 11);
    }

    @Test
    public void testInsert() {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "insert into entertainers(eid, ename) values(?, ?)";

            ps = conn.prepareStatement(sql);

            /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("2000-01-01");
//            ps.setDate(3, (java.sql.Date) (date));*/

            ps.setInt(1, 15);
            ps.setString(2,"christian_chen");
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps,conn);
        }
    }

    @Test
    public void testUpdate(){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtils.getConnection();

            String sql = "update entertainers set ename = ? where eid = ?";
            ps = conn.prepareStatement(sql);

            ps.setObject(1, "cxf");
            ps.setObject(2, 11);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps,conn);
        }
    }
}
