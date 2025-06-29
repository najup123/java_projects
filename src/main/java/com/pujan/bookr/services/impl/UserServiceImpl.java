package com.pujan.bookr.services.impl;




import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pujan.bookr.entities.User;
import com.pujan.bookr.exceptions.ResourceNotFoundException;
import com.pujan.bookr.payloads.UserDto;
import com.pujan.bookr.repositories.UserRepo;
import com.pujan.bookr.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
    	 User user = this.userRepo.findById(userId)
                 .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
         user.setUsername(userDto.getUsername());
         user.setEmail(userDto.getEmail());
         user.setPassword(userDto.getPassword());
         user.setRole(userDto.getRole());

         User updatedUser = this.userRepo.save(user);
         UserDto userDto1 = this.userToDto(updatedUser);
         return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
    	  User user = this.userRepo.findById(userId)
                  .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
          return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
    	 List<User> users = this.userRepo.findAll();
         List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
         return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
    	  User user = this.userRepo.findById(userId)
                  .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
          this.userRepo.delete(user);
    }

    private User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        
        
        
//        user.setId(userDto.getId());
//        user.setUsername(userDto.getUsername());
//        user.setEmail(userDto.getEmail());
//        user.setRole(userDto.getRole());
//        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto userToDto(User user) {
        
    	UserDto userDto = this.modelMapper.map(user, UserDto.class);
    	
    	
//        userDto.setId(user.getId());
//        userDto.setUsername(user.getUsername());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setRole(user.getRole());
        return userDto;
    }
}
