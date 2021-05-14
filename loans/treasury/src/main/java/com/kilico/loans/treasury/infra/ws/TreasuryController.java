/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */
package com.kilico.loans.treasury.infra.ws;

import com.kilico.loans.treasury.TreasuryService;
import com.kilico.loans.treasury.model.Treasury;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.OperationNotSupportedException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/treasury", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "treasury", description = "the Treasury API")
public class TreasuryController {

    private final TreasuryService treasuryService;

    public TreasuryController(@Autowired TreasuryService treasuryService) {
        this.treasuryService = treasuryService;
    }

    @GetMapping
    @Operation(summary = "List of all registered Treasury sources")
    public ResponseEntity<CollectionModel<EntityModel<Treasury>>> findAll() {
        List<EntityModel<Treasury>> list = treasuryService.list()
                .stream()
                .map(EntityModel::of)
                .collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(list));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Read Treasury by Id")
    public ResponseEntity<EntityModel<Treasury>> findOne(@PathVariable long id) {
        return treasuryService.get(id)
                .map(EntityModel::of)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Register a new Treasury source")
    public ResponseEntity<EntityModel<Treasury>> newTreasury(@RequestBody Treasury treasury) throws OperationNotSupportedException {
        EntityModel<Treasury> model = EntityModel.of(treasuryService.add(treasury));
//        try {
//            return ResponseEntity.created(new URI(model.getRequiredLink(IanaLinkRelations.SELF).getHref())).body(model);
            return ResponseEntity.ok().body(model);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(null);
//        }
    }

    @PutMapping
    @Operation(summary = "Update the Treasury source")
    public ResponseEntity<EntityModel<Treasury>> updateTreasury(@RequestBody Treasury treasury) throws OperationNotSupportedException {
        EntityModel<Treasury> model = EntityModel.of(treasuryService.update(treasury));
        try {
            return ResponseEntity.created(new URI(model.getRequiredLink(IanaLinkRelations.SELF).getHref())).body(model);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
}