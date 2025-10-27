package com.DinoData.DinoData.search.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

/**
 * 외부 공룡 API 호출에 필요한 설정을 관리하는 클래스.
 * (Base URL, Timeout 등)
 */
@Configuration
public class DinoApiClientConfig {

    /**
     * 외부 공룡 API의 기본 주소.
     * application.properties에 다음과 같이 설정:
     * external.dino.api.base-url=https://example-dino-api.com
     */
    @Value("${external.dino.api.base-url:https://example-dino-api.com}")
    private String baseUrl;

    /**
     * 요청 타임아웃 (ms)
     */
    @Value("${external.dino.api.timeout-ms:3000}")
    private int timeoutMs;

    /**
     * 외부 API 호출용 RestTemplate Bean
     */
    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(timeoutMs);
        factory.setReadTimeout(timeoutMs);
        return new RestTemplate(factory);
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
