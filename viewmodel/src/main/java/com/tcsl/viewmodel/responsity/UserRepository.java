package com.tcsl.viewmodel.responsity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.tcsl.viewmodel.bean.User;
import com.tcsl.viewmodel.http.Webservice;

import java.io.IOException;

import javax.inject.Inject;
public class UserRepository {
    private Webservice webservice;
    @Inject
    public UserRepository() {
    }

    public LiveData<User> getUser(int userId) {
        final MutableLiveData<User> data = new MutableLiveData<>();
        okhttp3.Response response = null;
        try {
            response = webservice.getUser(userId).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String resp = response.body().toString();
        data.setValue(new Gson().fromJson(resp,User.class));
        return data;
    }
}
