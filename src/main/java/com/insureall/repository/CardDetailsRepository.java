package com.insureall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insureall.entity.CardDetailsEntity;

@Repository
public interface CardDetailsRepository extends JpaRepository<CardDetailsEntity, Integer>{

	Optional<CardDetailsEntity> findByUid(Integer uid);
}