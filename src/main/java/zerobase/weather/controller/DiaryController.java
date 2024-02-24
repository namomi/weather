package zerobase.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
public class DiaryController {

    private final DiaryService diaryService;

    @ApiOperation(value = "일기 텍스트와 날씨를 이용해서 DB에 일기 저장", notes = "일기 텍스트를 저장할 수 있습니다.")
    @PostMapping("/create/diary")
    void createDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "선택한 날짜", example = "2024-02-02") LocalDate date,
                     @RequestBody String text) {
        diaryService.createDiary(date, text);
    }

    @ApiOperation(("선택한 날씨의 모든 일기 데이터를 가져옵니다"))
    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "선택한 날짜", example = "2024-02-02") LocalDate date) {
        return diaryService.readDiary(date);
    }

    @ApiOperation(("선택한 기간중의 모든 일기 데이터를 가져옵니다"))
    @GetMapping("read/diaries")
    List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 기간의 첫번째날", example = "2024-02-01")LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 기간의 마지막날", example = "2024-02-04") LocalDate endDate) {
        return diaryService.readDiaries(startDate, endDate);
    }

    @ApiOperation(("선택한 날씨의 모든 일기 데이터를 변경합니다"))
    @PutMapping("/update/diary")
    void updateDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "선택한 날짜", example = "2024-02-02") LocalDate date,
                     @RequestBody String text) {
        diaryService.updateDiary(date, text);
    }

    @ApiOperation(("선택한 날씨의 모든 일기 데이터를 지웁니다"))
    @DeleteMapping("/delete/diary")
    void deleteDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  @ApiParam(value = "선택한 날짜", example = "2024-02-02") LocalDate date) {
        diaryService.deleteDiary(date);
    }
}
