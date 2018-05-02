package com.sveticov.appjstl.repository;

import com.sveticov.appjstl.model.Cartons;
import com.sveticov.appjstl.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
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
        for (String s : repository.selectJoin()) {
            logger.info(s);
        }

//        repository.selectJoin();
    }

    @Transactional
    public UserModel joinByIDUserModel(int id_user_model) {//TODO JOIN METHOD USER MODEL


        String[] model = repository.joinByIdUserModel(id_user_model);
        String[] model_split;
        UserModel userModel = new UserModel();
        Cartons cartons;
        Set<Cartons> cartonsSet = new HashSet<>();

        for (int i = 0; i < model.length; i++) {
            model_split = model[i].split(",");
            cartons = new Cartons();
            for (int j = 0; j < model_split.length; j++) {
                System.out.println(j + "   " + model_split[j]);

                if (j == 0 && i == 0)
                    userModel.setId_user_model(Integer.parseInt(model_split[j]));

                if (j == 1 && i == 0)
                    userModel.setName_user_model(model_split[j]);
                if (j == 2) {
                    cartons.setId_carton(Integer.parseInt(model_split[j]));
                }
                if (j == 3) {
                    cartons.setName_carton(model_split[j]);
                    cartons.setUser_model(null);
                }

            }
            cartonsSet.add(cartons);
        }
        userModel.setCartons(cartonsSet);
        return userModel;
    }


}
