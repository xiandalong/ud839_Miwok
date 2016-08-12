package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kelvin on 8/12/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {
    //constructor
    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word word = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView enTextView = (TextView) listItemView.findViewById(R.id.en_word);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        enTextView.setText(word.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_word);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        miwokTextView.setText(word.getMiwokTranslation());

        // Find the ImageView in the list_item.xml layout with the ID version_number

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        if (word.hasImage()) {
            imageView.setImageResource(word.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else imageView.setVisibility(View.GONE);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
