package com.example.jesuitas.application;

import com.example.jesuitas.models.ERole;
import com.example.jesuitas.models.Role;
import com.example.jesuitas.models.User;
import com.example.jesuitas.payload.request.SignupRequest;
import com.example.jesuitas.repository.RoleRepository;
import com.example.jesuitas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UserRepository usuarioRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;


    @Override
    public List<User> obtenerUsuarios(Integer pagina, Integer tamanio) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanio);
        return usuarioRepository.findAll(pageRequest).getContent().stream().map(User::new).toList();
    }

    @Override
    public User obtenerUsuarioPorId(Integer id) {
        User usuario = usuarioRepository.findById(Long.valueOf(id)).orElseThrow();
        return new User(usuario);
    }

//    @Override
//    public List<UsuarioOutputDto> obtenerUsuarioPorNombre(String nombre) {
//        List<UsuarioOutputDto> usuarios = new ArrayList<>();
//        for (Usuario usuario: usuarioRepository.findByNombre(nombre)) {
//            usuarios.add(new UsuarioOutputDto(usuario));
//        }
//        return usuarios;
//    }


    @Override
    public User actualizarUsuario(Integer id, User usuarioInputDto) {
        User usuario = usuarioRepository.findById(Long.valueOf(id)).orElseThrow();

        usuario.setUsername(usuarioInputDto.getUsername());
        usuario.setEmail(usuarioInputDto.getEmail());
        usuario.setPassword(usuarioInputDto.getPassword());

        usuarioRepository.save(usuario);
        return new User(usuario);
    }

    @Override
    public void borrarUsuario(Integer id) throws Exception {
        usuarioRepository.delete(usuarioRepository.findById(Long.valueOf(id)).orElseThrow());
    }

    @Override
    public User saveUser(SignupRequest signUpRequest) {
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        Set<Role> roles = new HashSet<>();

        // Create roles if they don't exist
        if(roleRepository.findRoleByName(ERole.valueOf("ROLE_ADMIN")).isEmpty()) {
            Role adminRole = new Role();
            adminRole.setName(ERole.valueOf("ROLE_ADMIN"));
            roleRepository.save(adminRole);
        }
        if(roleRepository.findRoleByName(ERole.valueOf("ROLE_USER")).isEmpty()) {
            Role userRole = new Role();
            userRole.setName(ERole.valueOf("ROLE_USER"));
            roleRepository.save(userRole);
        }

        // Check if there are users in the database
        if(usuarioRepository.findAll().isEmpty()) {
            // If there are no users, make the first one an admin
            List<Role> adminRoles = roleRepository.findRoleByName(ERole.valueOf("ROLE_ADMIN"));
            if (!adminRoles.isEmpty()) {
                roles.add(adminRoles.get(0));
            }
        } else {
            // If there are users, make all subsequent ones regular users
            List<Role> userRoles = roleRepository.findRoleByName(ERole.valueOf("ROLE_USER"));
            if (!userRoles.isEmpty()) {
                roles.add(userRoles.get(0));
            }
        }

        user.setRoles(roles);
        return usuarioRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return usuarioRepository.findAll();
    }
}
