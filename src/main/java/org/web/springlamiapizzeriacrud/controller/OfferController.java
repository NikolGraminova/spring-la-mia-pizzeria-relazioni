package org.web.springlamiapizzeriacrud.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.web.springlamiapizzeriacrud.model.Offer;
import org.web.springlamiapizzeriacrud.model.Pizza;
import org.web.springlamiapizzeriacrud.repository.OfferRepository;
import org.web.springlamiapizzeriacrud.repository.PizzaRepository;

import java.util.Optional;

@Controller
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    OfferRepository offerRepository;

    @Autowired
    PizzaRepository pizzaRepository;

    @GetMapping("/create")
    public String create(@RequestParam("pizzaId") Integer pizzaId, Model model){
        Optional<Pizza> pizzaOptional = pizzaRepository.findById(pizzaId);
        if (pizzaOptional.isPresent()){
            Pizza pizza = pizzaOptional.get();
            Offer offer = new Offer();
            offer.setPizza(pizza);
            model.addAttribute("offer", offer);
            return "offers/create";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("offer") Offer offer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "offers/create";
        } else{
            offerRepository.save(offer);
            return "redirect:/list/show/" + offer.getPizza().getId();
        }
    }

    @GetMapping("/edit/{offerId}")
    public String edit(@PathVariable("offerId") Integer offerId, Model model){
        Optional<Offer> optionalOffer = offerRepository.findById(offerId);
        if (optionalOffer.isPresent()){
            model.addAttribute("offer", optionalOffer.get());
            return "offers/edit";
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit/{offerId}")
    public String doEdit(@PathVariable("offerId") Integer offerId, @Valid @ModelAttribute("offer") Offer offer, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "offers/edit";
        } else{
            try {
                offer.setId(offerId);
                offerRepository.save(offer);
                return "redirect:/list/show/" + offer.getPizza().getId();
            } catch (Exception e) {
                e.printStackTrace(); // Add this line for debugging
                return "offers/edit";
            }
        }
    }

    @PostMapping("/delete/{offerId}")
    public String delete(@PathVariable("offerId") Integer offerId){
        Optional<Offer> optionalOffer = offerRepository.findById(offerId);
        if (optionalOffer.isPresent()){
            Integer pizzaId = optionalOffer.get().getPizza().getId();
            offerRepository.deleteById(offerId);
            return "redirect:/list/show/" + pizzaId;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
