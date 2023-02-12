package com.reliance.integratenotificationservicedemo.controller;


import com.reliance.integratenotificationservicedemo.config.ApplicationProperties;
import com.reliance.integratenotificationservicedemo.pojo.SpecificResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.File;

@Component
public class DemoUploadTemplate {

    private final ApplicationProperties applicationProperties;

    private static Logger logger = LoggerFactory.getLogger(DemoUploadTemplate.class);

    public DemoUploadTemplate(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }


    /**
     * Initializes method to upload template.
     * <p>
     * This method runs only once, just after the initialization of bean properties.
     * This method is so because you can't upload templates eternally via postman calls
     * If you need to update the template, just change the file with same name and deploy again
     * <p>
     * You can find more information in the documentation.
     */
    @PostConstruct
    private void postConstruct() {

        logger.info("calling Notification service to upload template");

        //The try catch is here simply because I don't want the application start up to break because it can't upload template successfully.
        //Do at your own discretion and project design.
        try {
            File file = new File (new ClassPathResource("src/main/resources/templates/email/autorenewalt2.html").getPath());

            LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
            params.add("file", new FileSystemResource(file));
            params.add("name", applicationProperties.getNameOfEmailTemplate());
            params.add("documentType", "HTML_FILE");
            params.add("isFragment", false);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity =
                    new HttpEntity<>(params, headers);

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<Object> responseEntity = restTemplate.exchange(
                    applicationProperties.getNotificationServiceUrl() + "/api/templates/upload",
                    HttpMethod.POST,
                    requestEntity,
                    Object.class);

            HttpStatus statusCode = responseEntity.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                logger.info("upload successful");
                logger.info("response: {}", responseEntity.getBody());
            }else {
                logger.info("upload not successful");
                logger.info("response: {}", responseEntity.getBody());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.info("upload not successful");
            logger.error("errorInfo: {}", e.getMessage());
        }


    }

}
