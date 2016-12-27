package model;

/**
 * Created by wts4 on 8/7/16.
 */
public class M_user_path_res {

    /**
     * success : Success
     * error : {"code":"942","message":"Logged in successfully"}
     * user : {"username":"testabc","password":"wings123","first_name":"John","email_address":"testwts06@gmail.com"}
     */

    private String success;
    /**
     * code : 942
     * message : Logged in successfully
     */

    private ErrorBean error;
    /**
     * username : testabc
     * password : wings123
     * first_name : John
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
        private String first_name;
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

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getEmail_address() {
            return email_address;
        }

        public void setEmail_address(String email_address) {
            this.email_address = email_address;
        }
    }
}
