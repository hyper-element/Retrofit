package model;

/**
 * Created by wts4 on 8/7/16.
 */
public class M_user_signup_res {

    /**
     * success : Success
     * error : {"code":"912","message":"Registration Successfully done WITH JSON"}
     * user : {"username":"testabc","password":"wings123","email_address":"testwts06@gmail.com"}
     */

    private String success;
    /**
     * code : 912
     * message : Registration Successfully done WITH JSON
     */

    private ErrorBean error;
    /**
     * username : testabc
     * password : wings123
     * email_address : testwts06@gmail.com
     */

    private UserBean user;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class ErrorBean {
        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class UserBean {
        private String username;
        private String password;
        private String email_address;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail_address() {
            return email_address;
        }

        public void setEmail_address(String email_address) {
            this.email_address = email_address;
        }
    }
}
