package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.model.Livro;
import application.repository.GeneroRepository;
import application.repository.LivroRepository;

@Controller
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository livrosRepo;
    @Autowired
    private GeneroRepository generosRepo;

    @RequestMapping("/list")
    public String list(Model ui){
        ui.addAttribute("livros", livrosRepo.findAll());
        return "/livro/list";
    }

    @RequestMapping("/insert")
    public String insert(Model ui) {
        ui.addAttribute("generos", generosRepo.findAll());
        return "/livro/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("titulo") String titulo,
        @RequestParam("genero") long generoId) {
            
        Optional<Genero> resultado = generosRepo.findById(generoId);
        if(resultado.isPresent()) {
            Livro livro = new Livro();
            livro.setTitulo(titulo);
            livro.setGenero(resultado.get());

            livrosRepo.save(livro);
        }
        
        return "redirect:/livros/list";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("id") long id, Model ui) {
        Optional<Livro> result = livrosRepo.findById(id);
        if(result.isPresent()) {
            ui.addAttribute("livro", result.get());
            ui.addAttribute("generos", generosRepo.findAll());
            return "/livro/update";
        }
        return "redirect:/livros/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam("id") long id, @RequestParam("titulo") String titulo, @RequestParam("genero") long generoId) {
        Optional<Livro> result = livrosRepo.findById(id);
        if(result.isPresent()) {
            Optional<Genero> resultGenero = generosRepo.findById(generoId);
            if(resultGenero.isPresent()) {
                result.get().setTitulo(titulo);
                result.get().setGenero(resultGenero.get());

                livrosRepo.save(result.get());
            }
        }

        return "redirect:/livros/list";
    }

    @RequestMapping("/delete")
    public String delete(Model ui, @RequestParam("id") long id) {
        Optional<Livro> resultado = livrosRepo.findById(id);

        if(resultado.isPresent()) {
            ui.addAttribute("livro", resultado.get());
            return "/livro/delete";    
        }

        return "redirect:/livros/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        livrosRepo.deleteById(id);

        return "redirect:/livros/list";
    }

}
