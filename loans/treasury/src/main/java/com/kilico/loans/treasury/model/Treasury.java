/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */

package com.kilico.loans.treasury.model;

import com.kilico.loans.treasury.model.type.TreasuryProviderStatusType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
@Schema(name = "Treasury", description = "describes Treasury source")
public class Treasury {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String name;
    private TreasuryProvider provider;
    private Map<String, String> providerParams;
    private Map<String, String> registerParams;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private TreasuryProviderStatusType status;
}
