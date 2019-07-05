package com.ecut.entitys;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Amy
 * @date 2019-07-05 11:19
 * @description:
 */
@Component
@PropertySource({"classpath:/jdbc.properties"})
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSource {

    private String url;

    private String username;

    private String password;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
