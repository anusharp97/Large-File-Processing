package com.demo.batch.constants;

public final class PathConstants {

	// Suppress default constructor for noninstantiability
	private PathConstants() {
		throw new AssertionError("No instances for you!");
	}
	public static final String API_PATH = "/api";
    public static final String PATH_TO_PRODUCTS = API_PATH+"/products";
    public static final String PATH_TO_PRODUCT = API_PATH+"/product";
    public static final String SEARCH_PATH = API_PATH+"/search";
}
