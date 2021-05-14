/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */

package com.kilico.loans.treasury;

import com.kilico.loans.treasury.model.TreasuryProvider;
import com.kilico.loans.treasury.model.type.TreasuryProviderStatusType;
import com.kilico.loans.treasury.model.type.TreasuryProviderType;
import org.springframework.plugin.core.Plugin;

public interface TreasuryProviderPlugin extends Plugin<TreasuryProviderType> {

    TreasuryProviderStatusType getStatus();

    String getId();

    TreasuryProvider getDefinition();
}
