package co.za.wethinkcode.wethinkcode;

public class AuthenticateResponse {
    private String token;

    public AuthenticateResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
