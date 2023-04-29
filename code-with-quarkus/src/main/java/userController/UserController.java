package userController;
import java.util.Set;
import java.util.*;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import user.User;
import userNotFoundException.UserNotFoundException;
import userService.UserService;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.inject.Inject;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;


/*

@Path("/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController<UserDto> {

    private static final SortedSet<User> dummyUsers = new TreeSet<>();

    static {
        dummyUsers.addAll(Set.of(
                createDummyUser(1, "Leonardo", "DiCaprio", 45),
                createDummyUser(2, "Will", "Smith", 51),
                createDummyUser(3, "Denzel", "Washington", 65))
        );
    }
    
    @GET
    public Set<User> getUsers() {
        return dummyUsers;
    }
    
    
    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") int id) throws UserNotFoundException {
        return getUserById(id);
    }
    
    private User getUserById(int id) throws UserNotFoundException {
        return dummyUsers.stream().filter(user -> user.getId() == id).findFirst()
                .orElseThrow(() -> new UserNotFoundException("The user doesn't exist"));
    }
    
    @POST
    public User createUser(@Valid UserDto userDto) {
        User user = createDummyUser(dummyUsers.last().getId() + 1, ((User) userDto).getFirstName(), ((User) userDto).getLastName(), ((User) userDto).getAge());
        dummyUsers.add(user);
        return user;
    }
    
    
    @PUT
    @Path("/{id}")
    public User updateUser(@PathParam("id") int id, @Valid UserDto userDto) throws UserNotFoundException {
        User user = getUserById(id);
        user.setFirstName(((User) userDto).getFirstName());
        user.setLastName(((User) userDto).getLastName());
        user.setAge(((User) userDto).getAge());
        return user;
    }
    
    
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) throws UserNotFoundException {
        dummyUsers.remove(getUserById(id));
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    

    private static User createDummyUser(int id, String firstName, String lastName, int age) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        return user;
    }
    
}*/



@Path("/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") int id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @POST
    public User createUser(@Valid UserDto userDto) {
        return userService.saveUser(userDto.toUser());
    }

    @PUT
    @Path("/{id}")
    public User updateUser(@PathParam("id") int id, @Valid UserDto userDto) throws UserNotFoundException {
        return userService.updateUser(id, userDto.toUser());
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) throws UserNotFoundException {
        userService.deleteUser(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public static class UserDto {

        @NotBlank
        private String firstName;

        @NotBlank
        private String lastName;

        @Min(value = 1, message = "The value must be more than 0")
        @Max(value = 200, message = "The value must be less than 200")
        private int age;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public User toUser() {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setAge(age);
            return user;
        }
    }
}

