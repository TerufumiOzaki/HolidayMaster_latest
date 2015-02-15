package com.example.terufumiozaki.holidaymaster.api;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by TerufumiOzaki on 2015/02/14.
 */
public class FoursquareApiClientManager {

    public interface FoursquareService{
        @GET("/venues/search")
        void listResponse(@Query("ll") String ll,
                 @Query("query") String query,
                 @Query("radius") int radius,
                 Callback<VenueSearchResponse> callback);

        @GET("/venues/{VENUE_ID}/photos")
        void listPhotos(@Path("VENUE_ID") String id,
                        Callback<VenueSearchPhotos> callback);
    }

    public static RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("https://api.foursquare.com/v2")
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addQueryParam("client_id", "5BFU5NHEAWAMQKBHNLNVEGKROKUILUIGAWOU0KXNH5VUONZV");
                    request.addQueryParam("client_secret", "CR0HFEDWEIT5QVKJXJYGGQ1PYLZ2ZLL0AP05HGA2BGQ53WF1");
                    request.addQueryParam("v", "20150214");
                }
            })
            .build();

    public static FoursquareService service = restAdapter.create(FoursquareService.class);

}
