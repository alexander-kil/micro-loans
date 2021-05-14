/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */

package com.kilico.loans.treasury.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "Treasury", description = "describes Card source")
public class Card {
    @Schema(description = "id/token of card registration by provider", accessMode = Schema.AccessMode.READ_ONLY)
    private String id;
    @Schema(description = "expiration of id/token", accessMode = Schema.AccessMode.READ_ONLY)
    private String expiresAt;
    @Schema(description = "user defined name for the card")
    private String name;
    @Schema(description = "card number or 'last four' if card is registered")
    private String number;
    @Schema(description = "month of card expiration")
    private Integer expirationMonth;
    @Schema(description = "year of card expiration")
    private Integer expirationYear;
}
