/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.services.impl;

import domain.dto.UserDto;
import domain.entity.User;
import domain.entity.VerificationToken;
import domain.exception.EmailAlreadyExistException;
import domain.exception.UserAlreadyExistException;
import domain.repository.UserRepository;
import domain.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pauloborges
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public User registerNewUser(UserDto accountDto)
            throws EmailAlreadyExistException, UserAlreadyExistException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailAlreadyExistException(
                    "Another account is using this e-mail adress: " + accountDto.getEmail());
        }

        if (usernameExist(accountDto.getUsername())) {
            throw new UserAlreadyExistException(
                    "This username isn't available. Please try another." + accountDto.getUsername());
        }
        User user = new User();
        user.setUsername(accountDto.getUsername());
        user.setEmail(accountDto.getEmail());
        user.setPassword(accountDto.getPassword());
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        //user.setRoles(Arrays.asList("ROLE_USER"));
        return repository.save(user);
    }

    private boolean emailExist(String email) {
        User user = repository.findByEmail(email);
        return user != null;
    }

    private boolean usernameExist(String username) {
        User user = repository.findByUsername(username);
        return user != null;
    }

    @Override
    public User findUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public VerificationToken getVerificationToken(String token) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
