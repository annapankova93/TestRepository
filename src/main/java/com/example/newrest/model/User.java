package com.example.newrest.model;

import java.util.Date;

public class User {

        private String login;
        private String password;
        private Date registrationDate;



        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Date getRegistrationDate() { return registrationDate; }

        public void setRegistrationDate() { this.registrationDate = new Date(); }

    }

