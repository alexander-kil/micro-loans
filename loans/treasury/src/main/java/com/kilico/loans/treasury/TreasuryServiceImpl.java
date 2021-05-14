/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */

package com.kilico.loans.treasury;

import com.kilico.loans.treasury.model.Treasury;
import com.kilico.loans.treasury.model.TreasuryProvider;
import com.kilico.loans.treasury.model.type.TreasuryProviderStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class TreasuryServiceImpl implements TreasuryService {

    private final Map<Long, Treasury> registry = new HashMap<>();

    private final TreasuryProviderService providerService;

    public TreasuryServiceImpl(@Autowired TreasuryProviderService providerService) {
        this.providerService = providerService;
    }

    @Override
    public List<Treasury> list() {
        return new ArrayList<>(registry.values());
    }

    @Override
    public Optional<Treasury> get(final Long id) {
        return Optional.ofNullable(registry.get(id));
    }

    @Override
    public Treasury update(final Treasury entity) {
        return entity;
    }

    @Override
    public Treasury add(final Treasury entity) {
        entity.setProvider(providerService.get(entity.getProvider().getId()).get());
        entity.setStatus(connect(entity));
        return entity;
    }

    @Override
    public void delete(final Long id) {

    }

    @Override
    public TreasuryProviderStatusType connect(final Treasury treasury) {
        return providerService.connect(treasury);
    }

    @PostConstruct
    void init() {
        registry.put((long) registry.size(), add(Treasury.builder()
                .id((long) registry.size())
                .provider(providerService.get("paysend-b").get())
                .name("My PS BA")
                .build()));
    }
}
