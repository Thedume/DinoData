package com.DinoData.DinoData.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 특정 공룡의 상세 정보를 담는 DTO.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DinoDetailDto {

    /** 공룡 이름 (예: "Tyrannosaurus") */
    private String name;

    /** 생존 시대 (예: "Late Cretaceous") */
    private String era;

    /** 식성 (예: "CARNIVORE", "HERBIVORE", "OMNIVORE") */
    private String diet;

    /** 길이 (미터 단위) */
    private Double lengthMeters;

    /** 무게 (킬로그램 단위) */
    private Double weightKg;

    /** 공룡 설명 (상세 설명문) */
    private String description;
}
