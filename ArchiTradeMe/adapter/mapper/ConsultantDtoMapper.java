package adapter.mapper;

import adapter.in.CompetenceDto;
import adapter.in.ConsultantDto;
import adapter.in.ModaliteDto;
import domain.Competence;
import domain.Consultant;
import domain.Modalite;

import java.util.ArrayList;

public interface ConsultantDtoMapper {
    static Consultant toDomain(ConsultantDto dto) {
        ArrayList<Competence> competences = new ArrayList<>();
        for(CompetenceDto i : dto.getCompetences()) {
            competences.add(CompetenceDtoMapper.toDomain(i));
        }
        ArrayList<Modalite> modalites = new ArrayList<>();
        for(ModaliteDto i : dto.getModalites()) {
            modalites.add(Modalite.valueOf(i.name()));
        }
        return new Consultant(
          dto.getEmail(),
          dto.getNom(),
          dto.getPrenom(),
          competences,
          dto.getTJM(),
          dto.getDisponibilites(),
          modalites
        );
    }

    static ConsultantDto toDto(Consultant consultant) {
        ArrayList<CompetenceDto> competences = new ArrayList<>();
        for(Competence i : consultant.getCompetences()) {
            competences.add(CompetenceDtoMapper.toDto(i));
        }
        ArrayList<ModaliteDto> modalites = new ArrayList<>();
        for(Modalite i : consultant.getModalites()) {
            modalites.add(ModaliteDto.valueOf(i.name()));
        }
        return new ConsultantDto(
                consultant.getEmail(),
                consultant.getNom(),
                consultant.getPrenom(),
                competences,
                consultant.getTJM(),
                consultant.getDisponibilites(),
                modalites
        );
    }

}
