package com.example.connnection;

import com.example.bean.Entertainers;
import org.junit.Test;

import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author cxf
 * @create 2022-07-12 4:15 PM
 */

public class BlobTest {
    @Test
    public void testInsert(){
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream fis = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into entertainers(ename, password, photo) values(?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "abcd");
            ps.setString(2, "abc123");
            fis = new FileInputStream(new File("cxf.jpg"));
            ps.setBlob(3, fis);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.close(ps,conn);
        }
    }

    @Test
    public void testQuery(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream bs = null;
        FileOutputStream fos = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select eid, ename, password, photo from entertainers where eid = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 16);
            rs = ps.executeQuery();
            if(rs.next()){
                int eid = rs.getInt("eid");
                String ename = rs.getString("ename");
                String password = rs.getString("password");
                Entertainers entertainers = new Entertainers(eid, ename, password);
                System.out.println("entertainers = " + entertainers);

                Blob photo = rs.getBlob("photo");
                bs = photo.getBinaryStream();
                fos = new FileOutputStream(new File("abc.jpg"));
                byte[] bytes = new byte[1024];
                int len;
                while((len = bs.read(bytes)) != -1){
                    fos.write(bytes, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bs != null) {
                    bs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.close(ps,conn, rs);
        }
    }
}
