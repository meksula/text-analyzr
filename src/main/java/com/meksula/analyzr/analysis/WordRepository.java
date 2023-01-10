package com.meksula.analyzr.analysis;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface WordRepository extends JpaRepository<Word, Long> {

    Optional<Word> findByWordValue(String wordValue);
}
