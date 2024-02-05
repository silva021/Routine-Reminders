package com.silva.api.RoutineReminders.controller;

import com.silva.api.RoutineReminders.dto.ReminderRecordDTO;
import com.silva.api.RoutineReminders.model.ReminderModel;
import com.silva.api.RoutineReminders.repository.ReminderRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReminderController {

    @Autowired
    ReminderRepository reminderRepository;

    @PostMapping("/reminders")
    public ResponseEntity<ReminderModel> saveNewReminder(@RequestBody @Valid ReminderRecordDTO reminderRecordDTO)  {
        var reminderModel = new ReminderModel();
        BeanUtils.copyProperties(reminderRecordDTO, reminderModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(reminderRepository.save(reminderModel));
    }
}
