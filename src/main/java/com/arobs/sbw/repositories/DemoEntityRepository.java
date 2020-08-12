package com.arobs.sbw.repositories;

import com.arobs.sbw.model.DemoEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vasile.mihali
 * @since 8/6/2020
 */
@Repository
public interface DemoEntityRepository extends JpaRepository<DemoEntity, Integer> {


    Optional<DemoEntity> findByDescriptionContaining(String descLike);

}
