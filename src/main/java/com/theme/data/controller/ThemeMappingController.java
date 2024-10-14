package com.theme.data.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.theme.data.dto.ThemeMappingDTO;
import com.theme.data.service.ThemeMappingService;

import jakarta.validation.Valid;

	@RestController
	@RequestMapping("/theme/map")
	public class ThemeMappingController {

	    @Autowired
	    private ThemeMappingService themeMappingService;

	    @GetMapping
	    public ResponseEntity<List<ThemeMappingDTO>> getAllThemeMaps() {
	        List<ThemeMappingDTO> themeDTOs = themeMappingService.getAllThemes();
	        return (themeDTOs != null && !themeDTOs.isEmpty())  ? new ResponseEntity<>(themeDTOs, HttpStatus.OK)  : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @GetMapping("/mapped/{themeId}")
	    public ResponseEntity<ThemeMappingDTO> getThemeMappingByThemeId(@PathVariable String themeId) {
	        ThemeMappingDTO themeMappingDTO = themeMappingService.getThemeMappingByThemeId(themeId);
	        return new ResponseEntity<>(themeMappingDTO, HttpStatus.OK);
	    }

	    @PostMapping("/save")
	    public ResponseEntity<ThemeMappingDTO> createThemeMapping(@Valid @RequestBody ThemeMappingDTO themeMappingDTO) {
	        ThemeMappingDTO createdThemeMapping = themeMappingService.createThemeMapping(themeMappingDTO);
	        return new ResponseEntity<>(createdThemeMapping, HttpStatus.CREATED);
	    }

	    @GetMapping("/{formId}")
	    public ResponseEntity<ThemeMappingDTO> getThemeMappingByFormId(@PathVariable String formId) {
	        ThemeMappingDTO themeMappingDTO = themeMappingService.getThemeMappingByformId(formId);
	        return new ResponseEntity<>(themeMappingDTO, HttpStatus.OK);
	    }

	}
