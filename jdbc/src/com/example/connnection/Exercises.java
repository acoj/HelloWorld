package com.example.connnection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @author cxf
 * @create 2022-07-12 2:48 PM
 */

public class Exercises {
    @Test
    public void testInsert(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input eid: ");
        String eid = scanner.next();
        System.out.print("please input ename: ");
        String ename = scanner.next();
        String sql = "insert into entertainers(eid, ename) values(?, ?)";
        int count = Update(sql, eid, ename);
        if(count > 0){
            System.out.printf("insert %d lines", count);
        }
    }

    public int Update(String sql, Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps, conn);
        }
        return count;
    }
}
