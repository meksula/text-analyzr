package com.meksula.analyzr.analysis;

import com.meksula.analyzr.analysis.dto.WordDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class PositionSpecifier {

    List<WordDto> specifyPosition(List<String> words) {
        final List<WordDto> wordDtoList = new ArrayList<>(words.size());
        for (int i = 0; i < words.size(); i++) {
            WordDto wordDto = new WordDto(words.get(i), i + 1);
            wordDtoList.add(wordDto);
        }
        return wordDtoList;
    }
}
