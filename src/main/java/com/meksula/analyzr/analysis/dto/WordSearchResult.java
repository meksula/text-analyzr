package com.meksula.analyzr.analysis.dto;

import java.util.List;

public record WordSearchResult(String word,
                               List<SingleTextResult> texts) {
}
