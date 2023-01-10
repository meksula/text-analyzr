package com.meksula.analyzr.analysis;

import com.meksula.analyzr.analysis.dto.WordDto;
import com.meksula.analyzr.analysis.dto.WordOccurrencesDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OccurrenceCounterTest {

    @Test
    @Disabled("Should correctly count occurrences of words in text")
    void shouldCorrectlyCountOccurrencesOfWordsInText() {
        String text = TextUtils.getTEXT();
        TextSplitter textSplitter = new TextSplitter();
        List<String> wordList = textSplitter.splitTextByWords(text);

        PositionSpecifier positionSpecifier = new PositionSpecifier();
        List<WordDto> wordDtoList = positionSpecifier.specifyPosition(wordList);

        OccurrenceCounter occurrenceCounter = new OccurrenceCounter();
        Set<WordOccurrencesDto> wordOccurrencesDto = occurrenceCounter.countOccurrences(wordDtoList);

        assertAll(
                () -> assertEquals(37, wordOccurrencesDto.size()),
                () -> assertEquals(2, TextUtils.find(wordOccurrencesDto, "w").occurrences()),
                () -> assertEquals(1, TextUtils.find(wordOccurrencesDto, "Wirus").occurrences())
        );
    }


}