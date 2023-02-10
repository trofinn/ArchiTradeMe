package adapter.mapper;

import adapter.in.CompetenceDto;
import adapter.in.ModaliteDto;
import adapter.in.OffreDto;
import domain.Competence;
import domain.Modalite;
import domain.Offre;

import java.util.ArrayList;

public interface OffreDtoMapper {
    static Offre toDomain(OffreDto dto) {
        ArrayList<Competence> competences = new ArrayList<>();
        for(CompetenceDto i : dto.getComeptences_necessaires()) {
            competences.add(CompetenceDtoMapper.toDomain(i));
        }
        ArrayList<Modalite> modalites = new ArrayList<>();
        for(ModaliteDto i : dto.getModalites()) {
            modalites.add(Modalite.valueOf(i.name()));
        }
        return new Offre(
                dto.getId(),
                dto.getTJM(),
                competences,
                modalites,
                dto.getDate_debut(),
                dto.getDuration()
        );
    }

    static OffreDto toDto(Offre offre) {
        ArrayList<CompetenceDto> competences = new ArrayList<>();
        for(Competence i : offre.getComeptences_necessaires()) {
            competences.add(CompetenceDtoMapper.toDto(i));
        }
        ArrayList<ModaliteDto> modalites = new ArrayList<>();
        for(Modalite i : offre.getModalites()) {
            modalites.add(ModaliteDto.valueOf(i.name()));
        }
        return new OffreDto(
                offre.getId(),
                offre.getTJM(),
                competences,
                modalites,
                offre.getDate_debut(),
                offre.getDuration()
        );
    }
}
