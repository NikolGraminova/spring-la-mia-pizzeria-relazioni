package org.web.springlamiapizzeriacrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.web.springlamiapizzeriacrud.repository.OfferRepository;

@Controller
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    OfferRepository offerRepository;

    @GetMapping("/")
    public String index(){
        return "";
    }
}
