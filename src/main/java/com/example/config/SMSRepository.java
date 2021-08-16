package com.example.config;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bean.SmsPojo;

public interface SMSRepository extends JpaRepository<SmsPojo, Integer>{

}
