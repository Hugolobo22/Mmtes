package com.mmtes.Mmtes.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.mmtes.Mmtes.dtos.AuthenticationDTO;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @PostMapping("/login")
    public void/*ResponseEntity*/ login(@RequestBody @Valid AuthenticationDTO data){

    }
}
