package ru.geekbrains;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.geekbrains.product.ProductRepository;
import ru.geekbrains.product.ProductService;

@Configuration
@ComponentScan("ru.geekbrains")
public class AppConfig {

    @Bean
    public ProductRepository productRepository() {
        return new ProductService();
    }

    @Bean
    @Scope("prototype")
    public CartService cartService() {
        return new CartService();
    }
}
