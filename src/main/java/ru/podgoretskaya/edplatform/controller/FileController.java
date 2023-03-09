package ru.podgoretskaya.edplatform.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.podgoretskaya.edplatform.dto.CoursesDTO;
import ru.podgoretskaya.edplatform.dto.CoursesResponseDTO;
import ru.podgoretskaya.edplatform.dto.LessonsDTO;
import ru.podgoretskaya.edplatform.dto.test.TestDTO;
import ru.podgoretskaya.edplatform.dto.test.UserAnswerDTO;
import ru.podgoretskaya.edplatform.entity.EducationMaterialEntity;
import ru.podgoretskaya.edplatform.service.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/file")
@Tag(name = "Файлы", description = "Методы для работы с файлами, загрузка и отображение материалов")
public class FileController {
    private final EducationMaterialServiceImpl educationMaterialServiceImpl;
    private final CoursesService coursesService;
    private final LessonsService lessonsService;
    private final TestService testService;
    private final MetricServise metricServise;

    @PostMapping("/save/test")
    @Operation(summary = "загрузка материалов для тестирования, с указанием номера курса и проходного балла")
    public void saveTest(@RequestBody MultipartFile file, @RequestHeader("courseId") int courseId, @RequestHeader("threshold") int threshold) {
        testService.save(file, courseId, threshold);

    }

    @PostMapping("/save/cours")
    @Operation(summary = "загрузка курсов ")
    public void saveCours(@RequestBody CoursesDTO model) {
        coursesService.saveCoursInDB(model);
    }

    @PostMapping("/save/lessons")
    @Operation(summary = "загрузка уроков ")
    public void saveLessons(@RequestBody LessonsDTO model) {
        lessonsService.saveLessonsInDB(model);
    }

    @PostMapping("/save/education")
    @Operation(summary = "загрузка образовательных материалов, в заголовке указывается к номер урока")
    public void saveEducation(@RequestBody MultipartFile file, @RequestHeader("lessonsId") int lessonsId) {
        educationMaterialServiceImpl.save(file, lessonsId);
    }

    @GetMapping("/courses")
    @Operation(summary = "вывод списка всех курсов")
    public ResponseEntity<List<CoursesDTO>> findFromDBAllCourses() {
        List<CoursesDTO> fileList = coursesService.getCoursFromDB();
        return ResponseEntity.ok(fileList);
    }

    @GetMapping("/courses/{id}")
    @Operation(summary = "выбор курса, выводит все уроки курса")
    public ResponseEntity<CoursesResponseDTO> returnByIdCourses(@PathVariable int id) {//CoursesEntity
        metricServise.openCourseMetric(id);
        return ResponseEntity.ok(coursesService.chooseCourseFromDB(id));

    }

    @GetMapping("/lessons/{id}")
    @Operation(summary = "вывод всех материалов урока")
    public ResponseEntity<LessonsDTO> returnByIdLessons(@PathVariable int id) {
        return ResponseEntity.ok(lessonsService.chooseLessonsFromDB(id));
    }

    @GetMapping("/education/{id}")
    @Operation(summary = "вывод выбранного материала")
    public ResponseEntity<byte[]> findById(@PathVariable int id) {
        EducationMaterialEntity file = educationMaterialServiceImpl.findById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getNameFile() + "\"")
                .body(file.getData());
    }

    @GetMapping("/test/{id}")
    @Operation(summary = "вывод теста")
    public ResponseEntity<TestDTO> solveTheTest(@PathVariable int id) {
        return ResponseEntity.ok(testService.findById(id));
    }

    @PostMapping("/testAnswer/{id}")
    @Operation(summary = "проверка теста")
    public ResponseEntity<Object> getTestResult(@RequestBody UserAnswerDTO model, @PathVariable int id) {
        return ResponseEntity.ok(testService.answer(model, id));
    }
}
