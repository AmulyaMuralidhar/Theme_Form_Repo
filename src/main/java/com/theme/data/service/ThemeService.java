package com.theme.data.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.theme.data.dto.ThemeDTO;
import com.theme.data.exception.ThemeCustomException;
import com.theme.data.model.Theme;
import com.theme.data.repository.ThemeRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ThemeService {

	@Autowired
	private ThemeRepository themeRepository;

	public List<ThemeDTO> getAllThemes() {
		List<Theme> themes = themeRepository.findAll();
		List<ThemeDTO> themeDTOs = new ArrayList<>();
		for (Theme theme : themes) {
			ThemeDTO themeDTO = new ThemeDTO();
			themeDTO.setThemeId(theme.getThemeId());
			themeDTO.setThemeName(theme.getThemeName());
			themeDTO.setThemeData(theme.getThemeData());
			themeDTO.setClientId(theme.getClientId());
			themeDTOs.add(themeDTO);
		}
		return themeDTOs;
	}

	public ThemeDTO createTheme(ThemeDTO themeDTO) {
		Theme existingTheme = themeRepository.findByThemeId(themeDTO.getThemeId());
		Theme theme = new Theme();
		if(existingTheme==null) {
			theme.setThemeName(themeDTO.getThemeName());
			theme.setThemeData(themeDTO.getThemeData());
			theme.setClientId(themeDTO.getClientId());
			theme.setThemeId(themeDTO.getThemeId());
			theme.setDate(new Date());
			theme = themeRepository.save(theme);
		}
		else{
			throw new ThemeCustomException("Theme Id already exists");
		}

		return convertToDTO(theme);

	}

	private ThemeDTO convertToDTO(Theme theme) {
		ThemeDTO themeDTO = new ThemeDTO();
		themeDTO.setThemeId(theme.getThemeId());
		themeDTO.setThemeName(theme.getThemeName());
		themeDTO.setThemeData(theme.getThemeData());
		themeDTO.setClientId(theme.getClientId());
		return themeDTO;
	}

	public ThemeDTO getThemeByThemeId(String themeId) {
		Theme theme = themeRepository.existsByThemeId(themeId)
				.orElseThrow(() -> new ThemeCustomException("Theme with themeId " + themeId + " not found"));
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
		existingTheme = themeRepository.save(existingTheme);
		return convertToDTO(existingTheme);
	}

	public void deleteThemeByName(String themeName) {
		Theme existingTheme = themeRepository.findByThemeName(themeName)
				.orElseThrow(() -> new ThemeCustomException("Theme with name " + themeName + " not found"));
		themeRepository.delete(existingTheme);
	}

}

