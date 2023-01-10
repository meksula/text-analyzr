package com.meksula.analyzr.analysis;

import com.meksula.analyzr.analysis.dto.WordOccurrencesInText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface WordOccurrenceRepository extends JpaRepository<WordOccurrence, Long> {

    @Query("select new com.meksula.analyzr.analysis.dto.WordOccurrencesInText(wo.word.wordValue, wo.occurrences, wo.textPositions, wo.text.id) from WordOccurrence wo where wo.word = :word")
    List<WordOccurrencesInText> findAllByWord(Word word);
}
