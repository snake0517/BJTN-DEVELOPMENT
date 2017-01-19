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
import org.springframework.jdbc.support.rowset.SqlRowSet;
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
        Object[] values = {interactions.getClientid(), interactions.getOccurredOn(), interactions.getContactPerson(), interactions.getContactType(), interactions.getNotes()};
        return template.update(sql, values);
    }

    public int update(Interactions interactions) {
        String sql = "UPDATE interactions SET  `OccuredOn` = ?, `ContactPerson` = ?, `ContactType` = ?, `Notes` = ?"
                + "	   WHERE ClientId = ?";
        Object[] values = {interactions.getOccurredOn(), interactions.getContactPerson(), interactions.getContactType(), interactions.getNotes(), interactions.getClientId()};
        return template.update(sql, values);
    }

    public int delete(int id) {
        String sql = "DELETE FROM interactions WHERE ClientId=" + id + "";
        return template.update(sql);
    }

    public List<Interactions> getInteractionsList() {
        return template.query("SELECT * FROM interactions", new RowMapper<Interactions>() {
            @Override
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setClientid(rs.getInt("ClientId"));
                i.setContactPerson(rs.getString("ContactPerson"));
                i.setContactType(rs.getString("ContactType"));
                return i;
            }
        });
    }

    public Interactions getInteractionsById(int id) {
        String sql = "SELECT ClientId AS id, ContactPerson FROM Interactions WHERE ClientId = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Interactions>(Interactions.class));
    }
    public List<Interactions> getInteractionssByPage(int start, int total){
        String sql = "SELECT * FROM interactions LIMIT " + (start - 1) + "," + total;
        return template.query(sql,new RowMapper<Interactions>(){
            public Interactions mapRow(ResultSet rs,int row) throws SQLException{
                Interactions i = new Interactions();
                i.setInteractionId(rs.getInt(1));
                i.setClientid(rs.getInt(2));
                i.setOccurredOn(rs.getString(3));
                i.setContactPerson(rs.getString(4));
                i.setContactType(rs.getString(5));
                i.setNotes(rs.getString(6));
                return i;
            }
        });
    }
    
    public int getInteractionCount() {
        String sql = "SELECT COUNT(InteractionID) AS rowcount FROM interactions";
        SqlRowSet rs = template.queryForRowSet(sql);
        
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        
        return 1;
    }
}
