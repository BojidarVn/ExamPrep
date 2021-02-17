package EXAM_PREP.service.impl;

import EXAM_PREP.model.entities.User;
import EXAM_PREP.model.service.UserServiceModel;
import EXAM_PREP.repositories.UserRepository;
import EXAM_PREP.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(UserServiceModel userServiceModel) {
        try {
            userRepository.save(modelMapper.map(userServiceModel, User.class));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {


        return userRepository.findByUsernameAndPassword(username,password)
                .map(user ->
                    modelMapper.map(user,UserServiceModel.class))
                .orElse(null);


    }
}
