package com.hbl.sandbox1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hbl.sandbox1.models.BannersWrapper;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RetroListFragment extends Fragment {

    String baseUrl = "http://www.nutrients-supplements.com";
    BannerListAdapter adapter;

    public RetroListFragment() {
        // Required empty public constructor
    }

    public static RetroListFragment newInstance() {
        return new RetroListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_retro_list, container, false);
        final RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(baseUrl).build();
        NuSupAPI nuSupAPI = restAdapter.create(NuSupAPI.class);

        final RecyclerView bannerListView = (RecyclerView) itemView.findViewById(R.id.tab1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        bannerListView.setHasFixedSize(true);
        bannerListView.setLayoutManager(layoutManager);
        adapter = new BannerListAdapter();
        bannerListView.setAdapter(adapter);

        nuSupAPI.getBanners(new Callback<BannersWrapper>() {
            @Override
            public void success(BannersWrapper bannersWrapper, Response response) {
                Log.d("retro", "done " + bannersWrapper.getBanners());
                adapter.addBanners(bannersWrapper.getBanners());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("retro", "fail" + error.getLocalizedMessage());
            }
        });
        return itemView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
