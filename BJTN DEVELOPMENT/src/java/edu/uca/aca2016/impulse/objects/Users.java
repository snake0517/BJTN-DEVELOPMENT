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

    /**
     * RolesList Getter
     *
     * @return
     */
    public List<String> getRolelist() {
        return rolelist;
    }

    /**
     * RolesList Setter
     *
     * @param rolelist
     */
    public void setRolelist(List<String> rolelist) {
        this.rolelist = rolelist;
    }

    /**
     * Enable Getter
     *
     * @return
     */
    public Map<String, String> getEnable() {
        return enable;
    }

    /**
     * Enable Setter
     *
     * @param enable
     */
    public void setEnable(Map<String, String> enable) {
        this.enable = enable;
    }

    /**
     * EnableMap Getter
     *
     * @return
     */
    public Map<String, String> getEnableMap() {
        enable = new LinkedHashMap<>();
        enable.put("0", "no");
        enable.put("1", "yes");

        return enable;
    }

    /**
     * Roles Getter
     *
     * @return
     */
    public Map<String, String> getRoles() {
        roles = new LinkedHashMap<>();
        roles.put("ROLE_USER", "User");
        roles.put("ROLE_ADMIN", "Admin");

        return roles;
    }

    /**
     * Role Getter
     *
     * @return
     */
    public String getRole() {
        return Role;
    }

    /**
     * Role Setter
     *
     * @param Role
     */
    public void setRole(String Role) {
        this.Role = Role;
    }

    /**
     * Name Getter
     *
     * @return
     */
    public String getName() {
        return Name;
    }

    /**
     * Name Setter
     *
     * @param Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Username Getter
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Username Setter
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Password Getter
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Password Setter
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Enabled Getter
     *
     * @return
     */
    public int getEnabled() {
        return enabled;
    }

    /**
     * Enabled Setter
     *
     * @param enabled
     */
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

}
