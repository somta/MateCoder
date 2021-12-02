package net.somta.matecoder.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * 访问地址: http://localhost:8888/swagger-ui/index.html
 */
@OpenAPIDefinition(
        info = @Info(
                title = "OpenApi接口文档",
                description = "项目接口文档",
                version = "0.0.2"
        )
)
@Configuration
public class OpenApiConfiguration {
}
