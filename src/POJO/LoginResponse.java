package POJO;
import com.fasterxml.jackson.annotation.JsonProperty; 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class LoginResponse {
	String token;
	String userId;
	String message; 
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserID() {
		return userId;
	}
	public void setUserID(String userID) {
		this.userId = userID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	

}
