package com.ResponseEntity.Prueba.controller;

import com.ResponseEntity.Prueba.config.database;
import com.ResponseEntity.Prueba.dto.RequestLoginDTO;
import com.ResponseEntity.Prueba.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @GetMapping
    public ResponseEntity<List<Usuario>> usuarios (Usuario usuario){
        return ResponseEntity.ok(database.usuarios);
    }

    @PostMapping
    public ResponseEntity<?> Register( @RequestBody Usuario usuario){
        for(Usuario u : database.usuarios){
            if(u.getEmail().equalsIgnoreCase(usuario.getEmail())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con ese correo ya existe");
            }
        }
        Usuario usuarioNuevo = new Usuario(
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getContraseña()
        );
        database.usuarios.add(usuarioNuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente");

    }


    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody RequestLoginDTO login){
        for(Usuario u : database.usuarios){
            if(u.getEmail().equalsIgnoreCase(login.getEmail()) && u.getContraseña().equalsIgnoreCase(login.getContraseña())){
                return ResponseEntity.status(HttpStatus.OK).body("Login exitoso");
            }

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales no validas");
    }
}
