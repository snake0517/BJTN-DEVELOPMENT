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

import edu.uca.aca2016.impulse.objects.Users;
import java.sql.SQLException;
import java.util.logging.Logger;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author brela
 */
public class UsersDAO {

    private static final Logger logger = Logger.getLogger(UsersDAO.class.getName());

    JdbcTemplate template;

    /**
     *
     * @param template
     */
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /**
     *
     * @param users
     * @return
     */
    public int save(Users users) {

        String sql = "INSERT INTO users (`username`, `password`, `enabled`, `name`)"
                + "	VALUES (?, md5(?), ?, ?)";
        Object[] values = {users.getUsername(), users.getPassword(), users.getEnabled(), users.getName()};
        int r = template.update(sql, values);
        
        sql = "INSERT INTO user_roles (username, role) VALUES (?, ?)";
        
        for (String rolelist: users.getRolelist()) {
            Object[] role_values = {users.getUsername(), rolelist};
            
            logger.info("User DAO add role: " + values);
            
            template.update(sql, role_values);
        
    }
        return r;
    }

    /**
     *
     * @param users
     * @return
     */
    public int update(Users users) {
       
      String  sql = "DELETE From user_roles WHERE username = ?";
        Object[] delete = {users.getUsername()};
        template.update(sql, delete);
        
        sql = "INSERT INTO user_roles (username, role) VALUES (?, ?)";
        
        for (String rolelist: users.getRolelist()) {
            Object[] role_values = {users.getUsername(), rolelist};
            
           
            
            template.update(sql, role_values);
        
    }
        
        
         sql = "UPDATE users SET  `password` = md5(?), enabled = ?, name = ?"
                + "	   WHERE username = ?";
        Object[] values = {users.getPassword(), users.getEnabled(), users.getName(), users.getUsername()};
        int r = template.update(sql, values);
        
        
     return r;   
    }
    
    /**
     *
     * @param users
     * @return
     */
    public int delete(Users users) {
        String sql = "DELETE FROM users WHERE username = ?";
        Object[] values = {users.getUsername()};
        return template.update(sql, values);
    }

    /**
     *
     * @return
     */
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

    /**
     *
     * @param username
     * @return
     */
    public Users getUsersbyUsername(String username) {
        logger.info(username);
        String sql = "SELECT *  FROM users WHERE username = ?";
        return template.queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<Users>(Users.class));

    }

    /**
     *
     * @param start
     * @param total
     * @return
     */
    public List<Users> getUsersByPage(int start, int total) {
        String sql = "SELECT * FROM users LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Users>() {
            public Users mapRow(ResultSet rs, int row) throws SQLException {
                Users u = new Users();
                u.setUsername(rs.getString(1));
                u.setPassword(rs.getString(2));
                u.setEnabled(rs.getInt(3));
                u.setName(rs.getString(4));
                return u;
            }
        });
    }

    /**
     *
     * @return
     */
    public int getUsersCount() {
        String sql = "SELECT COUNT(username) AS rowcount FROM users";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }
}
