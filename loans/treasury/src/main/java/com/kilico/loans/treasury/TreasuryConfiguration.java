/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */

package com.kilico.loans.treasury;

import org.springframework.context.annotation.Configuration;
import org.springframework.plugin.core.config.EnablePluginRegistries;

@EnablePluginRegistries(TreasuryProviderPlugin.class)
@Configuration
public class TreasuryConfiguration {
}
