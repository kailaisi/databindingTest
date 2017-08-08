package com.tcsl.viewmodel.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.tcsl.viewmodel.bean.User;
import com.tcsl.viewmodel.responsity.DaggerUserComponents;
import com.tcsl.viewmodel.responsity.UserRepository;

import javax.inject.Inject;

public class UserProfileViewModel extends ViewModel {
    @Inject
    UserRepository repository;
    private String userId;
    private LiveData<User> user;

    public UserProfileViewModel() {
        DaggerUserComponents.builder().build().inject(this);
    }

    public void init(String userId) {
        if (this.user != null) {
            return;
        }
        if(repository!=null) {
            user = repository.getUser(Integer.parseInt(userId));
        }else {
            Log.d("UserProfileViewModel", "repository is null");
        }
        this.userId = userId;
    }

    public LiveData<User> getUser() {
        return user;
    }
}
