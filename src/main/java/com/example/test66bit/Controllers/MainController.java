package com.example.test66bit.Controllers;

import com.example.test66bit.DTO.FootballerDTO;
import com.example.test66bit.Entities.Footballer;
import com.example.test66bit.Services.ClubService;
import com.example.test66bit.Services.CountryService;
import com.example.test66bit.Services.FootballerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Objects;
import java.util.Optional;

@Controller
public class MainController {
    @Value("${limit}")
    private Integer limit;
    private FootballerService footballerService;
    private CountryService countryService;
    private ClubService clubService;

    public MainController(FootballerService footballerService, CountryService countryService, ClubService clubService) {
        this.footballerService = footballerService;
        this.countryService = countryService;
        this.clubService = clubService;
    }


    @GetMapping("/")
    public String main(Model model, @RequestParam Optional<Integer> limit, @RequestParam Optional<Integer> offset) {
        model.addAttribute("footballers", footballerService.getAllInDTOFormat(offset.orElse(0), limit.orElse(this.limit)));
        var count = footballerService.getCount();
        model.addAttribute("pageCount", count % limit.orElse(this.limit) != 0 ? count / limit.orElse(this.limit) + 1 : count / limit.orElse(this.limit));
        model.addAttribute("limit", this.limit);
        model.addAttribute("curPage", offset.orElse(0));
        return "show";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("clubs", clubService.getAll());
        model.addAttribute("footballer", new FootballerDTO());
        return "add";
    }

    @PostMapping("/add")
    @ResponseBody
    public ModelAndView addFootballer(FootballerDTO footballerDTO) throws ParseException {
        footballerService.saveFromDto(footballerDTO);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/edit/{id}")
    public String updateFootballerPage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("clubs", clubService.getAll());
        model.addAttribute("footballer", footballerService.getByIdInDTOFormat(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public ModelAndView updateFootballer(@PathVariable("id") Integer id, FootballerDTO footballerDTO) throws ParseException {
        footballerDTO.setId(id);
        System.out.println("footballerDTO.country is " + footballerDTO.getCountry() + " id is " + footballerDTO.getId());
        footballerService.updateFootballerFromDTO(footballerDTO);
        return new ModelAndView("redirect:/");
    }
}
