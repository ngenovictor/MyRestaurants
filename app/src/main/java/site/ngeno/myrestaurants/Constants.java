package site.ngeno.myrestaurants;

/**
 * Created by kingkong on 9/12/17.
 */

public class Constants {
    public static final String YELP_TOKEN = BuildConfig.YELP_TOKEN;
    public static final String CLIENT_ID = BuildConfig.CLIENT_ID;
    public static final String CLIENT_SECRET = BuildConfig.CLIENT_SECRET;

    public static final String YELP_BASE_URL = "https://api.yelp.com/v3/businesses/search?term=restaurant";
    public static final String YELP_LOCATION_QUERY_PARAMETER = "location";
}
