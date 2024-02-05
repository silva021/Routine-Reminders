package com.silva.api.RoutineReminders.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDTO(@NotBlank String amazon_user_id, @NotBlank String email) {
}
