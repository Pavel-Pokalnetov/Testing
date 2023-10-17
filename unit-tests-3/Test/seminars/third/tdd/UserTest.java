package seminars.third.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    static UserRepository repository;
    @BeforeAll
    static void setUp(){
        repository = new UserRepository();
    }

    @Test
    void checkAuthenticateUserPositive(){
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, password);
        assertTrue(accept);
    }

    @Test
    void checkAuthenticateUserNegative(){
        String name = "name";
        String password = "password";
        String wrongPassword = "wrongPassword";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, wrongPassword);
        assertFalse(accept);
    }

    @Test
    void checkRepositoryAddAuthenticatedUserPositive(){
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        user.authenticate(name, password);

        int currentCount = repository.data.size();
        repository.addUser(user);

       assertThat(repository.data.size())
               .isEqualTo(currentCount + 1);

       User userInRepository =
               repository.data.get(repository.data.size() - 1);

       assertEquals(user, userInRepository);
    }

    @Test
    void checkRepositoryAddNotAuthenticatedUserNegative(){
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);

        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size())
                .isEqualTo(currentCount);
    }


    @Test
    void testRepositoryUnLoginUsersExceptAdmins() {

        //готовим список пользователей
        List<User> users = new ArrayList<>();

        //админы: Charlie, Oliver, suadmin
        //остальные - пользователи
        users.add(new User("Charlie", "1l8p3jq9", true));
        users.add(new User("David", "o4k2h6yq", false));
        users.add(new User("Grace", "m9a3x8zr", false));
        users.add(new User("Linda", "s7t6j4kp", false));
        users.add(new User("Oliver", "v0b6w9tj", true));
        users.add(new User("Sophia", "n6g8p2fk", false));
        users.add(new User("William", "q9a1y5lz", false));
        users.add(new User("Emma", "u3k7i2v4", false));
        users.add(new User("James", "g2r9b1vn", false));
        users.add(new User("Mia", "e5z4v1x6", false));
        users.add(new User("suadmin", "e76g5t97658ewg", true));
        //авторизуем всех
        users.forEach(u -> u.authenticate(u.name, u.password));

        //создаем репозирторий пользователей
        UserRepository usr = new UserRepository();
        //закидываем в реп пользователей
        users.forEach(user -> usr.addUser(user));
        users = null;

        //всего должно быть 11 пользователей
        assertThat(usr.data.size())
                .isEqualTo(11);

        usr.unLoginUsersExceptAdmins();

        //должно остаться 3
        assertThat(usr.data.size())
                .isEqualTo(3);

        //проверяем что оставшиеся пользователи - это администраторы
        usr.data.forEach(u -> {
                    assertThat(u.isAdmin)
                            .isEqualTo(true);
                }
        );

        //проверяем что остались именно Charlie, Oliver и suadmin
        assertThat(usr.data.get(0).name)
                .isEqualTo("Charlie");

        assertThat(usr.data.get(1).name)
                .isEqualTo("Oliver");
        
        assertThat(usr.data.get(2).name)
                .isEqualTo("suadmin");

    }
}