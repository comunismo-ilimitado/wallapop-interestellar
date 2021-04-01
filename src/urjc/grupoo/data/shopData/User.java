package urjc.grupoo.data.shopData;

import java.io.Serializable;

    /*
     * Clase abstracta correspondiente al usuario
     */

    public abstract class User implements Serializable {
        private String name;
        private String nick;
        private String password;
        private String email;
        private int idNumber;


        public User(String name, String nick, String password, String email, int idNumber) {
            this.name = name;
            this.nick = nick;
            this.password = password;
            this.email = email;
            this.idNumber = idNumber;
        }

        public String getName() {
            return name;
        }

        public String getNick() {
            return nick;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
        }

        public int getIdNumber() {
            return idNumber;
        }
    }

