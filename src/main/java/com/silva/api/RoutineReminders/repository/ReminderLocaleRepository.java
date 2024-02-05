package com.silva.api.RoutineReminders.repository;

import com.silva.api.RoutineReminders.model.ReminderLocaleModel;
import com.silva.api.RoutineReminders.model.ReminderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReminderLocaleRepository extends JpaRepository<ReminderLocaleModel, Integer> {

    @Query(value = "SELECT r.name FROM tb_reminder r INNER JOIN tb_locale_reminder lr ON r.id = lr.reminder_id WHERE lr.locale_id = :locale_id and lr.user_id = :user_id", nativeQuery = true)
    List<String> getReminderByName(@Param(value = "locale_id") Integer localeId, @Param(value = "user_id") String userId);
}
