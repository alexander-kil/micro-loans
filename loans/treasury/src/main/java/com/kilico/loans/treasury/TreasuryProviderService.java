/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */

package com.kilico.loans.treasury;

import com.kilico.loans.treasury.model.Treasury;
import com.kilico.loans.treasury.model.TreasuryProvider;
import com.kilico.loans.treasury.model.type.TreasuryProviderStatusType;

public interface TreasuryProviderService extends CrudService<TreasuryProvider, String> {

    TreasuryProviderStatusType connect(Treasury treasury);
    TreasuryProviderStatusType getProviderStatus(String id);
}
