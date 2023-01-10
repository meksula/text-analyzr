package com.meksula.analyzr.api;

import com.meksula.analyzr.analysis.dto.SingleTextResult;

import java.util.List;

record WordSearchResponse(String word, List<SingleTextResult> texts) {
}
