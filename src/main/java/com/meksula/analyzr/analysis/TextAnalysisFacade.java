package com.meksula.analyzr.analysis;

import com.meksula.analyzr.analysis.dto.TextAnaliseResult;
import com.meksula.analyzr.analysis.dto.TextAnalyseCommand;
import com.meksula.analyzr.analysis.dto.WordSearchCommand;
import com.meksula.analyzr.analysis.dto.WordSearchResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TextAnalysisFacade {

    private final TextAnalysisService textAnalysisService;
    private final WordSearchService wordSearchService;

    public TextAnaliseResult analyseText(TextAnalyseCommand textAnalyseCommand) {
        return textAnalysisService.analyseText(textAnalyseCommand);
    }

    public WordSearchResult wordSearch(WordSearchCommand wordSearchCommand) {
        return wordSearchService.wordSearch(wordSearchCommand);
    }
}
