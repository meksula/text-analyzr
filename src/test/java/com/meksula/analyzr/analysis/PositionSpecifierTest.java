package com.meksula.analyzr.analysis;

import com.meksula.analyzr.analysis.dto.WordDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PositionSpecifierTest {

    @Test
    @Disabled("Should correctly add position to word")
    void shouldCorrectlyAddPositionToWord() {
        String text = TextUtils.getTEXT();
        TextSplitter textSplitter = new TextSplitter();
        List<String> wordList = textSplitter.splitTextByWords(text);

        PositionSpecifier positionSpecifier = new PositionSpecifier();
        List<WordDto> wordDtoList = positionSpecifier.specifyPosition(wordList);

        assertAll(() -> assertEquals(wordList.size(), wordDtoList.size()),
                () -> assertEquals("Kolejny", wordDtoList.get(0).word()),
                () -> assertEquals("zgonów", wordDtoList.get(37).word()));
    }

}