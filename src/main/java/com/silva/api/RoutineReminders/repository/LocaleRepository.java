package com.silva.api.RoutineReminders.repository;

import com.silva.api.RoutineReminders.model.LocaleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaleRepository extends JpaRepository<LocaleModel, Integer> {
    @Query(value = "select * from tb_locale where upper(name) = :name", nativeQuery = true)
    LocaleModel getLocaleByName(@Param(value = "name") String nome);
}
