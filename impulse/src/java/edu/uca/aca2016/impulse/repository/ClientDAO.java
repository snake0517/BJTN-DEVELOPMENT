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

import edu.uca.aca2016.impulse.Client;
import java.sql.SQLException;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author brela
 */
public class ClientDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Client client) {

        String sql = "INSERT INTO client (`FirstName`, `LastName`, `Address1`, `Address2`, `City`, `State`, `Zip`, `Email`, `Phone`, `Status`)"
                + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?,? , ?)";
        Object[] values = {client.getFirstName(), client.getLastName(), client.getAddress1(), client.getAddress2(), client.getCity(), client.getState(), client.getZip(), client.getEmail(), client.getPhone(), client.getStatus()};
        return template.update(sql, values);
    }

    public int update(Client client) {
        String sql = "UPDATE client SET `FirstName`= ?, `LastName` = ?, `Address1` = ?, `Address2` = ?, `City` = ?, `State` = ? , `Zip` = ?, `Email` = ?, `Phone` = ?, `Status` = ?"
                + "	   WHERE ClientId = ?";
        Object[] values = {client.getFirstName(), client.getLastName(), client.getAddress1(), client.getAddress2(), client.getCity(), client.getState(), client.getZip(), client.getEmail(), client.getPhone(), client.getStatus(), client.getClientid()};
        return template.update(sql, values);
    }

    public int delete(int id) {
        String sql = "DELETE FROM client WHERE ClientId=" + id + "";
        return template.update(sql);
    }

    public List<Client> getClientsList() {
        return template.query("SELECT * FROM client", new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet rs, int row) throws SQLException {
                Client c = new Client();
                c.setClientid(rs.getInt("ClientId"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                
                return c;
            }
        });
    }

    public Client getClientById(int id) {
        String sql = "SELECT ClientId AS id, FirstName FROM Client WHERE ClientId = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Client>(Client.class));
    }
    
    public List<Client> getClientsByPage(int start, int total){
        String sql = "SELECT * FROM client LIMIT " + (start - 1) + "," + total;
        return template.query(sql,new RowMapper<Client>(){
            public Client mapRow(ResultSet rs,int row) throws SQLException{
                Client c = new Client();
                c.setClientid(rs.getInt(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setAddress1(rs.getString(4));
                c.setAddress2(rs.getString(5));
                c.setCity(rs.getString(6));
                c.setState(rs.getString(7));
                c.setZip(rs.getString(8));
                c.setEmail(rs.getString(9));
                c.setPhone(rs.getString(10));
                c.setStatus(rs.getString(11));
                return c;
            }
        });
    }
    
    public int getClientCount() {
        String sql = "SELECT COUNT(ClientID) AS rowcount FROM client";
        SqlRowSet rs = template.queryForRowSet(sql);
        
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        
        return 1;
    }
}
