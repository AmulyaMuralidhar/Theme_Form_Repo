package com.theme.data.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.theme.data.model.Theme;
import com.theme.data.model.ThemeMapping;
import com.theme.data.service.ThemeMappingService;
import com.theme.data.service.ThemeService;
import java.util.List;

@RestController
@RequestMapping("/api/themes")
public class Theme_Controller {

	@Autowired
	private ThemeService themeService;

	@Autowired
	private ThemeMappingService themeMappingService;

	@GetMapping
	public List<Theme> getAllThemes() {
		return themeService.getAllThemes();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Theme> getThemeById(@PathVariable String id) {
		Theme theme = themeService.getThemeById(id);
		return theme != null ? ResponseEntity.ok(theme) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public Theme createTheme(@RequestBody Theme theme) {
		return themeService.createTheme(theme);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Theme> updateTheme(@PathVariable String id, @RequestBody Theme theme) {
		Theme updatedTheme = themeService.updateTheme(id, theme);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTheme(@PathVariable String id) {
		themeService.deleteTheme(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/mapped_themes")
	public List<ThemeMapping> getAllThemeMappings() {
		return themeMappingService.getAllThemeMappings();
	}

	@GetMapping("/mapped_themes/{id}")
	public ResponseEntity<ThemeMapping> getThemeMappingById(@PathVariable String id) {
		ThemeMapping themeMapping = themeMappingService.getThemeMappingById(id);
		return themeMapping != null ? ResponseEntity.ok(themeMapping) : ResponseEntity.notFound().build();
	}

	@PostMapping("/mapped_themes")
	public ThemeMapping createThemeMapping(@RequestBody ThemeMapping themeMapping) {
		return themeMappingService.createThemeMapping(themeMapping);
	}

	@PutMapping("/mapped_themes/{id}")
	public ResponseEntity<ThemeMapping> updateThemeMapping(@PathVariable String id, @RequestBody ThemeMapping themeMapping) {
		ThemeMapping updatedThemeMapping = themeMappingService.updateThemeMapping(id, themeMapping);
		return ResponseEntity.ok(updatedThemeMapping);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteThemeMapping(@PathVariable String id) {
		themeMappingService.deleteThemeMapping(id);
		return ResponseEntity.noContent().build();
	}
}
