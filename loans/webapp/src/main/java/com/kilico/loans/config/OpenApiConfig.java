/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */

package com.kilico.loans.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Loans API"
        , version = "0.0.1", contact = @Contact(name = "Alexandr Kil", email = "Alexander.Kill@gmail.com")
        , description = "Endpoint for HeadOffice, Accounting Engine, Private Area"))
public class OpenApiConfig {
//    @Bean
//    public OpenAPI openApiDescriptor(@Autowired BuildProperties buildProperties) throws IOException {
//        final OpenAPI loans_api_description = new OpenAPI()
//                .info(new Info()
//                        .title("Loans API description")
//                        .version(buildProperties.getVersion())
//                        .contact(new Contact().email("Alexander.Kill@gmail.com"))
//                );
//        new ObjectMapper(new YAMLFactory()).writer().writeValue(new File("openApiInfo.yaml"), loans_api_description);
//        return loans_api_description;
//    }
}
