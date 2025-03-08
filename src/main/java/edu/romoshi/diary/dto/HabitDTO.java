package edu.romoshi.diary.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HabitDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Min(1)
    @Max(7)
    private int frequency;
}
