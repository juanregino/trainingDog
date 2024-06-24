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

import com.trainingDog.api.dto.request.ProgressRequest;
import com.trainingDog.api.dto.response.basic.ProgressBasicResponse;
import com.trainingDog.infraestructure.abstract_services.IProgressService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/progress")
@RequiredArgsConstructor
public class ProgressController {
   @Autowired
  private final IProgressService progressService;

  @PostMapping
  public ResponseEntity<ProgressBasicResponse> createProgress(@Validated @RequestBody ProgressRequest request) {
    return ResponseEntity.ok(this.progressService.create(request));
  }

  @GetMapping
  public ResponseEntity<List<ProgressBasicResponse>> getAll() {
    return ResponseEntity.ok(this.progressService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProgressBasicResponse> getById(@PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(this.progressService.get(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
    this.progressService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProgressBasicResponse> update(@Validated @RequestBody ProgressRequest request, @PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(this.progressService.update(request, id));
  }


}
