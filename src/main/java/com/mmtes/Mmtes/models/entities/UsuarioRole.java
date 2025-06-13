package com.mmtes.Mmtes.models.entities;

public enum UsuarioRole {

    ADMIN("admin"),
    
    USUARIO("user");

    private String role;

    UsuarioRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
