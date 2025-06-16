package com.mmtes.Mmtes.dtos;

import com.mmtes.Mmtes.models.entities.UsuarioRole;

public record RegisterDTO(String login, String password, UsuarioRole role) {

}
