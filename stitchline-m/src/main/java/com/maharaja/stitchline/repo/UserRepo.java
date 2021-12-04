package com.maharaja.stitchline.repo;

import com.maharaja.stitchline.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author Dilki Cooray <dilkicooray97@gmal.com>
 * @since 12/3/2021
 **/
public interface UserRepo extends MongoRepository<User,String> {

    Optional<User>findByUsername(String username);
    Boolean existsByUsername(String username);

    Boolean existsByPassword(String password);

    //User findByUsername(String username);
}
