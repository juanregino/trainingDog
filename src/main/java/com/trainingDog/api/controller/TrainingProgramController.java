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

import com.trainingDog.api.dto.request.TrainingProgramRequest;
import com.trainingDog.api.dto.response.basic.TrainingPBasicResponse;
import com.trainingDog.infraestructure.abstract_services.ITrainingProgramService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/training-program")
@RequiredArgsConstructor
public class TrainingProgramController {
  @Autowired
  private final ITrainingProgramService trainingProgramService;

  @PostMapping
  public ResponseEntity<TrainingPBasicResponse> createT(@Validated @RequestBody
  TrainingProgramRequest request) {
    return ResponseEntity.ok(this.trainingProgramService.create(request));
  }

  @GetMapping("/get")
  public ResponseEntity<List<TrainingPBasicResponse>> getAll() {
    return ResponseEntity.ok(this.trainingProgramService.getAll());
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<TrainingPBasicResponse> getById(@PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(this.trainingProgramService.get(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
    this.trainingProgramService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<TrainingPBasicResponse> update(@Validated @RequestBody TrainingProgramRequest request, @PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(this.trainingProgramService.update(request, id));
  }

}
