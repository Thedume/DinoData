package com.DinoData.DinoData.search.service;

import com.DinoData.DinoData.search.dto.DinoSearchResultDto;
import com.DinoData.DinoData.search.dto.DinoDetailDto;
import com.DinoData.DinoData.search.client.ExternalDinoApiClient;
import com.DinoData.DinoData.search.exception.ExternalApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DinoSearchService {

    private final ExternalDinoApiClient externalDinoApiClient;

    /**
     * 공룡 이름 일부로 검색해서 후보 리스트를 반환
     * 예: query = "tyran" -> ["Tyrannosaurus", "Tyrannotitan", ...]
     */
    public List<DinoSearchResultDto> searchByName(String query) {
        // TODO: 외부 API 연동으로 교체 예정
        // return externalDinoApiClient.searchDinosaurs(query);

        // 임시 mock 결과
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
     * 특정 공룡 상세 정보 조회
     * 예: name = "Tyrannosaurus"
     */
    public DinoDetailDto getDinosaurDetail(String name) {
        // TODO: 외부 API 연동으로 교체 예정
        // return externalDinoApiClient.getDinosaurDetail(name)
        //        .orElseThrow(() -> new ExternalApiException("Dinosaur not found: " + name));

        // 임시 mock 상세
        if (name.equalsIgnoreCase("Tyrannosaurus")) {
            return new DinoDetailDto(
                    "Tyrannosaurus",
                    "Late Cretaceous",
                    "CARNIVORE",
                    12.3,
                    8000.0,
                    "One of the largest known terrestrial carnivores."
            );
        }

        // 기본적으로는 못 찾았다고 예외 던짐
        throw new ExternalApiException("Dinosaur not found: " + name);
    }
}
