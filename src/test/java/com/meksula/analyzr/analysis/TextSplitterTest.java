package com.meksula.analyzr.analysis;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextSplitterTest {

    @Test
    @Disabled("Should split text and return list of words")
    void shouldSplitTextAndReturnListOfWords() {
        final String text = TextUtils.getTEXT();
        TextSplitter textSplitter = new TextSplitter();
        List<String> wordList = textSplitter.splitTextByWords(text);

        assertEquals(38, wordList.size());
    }
}