package com.iit.formationsecurity.repository;


import com.iit.formationsecurity.entity.FormationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationDetailRepository extends JpaRepository<FormationDetail, Long> {
}
