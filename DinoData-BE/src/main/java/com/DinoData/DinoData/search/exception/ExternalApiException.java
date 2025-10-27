package com.DinoData.DinoData.search.exception;

/**
 * 외부 공룡 API 호출 중 오류가 발생했을 때 던지는 예외 클래스.
 * 예: API 서버 오류, 요청 파라미터 오류, 공룡 정보 없음 등
 */
public class ExternalApiException extends RuntimeException {

    /**
     * 기본 생성자
     */
    public ExternalApiException() {
        super("External API request failed");
    }

    /**
     * 커스텀 메시지 지정
     * @param message 오류 상세 메시지
     */
    public ExternalApiException(String message) {
        super(message);
    }

    /**
     * 예외 원인(중첩 예외) 포함 생성자
     * @param message 오류 메시지
     * @param cause 예외 원인
     */
    public ExternalApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
