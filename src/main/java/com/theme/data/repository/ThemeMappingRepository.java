package com.theme.data.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.theme.data.model.ThemeMapping;

public interface ThemeMappingRepository extends MongoRepository<ThemeMapping, String> {
}