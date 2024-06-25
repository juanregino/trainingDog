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

import com.trainingDog.api.dto.request.TrainingRequest;
import com.trainingDog.api.dto.response.basic.TrainingResponse;
import com.trainingDog.infraestructure.abstract_services.ITrainingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingController {
  
  @Autowired
  private final ITrainingService trainingService;

  @PostMapping
  public ResponseEntity<TrainingResponse> createTraining(@Validated @RequestBody TrainingRequest request) { 
    return ResponseEntity.ok(this.trainingService.create(request));
  }

  @GetMapping
  public ResponseEntity<List<TrainingResponse>> getAllTrainings() {
    return ResponseEntity.ok(this.trainingService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<TrainingResponse> getTrainingById(@PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(this.trainingService.get(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTraining(@PathVariable(value = "id") Long id) {
    this.trainingService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<TrainingResponse> updateTraining(@Validated @RequestBody TrainingRequest request, @PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(this.trainingService.update(request, id));
  }
}
