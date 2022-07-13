package com.example.DAO;

import com.example.bean.Entertainers;

import java.sql.Connection;
import java.util.List;

/**
 * @author cxf
 * @create 2022-07-13 10:29 AM
 */

public class EntertainersDAOImpl extends DAO<Entertainers> implements EntertainersDAO {
    @Override
    public void insert(Connection conn, Entertainers e) {
        String sql = "insert into entertainers(ename, password) values(?, ?)";
        update(conn,sql,e.getEname(),e.getPassword());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from entertainers where eid = ?";
        update(conn, sql, id);
    }

    @Override
    public void update(Connection conn, Entertainers e) {
        String sql = "update entertainers set ename = ?, password = ? where eid = ?";
        update(conn, sql, e.getEname(), e.getPassword(), e.getEid());
    }

    @Override
    public Entertainers getEntertainersById(Connection conn, int id) {
        String sql = "select eid, ename, password from entertainers where eid = ?";
        Entertainers e = getInstance(conn, sql, id);
        return e;
    }

    @Override
    public List<Entertainers> getAll(Connection conn) {
        String sql = "select eid, ename, password from entertainers";
        List<Entertainers> list = getForList(conn, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from entertainers";
        return getScalar(conn,sql);
    }
}
