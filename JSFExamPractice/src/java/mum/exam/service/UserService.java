/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.exam.service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import mum.exam.reopsitory.UserRepository;

/**
 *
 * @author dipen
 */
public class UserService implements Serializable{
    @Inject
    UserRepository userRepository;
    
    public List<String> getCountires() {
        return userRepository.getCountires();
    }
}
