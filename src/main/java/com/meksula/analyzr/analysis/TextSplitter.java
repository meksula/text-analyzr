package com.meksula.analyzr.analysis;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
class TextSplitter {

    public List<String> splitTextByWords(String text) {
        return Stream.of(text.split("\\s+"))
                .map(word -> word.replaceAll("[^-\\p{IsAlphabetic}\\d]", "").trim())
                .collect(Collectors.toList());
    }
}
