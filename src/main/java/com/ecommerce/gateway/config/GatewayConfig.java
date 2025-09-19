package com.ecommerce.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-catalog-service", r -> r.path("/api/products/**")
                        .uri("lb://product-catalog-service"))
                .route("inventory-service", r -> r.path("/api/inventory/**")
                        .uri("lb://inventory-service"))
                .route("pricing-service", r -> r.path("/api/pricing/**")
                        .uri("lb://pricing-service"))
                .route("order-service", r -> r.path("/api/orders/**")
                        .uri("lb://order-service"))
                .route("user-service", r -> r.path("/api/users/**")
                        .uri("lb://user-service"))
                .route("notification-service", r -> r.path("/api/notifications/**")
                        .uri("lb://notification-service"))
                .build();
    }
}