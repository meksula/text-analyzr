package com.meksula.analyzr.analysis;

import com.meksula.analyzr.analysis.dto.TextAnaliseResult;
import com.meksula.analyzr.analysis.dto.TextAnalyseCommand;
import com.meksula.analyzr.analysis.dto.WordOccurrencesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
class TextAnalysisService {

    private final TextSplitter textSplitter;
    private final PositionSpecifier positionSpecifier;
    private final OccurrenceCounter occurrenceCounter;
    private final TextRepository textRepository;
    private final WordRepository wordRepository;
    private final WordOccurrenceRepository wordOccurrenceRepository;

    TextAnaliseResult analyseText(TextAnalyseCommand textAnalyseCommand) {
        final var wordList = textSplitter.splitTextByWords(textAnalyseCommand.text());
        final var wordDtoList = positionSpecifier.specifyPosition(wordList);
        final Set<WordOccurrencesDto> wordOccurrencesDtoList = occurrenceCounter.countOccurrences(wordDtoList);

        Text text = Text.create(textAnalyseCommand.text());
        textRepository.save(text);

        wordOccurrencesDtoList.forEach(dto -> wordRepository.findByWordValue(dto.word())
                .ifPresentOrElse(word -> saveIfWordExists(text, word, dto), () -> saveIfWordNotExists(text, dto)));

        return new TextAnaliseResult(sortAlphabetical(wordOccurrencesDtoList));
    }

    private List<WordOccurrencesDto> sortAlphabetical(Set<WordOccurrencesDto> wordOccurrencesDtoList) {
        return wordOccurrencesDtoList.stream()
                .sorted(Comparator.comparing(WordOccurrencesDto::word))
                .toList();
    }

    private void saveIfWordExists(Text text, Word word, WordOccurrencesDto dto) {
        WordOccurrence wordOccurrence = WordOccurrence.create(text, word, dto.textPositions());
        wordOccurrenceRepository.save(wordOccurrence);
    }

    private void saveIfWordNotExists(Text text, WordOccurrencesDto dto) {
        Word word = Word.create(dto.word());
        word = wordRepository.save(word);
        WordOccurrence wordOccurrence = WordOccurrence.create(text, word, dto.textPositions());
        wordOccurrenceRepository.save(wordOccurrence);
    }

}
