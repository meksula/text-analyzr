package com.meksula.analyzr.api;

import com.meksula.analyzr.analysis.dto.TextAnaliseResult;
import com.meksula.analyzr.analysis.dto.TextAnalyseCommand;
import com.meksula.analyzr.analysis.TextAnalysisFacade;
import com.meksula.analyzr.analysis.dto.WordSearchCommand;
import com.meksula.analyzr.analysis.dto.WordSearchResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
class TextAnalyzerController {

    private final TextAnalysisFacade textAnalysisFacade;

    @PostMapping("/analyze")
    ResponseEntity<TextAnalyzeResponse> textAnalyze(@Valid @RequestBody TextAnalyzeRequest textAnalyzeRequest) {
        var textAnalyseCommand = new TextAnalyseCommand(textAnalyzeRequest.text());
        TextAnaliseResult textAnaliseResult = textAnalysisFacade.analyseText(textAnalyseCommand);
        return ResponseEntity.ok(new TextAnalyzeResponse(textAnaliseResult.words()));
    }

    @PostMapping("/word")
    ResponseEntity<WordSearchResponse> wordSearch(@Valid @RequestBody WordSearchRequest wordSearchRequest) {
        var wordSearchCommand = new WordSearchCommand(wordSearchRequest.word());
        WordSearchResult wordSearchResult = textAnalysisFacade.wordSearch(wordSearchCommand);
        return ResponseEntity.ok(new WordSearchResponse(wordSearchResult.word(), wordSearchResult.texts()));
    }
}
