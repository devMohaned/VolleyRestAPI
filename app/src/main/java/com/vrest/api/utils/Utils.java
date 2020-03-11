package com.vrest.api.utils;



/*
 *
 *
 * Github REST API Project:
 *   https://github.com/public-apis/public-apis?fbclid=IwAR2FV39YRNuLpNcTLYokHuR6w0xaRvmJpMVDBvZ1o5dyl0fUANngPJi0o64#animals
 * Public API:
 * https://github.com/davemachado/public-api
 *
 *
 * */
public class Utils {


    public static final String BASE_URL = /*"https://api.publicapis.org"*/ "http://my-json-server.typicode.com/devMohaned/dummy-animals-api";
    public static final String URL_ENTRIES = BASE_URL + "/entries";

    public static String getEntriesGetRequestUrl(String category /* Animals */) {
        return URL_ENTRIES /*+ "?category=" + category*/;
    }


    public static class Constants{
        public static final  String JSON_API = "API";
        public static final String JSON_DESCRIPTION = "Description";
        public static final String JSON_AUTH = "Auth";
        public static final String JSON_HTTPS = "HTTPS";
        public static final String JSON_CORS = "Cors";
        public static final String JSON_LINK = "Link";
        public static final String JSON_CATEGORY = "Category";
    }
}
