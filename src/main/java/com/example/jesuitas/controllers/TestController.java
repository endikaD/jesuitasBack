package com.example.jesuitas.controllers;

import com.example.jesuitas.application.UsuarioService;
import com.example.jesuitas.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @Autowired
  UsuarioService usuarioService;
  @GetMapping("/admin")
  //@PreAuthorize("hasRole('ADMIN')")
  public List<User> getAllUsers() {
    return usuarioService.getAllUsers();
  }

}
