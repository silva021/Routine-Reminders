package com.silva.api.RoutineReminders.controller;

import com.silva.api.RoutineReminders.dto.UserRecordDTO;
import com.silva.api.RoutineReminders.model.UserModel;
import com.silva.api.RoutineReminders.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("user")
    public ResponseEntity<String> saveNewReminder(@RequestBody @Valid UserRecordDTO userRecordDTO)  {
        var user = userRepository.getIdByAmazonId(userRecordDTO.amazon_user_id());

        if (user == null) {
            var userModel = new UserModel();
            BeanUtils.copyProperties(userRecordDTO, userModel);
            userRepository.save(userModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado");
        } {
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário já criado");
        }
    }
}
