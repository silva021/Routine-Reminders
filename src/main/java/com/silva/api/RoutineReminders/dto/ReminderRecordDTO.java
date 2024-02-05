package com.silva.api.RoutineReminders.dto;

import jakarta.validation.constraints.NotBlank;

public record ReminderRecordDTO(@NotBlank String name) {
}