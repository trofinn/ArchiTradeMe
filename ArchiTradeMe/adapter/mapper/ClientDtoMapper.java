package adapter.mapper;

import adapter.in.ClientDto;
import adapter.in.OffreDto;
import domain.Client;
import domain.Offre;

import java.util.ArrayList;

public interface ClientDtoMapper {
    static Client toDomain(ClientDto dto) {
        ArrayList<Offre> offres = new ArrayList<>();
        for(OffreDto i : dto.getOffres()) {
            offres.add(OffreDtoMapper.toDomain(i));
        }
        return new Client(
                dto.getEmail(),
                dto.getNom(),
                dto.getPrenom(),
                offres
        );
    }

    static ClientDto toDto(Client client) {
        ArrayList<OffreDto> offres = new ArrayList<>();
        for(Offre i : client.getOffres()) {
            offres.add(OffreDtoMapper.toDto(i));
        }
        return new ClientDto(
                client.getEmail(),
                client.getNom(),
                client.getPrenom(),
                offres
        );
    }
}
