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
public class Client implements Serializable {

    private int clientid;
    private String FirstName;
    private String LastName;
    private String Address1;
    private String Address2;
    private String City;
    private String State;
    private String Zip;
    private String Email;
    private String Phone;
    private String Status;
    private Map<String, String> stat;
    private Map<String, String> states;

    /**
     *
     * @return
     */
    public Map<String, String> getStates() {
        states = new LinkedHashMap<>();
        states.put("Alabama", "Alabama");
        states.put("Alaska", "Alaska");
        states.put("Arizona", "Arizona");
        states.put("Arkansas", "Arkansas");
        states.put("California", "California");
        states.put("Colorado", "Colorado");
        states.put("Connecticut", "Connecticut");
        states.put("Delaware", "Delaware");
        states.put("Florida", "Florida");
        states.put("Georgia", "Georgia");
        states.put("Hawaii", "Hawii");
        states.put("Idaho", "Idaho");
        states.put("Illinois", "Illinois");
        states.put("Indiana", "Indiana");
        states.put("Iowa", "Iowa");
        states.put("Kansas", "Kansas");
        states.put("Kentucky", "Kentucky");
        states.put("Louisiana", "Louisiana");
        states.put("Maine", "Maine");
        states.put("Maryland", "Maryland");
        states.put("Massachusetts", "Massachusetts");
        states.put("Michigan", "Michigan");
        states.put("Minnesota", "Minnesota");
        states.put("Mississippi", "Mississippi");
        states.put("Missouri", "Missouri");
        states.put("Montana", "Montana");
        states.put("Nebraska", "Nebraska");
        states.put("Nevada", "Nevada");
        states.put("New Hampshire", "New Hampshire");
        states.put("New Jersey", "New Jersey");
        states.put("New Mexico", "New Mexico");
        states.put("New York", "New York");
        states.put("North Carolina", "North Carolina");
        states.put("North Dakota", "North Dakota");
        states.put("Ohio", "Ohio");
        states.put("Oklahoma", "Oklahoma");
        states.put("Oregon", "Oregon");
        states.put("Pennsylvania", "Pensylvania");
        states.put("Rhode Island", "Rhode Island");
        states.put("South Carolina", "South Carolina");
        states.put("South Dakota", "South Dakota");
        states.put("Tennessee", "Tennessee");
        states.put("Texas", "Texas");
        states.put("Utah", "Utah");
        states.put("Vermont", "Vermont");
        states.put("Virginia", "Virginia");
        states.put("Washington", "Washington");
        states.put("Washington DC", "Washington DC");
        states.put("West Virginia", "West Virginia");
        states.put("Wisconson", "Wisconson");
        states.put("Wyoming", "Wyoming");
        

        return states;
    }

    /**
     *
     * @return
     */
    public Map<String, String> getStat() {
        stat = new LinkedHashMap<>();
        stat.put("POTENTIAL", "POTENTIAL");
        stat.put("CURRENT", "CURRENT");
        stat.put("FORMER", "FORMER");
        return stat;
    }

    /**
     *
     * @return
     */
    public int getClientid() {
        return clientid;
    }

    /**
     *
     * @param clientid
     */
    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     *
     * @param FirstName
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return LastName;
    }

    /**
     *
     * @param LastName
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     *
     * @return
     */
    public String getAddress1() {
        return Address1;
    }

    /**
     *
     * @param Address1
     */
    public void setAddress1(String Address1) {
        this.Address1 = Address1;
    }

    /**
     *
     * @return
     */
    public String getAddress2() {
        return Address2;
    }

    /**
     *
     * @param Address2
     */
    public void setAddress2(String Address2) {
        this.Address2 = Address2;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return City;
    }

    /**
     *
     * @param City
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return State;
    }

    /**
     *
     * @param State
     */
    public void setState(String State) {
        this.State = State;
    }

    /**
     *
     * @return
     */
    public String getZip() {
        return Zip;
    }

    /**
     *
     * @param Zip
     */
    public void setZip(String Zip) {
        this.Zip = Zip;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return Email;
    }

    /**
     *
     * @param Email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return Phone;
    }

    /**
     *
     * @param Phone
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return Status;
    }

    /**
     *
     * @param Status
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

}
