/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */

package com.kilico.loans.treasury.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class TreasuryProvider {
    private String id;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String name;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Map<String, String> providerParams;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Map<String, String> registerParams;
}
