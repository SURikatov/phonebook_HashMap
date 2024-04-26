import java.util.*;

public class PhoneBook 
{
    private Map<String, Set<String>> contacts;
    public PhoneBook() 
    {
        contacts = new HashMap<>();
    }
    public void addContact(String name, String phoneNumber) 
    {
        contacts.putIfAbsent(name, new HashSet<>());
        contacts.get(name).add(phoneNumber);
    }
    public void removeContact(String name) 
    {
        if (!contacts.containsKey(name)) 
        {
            System.out.println("Контакт " + name + " не найден.");
            return;
        }
        contacts.remove(name);
    }
    public void findContact(String name) 
    {
        if (!contacts.containsKey(name)) 
        {
            System.out.println("Контакт " + name + " не найден.");
            return;
        }
        Set<String> phoneNumbers = contacts.get(name);
        System.out.println("Телефоны контакта " + name + ": " + phoneNumbers);
    }
    public void showPhoneBook() 
    {
        if (contacts.isEmpty()) 
        {
            System.out.println("Телефонная книга пуста.");
            return;
        }
        List<Map.Entry<String, Set<String>>> sortedContacts = new ArrayList<>(contacts.entrySet());
        sortedContacts.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        System.out.println("Телефонная книга:");
        for (Map.Entry<String, Set<String>> entry : sortedContacts) 
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args) 
    {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Сергей", "89991122333");
        phoneBook.addContact("Пётр", "89121122333");
        phoneBook.showPhoneBook();
    }
}
