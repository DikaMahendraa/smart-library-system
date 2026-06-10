public abstract class User {

    protected int id;
    protected String nama;
    protected String username;
    protected String password;
    protected String role;

    public User(int id, String nama, String username,
            String password, String role) {

        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void showMenu();
}