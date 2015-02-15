package com.example.terufumiozaki.holidaymaster.api;

import java.util.List;

/**
 * Created by TerufumiOzaki on 2015/02/14.
 */
public class VenueSearchResponse {
    private Response response;

    public Response getResponse() {
        return response;
    }

    public class Response {
        private List<Venue> venues;

        public List<Venue> getVenues() {
            return venues;
        }

    }


    public class Venue {

        private String id;
        private String name;
        private boolean verified;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public boolean getVerified() {
            return verified;
        }
    }
}
