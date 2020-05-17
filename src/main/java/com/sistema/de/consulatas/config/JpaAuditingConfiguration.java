package com.sistema.de.consulatas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class JpaAuditingConfiguration {

    @Autowired
    private HttpSession httpSession;


    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAware<String>() {
            @Override
            public Optional<String> getCurrentAuditor() {

                try {
                    if (SecurityContextHolder.getContext().getAuthentication()!=null) {
                        String username = SecurityContextHolder.getContext().getAuthentication().getName();
                        return Optional.of(username);
                    }
                    else
                        return Optional.of("superadmin@anonymous.com");
                } catch (NullPointerException ex) {
                    return Optional.of("superadmin@anonymous.com");
                }
            }
        };

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }


}