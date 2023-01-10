package com.meksula.analyzr.api;

import javax.validation.constraints.NotNull;

record WordSearchRequest(@NotNull String word) {
}
