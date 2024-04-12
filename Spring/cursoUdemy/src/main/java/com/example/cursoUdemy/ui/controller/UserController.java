package com.example.cursoUdemy.ui.controller;


import com.example.cursoUdemy.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.cursoUdemy.ui.model.request.UserDetailsRequestModel;
import com.example.cursoUdemy.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, UserRest> users;

    //Búsqueda por número de página y límite de usuarios mostrados
    //Parámetros por defecto con default
    //Parámetros opcionales con required. No funciona correctamente con tipos de dato primitivos
    @GetMapping
    public String getUsers(@RequestParam(value="page", defaultValue="1") int page,
                           @RequestParam(value="limit", defaultValue="50") int limit,
                           @RequestParam(value="sort", defaultValue="desc",required = false) String sort)
    {
        return "get users was called with page = " + page + " and limit " + limit + " and sort = " + sort;
    }

    //Búsqueda por ID
    @GetMapping(path="/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

        //Control si le pasamos un ID válido o si ese ID no existe en el HashMap
        if(users.containsKey(userId)){
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Validated @RequestBody UserDetailsRequestModel userDetails){

        //Creación de usuario con instancia a clase UserRest
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        //Creamos ID único y añadimos entrada al HashMap users
        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);
        if(users==null) users = new HashMap<>();
        users.put(userId, returnValue);

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path="/{userId}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId, @Validated @RequestBody UpdateUserDetailsRequestModel userDetails){

        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId, storedUserDetails);
        return storedUserDetails;
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        users.remove(id);
        return ResponseEntity.noContent().build();
    }
}
