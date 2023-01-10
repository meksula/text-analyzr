package com.meksula.analyzr.analysis;

import com.meksula.analyzr.analysis.dto.WordOccurrencesDto;
import lombok.Getter;

import java.util.Set;

public class TextUtils {

    @Getter
    private static final String TEXT = """
            Kolejny gatunek ludzkiego koronawirusa, znacznie groźniejszy, zidentyfikowano w 2002 roku w chińskiej prowincji Guangdong.
            Wirus SARS-CoV, nazywany tak od wywoływanego przez niego zespołu ciężkiej niewydolności oddechowej
            (ang. Severe Acute Respiratory Syndrome), spowodował falę zachorowań i 775 potwierdzonych zgonów
            """;

    public static WordOccurrencesDto find(Set<WordOccurrencesDto> wordOccurrencesDtoSet, String word) {
        return wordOccurrencesDtoSet.stream().filter(dto -> dto.word().equals(word))
                .findAny()
                .get();
    }
}
