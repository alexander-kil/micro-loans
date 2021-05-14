/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */
package com.kilico.loans.infra.ws;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class RootController {

//    @GetMapping
//    public RepresentationModel index() {
//        RepresentationModel rootResource = new RepresentationModel();
//        rootResource.add(ControllerLinkBuilder.linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
//        rootResource.add(ControllerLinkBuilder.linkTo(methodOn(ProjectController.class).all()).withRel("projects"));
//        rootResource.add(ControllerLinkBuilder.linkTo(methodOn(CustomerController.class).all()).withRel("customers"));
//        return rootResource;
//    }

}