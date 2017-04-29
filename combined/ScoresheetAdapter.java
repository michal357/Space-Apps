package com.example.aleksandra.combined;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

//import mateusz.rutkiewicz.spaceapp.Models.User;
//import mateusz.rutkiewicz.spaceapp.R;

public class ScoresheetAdapter extends ArrayAdapter<User> {
    public ScoresheetAdapter(Context context, int resource, User[] items) {
        super(context, resource, items);
    }

    public View getView(int position, View contextView, ViewGroup parent) {
        LayoutInflater buckysInflater = LayoutInflater.from(getContext());
        View customView = buckysInflater.inflate(R.layout.row_scoresheet, parent, false);

        User singleUser = getItem(position);
        TextView positionTextView = (TextView)customView.findViewById(R.id.position_textView);
        TextView userNameTextView = (TextView)customView.findViewById(R.id.userName_textView);
        TextView scoresheetTextView = (TextView)customView.findViewById(R.id.scoresheet_textView);

        positionTextView.setText(Integer.toString(position + 1) + ".");
        userNameTextView.setText(singleUser.getName());
        scoresheetTextView.setText(Integer.toString(singleUser.getRating()));

        return customView;
    }
}
