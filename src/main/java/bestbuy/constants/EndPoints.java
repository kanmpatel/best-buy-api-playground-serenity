package bestbuy.constants;

public class EndPoints {
    /*
    * This EndPoints for PRODUCTS
    * */
    public static final String GET_ALL_PRODUCTS = "/products";
    public static final String GET_SINGLE_PRODUCT = "/products/{productID}";
    public static final String UPDATE_PRODUCT_BY_ID = "/products/{productID}";
    public static final String DELETE_PRODUCT_BY_ID = "/products/{productID}";

    /*
     * This EndPoints for STORES
     * */
    public static final String GET_ALL_STORES = "/stores";
    public static final String GET_SINGLE_STORES = "/stores/{storesID}";
    public static final String UPDATE_STORES_BY_ID = "/stores/{storesID}";
    public static final String DELETE_STORES_BY_ID = "/stores/{storesID}";

    /*
     * This EndPoints for SERVICES
     * */
    public static final String GET_ALL_SERVICES = "/services";
    public static final String GET_SINGLE_SERVICES = "/services/{servicesID}";
    public static final String UPDATE_SERVICES_BY_ID = "/services/{servicesID}";
    public static final String DELETE_SERVICES_BY_ID = "/services/{servicesID}";

    /*
     * This EndPoints for CATEGORIES
     * */
    public static final String GET_ALL_CATEGORIES = "/categories";
    public static final String GET_SINGLE_CATEGORIES = "/categories/{categoriesID}";
    public static final String UPDATE_CATEGORIES_BY_ID = "/categories/{categoriesID}";
    public static final String DELETE_CATEGORIES_BY_ID = "/categories/{categoriesID}";

    /*
     * This EndPoints for UTITLIES
     * */
    public static final String GET_ALL_HEALTHCHECK = "/healthcheck";
    public static final String GET_ALL_VERSION = "/version";

}
