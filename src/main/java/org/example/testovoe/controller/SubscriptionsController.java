package org.example.testovoe.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.testovoe.dto.SubscriptionsDTO;
import org.example.testovoe.service.SubscriptionsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubscriptionsController {

  private final SubscriptionsService subscriptionsService;

  @PostMapping("/users/{id}/subscriptions")
  public void addSubscription(@PathVariable int id, @RequestBody SubscriptionsDTO subscriptionsDTO) {
    subscriptionsService.addSubscription(id, subscriptionsDTO);
  }
  @GetMapping("/users/{id}/subscriptions")
  public List<SubscriptionsDTO> subscriptionsUser(@PathVariable int id) {
    return subscriptionsService.getSubscription(id);
  }

  @DeleteMapping("/users/subscriptions/{sub_id}")
  public void deleteSubscription(@PathVariable int sub_id) {
    subscriptionsService.deleteSubscription(sub_id);
  }

  @GetMapping("/subscriptions/top")
  public List<String> top() {
    return subscriptionsService.topSubscriptions();
  }

}
