package com.dzhao.exams.security.basic.repositories;

import com.dzhao.exams.security.basic.model.MyUser;
import org.springframework.stereotype.Repository;

/**
 * Created by dzhao on 14/03/2016.
 */
@Repository
public interface UserRepository {
    MyUser findByEmail(String email);
}
