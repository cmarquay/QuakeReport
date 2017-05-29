package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.android.quakereport.R.id.mag;

public class QuakeAdapter extends ArrayAdapter<Quake> {

    public QuakeAdapter(Activity context, ArrayList<Quake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Quake currentQuake = getItem(position);
        if (currentQuake != null) {
            TextView magTextView = (TextView) listItemView.findViewById(mag);
            if (magTextView != null) {
                GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();
                int magnitudeColor = getMagnitudeColor(currentQuake.getmMag());
                magnitudeCircle.setColor(magnitudeColor);
                DecimalFormat formatter = new DecimalFormat("0.0");
                String mag = formatter.format(currentQuake.getmMag());
                magTextView.setText(mag);
            }

            String place = currentQuake.getmLocation();
            String displayLocation[];

            if (place.contains(" of ")) {
                displayLocation = place.split(" of ");
            } else {
                displayLocation = new String[2];
                displayLocation[0] = getContext().getString(R.string.near);
                displayLocation[1] = place;
            }

            TextView offsetTextView = (TextView) listItemView.findViewById(R.id.offset);
            if (offsetTextView != null) {
                offsetTextView.setText(displayLocation[0]);
            }

            TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
            if (locationTextView != null) {
                locationTextView.setText(displayLocation[1]);
            }

            Date dateObject = new Date(currentQuake.getmDate());

            TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
            if (dateTextView != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
                String date = dateFormat.format(dateObject);
                dateTextView.setText(date);
            }

            TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
            if (timeTextView != null) {
                SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
                String time = timeFormat.format(dateObject);
                timeTextView.setText(time);
            }
        }
        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColor;
        switch ((int) magnitude) {
            case 2:
                magnitudeColor = R.color.magnitude2;
                break;
            case 3:
                magnitudeColor = R.color.magnitude3;
                break;
            case 4:
                magnitudeColor = R.color.magnitude4;
                break;
            case 5:
                magnitudeColor = R.color.magnitude5;
                break;
            case 6:
                magnitudeColor = R.color.magnitude6;
                break;
            case 7:
                magnitudeColor = R.color.magnitude7;
                break;
            case 8:
                magnitudeColor = R.color.magnitude8;
                break;
            case 9:
                magnitudeColor = R.color.magnitude9;
                break;
            case 10:
                magnitudeColor = R.color.magnitude10plus;
                break;
            default:
                magnitudeColor = R.color.magnitude1;
        }
        return ContextCompat.getColor(getContext(), magnitudeColor);
    }
}
