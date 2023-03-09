package ru.podgoretskaya.edplatform.mapper;

import org.springframework.stereotype.Component;
import ru.podgoretskaya.edplatform.dto.LessonsDTO;
import ru.podgoretskaya.edplatform.dto.MaterialResponseDTO;
import ru.podgoretskaya.edplatform.entity.EducationMaterialEntity;
import ru.podgoretskaya.edplatform.entity.LessonsEntity;


import java.util.stream.Collectors;


@Component
public class LessonsMapper {
    public LessonsDTO mapLessonsEntityToDTO(LessonsEntity lessonsEntity) {
        LessonsDTO lessonsDTO = new LessonsDTO();
        lessonsDTO.setDescriptionLessons(lessonsEntity.getDescriptionLessons());
        lessonsDTO.setNameLessons(lessonsEntity.getNameLessons());
        lessonsDTO.setId(lessonsEntity.getId());
        lessonsDTO.setEducationMaterialName(
                lessonsEntity.getEducationMaterials().stream().map(dto -> mapToMaterialResponseDTO(dto)).collect(Collectors.toList())
        );
        return lessonsDTO;
    }

    public LessonsEntity mapLessonsDTOToEntity(LessonsDTO lessonsDTO) {
        LessonsEntity lessonsEntity = new LessonsEntity();
        lessonsEntity.setNameLessons(lessonsDTO.getNameLessons());
        lessonsEntity.setDescriptionLessons(lessonsDTO.getDescriptionLessons());
        return lessonsEntity;
    }

    private MaterialResponseDTO mapToMaterialResponseDTO(EducationMaterialEntity entity) {
        MaterialResponseDTO materialResponseDTO = new MaterialResponseDTO();
        materialResponseDTO.setId(entity.getId());
        materialResponseDTO.setName(entity.getNameFile());
        return materialResponseDTO;
    }
}
