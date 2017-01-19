/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.impulse;

import java.io.Serializable;

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

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int ClientId) {
        this.ClientId = ClientId;
    }

    public int getInteractionId() {
        return InteractionId;
    }

    public void setInteractionId(int InteractionId) {
        this.InteractionId = InteractionId;
    }

    public int getClientid() {
        return Clientid;
    }

    public void setClientid(int Clientid) {
        this.Clientid = Clientid;
    }

    public String getOccurredOn() {
        return OccurredOn;
    }

    public void setOccurredOn(String OccurredOn) {
        this.OccurredOn = OccurredOn;
    }

    public String getContactPerson() {
        return ContactPerson;
    }

    public void setContactPerson(String ContactPerson) {
        this.ContactPerson = ContactPerson;
    }

    public String getContactType() {
        return ContactType;
    }

    public void setContactType(String ContactType) {
        this.ContactType = ContactType;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

}
