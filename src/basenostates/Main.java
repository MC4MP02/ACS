package basenostates;

/**Before executing enable assertions :
 *<a href="https://se-education.org/guides/tutorials/intellijUsefulSettings.html">...</a>
 */

public class Main {
  public static void main(String[] args) {
    DirectoryDoorsAndAreas.makeDoorsAndAreas();
    DirectoryUserGroups.makeUserGroup();
    new WebServer();
  }
}
