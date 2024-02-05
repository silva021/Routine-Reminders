package com.silva.api.RoutineReminders.repository;

import com.silva.api.RoutineReminders.model.ReminderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepository extends JpaRepository<ReminderModel, Integer> {
}
