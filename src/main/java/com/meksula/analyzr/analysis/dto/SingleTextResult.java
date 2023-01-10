package com.meksula.analyzr.analysis.dto;

import java.util.List;

public record SingleTextResult(Long textId,
                               int occurrences,
                               List<Integer> textPositions) {
}