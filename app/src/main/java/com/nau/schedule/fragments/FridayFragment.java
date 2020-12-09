package com.nau.schedule.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nau.schedule.adapters.WeekAdapter;
import com.nau.schedule.utils.DbHelper;
import com.nau.schedule.R;
import com.nau.schedule.utils.FragmentHelper;


@SuppressLint("ValidFragment")
public class FridayFragment extends Fragment {

    public static final String KEY_FRIDAY_FRAGMENT = "Friday";
    private DbHelper db;
    private ListView listView;
    private WeekAdapter adapter;
    private int week;

    public FridayFragment(int week){
        this.week = week;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friday, container, false);
        setupAdapter(view);
        setupListViewMultiSelect();
        return view;
    }

    private void setupAdapter(View view){
        db = new DbHelper(getActivity());
        listView = view.findViewById(R.id.fridaylist);
        adapter = new WeekAdapter(getActivity(), listView, R.layout.listview_week_adapter, db.getWeek(KEY_FRIDAY_FRAGMENT + "Fragment" + week));

        listView.setAdapter(adapter);
    }

    private void setupListViewMultiSelect() {
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(FragmentHelper.setupListViewMultiSelect(getActivity(), listView, adapter, db));
    }
}
