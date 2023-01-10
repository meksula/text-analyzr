package com.meksula.analyzr.api;

import javax.validation.constraints.NotBlank;

record TextAnalyzeRequest(@NotBlank String text) {
}
