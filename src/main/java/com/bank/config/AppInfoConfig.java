package com.bank.config;

import java.util.Map;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class AppInfoConfig implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {

        builder.withDetail("application", Map.of(
                "name", "Bank System",
                "description", "Bank System Application",
                "version", "1.0.0"
        ));
    }
}