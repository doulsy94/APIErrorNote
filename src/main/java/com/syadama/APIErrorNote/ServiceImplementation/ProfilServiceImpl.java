package com.syadama.APIErrorNote.ServiceImplementation;

import com.syadama.APIErrorNote.Repository.ProfilRepository;
import com.syadama.APIErrorNote.Service.ProfilService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfilServiceImpl implements ProfilService {
    private final ProfilRepository profilRepository;


}
