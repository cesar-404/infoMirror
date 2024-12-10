package br.com.infomirror.controller;

import br.com.infomirror.model.User;
import br.com.infomirror.model.UserDto;
import br.com.infomirror.service.UserService;
import br.com.infomirror.service.ViaCepService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService, ViaCepService viaCepService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDto));
    }
}