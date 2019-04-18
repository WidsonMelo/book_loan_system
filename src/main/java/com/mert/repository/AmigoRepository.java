package com.mert.repository;

/**
 * Created by Yasin Mert on 25.02.2017.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mert.model.Amigo;

@Repository("amigoRepository")
public interface AmigoRepository extends JpaRepository<Amigo, Integer> {
}
