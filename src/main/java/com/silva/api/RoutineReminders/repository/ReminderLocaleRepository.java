package com.silva.api.RoutineReminders.repository;

import com.silva.api.RoutineReminders.model.ReminderLocaleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderLocaleRepository extends JpaRepository<ReminderLocaleModel, Integer> {
}
