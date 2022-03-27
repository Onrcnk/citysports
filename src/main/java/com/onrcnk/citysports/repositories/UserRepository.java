package com.onrcnk.citysports.repositories;

import com.onrcnk.citysports.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}