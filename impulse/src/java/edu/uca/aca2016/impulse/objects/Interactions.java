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
     *Contact type map
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
     *Getter for Client
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     *Setter for Client
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     *Map for Clients(Getter)
     * @return
     */
    public Map<Integer, String> getClients() {
        return clients;
    }

    /**
     *Map for Clients(Setter)
     * @param clients
     */
    public void setClients(Map<Integer, String> clients) {
        this.clients = clients;
    }

    /**
     *Getter method for ClientID
     * @return
     */
    public int getClientId() {
        return ClientId;
    }

    /**
     *Setter method for ClientID
     * @param ClientId
     */
    public void setClientId(int ClientId) {
        this.ClientId = ClientId;
    }

    /**
     *Getter method for InteractionID
     * @return
     */
    public int getInteractionId() {
        return InteractionId;
    }

    /**
     *Setter method for InteractionID
     * @param InteractionId
     */
    public void setInteractionId(int InteractionId) {
        this.InteractionId = InteractionId;
    }

    /**
     *Getter method for ClientID
     * @return
     */
    public int getClientid() {
        return Clientid;
    }

    /**
     *Setter method for ClientID
     * @param Clientid
     */
    public void setClientid(int Clientid) {
        this.Clientid = Clientid;
    }

    /**
     *Getter method for OccurredOn
     * @return
     */
    public String getOccurredOn() {
        return OccurredOn;
    }

    /**
     *Setter method for OccurredOn
     * @param OccurredOn
     */
    public void setOccurredOn(String OccurredOn) {
        this.OccurredOn = OccurredOn;
    }

    /**
     *ContactPerson Getter
     * @return
     */
    public String getContactPerson() {
        return ContactPerson;
    }

    /**
     *Contact Person Setter
     * @param ContactPerson
     */
    public void setContactPerson(String ContactPerson) {
        this.ContactPerson = ContactPerson;
    }

    /**
     *ContactType Getter
     * @return
     */
    public String getContactType() {
        return ContactType;
    }

    /**
     *ContactType Setter
     * @param ContactType
     */
    public void setContactType(String ContactType) {
        this.ContactType = ContactType;
    }

    /**
     *Notes Getter
     * @return
     */
    public String getNotes() {
        return Notes;
    }

    /**
     *Notes Setter
     * @param Notes
     */
    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

}
