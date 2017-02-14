/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.impulse.objects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author brela
 */
public class Users implements Serializable {

    private String username;
    private String password;
    private int enabled;
    private String Name;
    private String Role;
     private List<String> rolelist;
    private Map<String, String> roles;
    private Map<String, String> enable;

    public List<String> getRolelist() {
        return rolelist;
    }

    public void setRolelist(List<String> rolelist) {
        this.rolelist = rolelist;
    }

    public Map<String, String> getEnable() {
        return enable;
    }

    public void setEnable(Map<String, String> enable) {
        this.enable = enable;
    }

    public Map<String, String> getEnableMap() {
        enable = new LinkedHashMap<>();
        enable.put("0", "no");
        enable.put("1", "yes");

        return enable;
    }

    public Map<String, String> getRoles() {
        roles = new LinkedHashMap<>();
        roles.put("ROLE_USER", "User");
        roles.put("ROLE_ADMIN", "Admin");

        return roles;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

}
