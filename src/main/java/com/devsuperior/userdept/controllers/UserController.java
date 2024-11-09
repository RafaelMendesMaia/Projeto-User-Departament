package com.devsuperior.userdept.controllers;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que essa classe vai ser um Controlador e vai receber Resquisições!.
@RequestMapping( value = "/users") // Caminho da requisição
public class UserController {

    @Autowired // Mecanismo de injeção de dependência, não preciso ficar instaciando.
    private UserRepository repository; // Acesso ao banco de Dados que é por meio da classe UserRepository


    // LISTAR
    @GetMapping
    public List<User> findAll(){
     List<User> result = repository.findAll();
     return result;

    }

    // BUSCAR USUARIOS!!
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }

    // OUTRO JEITO DE DAR UM GET BUSCAR NO USUARIO!!!!!

    /*
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User result = repository.findById(id).get();
        return = result;
    }
    */

    // Adicionar Usuarios!!!
    @PostMapping
    public User insert(@RequestBody User user) {
        User result = repository.save(user);
        return result;
    }




}
