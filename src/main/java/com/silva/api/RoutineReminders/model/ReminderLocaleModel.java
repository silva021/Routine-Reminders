package com.silva.api.RoutineReminders.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_locale_reminder")
public class ReminderLocaleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer locale_id;
    private Integer reminder_id;
    private Integer user_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocale_id() {
        return locale_id;
    }

    public void setLocale_id(Integer locale_id) {
        this.locale_id = locale_id;
    }

    public Integer getReminder_id() {
        return reminder_id;
    }

    public void setReminder_id(Integer reminder_id) {
        this.reminder_id = reminder_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
