package com.kcp.oms.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author kapanda
 *
 */
@SpringBootApplication
@EnableJpaRepositories
public class InventoryServiceApplication {

    public static void main(String[] args) {
        System.out.println("initializing spring applciation");
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
}
