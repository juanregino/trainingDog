package com.trainingDog.infraestructure.abstract_services;

import java.util.List;

import org.springframework.data.domain.Page;

public interface CrudService<RQ, RS, ID> {

  public RS create(RQ request);

  public RS get(ID id);

  public RS update(RQ request, ID id);

  public void delete(ID id);

  public List<RS> getAll();
}
