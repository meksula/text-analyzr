package com.meksula.analyzr.analysis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "word_occurrence")
class WordOccurrence {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "word_occurrence_id_seq")
    @SequenceGenerator(name = "word_occurrence_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "text_id")
    private Text text;

    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word word;

    @Column(name = "text_positions")
    @Convert(converter = IntegerListConverter.class)
    private List<Integer> textPositions;

    @Column(name = "occurrences")
    private Integer occurrences;

    static WordOccurrence create(Text text, Word word, List<Integer> textPositions) {
        return new WordOccurrence(null, text, word, textPositions, textPositions.size());
    }
}
