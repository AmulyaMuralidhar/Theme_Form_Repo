package com.theme.data.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.theme.data.model.ThemeMapping;

public interface ThemeMappingRepository extends MongoRepository<ThemeMapping, String> {
    @Query("{ 'themeId' : ?0 }")
    boolean existsByThemeMapId(String themeId);
    
    @Query("{ 'formId' : ?0 }")
    Optional<ThemeMapping> findByFormId(String formId);
}