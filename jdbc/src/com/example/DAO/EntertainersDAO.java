package com.example.DAO;

import com.example.bean.Entertainers;

import java.sql.Connection;
import java.util.List;

/**
 * @author cxf
 * @create 2022-07-13 10:14 AM
 */

public interface EntertainersDAO {
    void insert(Connection conn, Entertainers e);

    void deleteById(Connection conn, int id);

    void update(Connection conn, Entertainers e);

    Entertainers getEntertainersById(Connection conn, int id);

    List<Entertainers> getAll(Connection conn);

    Long getCount(Connection conn);

}
