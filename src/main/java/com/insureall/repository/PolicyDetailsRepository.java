package com.insureall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insureall.entity.PolicyDetailsEntity;

@Repository
public interface PolicyDetailsRepository extends JpaRepository<PolicyDetailsEntity, Integer>{

	Optional<PolicyDetailsEntity> findByUid(Integer uid);
}