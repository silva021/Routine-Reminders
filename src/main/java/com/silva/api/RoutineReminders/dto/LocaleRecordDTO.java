package com.silva.api.RoutineReminders.dto;

import jakarta.validation.constraints.NotBlank;

public record LocaleRecordDTO(@NotBlank String name) {
}