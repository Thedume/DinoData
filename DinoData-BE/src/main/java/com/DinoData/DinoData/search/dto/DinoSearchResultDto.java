package com.DinoData.DinoData.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 공룡 검색 결과 목록에서 한 공룡의 요약 정보를 담는 DTO.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DinoSearchResultDto {

    /** 공룡 이름 (예: "Tyrannosaurus") */
    private String name;

    /** 생존 시대 (예: "Late Cretaceous") */
    private String era;

    /** 간단한 설명 또는 특징 요약 */
    private String description;
}
