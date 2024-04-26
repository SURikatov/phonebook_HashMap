import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }
    public void addContact(String name, String phoneNumber) {
    contacts.putIfAbsent(name, new HashSet<>());
    contacts.get(name).add(phoneNumber);
    }
}
