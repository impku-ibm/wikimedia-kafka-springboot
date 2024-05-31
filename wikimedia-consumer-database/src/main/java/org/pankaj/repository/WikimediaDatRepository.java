package org.pankaj.repository;

import org.pankaj.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaDatRepository extends JpaRepository<WikimediaData,Long> {

}
