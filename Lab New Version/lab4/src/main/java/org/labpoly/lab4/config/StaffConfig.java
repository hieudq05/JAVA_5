package org.labpoly.lab4.config;

import org.labpoly.lab4.model.Staff;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class StaffConfig {
    @Bean
    @Scope
    public Staff staff() {
        return new Staff();
    }
}
