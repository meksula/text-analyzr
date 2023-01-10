package com.meksula.analyzr.analysis;

import com.meksula.analyzr.analysis.dto.SingleTextResult;
import com.meksula.analyzr.analysis.dto.WordSearchCommand;
import com.meksula.analyzr.analysis.dto.WordSearchResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class WordSearchService {

    private final WordRepository wordRepository;
    private final WordOccurrenceRepository wordOccurrenceRepository;

    WordSearchResult wordSearch(WordSearchCommand wordSearchCommand) {
        return wordRepository.findByWordValue(wordSearchCommand.word())
                .map(wordOccurrenceRepository::findAllByWord)
                .map(wordOccurrences -> new WordSearchResult(wordSearchCommand.word(),
                        wordOccurrences.stream()
                                .map(wordOccurrence -> new SingleTextResult(wordOccurrence.textId(),
                                        wordOccurrence.occurrences(), wordOccurrence.textPositions()))
                                .collect(Collectors.toList())))
                .orElseThrow(() -> new EntityNotFoundException("Cannot find word: " + wordSearchCommand.word()));
    }
}
