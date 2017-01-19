/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.impulse.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.uca.aca2016.impulse.Users;
import java.sql.SQLException;
import org.springframework.jdbc.support.rowset.SqlRowSet;
/**
 *
 * @author brela
 */
public class UsersDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Users users) {

        String sql = "INSERT INTO users (`username`, `password`, `enabled`)"
                + "	VALUES (?, md5(?), ?)";
        Object[] values = {users.getUsername(), users.getPassword(), users.getEnabled()};
        return template.update(sql, values);
    }

    public int update(Users users) {
        String sql = "UPDATE users SET `username` = ?, `password` = ?, enabled = ?"
                + "	   WHERE username = ?";
        Object[] values = {users.getUsername(),users.getPassword(), users.getEnabled(), users.getUsername()};
        return template.update(sql, values);
    }

    public int delete(Users users) {
        String sql = "DELETE FROM users WHERE username = ?";
        Object[] values = {users.getUsername()};
        return template.update(sql, values);
    }

    public List<Users> getUsersList() {
        return template.query("SELECT * FROM users", new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet rs, int row) throws SQLException {
                Users u = new Users();
                u.setUsername(rs.getString("username"));

                return u;
            }
        });
    }

    public Users getUsersbyUsername(String username) {
        String sql = "SELECT username AS username, username FROM users WHERE username = ?";
        return template.queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<Users>(Users.class));
    }
    public List<Users> getUsersByPage(int start, int total){
        String sql = "SELECT * FROM users LIMIT " + (start - 1) + "," + total;
        return template.query(sql,new RowMapper<Users>(){
            public Users mapRow(ResultSet rs,int row) throws SQLException{
                Users u = new Users();
                u.setUsername(rs.getString(1));
               
                return u;
            }
        });
    }
    
    public int getUsersCount() {
        String sql = "SELECT COUNT(username) AS rowcount FROM users";
        SqlRowSet rs = template.queryForRowSet(sql);
        
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        
        return 1;
    }
}
