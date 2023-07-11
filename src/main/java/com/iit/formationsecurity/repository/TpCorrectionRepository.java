package com.iit.formationsecurity.repository;
import com.iit.formationsecurity.entity.TpCorrection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TpCorrectionRepository extends JpaRepository<TpCorrection, Long> {
}
