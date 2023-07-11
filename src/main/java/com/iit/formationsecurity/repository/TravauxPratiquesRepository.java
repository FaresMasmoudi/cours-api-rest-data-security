package com.iit.formationsecurity.repository;
import com.iit.formationsecurity.entity.TP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravauxPratiquesRepository extends JpaRepository<TP, Long> {
}
