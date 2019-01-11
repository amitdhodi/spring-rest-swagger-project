package com.example.swagger.service;

import com.example.swagger.entity.Resource;
import com.example.swagger.exception.ResourceNotFoundException;
import com.example.swagger.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> getAllResources(){
        List<Resource> resources = new ArrayList<>();
        resourceRepository.findAll().forEach(resource -> resources.add(resource));
        return resources;
    }

    public void saveResource(Resource resource){
        resourceRepository.save(resource);
    }

    public void updateResource(Resource resource, int resourceId){
        Optional<Resource> resourceOptional = resourceRepository.findById(resourceId);
        if (resourceOptional.isPresent()){
            Resource dbResource = resourceOptional.get();
            dbResource.setAge(resource.getAge());
            dbResource.setName(resource.getName());
            resourceRepository.save(dbResource);
        } else {
            throw new ResourceNotFoundException("Resource with id: " + resourceId + " not found!!");
        }
    }
}
