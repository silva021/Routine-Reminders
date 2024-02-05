package com.silva.api.RoutineReminders.controller;

import com.silva.api.RoutineReminders.dto.LocaleRecordDTO;
import com.silva.api.RoutineReminders.dto.ReminderLocaleRecordDTO;
import com.silva.api.RoutineReminders.dto.ReminderLocaleRecordNameDTO;
import com.silva.api.RoutineReminders.dto.ReminderRecordDTO;
import com.silva.api.RoutineReminders.model.LocaleModel;
import com.silva.api.RoutineReminders.model.ReminderLocaleModel;
import com.silva.api.RoutineReminders.model.ReminderModel;
import com.silva.api.RoutineReminders.repository.LocaleRepository;
import com.silva.api.RoutineReminders.repository.ReminderLocaleRepository;
import com.silva.api.RoutineReminders.repository.ReminderRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReminderController {

    @Autowired
    ReminderRepository reminderRepository;

    @Autowired
    LocaleRepository localeRepository;
    @Autowired
    ReminderLocaleRepository reminderLocaleRepository;

    @PostMapping("{id}/reminders")
    public ResponseEntity<String> saveNewReminder(@PathVariable(name = "id") String id, @RequestBody @Valid ReminderLocaleRecordNameDTO reminderLocaleRecordDTO)  {
        var reminder = reminderRepository.getReminderByName(reminderLocaleRecordDTO.reminder());
        var reminderId = 0;
        var localeId = 0;

        if (reminder == null) {
            var reminderRecordDTO = new ReminderRecordDTO(reminderLocaleRecordDTO.reminder());
            var reminderModel = new ReminderModel();
            BeanUtils.copyProperties(reminderRecordDTO, reminderModel);
            reminderId = reminderRepository.save(reminderModel).getId();
        } else {
            reminderId = reminder.getId();
        }

        var locale = localeRepository.getLocaleByName(reminderLocaleRecordDTO.nameLocale());
        if (locale == null) {
            var localeRecordDTO = new LocaleRecordDTO(reminderLocaleRecordDTO.nameLocale());
            var localeModel = new LocaleModel();
            BeanUtils.copyProperties(localeRecordDTO, localeModel);
            localeId = localeRepository.save(localeModel).getId();
        } {
            localeId = locale.getId();
        }


        try {
            var reminderLocaleRecord = new ReminderLocaleRecordDTO(localeId, reminderId, id);
            var reminderLocaleModel = new ReminderLocaleModel();
            BeanUtils.copyProperties(reminderLocaleRecord, reminderLocaleModel);
            reminderLocaleRepository.save(reminderLocaleModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Foi guardado seu lembrete");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível guardar o seu lembrete");
        }
    }

    @GetMapping("{id}/{locale}/reminders")
    public ResponseEntity<String> getReminderByLocale(@PathVariable(name = "id") String id, @PathVariable(name = "locale") String localePath)  {
        var locale = localeRepository.getLocaleByName(localePath.toUpperCase());

        if (locale == null) {
            var localeModel = new LocaleModel();
            BeanUtils.copyProperties(new LocaleRecordDTO(localePath), localeModel);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não sei o que que deu não em, brincadeira sei sim mas tenho que resolver ainda");
        } {
            try {
                var reminderList = reminderLocaleRepository.getReminderByName(locale.getId(), id);

                if (reminderList.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.CREATED).body("Você ainda não tem lembretes para " + locale.getName());
                }

                StringBuilder newText = new StringBuilder();
                for (String reminder : reminderList) {
                    newText.append(reminder).append(", ");
                }

                return ResponseEntity.status(HttpStatus.CREATED).body("Seus lembretes antes de sair para " + locale.getName() + " são " + newText);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi buscar seus lembretes");
            }
        }
    }
}
