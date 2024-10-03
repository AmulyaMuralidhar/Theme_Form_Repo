package com.theme.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theme.data.model.ThemeMapping;
import com.theme.data.repository.ThemeMappingRepository;

import java.util.List;

@Service
public class ThemeMappingService {
    @Autowired
    private ThemeMappingRepository themeMappingRepository;

    public List<ThemeMapping> getAllThemeMappings() {
        return themeMappingRepository.findAll();
    }

    public ThemeMapping createThemeMapping(ThemeMapping themeMapping) {
        return themeMappingRepository.save(themeMapping);
    }

    public ThemeMapping updateThemeMapping(String id, ThemeMapping themeMapping) {
        themeMapping.setId(id);
        return themeMappingRepository.save(themeMapping);
    }

    public void deleteThemeMapping(String id) {
        themeMappingRepository.deleteById(id);
    }

    public ThemeMapping getThemeMappingById(String id) {
        return themeMappingRepository.findById(id).orElse(null);
    }
}