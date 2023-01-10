package com.meksula.analyzr.analysis.dto;

import java.util.List;

public record WordOccurrencesDto(String word,
                                 int occurrences,
                                 List<Integer> textPositions) {
}
