package com.example.swagger.repository;

import com.example.swagger.entity.Resource;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource, Integer> {
}
