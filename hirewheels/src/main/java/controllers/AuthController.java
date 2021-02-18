package controllers;

import com.upgrad.hirewheels.validator.UserValidetor;
import dto.LoginDTO;
import dto.UsersDTO;
import entities.Users;
import exceptions.APIException;
import exceptions.BadCredentialsException;
import exceptions.UserAlreadyExists;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/hirewheels/v1/users")
public class AuthController {


    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserService userService;
    @Autowired
    UserValidetor userValidator;

    @PostMapping(value = "/signup",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity signup(@RequestBody  UsersDTO usersDTO)
            throws APIException, UserAlreadyExists {

        userValidator.validateCustomer(usersDTO);
        try {
            Users users = userService.getUserByemail(usersDTO.getEmail());
            if (users != null) {
                throw new UserAlreadyExists(
                        "Customer username already exists for : ");
            }
        } catch ( UserAlreadyExists ex) {
            System.out.println("Customer does not exist for the given details");
        }
        try {
            Map<String, String> model = new HashMap<>();
            String username = usersDTO.getUsername();
            String password = usersDTO.getPassword();
            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                model.put("Error", "Username is invalid/ Password is empty");
                return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
            }
            Users newUsers = modelMapper.map(usersDTO,Users.class);
            Users savedUser = userService.createUser(newUsers);
            UsersDTO savedUserDTO = modelMapper.map(savedUser,UsersDTO.class);
            return new ResponseEntity<>(savedUserDTO,HttpStatus.CREATED);
        } catch (Exception e) {
            throw new UserAlreadyExists("Username already registered");

        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO)
            throws APIException,UserAlreadyExists,Exception {
        userValidator.validateUserLogin(loginDTO);
        Map<String, String> model = new HashMap<>();
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.put("Error", "Username is invalid/ Password is empty");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }
        Users saveduser = userService.getUserbyusername(username);
        if (!saveduser.getPassword().equals(password)) {
            throw new BadCredentialsException("Invalid username/password");
        }
        model.put("message","Logged in Successfully");
        model.put("token",saveduser.getUsername());
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
