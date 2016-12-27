package model;

/**
 * Created by wts4 on 8/7/16.
 */
public class M_user_res {

    private boolean success;
    private String usertype;
    private ClientBean client;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public ClientBean getClient() {
        return client;
    }

    public void setClient(ClientBean client) {
        this.client = client;
    }

    public static class ClientBean {
        private String c_id;
        private String c_firstname;
        private String c_username;
        private String c_phone;
        private String c_email;
        private String c_language;
        private String c_profilepicture;
        private String c_status;
        private String c_quickblox_id;
        private String c_cardno;
        private String c_expiry_date;
        private String c_cvv;
        private String c_zip;
        private String c_label;
        private String deviceid;
        private String is_online;

        public String getC_id() {
            return c_id;
        }

        public void setC_id(String c_id) {
            this.c_id = c_id;
        }

        public String getC_firstname() {
            return c_firstname;
        }

        public void setC_firstname(String c_firstname) {
            this.c_firstname = c_firstname;
        }

        public String getC_username() {
            return c_username;
        }

        public void setC_username(String c_username) {
            this.c_username = c_username;
        }

        public String getC_phone() {
            return c_phone;
        }

        public void setC_phone(String c_phone) {
            this.c_phone = c_phone;
        }

        public String getC_email() {
            return c_email;
        }

        public void setC_email(String c_email) {
            this.c_email = c_email;
        }

        public String getC_language() {
            return c_language;
        }

        public void setC_language(String c_language) {
            this.c_language = c_language;
        }

        public String getC_profilepicture() {
            return c_profilepicture;
        }

        public void setC_profilepicture(String c_profilepicture) {
            this.c_profilepicture = c_profilepicture;
        }

        public String getC_status() {
            return c_status;
        }

        public void setC_status(String c_status) {
            this.c_status = c_status;
        }

        public String getC_quickblox_id() {
            return c_quickblox_id;
        }

        public void setC_quickblox_id(String c_quickblox_id) {
            this.c_quickblox_id = c_quickblox_id;
        }

        public String getC_cardno() {
            return c_cardno;
        }

        public void setC_cardno(String c_cardno) {
            this.c_cardno = c_cardno;
        }

        public String getC_expiry_date() {
            return c_expiry_date;
        }

        public void setC_expiry_date(String c_expiry_date) {
            this.c_expiry_date = c_expiry_date;
        }

        public String getC_cvv() {
            return c_cvv;
        }

        public void setC_cvv(String c_cvv) {
            this.c_cvv = c_cvv;
        }

        public String getC_zip() {
            return c_zip;
        }

        public void setC_zip(String c_zip) {
            this.c_zip = c_zip;
        }

        public String getC_label() {
            return c_label;
        }

        public void setC_label(String c_label) {
            this.c_label = c_label;
        }

        public String getDeviceid() {
            return deviceid;
        }

        public void setDeviceid(String deviceid) {
            this.deviceid = deviceid;
        }

        public String getIs_online() {
            return is_online;
        }

        public void setIs_online(String is_online) {
            this.is_online = is_online;
        }
    }
}
