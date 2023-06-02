package com.example.challenge_chapter_4.Repository;

import com.example.challenge_chapter_4.Model.DataTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DataTransactionInterface extends JpaRepository<DataTransactionEntity, UUID> {
}
