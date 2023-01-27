package com.example.Zadanie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDataDao extends JpaRepository<LoginData, Long> {

    LoginData findByLogin(String login);
}
