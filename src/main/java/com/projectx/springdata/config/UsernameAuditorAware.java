package com.projectx.springdata.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsernameAuditorAware implements AuditorAware<String> {

    private static final String SYSTEM = "SYSTEM";

    @Override
    public Optional<String> getCurrentAuditor() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() != null) {
//            return Optional.ofNullable(((UserDetails) authentication.getPrincipal()).getUsername());
//        }
        return Optional.of(SYSTEM);
    }
}
