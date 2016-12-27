package model;

/**
 * Created by wts4 on 8/7/16.
 */
public class M_user_req {

    String email;
    String password;

    public M_user_req(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private M_user_req(Builder builder) {
        email = builder.email;
        password = builder.password;
    }


    public static final class Builder {
        private String email;
        private String password;

        public Builder() {
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public M_user_req build() {
            return new M_user_req(this);
        }
    }
}
