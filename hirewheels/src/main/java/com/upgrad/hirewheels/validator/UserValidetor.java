package com.upgrad.hirewheels.validator;

import dto.LoginDTO;
import dto.UsersDTO;
import exceptions.APIException;

public interface UserValidetor {
    public void validateCustomer(UsersDTO usersDTO) throws APIException;



    public void validateUserLogin(LoginDTO loginDTO) throws APIException ;


}
