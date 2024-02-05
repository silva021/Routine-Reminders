package com.silva.api.RoutineReminders.dto;

import jakarta.validation.constraints.NotBlank;

public record ReminderLocaleRecordDTO(
        @NotBlank Integer locale_id,
        @NotBlank Integer reminder_id,
        @NotBlank Integer user_id
) {
}
