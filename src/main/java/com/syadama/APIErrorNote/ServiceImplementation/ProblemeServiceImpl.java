package com.syadama.APIErrorNote.ServiceImplementation;

import com.syadama.APIErrorNote.Model.Probleme;
import com.syadama.APIErrorNote.Repository.ProblemeRepository;
import com.syadama.APIErrorNote.Service.ProblemeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProblemeServiceImpl implements ProblemeService {

    private final ProblemeRepository problemeRepository;
    @Override
    public Probleme ajouter(Probleme probleme) {
        return problemeRepository.save(probleme);
    }

    @Override
    public Probleme modifier(Long id_probleme, Probleme probleme) {
        return problemeRepository.findById(id_probleme)
                .map(probleme1 -> {
                    probleme1.setDescription(probleme.getDescription());
                    probleme1.setTitre(probleme.getTitre());
                    probleme1.setTechno_concerne(probleme.getTechno_concerne());
                    return problemeRepository.save(probleme);
                }).orElseThrow(() -> new RuntimeException("Problème non trouvé"));
    }

    @Override
    public String supprimer(Long id_probleme) {
        problemeRepository.deleteById(id_probleme);
        return "Problème supprimé";
    }

    @Override
    public List<Probleme> lire() {
        return problemeRepository.findAll();
    }
}
