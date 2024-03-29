package yota.homework.tariff.dao;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import yota.homework.tariff.RepositoryTest;
import yota.homework.tariff.dto.UserDto;
import yota.homework.tariff.model.User;
import yota.homework.tariff.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@RepositoryTest
class UserRepositoryTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void mustFindUserByPassport() {
        User user = new User(UserDto.randomUserDto());
        User added = userRepository.save(user);
        flushAndClear();
        User fromDb = userRepository.findOneByPassport(user.getPassport());
        assertThat(added).isEqualToComparingFieldByFieldRecursively(fromDb);
    }

    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }

}
