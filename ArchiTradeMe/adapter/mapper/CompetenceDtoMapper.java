package adapter.mapper;

import adapter.in.CompetenceDto;
import domain.Competence;

public interface CompetenceDtoMapper {
    static Competence toDomain(CompetenceDto dto) {
        return new Competence(dto.getVal());
    }

    static CompetenceDto toDto(Competence competence) {
        return new CompetenceDto(competence.getVal());
    }
}
