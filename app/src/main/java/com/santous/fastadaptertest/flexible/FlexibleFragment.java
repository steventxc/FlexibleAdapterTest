package com.santous.fastadaptertest.flexible;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.santous.fastadaptertest.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration;
import eu.davidea.flexibleadapter.items.ISectionable;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FlexibleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlexibleFragment extends SupportFragment implements FlexibleAdapter.OnItemClickListener {

    @BindView(R.id.rv_list)
    RecyclerView recyclerView;
    Unbinder unbinder;

    FlexibleAdapter<ISectionable> mAdapter;

    public FlexibleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FlexibleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FlexibleFragment newInstance() {
        FlexibleFragment fragment = new FlexibleFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flexible, container, false);
        unbinder = ButterKnife.bind(this, view);

        List<ISectionable> list = new ArrayList<>();

        // section 1
        FDHeader header1 = new FDHeader(1, "Header 1");
        FDSection section1 = new FDSection(header1, "section1_1");
        section1.addSubItem(new FDSubItem(0, "section sub 1_1_1"));
        list.add(section1);

        // section 2
        FDHeader header2 = new FDHeader(2, "Header 2");

        FDSection section2_1 = new FDSection(header2, "section2_1");
        section2_1.addSubItem(new FDSubItem(1, "section sub 2_1_1"));
        section2_1.addSubItem(new FDSubItem(2, "section sub 2_1_2"));
        list.add(section2_1);

        FDSection section2_2 = new FDSection(header2, "section2_2");
        section2_2.addSubItem(new FDSubItem(3, "section sub 2_2_1"));
        list.add(section2_2);

        FDSection section2_3 = new FDSection(header2, "section2_3");
        section2_3.addSubItem(new FDSubItem(4, "section sub 2_3_1"));
        list.add(section2_3);

        FDSection section2_4 = new FDSection(header2, "section2_4");
        section2_4.addSubItem(new FDSubItem(5, "section sub 2_4_1"));
        list.add(section2_4);

        mAdapter = new FlexibleAdapter<ISectionable>(list, this, true);

        mAdapter.setDisplayHeadersAtStartUp(true)
                .setMinCollapsibleLevel(1) // 可以展开折叠level1级的item
                .setAutoCollapseOnExpand(true) // 可以自动关闭其他level1级以上的item
                .expandAll(); // 展开level0级的item


        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new FlexibleItemDecoration(_mActivity)
                .withSectionGapOffset(24));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public boolean onItemClick(int position) {
        return false;
    }
}
