/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */

package com.kilico.loans.treasury;

import com.kilico.loans.treasury.model.Treasury;
import com.kilico.loans.treasury.model.TreasuryProvider;
import com.kilico.loans.treasury.model.type.TreasuryProviderStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.plugin.core.OrderAwarePluginRegistry;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.naming.OperationNotSupportedException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TreasuryProviderServiceImpl implements TreasuryProviderService {

    private final Map<String, TreasuryProvider> registry = new HashMap<>();

    @Qualifier("treasuryProviderPluginRegistry")
    @Autowired
    private OrderAwarePluginRegistry pluginRegistry;

    @Override
    public List<TreasuryProvider> list() {
        final List<TreasuryProviderPlugin> plugins = pluginRegistry.getPlugins();
        return plugins.stream().map(TreasuryProviderPlugin::getDefinition).collect(Collectors.toList());
//        return new ArrayList<>(registry.values());
    }

    @Override
    public Optional<TreasuryProvider> get(String id) {
        final List<TreasuryProviderPlugin> plugins = pluginRegistry.getPlugins();
        return plugins.stream()
                .filter(providerPlugin -> id.equals(providerPlugin.getId()))
                .map(TreasuryProviderPlugin::getDefinition)
                .findFirst();
//        return Optional.of(registry.get(id));
    }

    @Override
    public TreasuryProvider update(TreasuryProvider entity) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public TreasuryProvider add(TreasuryProvider entity) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public void delete(String id) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public TreasuryProviderStatusType connect(final Treasury treasury) {
        return TreasuryProviderStatusType.UNDEFINED;
    }

    @Override
    public TreasuryProviderStatusType getProviderStatus(String id) {
        final List<TreasuryProviderPlugin> plugins = pluginRegistry.getPlugins();
        return plugins.stream()
                .filter(providerPlugin -> id.equals(providerPlugin.getId()))
                .map(TreasuryProviderPlugin::getStatus)
                .findFirst().orElse(TreasuryProviderStatusType.UNDEFINED);
    }

    @PostConstruct
    void init() {
//        registry.put("paysend-ga", TreasuryProvider.builder()
//                .id("paysend-ga")
//                .name("Paysend Global Account")
//                .providerParams(new String[]{"client_id", "client_secret"})
//                .build());
    }
}
