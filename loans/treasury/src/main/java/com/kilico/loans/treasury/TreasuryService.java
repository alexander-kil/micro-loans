/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */

package com.kilico.loans.treasury;

import com.kilico.loans.treasury.model.Treasury;
import com.kilico.loans.treasury.model.type.TreasuryProviderStatusType;

import java.util.Map;

public interface TreasuryService extends CrudService<Treasury, Long> {
    TreasuryProviderStatusType connect(Treasury treasury);
}
