package homework;

import org.junit.jupiter.api.Test;

public class HomeWork01 {
    public static void main(String[] args) {

    }

    @Test
    public void testList() {
        DAO<User> dao = new DAO<>();
        dao.save("001", new User( 1, 20, "joker"));
        dao.save("002", new User(18, 18, "panther"));
        dao.save("003", new User(2, 0, "mona"));

        System.out.println("list = " + dao.list());
        System.out.println("listError = " + dao.listError());
    }
}
