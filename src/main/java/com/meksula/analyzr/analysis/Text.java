package com.meksula.analyzr.analysis;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "text")
class Text {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "text_id_seq")
    @SequenceGenerator(name = "text_id_seq", allocationSize = 1)
    private Long id;

    @Lob
    @Column(name = "text")
    private String text;

    @Column(name = "created_date_time")
    private ZonedDateTime createdDateTime;

    static Text create(String textContent) {
        return new Text(null, textContent, ZonedDateTime.now());
    }
}
