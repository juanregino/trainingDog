package com.trainingDog.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingDog.api.dto.request.DogRequest;
import com.trainingDog.api.dto.response.basic.DogBasicResponse;
import com.trainingDog.infraestructure.abstract_services.IDogService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dogs")
@RequiredArgsConstructor

public class DogController {
  
  @Autowired
  private final IDogService dogService;
  @PostMapping
  public ResponseEntity<DogBasicResponse> createDog(@Validated @RequestBody DogRequest dog) {
    return ResponseEntity.ok(this.dogService.create(dog));

  }

  @GetMapping("/get")
  public ResponseEntity<List<DogBasicResponse>> getAllDogs() {
    return ResponseEntity.ok(this.dogService.getAll());
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<DogBasicResponse> getDogById(@PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(this.dogService.get(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDog(@PathVariable(value = "id") Long id) {
    this.dogService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<DogBasicResponse> updateDog(@Validated @RequestBody DogRequest dog ,@PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(this.dogService.update(dog, id));
  }
}
