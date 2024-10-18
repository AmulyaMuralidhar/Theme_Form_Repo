package com.theme.data.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.theme.data.dto.ThemeDTO;
import com.theme.data.exception.ThemeCustomException;
import com.theme.data.model.Theme;
import com.theme.data.repository.ThemeRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThemeService {

	@Autowired
	private ThemeRepository themeRepository;

	/*
	 * public List<ThemeDTO> getAllThemes() { List<Theme> themes =
	 * themeRepository.findAll(); List<ThemeDTO> themeDTOs = new ArrayList<>(); for
	 * (Theme theme : themes) { ThemeDTO themeDTO = new ThemeDTO();
	 * themeDTO.setThemeId(theme.getThemeId());
	 * themeDTO.setThemeName(theme.getThemeName());
	 * themeDTO.setThemeData(theme.getThemeData());
	 * themeDTO.setClientId(theme.getClientId()); themeDTOs.add(themeDTO); } return
	 * themeDTOs; }
	 */

	 public List<ThemeDTO> getAllThemes() {
	        return themeRepository.findAll().stream()
	                .map(theme -> {
	                    ThemeDTO dto = new ThemeDTO();
	                    dto.setThemeId(theme.getThemeId());
	                    dto.setThemeName(theme.getThemeName());
	                    dto.setThemeData(theme.getThemeData());
	                    dto.setClientId(theme.getClientId());
	                    dto.setFormIds(theme.getFormIds());
	                    return dto;
	                })
	                .collect(Collectors.toList());
	    }
	/*
	 * public ThemeDTO createTheme(ThemeDTO themeDTO) { Theme existingTheme =
	 * themeRepository.findByThemeId(themeDTO.getThemeId()); Theme theme = new
	 * Theme(); if(existingTheme==null) {
	 * theme.setThemeName(themeDTO.getThemeName());
	 * theme.setThemeData(themeDTO.getThemeData());
	 * theme.setClientId(themeDTO.getClientId());
	 * theme.setThemeId(themeDTO.getThemeId()); theme.setDate(new Date()); theme =
	 * themeRepository.save(theme); } else{ throw new
	 * ThemeCustomException("Theme Id already exists"); }
	 * 
	 * return convertToDTO(theme);
	 * 
	 * }
	 */

	public ThemeDTO createTheme(ThemeDTO themeDTO) {
		// Check if the theme with the same ID already exists
		if (themeRepository.existsById(themeDTO.getThemeId())) {
			throw new IllegalArgumentException("Theme with ID " + themeDTO.getThemeId() + " already exists.");
		}
		Theme theme = new Theme();
		theme.setThemeId(themeDTO.getThemeId()); // Set the themeId from DTO
		theme.setThemeName(themeDTO.getThemeName());
		theme.setThemeData(themeDTO.getThemeData());
		theme.setClientId(themeDTO.getClientId());
		theme.setFormIds(themeDTO.getFormIds());
		theme.setDate(new Date()); // Set creation date
		theme = themeRepository.save(theme);
		return convertToDTO(theme);
	}

	private ThemeDTO convertToDTO(Theme theme) {
		ThemeDTO themeDTO = new ThemeDTO();
		themeDTO.setThemeId(theme.getThemeId());
		themeDTO.setThemeName(theme.getThemeName());
		themeDTO.setThemeData(theme.getThemeData());
		themeDTO.setClientId(theme.getClientId());
		themeDTO.setFormIds(theme.getFormIds());
		return themeDTO;
	}

	public ThemeDTO getThemeById(String themeId) {
		Theme theme = themeRepository.findByThemeId(themeId) .orElseThrow(() -> new IllegalArgumentException("Theme not found"));
		return convertToDTO(theme);
	}

	public ThemeDTO updateThemeById(String themeId, ThemeDTO themeDTO) {
		Theme existingTheme = themeRepository.existsByThemeId(themeId)
				.orElseThrow(() -> new ThemeCustomException("ThemeMapping with themeId " + themeId + " not found"));
		existingTheme.setThemeName(themeDTO.getThemeName());
		existingTheme.setThemeId(themeDTO.getThemeId());
		existingTheme.setClientId(themeDTO.getClientId());
		existingTheme.setThemeData(themeDTO.getThemeData());
		existingTheme.setModifyDate(new Date());
		existingTheme.setFormIds(themeDTO.getFormIds());
		existingTheme = themeRepository.save(existingTheme);
		return convertToDTO(existingTheme);
	}

	public void deleteTheme(String id) {
		themeRepository.deleteById(id);
	}


	public ThemeDTO getThemeByThemeName(String themeName) {
		Theme theme = themeRepository.findByThemeName(themeName)
				.orElseThrow(() -> new ThemeCustomException("Theme with name " + themeName + " not found"));
		return convertToDTO(theme);
	}

	public ThemeDTO updateThemeByName(String themeName, ThemeDTO themeDTO) {
		Theme existingTheme = themeRepository.findByThemeName(themeName)
				.orElseThrow(() -> new ThemeCustomException("Theme with name " + themeName + " not found"));
		existingTheme.setThemeData(themeDTO.getThemeData());
		existingTheme.setModifyDate(new Date());
		existingTheme.setFormIds(themeDTO.getFormIds());
		existingTheme = themeRepository.save(existingTheme);
		return convertToDTO(existingTheme);
	}

	public void deleteThemeByName(String themeName) {
		Theme existingTheme = themeRepository.findByThemeName(themeName)
				.orElseThrow(() -> new ThemeCustomException("Theme with name " + themeName + " not found"));
		themeRepository.delete(existingTheme);
	}

	public Theme createThemeTest(ThemeDTO themeDTO) {
		Theme theme = new Theme();
		theme.setThemeId(themeDTO.getThemeId());
		theme.setThemeName(themeDTO.getThemeName());
		theme.setThemeData(themeDTO.getThemeData()); // Assuming themeData is already a JsonNode
		theme.setClientId(themeDTO.getClientId());

		return themeRepository.save(theme);
	}

	public ThemeDTO getThemeByIdTest(String themeId) {
		Theme theme = themeRepository.existsByThemeId(themeId)
				.orElseThrow(() -> new ThemeCustomException("Theme not found with id: " + themeId));

		// Convert Theme to ThemeDTO
		ThemeDTO themeDTO = new ThemeDTO();
		themeDTO.setThemeId(theme.getThemeId());
		themeDTO.setThemeName(theme.getThemeName());
		themeDTO.setThemeData(theme.getThemeData());
		themeDTO.setClientId(theme.getClientId());

		return themeDTO;
	}

}

