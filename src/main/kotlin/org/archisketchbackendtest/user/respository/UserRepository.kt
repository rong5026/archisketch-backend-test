package org.archisketchbackendtest.user.respository

import org.archisketchbackendtest.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository : JpaRepository<User, Long> {

}