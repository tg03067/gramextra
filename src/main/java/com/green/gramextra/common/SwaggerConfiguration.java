package com.green.gramextra.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "그램엑스트라"
                , description = "GramExtra with react"
                , version = "v4"
        )
)
public class SwaggerConfiguration {

}
