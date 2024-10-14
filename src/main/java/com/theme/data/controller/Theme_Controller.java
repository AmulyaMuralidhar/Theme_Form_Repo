package com.theme.data.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.theme.data.dto.ThemeDTO;
import com.theme.data.service.ThemeService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/theme")
public class Theme_Controller {

	@Autowired
	private ThemeService themeService;

	@GetMapping("/themes")
	public ResponseEntity<List<ThemeDTO>> getAllThemes() {
		List<ThemeDTO> themes = themeService.getAllThemes();
		return themes != null ? new ResponseEntity<>(themes, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/theme/data/{themeId}")
	public ResponseEntity<ThemeDTO> getThemeByThemeId(@PathVariable String themeId) {
        ThemeDTO themeMapping = themeService.getThemeByThemeId(themeId);
        return new ResponseEntity<>(themeMapping, HttpStatus.OK);
    }

	@PostMapping("/theme/data/save")
	public ResponseEntity<ThemeDTO> createTheme(@Valid @RequestBody ThemeDTO themeDTO) {
		ThemeDTO createdTheme = themeService.createTheme(themeDTO);
		return new ResponseEntity<>(createdTheme, HttpStatus.CREATED); // Return created theme with 201 status
	}

	@PutMapping("/theme/data/{themeId}")
	public ResponseEntity<ThemeDTO> updateThemeById(@PathVariable String themeId, @Valid @RequestBody ThemeDTO themeDTO) {
		ThemeDTO updatedTheme = themeService.updateThemeById(themeId, themeDTO);
		return updatedTheme != null ? new ResponseEntity<>(updatedTheme, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	@GetMapping("/{themeName}")
	public ResponseEntity<ThemeDTO> getThemeByThemeName(@PathVariable String themeName) {
		ThemeDTO theme = themeService.getThemeByThemeName(themeName);
		return theme != null ? new ResponseEntity<>(theme, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{themeName}")
	public ResponseEntity<ThemeDTO> updateTheme(@PathVariable String themeName, @Valid @RequestBody ThemeDTO themeDTO) {
		ThemeDTO updatedTheme = themeService.updateThemeByName(themeName, themeDTO);
		return updatedTheme != null  ? new ResponseEntity<>(updatedTheme, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
