package com.meksula.analyzr.analysis;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "word")
class Word {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "word_id_seq")
    @SequenceGenerator(name = "word_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "word_value", unique = true)
    private String wordValue;

    static Word create(String wordValue) {
        return new Word(null, wordValue);
    }
}
