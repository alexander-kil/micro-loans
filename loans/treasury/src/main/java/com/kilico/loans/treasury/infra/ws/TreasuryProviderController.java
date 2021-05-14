/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */
package com.kilico.loans.treasury.infra.ws;

import com.kilico.loans.treasury.TreasuryProviderService;
import com.kilico.loans.treasury.model.Treasury;
import com.kilico.loans.treasury.model.TreasuryProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/treasury/provider", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "treasury")
public class TreasuryProviderController {

    private final TreasuryProviderService providerService;

    public TreasuryProviderController(@Autowired TreasuryProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping()
    @Operation(summary = "List of all available Treasury providers")
    public ResponseEntity<CollectionModel<EntityModel<TreasuryProvider>>> treasuryProviderFindAll() {
        List<EntityModel<TreasuryProvider>> list = providerService.list().stream()
                .map(EntityModel::of).collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(list));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Read Treasury Provider by Id")
    public ResponseEntity<EntityModel<TreasuryProvider>> findOne(@PathVariable String id) {
        return providerService.get(id)
                .map(EntityModel::of)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}