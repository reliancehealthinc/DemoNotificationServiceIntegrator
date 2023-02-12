package com.reliance.integratenotificationservicedemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private String notificationServiceUrl;
    private String nameOfEmailTemplate;


    public String getNotificationServiceUrl() {
        return notificationServiceUrl;
    }

    public void setNotificationServiceUrl(String notificationServiceUrl) {
        this.notificationServiceUrl = notificationServiceUrl;
    }

    public String getNameOfEmailTemplate() {
        return nameOfEmailTemplate;
    }

    public void setNameOfEmailTemplate(String nameOfEmailTemplate) {
        this.nameOfEmailTemplate = nameOfEmailTemplate;
    }
}
