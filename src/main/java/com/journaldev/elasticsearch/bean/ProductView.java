package com.journaldev.elasticsearch.bean;

import java.time.format.DateTimeFormatter;

import org.joda.time.DateTimeUtils;
import org.joda.time.LocalDateTime;

public class ProductView {
	
	    private String id;
	    private String productId;
	    private String productcode;
	    private String productname;
	    private String categoryIdname;
	    private String region_code;
	    private String region_name;
	    private String city;
	    //private String zipcode;
	    private Double latitude;
	    private Double longitude;
	   // private String metro_code;
	    private String area_code;
	    private LocalDateTime dtr;
	    public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		public String getProductcode() {
			return productcode;
		}
		public void setProductcode(String productcode) {
			this.productcode = productcode;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public String getCategoryIdname() {
			return categoryIdname;
		}
		public void setCategoryIdname(String categoryIdname) {
			this.categoryIdname = categoryIdname;
		}
		public String getRegion_code() {
			return region_code;
		}
		public void setRegion_code(String region_code) {
			this.region_code = region_code;
		}
		public String getRegion_name() {
			return region_name;
		}
		public void setRegion_name(String region_name) {
			this.region_name = region_name;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public Double getLatitude() {
			return latitude;
		}
		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}
		public Double getLongitude() {
			return longitude;
		}
		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}
		public String getArea_code() {
			return area_code;
		}
		public void setArea_code(String area_code) {
			this.area_code = area_code;
		}
		public LocalDateTime getDtr() {
			return dtr;
		}
		public void setDtr(LocalDateTime dtr) {
			this.dtr = dtr;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "ProductView [id=" + id + ", productId=" + productId + ", productcode=" + productcode
					+ ", productname=" + productname + ", categoryIdname=" + categoryIdname + ", region_code="
					+ region_code + ", region_name=" + region_name + ", city=" + city + ", latitude=" + latitude
					+ ", longitude=" + longitude + ", area_code=" + area_code + ", dtr=" + dtr + "]";
		}

}
