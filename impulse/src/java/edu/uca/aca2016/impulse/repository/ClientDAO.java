/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.impulse.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.uca.aca2016.impulse.Client;
import java.sql.PreparedStatement;

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

        String sql = "INSERT INTO impulse.client (`FirstName`, `LastName`, `Address1`, `Address2`, `City`, `State`, `Zip`, `Email`, `Phone`, `Status`)"
                + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?,? , ?)";
        Object[] values = {client.getFirstName(), client.getLastName(), client.getAddress1(), client.getAddress2(), client.getCity(), client.getState(), client.getZip(), client.getEmail(), client.getPhone(), client.getStatus()};
        return template.update(sql, values);
    }

    public int update(Client client) {
        String sql = "UPDATE impluse.client SET (`FirstName`, `LastName`, `Address1`, `Address2`, `City`, `State`, `Zip`, `Email`, `Phone`, `Status`)"
                + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" + "' WHERE ClientId = " + client.getClientid();
        Object[] values = {client.getFirstName(), client.getLastName(), client.getAddress1(), client.getAddress2(), client.getCity(), client.getState(), client.getZip(), client.getEmail(), client.getPhone(), client.getStatus()};
        return template.update(sql, values);
    }

    public int delete(int id) {
        String sql = "DELETE FROM impluse.client WHERE ClientId=" + id + "";
        return template.update(sql);
    }

    public List<Client> getClientsList() {
        return template.query("SELECT * FROM impluse.client", (ResultSet rs, int row) -> {
            Client c = new Client();
            c.setClientid(rs.getInt("ClientId"));
            c.setFirstName(rs.getString("FirstName"));
            return c;
        });
    }

    public Client getClientById(int id) {
        String sql = "SELECT ClientId AS id, Name FROM Client WHERE ClientId = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Client>(Client.class));
    }
}
