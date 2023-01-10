package com.meksula.analyzr.api;

import com.meksula.analyzr.analysis.dto.WordOccurrencesDto;

import java.util.List;

record TextAnalyzeResponse(List<WordOccurrencesDto> words) {
}
