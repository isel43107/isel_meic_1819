/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.services;

import domain.dto.UserDto;
import domain.entity.User;
import domain.entity.VerificationToken;
import domain.exception.EmailAlreadyExistException;
import domain.exception.UserAlreadyExistException;

/**
 *
 * @author pauloborges
 */
public interface IUserService {

    User findUserByUsername(String username);
    
    User findUserByEmail(String email);
    
    User registerNewUser(UserDto accountDto) throws EmailAlreadyExistException, UserAlreadyExistException;
    
    VerificationToken getVerificationToken(String token);
}
