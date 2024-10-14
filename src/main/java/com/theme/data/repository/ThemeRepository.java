package com.theme.data.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.theme.data.model.Theme;

public interface ThemeRepository extends MongoRepository<Theme, String> {
	 // Custom query to check for existence of themeId
    @Query("{ 'themeId' : ?0 }")
    Optional<Theme> existsByThemeId(String themeId);
    
    @Query("{ 'themeId' : ?0 }")
    Theme findByThemeId(String themeId);
    
    @Query("{ 'themeName' : ?0 }")
    Optional<Theme> findByThemeName(String themeName);
    
    
}
