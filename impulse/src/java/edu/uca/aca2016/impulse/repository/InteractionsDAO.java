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

import edu.uca.aca2016.impulse.Interactions;
import java.sql.SQLException;

/**
 *
 * @author brela
 */
public class InteractionsDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Interactions interactions) {

        String sql = "INSERT INTO interactions (`ClientId`, `OccuredOn`, `ContactPerson`, `ContactType`, `Notes`)"
                + "	VALUES (?, ?, ?, ?, ?)";
        Object[] values = {interactions.getClientid(), interactions.getOccuredOn(), interactions.getContactPerson(), interactions.getContactType(), interactions.getNotes()};
        return template.update(sql, values);
    }

    public int update(Interactions interactions) {
        String sql = "UPDATE interactions SET  `OccuredOn` = ?, `ContactPerson` = ?, `ContactType` = ?, `Notes` = ?"
                + "	   WHERE ClientId = ?";
        Object[] values = {interactions.getOccuredOn(), interactions.getContactPerson(), interactions.getContactType(), interactions.getNotes()};
        return template.update(sql, values);
    }
 
    public int delete(int id) {
        String sql = "DELETE FROM interactions WHERE ClientId=" + id + "";
        return template.update(sql);
    }

    public List<Interactions> getInteractionsList(){
        return template.query("SELECT * FROM interactions",new RowMapper<Interactions>(){
            @Override
            public Interactions mapRow(ResultSet rs,int row) throws SQLException{
                Interactions i = new Interactions();
                i.setClientid(rs.getInt("ClientId"));
                i.setContactPerson(rs.getString("ContactPerson"));
                return i;
            }
        });
    }

    public Interactions getInteractionsById(int id) {
        String sql = "SELECT InteractionsId AS id, ContactPerson FROM Interactions WHERE InteractionsId = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Interactions>(Interactions.class));
    }
}
