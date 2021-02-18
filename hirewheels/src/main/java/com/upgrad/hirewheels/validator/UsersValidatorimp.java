package com.upgrad.hirewheels.validator;

import dto.LoginDTO;
import dto.UsersDTO;
import exceptions.APIException;

public class UsersValidatorimp implements UserValidetor{

    @Override
    public void validateCustomer(UsersDTO usersDTO) throws APIException {

        if(usersDTO.getFirstName() == null || usersDTO.getFirstName().length() <= 0 )
            throw new APIException("Invalid firstname");

        if(usersDTO.getLastName() == null || usersDTO.getLastName().length() <= 0 )
            throw new APIException("Invalid lastname");
        if(usersDTO.getUsername() == null || usersDTO.getUsername().length() <= 0)
            throw new APIException("Invalid username");

        if(usersDTO.getPassword() == null || usersDTO.getPassword().length() <= 0   )
            throw new APIException("Invalid password");

        if(usersDTO.getPhoneNumbers() == null || usersDTO.getUsername().length() == 10)
            throw new APIException("Invalid mobile number");

        if(usersDTO.getEmail() == null || usersDTO.getEmail().contains("@gmail.com"))
            throw new APIException("Invalid mailID");

    }

    @Override
    public void validateUserLogin(LoginDTO loginDTO) throws APIException {
        if (loginDTO.getUsername() == null || loginDTO.getUsername().length() <= 0) {
            throw new APIException("Invalid username");
        }
        if(loginDTO.getPassword() == null || loginDTO.getPassword().length() <= 0   ) {
            throw new APIException("Invalid password");
        }
    }
}
