package com.hbl.sandbox1;

import com.hbl.sandbox1.models.BannersWrapper;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by hbl on 4/3/2017.
 */

public interface NuSupAPI {
    @GET("/magentoApi/magento_banners.php")
    void getBanners(Callback<BannersWrapper> callback);
}