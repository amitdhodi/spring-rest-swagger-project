package com.example.swagger.controller;

import com.example.swagger.entity.Resource;
import com.example.swagger.service.ResourceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation(
            value = "Get resource using GET endpoint",
            response = Resource[].class,
            responseContainer = "List"
    )
    @ApiResponses({
            @ApiResponse(code = 200, response = Resource[].class, message = "Get resources"),
            @ApiResponse(code = 400, message = "Bad request. Payload is not aligned with contract"),
            @ApiResponse(code = 401, message = "Not authorized to access resource"),
            @ApiResponse(code = 500, message = "Error message will be put here"),
    })
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "X-CLIENT-ID", value = "Client Id", dataType = "string", paramType = "header"),
                    @ApiImplicitParam(name = "X-CLIENT-SECRET", value = "Client Secret", dataType = "string", paramType = "header"),
                    @ApiImplicitParam(name = "Authorization", value = "Bearer <token>", dataType = "string", paramType = "header")
            }
    )

    @GetMapping(value = "/v1/resources", produces = "application/json")
    public List<Resource> getResource(){
        return resourceService.getAllResources();
    }


    @ApiOperation(
            value = "Add resource using POST endpoint"
    )
    @ApiResponses({
            @ApiResponse(code = 201, message = "Add resource"),
            @ApiResponse(code = 401, message = "Not authorized to access resource"),
            @ApiResponse(code = 404, message = "Resource does not exist"),
            @ApiResponse(code = 500, message = "Error message will be put here"),
    })
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "X-CLIENT-ID", value = "Client Id", dataType = "string", paramType = "header"),
                    @ApiImplicitParam(name = "X-CLIENT-SECRET", value = "Client Secret", dataType = "string", paramType = "header"),
                    @ApiImplicitParam(name = "Authorization", value = "Bearer <token>", dataType = "string", paramType = "header")
            }
    )
    @PostMapping(value = "/v1/resource", produces = "application/json")
    public void addResource(@RequestBody Resource resource){
        resourceService.saveResource(resource);
    }


    @ApiOperation(
            value = "Update resource using PUT endpoint"
    )

    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Update resource"),
                    @ApiResponse(code = 401, message = "Not authorized to access resource"),
                    @ApiResponse(code = 403, message = "Forbidden"),
                    @ApiResponse(code = 404, message = "Resource does not exist"),
                    @ApiResponse(code = 500, message = "Error message will be put here")
            }
    )

    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "X-CLIENT-ID", value = "Client Id", dataType = "string", paramType = "header"),
                    @ApiImplicitParam(name = "X-CLIENT-SECRET", value = "Client Secret", dataType = "string", paramType = "header"),
                    @ApiImplicitParam(name = "Authorization", value = "Bearer <token>", dataType = "string", paramType = "header")
            }
    )

    @PutMapping(
            value = "/v1/resource/{resourceId}",
            consumes = "application/json", produces = "application/json")
    public void updateResource(@RequestBody Resource resource, @PathVariable("resourceId") int resourceId){
        resourceService.updateResource(resource, resourceId);
    }
}
