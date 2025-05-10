package org.example.testovoe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundUser extends RuntimeException{
  public NotFoundUser(int id) {
    super("Не найден пользователь с id: " + id);
  }
}
