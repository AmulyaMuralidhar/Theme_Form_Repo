package com.theme.data.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.theme.data.model.Theme;
import com.theme.data.model.ThemeMapping;
import com.theme.data.service.ThemeMappingService;
import com.theme.data.service.ThemeService;
import java.util.List;

@RestController
@RequestMapping("/themes")
public class Theme_Controller {

	@Autowired
	private ThemeService themeService;

	@Autowired
	private ThemeMappingService themeMappingService;

	@GetMapping
	public ResponseEntity<Theme> getAllThemes() {
		List<Theme> theme = themeService.getAllThemes();
		return new ResponseEntity(theme, HttpStatus.OK);
	}

	@GetMapping("/theme/data/{id}")
	public ResponseEntity<Theme> getThemeById(@PathVariable String id) {
		Theme theme = themeService.getThemeById(id);
		return theme != null ? new ResponseEntity<>(theme, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/theme/data/save")
	public ResponseEntity<Theme> createTheme(@RequestBody Theme theme) {
		Theme createdTheme = themeService.createTheme(theme);
		return new ResponseEntity<>(createdTheme, HttpStatus.CREATED);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Theme> updateTheme(@PathVariable String id, @RequestBody Theme theme) {
		Theme updatedTheme = themeService.updateTheme(id, theme);
		return new ResponseEntity<>(updatedTheme, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTheme(@PathVariable String id) {
		themeService.deleteTheme(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/mapped_themes")
	public ResponseEntity<ThemeMapping> getAllThemeMappings() {
		List<ThemeMapping> themeMapping = themeMappingService.getAllThemeMappings();
		return new ResponseEntity(themeMapping, HttpStatus.OK);
	}

	@GetMapping("/mapped_themes/{id}")
	public ResponseEntity<ThemeMapping> getThemeMappingById(@PathVariable String id) {
		ThemeMapping themeMapping = themeMappingService.getThemeMappingById(id);
        return themeMapping != null ? new ResponseEntity<>(themeMapping, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

	@PostMapping("/theme/map/save")
	public ResponseEntity<ThemeMapping> createThemeMapping(@RequestBody ThemeMapping themeMapping) {
		ThemeMapping createdThemeMapping = themeMappingService.createThemeMapping(themeMapping);
        return new ResponseEntity<>(createdThemeMapping, HttpStatus.CREATED);
    }

	@PutMapping("/mapped_themes/{id}")
	public ResponseEntity<ThemeMapping> updateThemeMapping(@PathVariable String id, @RequestBody ThemeMapping themeMapping) {
		ThemeMapping updatedThemeMapping = themeMappingService.updateThemeMapping(id, themeMapping);
        return new ResponseEntity<>(updatedThemeMapping, HttpStatus.OK);
    }

	@DeleteMapping("/mapped_themes/{id}")
	 public ResponseEntity<Void> deleteThemeMapping(@PathVariable String id) {
        themeMappingService.deleteThemeMapping(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
}
