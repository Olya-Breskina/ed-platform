package ru.podgoretskaya.edplatform.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "учебные материалы")
public class ResponseFileDTO {
    @Schema(description = "порядковый номер файла")
    private int id;
    @Schema(description = "название файла")
    private String nameFile;
    @Schema(description = "тип файла")
    private String typeFile;
}
