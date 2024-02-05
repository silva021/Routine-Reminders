package com.silva.api.RoutineReminders.repository;

import com.silva.api.RoutineReminders.model.ReminderLocaleModel;
import com.silva.api.RoutineReminders.model.ReminderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderLocaleRepository extends JpaRepository<ReminderLocaleModel, Integer> {
}
