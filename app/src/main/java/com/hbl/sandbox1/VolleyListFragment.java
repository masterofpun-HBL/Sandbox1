package com.hbl.sandbox1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.hbl.sandbox1.models.BannersWrapper;

import org.json.JSONObject;

public class VolleyListFragment extends Fragment {

    String url = "http://www.nutrients-supplements.com/magentoApi/magento_banners.php";
    BannerListAdapter adapter;

    public VolleyListFragment() {
        // Required empty public constructor
    }

    public static VolleyListFragment newInstance() {
        return new VolleyListFragment();
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
        final RecyclerView bannerListView = (RecyclerView) itemView.findViewById(R.id.tab1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        bannerListView.setHasFixedSize(true);
        bannerListView.setLayoutManager(layoutManager);
        adapter = new BannerListAdapter();
        bannerListView.setAdapter(adapter);

        final Gson gson = new Gson();

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(new JsonObjectRequest(Request.Method.GET, url, null,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response.toString());
                        BannersWrapper bannersWrapper = gson.fromJson(response.toString(), BannersWrapper.class);
                        adapter.addBanners(bannersWrapper.getBanners());
                        adapter.notifyDataSetChanged();
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.toString());
                    }
                }));
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
