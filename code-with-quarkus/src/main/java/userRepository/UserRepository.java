package userRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import user.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
  
}