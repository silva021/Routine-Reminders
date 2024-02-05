package com.silva.api.RoutineReminders.dto;

import jakarta.validation.constraints.NotBlank;

public record ReminderLocaleRecordNameDTO(@NotBlank String nameLocale, @NotBlank String reminder) {

}
