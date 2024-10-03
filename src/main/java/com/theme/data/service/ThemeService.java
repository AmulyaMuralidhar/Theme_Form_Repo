package com.theme.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theme.data.model.Theme;
import com.theme.data.repository.ThemeRepository;

import java.util.List;

@Service
public class ThemeService {
    @Autowired
    private ThemeRepository themeRepository;

    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    public Theme createTheme(Theme theme) {
        return themeRepository.save(theme);
    }

    public Theme updateTheme(String id, Theme theme) {
        theme.setId(id);
        return themeRepository.save(theme);
    }

    public void deleteTheme(String id) {
        themeRepository.deleteById(id);
    }

    public Theme getThemeById(String id) {
        return themeRepository.findById(id).orElse(null);
    }
}
