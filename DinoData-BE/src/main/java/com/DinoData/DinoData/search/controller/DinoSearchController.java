package com.DinoData.DinoData.search.controller;

import com.DinoData.DinoData.search.dto.DinoSearchResultDto;
import com.DinoData.DinoData.search.dto.DinoDetailDto;
import com.DinoData.DinoData.search.service.DinoSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search/dinosaurs")
@RequiredArgsConstructor
public class DinoSearchController {

    private final DinoSearchService dinoSearchService;

    /**
     * 공룡 이름 일부로 검색
     * 예: GET /api/search/dinosaurs?q=tyran
     */
    @GetMapping
    public ResponseEntity<List<DinoSearchResultDto>> searchDinosaurs(
            @RequestParam(name = "q") String query
    ) {
        List<DinoSearchResultDto> results = dinoSearchService.searchByName(query);
        return ResponseEntity.ok(results);
    }

    /**
     * 특정 공룡 이름으로 상세 정보 조회
     * 예: GET /api/search/dinosaurs/Tyrannosaurus
     */
    @GetMapping("/{name}")
    public ResponseEntity<DinoDetailDto> getDinosaurDetail(
            @PathVariable String name
    ) {
        DinoDetailDto detail = dinoSearchService.getDinosaurDetail(name);
        return ResponseEntity.ok(detail);
    }
}
