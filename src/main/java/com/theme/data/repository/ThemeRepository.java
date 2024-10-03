package com.theme.data.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.theme.data.model.Theme;

public interface ThemeRepository extends MongoRepository<Theme, String> {
}
