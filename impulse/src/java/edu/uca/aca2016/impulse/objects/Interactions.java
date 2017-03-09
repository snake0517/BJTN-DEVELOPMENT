/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.impulse.objects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author brela
 */
public class Interactions implements Serializable {

    private int ClientId;
    private int InteractionId;
    private int Clientid;
    private String OccurredOn;
    private String ContactPerson;
    private String ContactType;
    private String Notes;
    private Client client;
    private Map<Integer, String> clients;
    private Map<String, String> contact;

    /**
     *
     * @return
     */
    public Map<String, String> getContact() {
        contact = new LinkedHashMap<>();
        contact.put("Direct", "Direct");
        contact.put("Phone", "Phone");
        contact.put("Email", "Email");
        contact.put("Message", "Message");

        return contact;
    }

    /**
     *
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     *
     * @return
     */
    public Map<Integer, String> getClients() {
        return clients;
    }

    /**
     *
     * @param clients
     */
    public void setClients(Map<Integer, String> clients) {
        this.clients = clients;
    }

    /**
     *
     * @return
     */
    public int getClientId() {
        return ClientId;
    }

    /**
     *
     * @param ClientId
     */
    public void setClientId(int ClientId) {
        this.ClientId = ClientId;
    }

    /**
     *
     * @return
     */
    public int getInteractionId() {
        return InteractionId;
    }

    /**
     *
     * @param InteractionId
     */
    public void setInteractionId(int InteractionId) {
        this.InteractionId = InteractionId;
    }

    /**
     *
     * @return
     */
    public int getClientid() {
        return Clientid;
    }

    /**
     *
     * @param Clientid
     */
    public void setClientid(int Clientid) {
        this.Clientid = Clientid;
    }

    /**
     *
     * @return
     */
    public String getOccurredOn() {
        return OccurredOn;
    }

    /**
     *
     * @param OccurredOn
     */
    public void setOccurredOn(String OccurredOn) {
        this.OccurredOn = OccurredOn;
    }

    /**
     *
     * @return
     */
    public String getContactPerson() {
        return ContactPerson;
    }

    /**
     *
     * @param ContactPerson
     */
    public void setContactPerson(String ContactPerson) {
        this.ContactPerson = ContactPerson;
    }

    /**
     *
     * @return
     */
    public String getContactType() {
        return ContactType;
    }

    /**
     *
     * @param ContactType
     */
    public void setContactType(String ContactType) {
        this.ContactType = ContactType;
    }

    /**
     *
     * @return
     */
    public String getNotes() {
        return Notes;
    }

    /**
     *
     * @param Notes
     */
    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

}
