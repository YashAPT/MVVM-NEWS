package com.yash.news.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yash.news.R;
import com.yash.news.data.FakeDataSource;
import com.yash.news.data.NewsItem;
import com.yash.news.databinding.FragmentNewsDetailsBinding;

public class NewsDetailsFragment extends Fragment {

    public NewsDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        FragmentNewsDetailsBinding fragmentNewsDetailsBinding =
                DataBindingUtil.inflate(LayoutInflater.from(getContext()),
                        R.layout.fragment_news_details, container, false);

        FakeDataSource fakeDataSource = new FakeDataSource();
        NewsItem item = fakeDataSource.generateRandomNewsItem();

        item.setFav(true);
        fragmentNewsDetailsBinding.setNewsItemData(item);

        return fragmentNewsDetailsBinding.getRoot();

    }
}