package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Category;
import com.mds.libraryMgmtSystem.entity.OQ;
import com.mds.libraryMgmtSystem.repository.OQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OQService {
    @Autowired
    private OQRepository oqRepository;

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

    public List<OQ> getOQ(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<OQ> pagedResult = oqRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<OQ>();
        }
    }
}
