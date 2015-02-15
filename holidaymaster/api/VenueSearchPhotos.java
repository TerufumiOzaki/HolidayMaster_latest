package com.example.terufumiozaki.holidaymaster.api;

import java.util.List;

/**
 * Created by TerufumiOzaki on 2015/02/14.
 */
public class VenueSearchPhotos {

    private Response response;

    public Response getResponse() {
        return response;
    }

    public class Response {

        private List<Photo> photos;

        public List<Photo> getPhotos() {
            return photos;
        }
    }

    public class Photo {
        private String id;
        private String prefix;
        private String suffix;

        public String getId() {
            return id;
        }

        public String getPrefix() {
            return prefix;
        }

        public String getSuffix() {
            return suffix;
        }
    }

    }
