import com.sun.istack.NotNull;

// Lombok @Data for a nice shortcut
// @Data
public class Credentials {
  // JSR 303 for bean validation
  @NotNull
  private String username;
  @NotNull
  private String password;

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


}
