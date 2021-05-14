/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */

package com.kilico.loans.treasury;

import com.kilico.loans.treasury.model.TreasuryProvider;
import com.kilico.loans.treasury.model.type.TreasuryProviderStatusType;
import com.kilico.loans.treasury.model.type.TreasuryProviderType;
import org.springframework.stereotype.Component;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.HashMap;

@Component
public class PaySendBusinessProviderPlugin implements TreasuryProviderPlugin {

    final static TreasuryProviderType SUPPORTED = TreasuryProviderType.CARD;

    @Override
    public TreasuryProviderStatusType getStatus() {
        return TreasuryProviderStatusType.ONLINE;
    }

    @Override
    public String getId() {
        return "paysend-b";
    }

    @Override
    public TreasuryProvider getDefinition() {
        return TreasuryProvider.builder()
                .id(getId())
                .name("Paysend Business")
                .providerParams(new HashMap<String, String>(){
                    {
                        put("client_id", "clientId from registration");
                        put("client_secret", "client_secret from registration");
                    }
                })
                .registerParams(new HashMap<String, String>(){
                    {
                        put("number", "Card number without any separators");
                        put("expiration_month", "Integer representing the card’s expiration month");
                        put("expiration_year", "Four digit number representing card’s expiration year");
                        put("security_code", "Card security code (CVC, CVV2)");
                    }
                })
                .build();
    }

    @Override
    public boolean supports(TreasuryProviderType delimiter) {
        return SUPPORTED.equals(delimiter);
    }
}
