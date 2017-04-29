package com.example.aleksandra.combined;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.Comparator;
/*
import mateusz.rutkiewicz.spaceapp.Adapters.ScoresheetAdapter;
import mateusz.rutkiewicz.spaceapp.Models.User;
import mateusz.rutkiewicz.spaceapp.R;
import mateusz.rutkiewicz.spaceapp.Services.FakedUserService;
import mateusz.rutkiewicz.spaceapp.Services.IUserService;*/

public class ScoresheetActivity extends AppCompatActivity {
    private IUserService userService;
    private ListView listView;
    private ArrayAdapter<User> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoresheet);

        setContentView(R.layout.activity_scoresheet);
        userService = new FakedUserService();
        listView = (ListView)findViewById(R.id.scoresheet_listView);
        adapter = new ScoresheetAdapter(this, android.R.layout.simple_list_item_1, getUsersSortedByScore());
        listView.setAdapter(adapter);
    }

    private User[] getUsersSortedByScore() {
        User[] users = userService.getUsers().toArray(new User[userService.getUsers().size()]);
        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getRating() > o2.getRating() ? -1 : o1.getRating() == o2.getRating() ? 0 : 1;
            }
        });

        return users;
    }
}

