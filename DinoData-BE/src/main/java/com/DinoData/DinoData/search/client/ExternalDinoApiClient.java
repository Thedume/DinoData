package com.DinoData.DinoData.search.client;

import com.DinoData.DinoData.search.dto.DinoSearchResultDto;
import com.DinoData.DinoData.search.dto.DinoDetailDto;
import com.DinoData.DinoData.search.exception.ExternalApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * 외부 공룡 API와의 통신을 담당하는 클래스.
 * 실제 HTTP 호출은 여기서 수행되며, 서비스 계층에서는 이 클래스를 통해서만 접근함.
 */
@Slf4j
@Component
public class ExternalDinoApiClient {

    /**
     * 공룡 이름 일부로 외부 API에서 검색
     * @param query 검색어 (예: "tyran")
     * @return 공룡 검색 결과 리스트
     */
    public List<DinoSearchResultDto> searchDinosaurs(String query) {
        // TODO: 실제 외부 API 호출 로직으로 교체 예정
        log.info("[External API] Search dinosaurs with query: {}", query);

        // 임시 Mock 데이터
        return List.of(
                new DinoSearchResultDto(
                        "Tyrannosaurus",
                        "Late Cretaceous",
                        "Large carnivorous theropod"
                ),
                new DinoSearchResultDto(
                        "Tyrannotitan",
                        "Early Cretaceous",
                        "Large carcharodontosaurid theropod"
                )
        );
    }

    /**
     * 특정 공룡 이름으로 외부 API에서 상세 정보 조회
     * @param name 공룡 이름 (예: "Tyrannosaurus")
     * @return 공룡 상세 정보 DTO (없을 경우 Optional.empty)
     */
    public Optional<DinoDetailDto> getDinosaurDetail(String name) {
        // TODO: 실제 외부 API 호출 로직으로 교체 예정
        log.info("[External API] Get dinosaur detail for: {}", name);

        // Mock 예시
        if (name.equalsIgnoreCase("Tyrannosaurus")) {
            return Optional.of(new DinoDetailDto(
                    "Tyrannosaurus",
                    "Late Cretaceous",
                    "CARNIVORE",
                    12.3,
                    8000.0,
                    "One of the largest known terrestrial carnivores."
            ));
        }

        // 공룡 이름이 일치하지 않으면 empty 반환
        return Optional.empty();
    }

    /**
     * 실제 외부 API 연동 시 사용할 예외 래핑 메서드 예시
     */
    private void handleExternalError(String message, Exception e) {
        log.error("[External API ERROR] {} - {}", message, e.getMessage());
        throw new ExternalApiException(message, e);
    }
}
