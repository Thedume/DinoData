package com.DinoData.DinoData.config;

import com.DinoData.DinoData.search.exception.ExternalApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

/**
 * 컨트롤러 전역에서 발생하는 예외를 JSON 형태로 변환해주는 핸들러.
 * 프론트엔드는 이 포맷만 믿고 처리하면 됨.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 외부 API 관련 예외 처리
     * 예: 공룡 정보 없음, 외부 API 호출 실패 등
     * 기본적으로 502 Bad Gateway로 내려주지만
     * 필요에 따라 DinoSearchService에서
     * 더 세부적인 예외 타입을 분리할 수도 있음.
     */
    @ExceptionHandler(ExternalApiException.class)
    public ResponseEntity<Map<String, Object>> handleExternalApiException(ExternalApiException e) {
        HttpStatus status = HttpStatus.BAD_GATEWAY; // 502

        Map<String, Object> body = Map.of(
                "error", "external_api_error",
                "message", e.getMessage(),
                "status", status.value(),
                "timestamp", Instant.now().toString()
        );

        return ResponseEntity.status(status).body(body);
    }

    /**
     * 기타 처리하지 않은 모든 예외 처리
     * NullPointerException 등 예상 못 한 서버 내부 에러
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500

        Map<String, Object> body = Map.of(
                "error", "internal_server_error",
                "message", e.getMessage(),
                "status", status.value(),
                "timestamp", Instant.now().toString()
        );

        return ResponseEntity.status(status).body(body);
    }
}