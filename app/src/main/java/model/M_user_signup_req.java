package model;

/**
 * Created by wts4 on 8/7/16.
 */
public class M_user_signup_req {

    String username;
    String password;
    String email_address;

    public M_user_signup_req(String email_address, String password, String username) {
        this.email_address = email_address;
        this.password = password;
        this.username = username;
    }

    private M_user_signup_req(Builder builder) {
        email_address = builder.email_address;
        username = builder.username;
        password = builder.password;
    }


    public static final class Builder {
        private String email_address;
        private String username;
        private String password;

        public Builder() {
        }

        public Builder email_address(String val) {
            email_address = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public M_user_signup_req build() {
            return new M_user_signup_req(this);
        }
    }
}
