package email.service;

import email.model.Email;
import email.repository.IRepoEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    IRepoEmail repoEmail;

    @Override
    public List<String> getListLanguage() {
        return repoEmail.getListLanguage();
    }

    @Override
    public List<Integer> getListSize() {
        return repoEmail.getListSize();
    }

    @Override
    public List<Email> getList() {
        return repoEmail.getList();
    }

    @Override
    public Email getEmail(int id) {
        return repoEmail.getEmail(id);
    }

    @Override
    public void edit(Email email) {
        repoEmail.edit(email);
    }
}
