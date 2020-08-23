package serializationDeSerialization;

import java.util.List;

public class Courses {

	public Web[] getWeb() {
		return web;
	}
	public void setWeb(Web[] web) {
		this.web = web;
	}
	public API[] getApi() {
		return api;
	}
	public void setApi(API[] api) {
		this.api = api;
	}
	private Web[] web;
	private API[] api;
	
}
