package com.codeclan.example.filesfolders.components;

import com.codeclan.example.filesfolders.models.File;
import com.codeclan.example.filesfolders.models.Folder;
import com.codeclan.example.filesfolders.models.User;
import com.codeclan.example.filesfolders.repositories.FileRepository;
import com.codeclan.example.filesfolders.repositories.FolderRepository;
import com.codeclan.example.filesfolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){
    }

    @Override
    public void run(ApplicationArguments args) {
        User tanya = new User("Tanya");
        userRepository.save(tanya);

        User sofia = new User("Sofia");
        userRepository.save(sofia);

        Folder documents = new Folder("Documents", tanya);
        folderRepository.save(documents);

        Folder codeclan_work = new Folder("codeclan_work", tanya);
        folderRepository.save(codeclan_work);

        Folder e56_classnotes = new Folder("e56_classnotes", tanya);
        folderRepository.save(e56_classnotes);

        File ideas = new File("Ideas for Projects", ".docx", 13, documents);
        fileRepository.save(ideas);

        File debugging = new File("Debugging Checklist", ".docx", 12, documents);
        fileRepository.save(debugging);

    }
}
