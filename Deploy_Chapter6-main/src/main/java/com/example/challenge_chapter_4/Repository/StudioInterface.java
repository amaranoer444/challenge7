package com.example.challenge_chapter_4.Repository;

import com.example.challenge_chapter_4.Model.StudioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudioInterface extends JpaRepository<StudioEntity, Character>{
    Page<StudioEntity> findAll(Pageable pageable);

}
