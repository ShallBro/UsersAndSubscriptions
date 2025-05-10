package org.example.testovoe.controller;

import lombok.RequiredArgsConstructor;
import org.example.testovoe.dto.UserDTO;
import org.example.testovoe.service.UsersService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {
  private final UsersService usersService;

  @PostMapping("/post")
  public void createUser(@RequestBody UserDTO userDTO) {
    usersService.createUser(userDTO);
  }

  @GetMapping("/get")
  public UserDTO getUser(@RequestParam int id) {
    return usersService.getUser(id);
  }

  @PutMapping("/put")
  public UserDTO putUser(@RequestParam int id, @RequestBody UserDTO userDTO) {
    return usersService.updateUser(id, userDTO);
  }

  @DeleteMapping("/delete")
  public void deleteUser(@RequestParam int id) {
    usersService.deleteUser(id);
  }
}
