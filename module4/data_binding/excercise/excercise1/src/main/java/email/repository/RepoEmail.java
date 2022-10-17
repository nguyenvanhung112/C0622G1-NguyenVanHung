package email.repository;

import email.model.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepoEmail implements IRepoEmail {
    private static List<Email> emails = new ArrayList<>();

    static {
        emails.add(new Email(1, "Vietnamese", 5, "Enable spams filter", "Adam"));
        emails.add(new Email(2, "English", 15, " ", "Quang"));
        emails.add(new Email(3, "Vietnamese", 25, " ", "Huy"));
        emails.add(new Email(4, "Japanese", 50, "Enable spams filter", "Hai"));
        emails.add(new Email(5, "Chinese", 100, " ", "Dat"));
    }

    @Override
    public List<String> getListLanguage() {
        List<String> languagesList = new ArrayList<>();
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("Japanese");
        languagesList.add("Chinese");
        return languagesList;
    }

    @Override
    public List<Integer> getListSize() {
        List<Integer> size = new ArrayList<>();
        size.add(5);
        size.add(10);
        size.add(15);
        size.add(20);
        size.add(25);
        size.add(50);
        size.add(100);
        return size;
    }

    @Override
    public List<Email> getList() {
        return emails;
    }

    @Override
    public Email getEmail(int id) {
        for (Email email : emails) {
            if (email.getId() == id) {
                return email;
            }
        }
        return null;
    }

    @Override
    public void edit(Email email) {
        for (Email item : emails) {
            if (item.getId() == email.getId()) {
                item.setLanguage(email.getLanguage());
                item.setPageSize(email.getPageSize());
                item.setSignature(email.getSignature());
                item.setSpamsFilter(email.getSpamsFilter());
            }
        }
    }
}
