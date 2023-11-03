package basenostates;

/**
 *User class, we create on it a user with
 *his name and his credential.
 */
public class User {
  private final String name;
  private final String credential;

  // class constructor, we give to the object his name and credential
  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
  }

  // getters
  public String getCredential() {
    return credential;
  }

  public String getName() {
    return name;
  }
  //all user's information to a concatenated string
  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
