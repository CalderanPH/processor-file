package br.paulocalderan.fileprocessor.domain.user.controller;


import br.paulocalderan.fileprocessor.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@Valid @RequestParam("file") MultipartFile file) {
        userService.processFile(file);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<String> getAllUsers(@RequestParam(value = "source", required = false) String source) {
        return ResponseEntity.ok(userService.findAllUsers(source));
    }

}
