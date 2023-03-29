package com.jac.mvcproject.joinexamples.one_to_one.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
