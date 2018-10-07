package spring.ku.boot.authentication;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class FingerAuthentication extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 8077867154534895184L;

    private final String fingerPrint;

    private Object principal;
    private Object credentials;

    public FingerAuthentication(String fingerPrint){
        super(null);
        this.fingerPrint = fingerPrint;
        setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    public String getFingerPrint(){
        return this.fingerPrint;
    }

    public void setPrincipal(Object principal) {
        this.principal = principal;
    }

    public void setCredentials(Object credentials) {
        this.credentials = credentials;
    }
}
