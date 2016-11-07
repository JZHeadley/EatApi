package com.jzheadley.eat.Respositories;

import com.jzheadley.eat.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByFirebaseId(@Param("firebaseId") String firebaseId);
}
