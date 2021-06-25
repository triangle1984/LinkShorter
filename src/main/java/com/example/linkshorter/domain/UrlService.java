package com.example.linkshorter.domain;

import com.example.linkshorter.infrastructure.entity.ShortUrlEntity;
import com.example.linkshorter.infrastructure.repository.RepositoryUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Andrey Markov
 * @version 1.0 23.06.2021
 */
@Service
public class UrlService {
    @Autowired
    RepositoryUrl repositoryUrl;
    @Value("${application.prefixSize}")
    Integer prefixSize;
    @Autowired
    GeneratePrefix generatePrefix;

    public ShortUrlEntity createShortUrl(ShortUrlEntity shortUrlEntity) {
        shortUrlEntity.setPrefix(generatePrefix.generate(prefixSize));
        return repositoryUrl.save(shortUrlEntity);
    }

    public Optional<ShortUrlEntity> findUrlByPrefix(String prefix) {
        return repositoryUrl.findByPrefix(prefix);
    }
}
