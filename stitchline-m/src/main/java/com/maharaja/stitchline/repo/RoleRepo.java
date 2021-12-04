package com.maharaja.stitchline.repo;

import com.maharaja.stitchline.entity.Role;
import com.maharaja.stitchline.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Dilki Cooray <dilkicooray97@gmal.com>
 * @since 12/3/2021
 **/
public interface RoleRepo extends MongoRepository<Role,String> {
    Role findByRole(String role);
}
