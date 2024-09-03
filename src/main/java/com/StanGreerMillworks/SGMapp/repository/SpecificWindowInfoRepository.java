package com.StanGreerMillworks.SGMapp.repository;

import com.StanGreerMillworks.SGMapp.domain.SpecificWindowInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificWindowInfoRepository extends JpaRepository<SpecificWindowInfo, Long> {
}
