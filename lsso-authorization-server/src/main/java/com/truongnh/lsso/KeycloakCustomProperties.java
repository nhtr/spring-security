package com.truongnh.lsso;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@Getter
@Setter
@ConfigurationProperties(prefix = "keycloak.custom")
public class KeycloakCustomProperties {

    Server server = new Server();

    AdminUser adminUser = new AdminUser();

    Infinispan infinispan = new Infinispan();
    
    String importLocation = "lsso-realm.json";

    @Getter
    @Setter
    public class Server {

        String contextPath;
    }

    @Getter
    @Setter
    public class Infinispan {

        Resource configLocation;
    }

    @Getter
    @Setter
    public class AdminUser {

        String username;

        String password;
    }
}
