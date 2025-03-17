package com.academy.learning_journal_team3.service;

import com.academy.learning_journal_team3.entity.Entry;
import com.academy.learning_journal_team3.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    public List<Entry> getAllEntries() {

        return entryRepository.findAll();
    }


}
