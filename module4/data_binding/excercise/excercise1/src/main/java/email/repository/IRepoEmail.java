package email.repository;

import email.model.Email;

import java.util.List;

public interface IRepoEmail {
    List<String> getListLanguage();

    List<Integer> getListSize();

    List<Email> getList();

    Email getEmail(int id);

    void edit(Email email);
}
