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

import edu.uca.aca2016.impulse.User_Role;
import java.sql.SQLException;

/**
 *
 * @author brela
 */
public class User_RoleDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(User_Role user_role) {

        String sql = "INSERT INTO user_roles (`username`, `role`)"
                + "	VALUES (?, ?)";
        Object[] values = {user_role.getUsername(), user_role.getRole()};
        return template.update(sql, values);
    }

    public int update(User_Role user_role) {
        String sql = "UPDATE user_roles SET `username` = ?, `role` = ?"
                + "	   WHERE user_role_id = ?";
        Object[] values = {user_role.getUsername(), user_role.getRole(), user_role.getUser_role_id()};
        return template.update(sql, values);
    }

    public int delete(int id) {
        String sql = "DELETE FROM user_roles WHERE user_role_id =" + id + "";
        return template.update(sql);
    }

    public List<User_Role> getUser_RoleList() {
        return template.query("SELECT * FROM user_roles", new RowMapper<User_Role>() {
            @Override
            public User_Role mapRow(ResultSet rs, int row) throws SQLException {
                User_Role u = new User_Role();
                u.setUser_role_id(rs.getInt("user_role_id"));
                u.setUsername(rs.getString("username"));
                return u;
            }
        });
    }

    public User_Role getUser_RoleById(int id) {
        String sql = "SELECT user_role_id AS id, username FROM user_roles WHERE user_role_id = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<User_Role>(User_Role.class));
    }
}
