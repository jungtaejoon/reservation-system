package dunkirk.reservation.dao;

import dunkirk.reservation.domain.User;

public interface UserDao {
    User getByEmail(String email);

    User add(User user);

    User modify(User user);
}
