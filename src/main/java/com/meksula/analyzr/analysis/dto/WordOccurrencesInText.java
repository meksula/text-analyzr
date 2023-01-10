package com.meksula.analyzr.analysis.dto;

import java.util.List;

public record WordOccurrencesInText(String word,
                                    int occurrences,
                                    List<Integer> textPositions,
                                    Long textId) {
}