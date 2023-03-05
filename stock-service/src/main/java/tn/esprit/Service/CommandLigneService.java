package tn.esprit.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.CommandLigne;
import tn.esprit.Entity.Product;
import tn.esprit.Interface.ICommandLigneService;
import tn.esprit.Repository.ICommandLigneRepository;
import tn.esprit.Repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class CommandLigneService implements ICommandLigneService {

    ICommandLigneRepository ligneRepository;
    IProductRepository productRepository;

    @Override
    public CommandLigne AddLigneAndAssign(CommandLigne ligne, Long idProd) {
        Product product = productRepository.findById(idProd).orElse(null);
        ligne.setProduct(product);
        ligneRepository.save(ligne);
        return ligne;
    }

    @Override
    public CommandLigne GetCommandById(Long id) {
        return ligneRepository.findById(id).orElse(null);
    }

    @Override
    public Set<CommandLigne> getAllOrdersLine() {
        Set<CommandLigne> ligneList = new HashSet<>();
        ligneRepository.findAll().forEach(ligneList::add);
        return ligneList;
    }

    @Override
    public void deleteOrderLine(Long id) {
        ligneRepository.deleteById(id);
    }
}
