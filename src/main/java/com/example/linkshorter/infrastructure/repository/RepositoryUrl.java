package com.example.linkshorter.infrastructure.repository;

import com.example.linkshorter.infrastructure.entity.ShortUrlEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepositoryUrl extends CrudRepository<ShortUrlEntity, Long> {
    Optional<ShortUrlEntity> findByPrefix(String prefix);
}
