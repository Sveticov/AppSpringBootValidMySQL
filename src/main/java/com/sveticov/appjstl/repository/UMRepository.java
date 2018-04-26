package com.sveticov.appjstl.repository;

import com.sveticov.appjstl.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UMRepository {
    private Logger logger = LoggerFactory.getLogger(UMRepository.class);
    @Autowired
    UserModelRepository repository;

    public UserModel findByName(String name) {
        return repository.selectName(name);
    }

    @Transactional
    public UserModel findUserModelByID(int id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void saveUserModel(UserModel model) {
        repository.save(model);
    }

    @Transactional
    public void selectJoin() {
    for(String t: repository.selectJoin()){
        logger.info(t);
    }

//        repository.selectJoin();
    }

}
