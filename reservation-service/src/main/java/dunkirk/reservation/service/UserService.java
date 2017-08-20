package dunkirk.reservation.service;

import dunkirk.reservation.domain.User;

public interface UserService {
    User getByEmail(String email);

    User add(User user);

    User modify(User user);
}
