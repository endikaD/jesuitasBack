package com.example.jesuitas.application;


import com.example.jesuitas.models.User;
import com.example.jesuitas.payload.request.SignupRequest;

import java.util.List;

public interface UsuarioService {

    //List<UsuarioOutputDto> obtenerUsuarioPorNombre(String nombre);

    User obtenerUsuarioPorId(Integer id);

    List<User> obtenerUsuarios(Integer pagina, Integer tamanio);

    User actualizarUsuario(Integer id, User user);

    void borrarUsuario(Integer id) throws Exception;
    User saveUser(SignupRequest signUpRequest);
    List<User> getAllUsers();
}
