public class AuthService {

    public boolean register(User user) {

        System.out.println("Registering user: "
                + user.getUsername());

        return true;
    }

    public boolean login(String username, String password) {

        if (username == null || password == null) {
            return false;
        }

        System.out.println("Checking login...");

        return true;
    }
}