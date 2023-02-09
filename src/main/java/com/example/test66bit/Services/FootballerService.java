package com.example.test66bit.Services;

import com.example.test66bit.DTO.FootballerDTO;
import com.example.test66bit.Entities.Footballer;
import com.example.test66bit.Repository.FootballerRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class FootballerService {
    private final FootballerRepository footballerRepository;
    private final ClubService clubService;
    private final CountryService countryService;

    public FootballerService(FootballerRepository footballerRepository, ClubService clubService, CountryService countryService) {
        this.footballerRepository = footballerRepository;
        this.clubService = clubService;
        this.countryService = countryService;
    }

    public void saveFromDto(FootballerDTO footballerDTO) throws ParseException {
        var footballer = new Footballer(footballerDTO);
        footballer.setCountry(countryService.findByName(footballerDTO.getCountry()));
        footballer.setClub(clubService.findByNameOrSaveNew(footballerDTO.getClub()));
        footballerRepository.save(footballer);
    }

    public List<FootballerDTO> getAllInDTOFormat(Integer offset, Integer limit) {
        return footballerRepository.findAllPaginated(offset*limit, limit).stream().map(FootballerDTO::new).toList();
    }

    public long getCount() {
        return footballerRepository.count();
    }

    public FootballerDTO getByIdInDTOFormat(Integer id) {
        return new FootballerDTO(footballerRepository.findFootballerById(id));
    }

}
