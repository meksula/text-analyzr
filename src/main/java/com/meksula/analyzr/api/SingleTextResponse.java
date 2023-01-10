package com.meksula.analyzr.api;

import java.util.List;

record SingleTextResponse(Long textId,
                          int occurrences,
                          List<Integer> textPositions) {
}