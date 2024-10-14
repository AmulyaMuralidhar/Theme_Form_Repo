package com.theme.data.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.theme.data.dto.ThemeMappingDTO;
import com.theme.data.exception.ThemeCustomException;
import com.theme.data.model.ThemeMapping;
import com.theme.data.repository.ThemeMappingRepository;
import java.util.Date;
import java.util.List;

@Service
public class ThemeMappingService {


	@Autowired
	private ThemeMappingRepository themeMappingRepository;

	public List<ThemeMappingDTO> getAllThemes() {
		return themeMappingRepository.findAll().stream()
				.map(this::convertToDTO)
				.toList(); // Using Java 17 features
	}

	public ThemeMappingDTO getThemeMappingByThemeId(String themeId) {
		ThemeMapping themeMapping = themeMappingRepository.findById(themeId)
				.orElseThrow(() -> new ThemeCustomException("ThemeMapping with themeId " + themeId + " not found"));
		return convertToDTO(themeMapping);
	}

	public ThemeMappingDTO getThemeMappingByformId(String formId) {
		ThemeMapping themeMapping = themeMappingRepository.findByFormId(formId)
				.orElseThrow(() -> new ThemeCustomException("ThemeMapping with FormId " + formId + " not found"));
		return convertToDTO(themeMapping);
	}
	
	public ThemeMappingDTO createThemeMapping(ThemeMappingDTO themeMappingDTO) {
		ThemeMapping themeMapping = new ThemeMapping();
		themeMapping.setFormId(themeMappingDTO.getFormId());
		themeMapping.setThemeId(themeMappingDTO.getThemeId());
		themeMapping.setCreateStamp(new Date());
		themeMapping = themeMappingRepository.save(themeMapping);
		return convertToDTO(themeMapping);
	}

	public ThemeMappingDTO updateThemeMapping(String themeId, ThemeMappingDTO themeMappingDTO) {
		ThemeMapping existingThemeMapping = themeMappingRepository.findById(themeId)
				.orElseThrow(() -> new ThemeCustomException("ThemeMapping with themeId " + themeId + " not found"));
		existingThemeMapping.setFormId(themeMappingDTO.getFormId());
		existingThemeMapping.setModifyStamp(new Date());
		existingThemeMapping = themeMappingRepository.save(existingThemeMapping);
		return convertToDTO(existingThemeMapping);
	}

	public void deleteThemeMapping(String themeId) {
		ThemeMapping existingThemeMapping = themeMappingRepository.findById(themeId)
				.orElseThrow(() -> new ThemeCustomException("ThemeMapping with themeId " + themeId + " not found"));
		themeMappingRepository.delete(existingThemeMapping);
	}

	private ThemeMappingDTO convertToDTO(ThemeMapping themeMapping) {
		ThemeMappingDTO themeMappingDTO = new ThemeMappingDTO();
		themeMappingDTO.setId(themeMapping.getId());
		themeMappingDTO.setFormId(themeMapping.getFormId());
		themeMappingDTO.setThemeId(themeMapping.getThemeId());
		themeMappingDTO.setCreateStamp(themeMapping.getCreateStamp());
		themeMappingDTO.setModifyStamp(themeMapping.getModifyStamp());
		return themeMappingDTO;
	}
}

