package com.example.irfan.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class NewsAdpater extends ArrayAdapter<News> {

    public NewsAdpater(Context context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item, parent, false);
        }

        News currentNews = getItem(position);
        TextView newsTitleTextView = listItemView.findViewById(R.id.title_text_view);
        String title = currentNews.getmTitle();
        newsTitleTextView.setText(title);

        TextView newsCategorytextView = listItemView.findViewById(R.id.category_text_view);
        String category = currentNews.getmCategory();
        newsCategorytextView.setText(category);

        TextView newsDatetextView = listItemView.findViewById(R.id.date_text_view);
        String date = currentNews.getmDate();
        newsDatetextView.setText(date);

        TextView newsAuthortextView = listItemView.findViewById(R.id.author_text_view);
        String author = currentNews.getmAuthor();

        //Check Author is empty show this message
        if (author.equals("")) {
            author = getContext().getString(R.string.noauthor);
        }

        newsAuthortextView.setText(author);

        return listItemView;
    }
}
