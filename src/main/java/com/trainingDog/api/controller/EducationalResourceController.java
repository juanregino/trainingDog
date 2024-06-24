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

import com.trainingDog.api.dto.request.EducationalResourceReq;
import com.trainingDog.api.dto.response.basic.EducationalBasicResponse;
import com.trainingDog.infraestructure.abstract_services.IEducationalResourceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/educational-resource")
@RequiredArgsConstructor
public class EducationalResourceController {
  @Autowired
  private final IEducationalResourceService educationalResourceService;

  @PostMapping
  public ResponseEntity<EducationalBasicResponse> create(@Validated @RequestBody EducationalResourceReq request){
    return ResponseEntity.ok(this.educationalResourceService.create(request));
  }

  @GetMapping("/get")
  public ResponseEntity<List<EducationalBasicResponse>> getAll() {
    return ResponseEntity.ok(this.educationalResourceService.getAll());
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<EducationalBasicResponse> getById(@PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(this.educationalResourceService.get(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
    this.educationalResourceService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<EducationalBasicResponse> update(@Validated @RequestBody EducationalResourceReq request, @PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(this.educationalResourceService.update(request, id));
  }
}
