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
import edu.uca.aca2016.impulse.objects.Client;
import edu.uca.aca2016.impulse.objects.Interactions;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author brela
 */
public class InteractionsDAO {

    JdbcTemplate template;

    /**
     *JDBC Template Setter
     * @param template
     */
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /**
     * Save Interactions method and SQL Query
     * @param interactions
     * @return
     */
    public int save(Interactions interactions) {

        String sql = "INSERT INTO interactions (`ClientId`, `OccuredOn`, `ContactPerson`, `ContactType`, `Notes`)"
                + "	VALUES (?, ?, ?, ?, ?)";
        Object[] values = {interactions.getClientid(), interactions.getOccurredOn(), interactions.getContactPerson(), interactions.getContactType(), interactions.getNotes()};
        return template.update(sql, values);
    }

    /**
     *Update interactions method and SQL Query
     * @param interactions
     * @return
     */
    public int update(Interactions interactions) {
        String sql = "UPDATE interactions SET  `OccuredOn` = ?, `ContactPerson` = ?, `ContactType` = ?, `Notes` = ?"
                + "	   WHERE InteractionId = ?";
        Object[] values = {interactions.getOccurredOn(), interactions.getContactPerson(), interactions.getContactType(), interactions.getNotes(), interactions.getInteractionId()};
        return template.update(sql, values);
    }

    /**
     *Delete interactions method and SQL Query
     * @param id
     * @return
     */
    public int delete(int id) {
        String sql = "DELETE FROM interactions WHERE InteractionId=" + id + "";
        return template.update(sql);
    }

    /**
     *List<Interactions> getInteractionsList method and SQL Query
     * @param id
     * @return
     */
    public List<Interactions> getInteractionsList(int id) {
        return template.query( "SELECT * FROM Interactions WHERE ClientId = " + id, new RowMapper<Interactions>() {
            @Override
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setInteractionId(rs.getInt(1));
                i.setClientid(rs.getInt(2));
                i.setOccurredOn(rs.getNString(3));
                i.setContactPerson(rs.getString(4));
                i.setContactType(rs.getString(5));
                i.setNotes(rs.getString(6));
                return i;
            }
        });
        
    }

    /**
     * List<Interactions> getAPIInteractionsList method and SQL Query
     * @return
     */
    public List<Interactions> getAPIInteractionsList() {
        return template.query( "SELECT * FROM Interactions " , new RowMapper<Interactions>() {
            @Override
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setInteractionId(rs.getInt(1));
                i.setClientid(rs.getInt(2));
                i.setOccurredOn(rs.getNString(3));
                i.setContactPerson(rs.getString(4));
                i.setContactType(rs.getString(5));
                i.setNotes(rs.getString(6));
                return i;
            }
        });
    }

    /**
     * getInteractionsByID method and SQL Query
     * @param id
     * @return
     */
    public Interactions getInteractionsById(int id) {
        String sql = "SELECT * FROM Interactions WHERE InteractionId = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Interactions>(Interactions.class));
    }

    /**
     *getVInteractionsById method and SQL Query
     * @param id
     * @return
     */
    public Interactions getVInteractionsById(int id) {
        String sql = "SELECT * FROM Interactions WHERE ClientId = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Interactions>(Interactions.class));
    }

    /**
     * List<Interactions> getInteractionsByPage method and SQL Query
     * @param start
     * @param total
     * @return
     */
    public List<Interactions> getInteractionssByPage(int start, int total) {
        String sql = "SELECT interactions.InteractionId, interactions.ClientId, interactions.OccuredOn, interactions.ContactPerson, interactions.ContactType, interactions.Notes, client.ClientId "
                + "FROM Interactions AS interactions "
                + "INNER JOIN Client AS client ON client.ClientId = interactions.ClientId "
                + "ORDER BY client.ClientId, interactions.OccuredOn "
                + "LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Interactions>() {
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setInteractionId(rs.getInt(1));
                i.setClientid(rs.getInt(2));
                i.setOccurredOn(rs.getString(3));
                i.setContactPerson(rs.getString(4));
                i.setContactType(rs.getString(5));
                i.setNotes(rs.getString(6));

                Client client = new Client();
                client.setClientid(rs.getInt(1));
                client.setFirstName(rs.getString(2));

                i.setClient(client);

                return i;
            }
        });
    }

    /**
     *getInteractionsCount method and SQL Query
     * @return
     */
    public int getInteractionCount() {
        String sql = "SELECT COUNT(InteractionID) AS rowcount FROM interactions";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }

    /**
     *getClientsMap method and SQL Query
     * @return
     */
    public Map<Integer, String> getClientsMap() {
        Map<Integer, String> clients = new LinkedHashMap<>();
        String sql = "SELECT ClientID, FirstName, LastName FROM Client ORDER BY FirstName";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            clients.put(rs.getInt(1), rs.getString(2) + " " + rs.getString(3));
        }

        return clients;
    }

    /**
     *List<Interactions> getLastInteractions and SQL Query
     * @return
     */
    public List<Interactions> getLastInteractions() {
        String sql = "SELECT * From interactions Order by interactionid Desc Limit 5";
        return template.query(sql , (ResultSet rs, int row) -> {
            Interactions i = new Interactions();
            i.setInteractionId(rs.getInt(1));
            i.setClientid(rs.getInt(2));
            i.setOccurredOn(rs.getNString(3));
            i.setContactPerson(rs.getString(4));
            i.setContactType(rs.getString(5));
            i.setNotes(rs.getString(6));
            return i;
        });
    }
}
