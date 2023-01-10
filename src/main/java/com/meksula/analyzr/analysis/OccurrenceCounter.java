package com.meksula.analyzr.analysis;

import com.meksula.analyzr.analysis.dto.WordDto;
import com.meksula.analyzr.analysis.dto.WordOccurrencesDto;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
class OccurrenceCounter {

    Set<WordOccurrencesDto> countOccurrences(List<WordDto> wordDtoList) {
        return wordDtoList.stream()
                .map(wordDto -> {
                    final List<Integer> positions = wordDtoList.stream()
                            .filter(second -> wordDto.word().equals(second.word()))
                            .map(WordDto::position)
                            .toList();
                    return new WordOccurrencesDto(wordDto.word(), positions.size(), positions);
                }).collect(Collectors.toSet());
    }
}
