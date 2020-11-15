package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.OQ;
import com.mds.libraryMgmtSystem.repository.OQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OQService {
    @Autowired
    private OQRepository oqRepository;


    public List<OQ> getOQ() {
        return oqRepository.findAll();
    }

    public OQ findById(Long id) {
        return oqRepository.findById(id).orElse(null);
    }

    public OQ addOQ(OQ oq) {
        return oqRepository.save(oq);
    }

    public void deleteOQ(Long id) {
        oqRepository.deleteById(id);
    }

    public OQ updateOQ(OQ oq) {
        return oqRepository.save(oq);
    }
}
