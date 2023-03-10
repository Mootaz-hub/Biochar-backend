package tn.esprit.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.Command;
import tn.esprit.Entity.Product;
import tn.esprit.Exception.ElementNotFoundException;
import tn.esprit.Exception.NoProductException;
import tn.esprit.Interface.IProductService;
import tn.esprit.Repository.ICommandRepository;
import tn.esprit.Repository.IProductRepository;
import tn.esprit.Repository.IStockRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    IProductRepository productRepository;
    ICommandRepository commandRepository;
    IStockRepository stockRepository;


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean ifProductExist(String reference){
        List<Product> p = productRepository.findProduc(reference);
        if(p.size()==0){
            return false;
        }else
            return true;
    }

    @Override
    public Product modifyProduct(Product product) {
            productRepository.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
         productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ElementNotFoundException("Offer with id "+ id +" not found : " ));
    }

    @Override
    public Set<Product> getProductList() {
        Set<Product> productList=new HashSet<>();
        productRepository.findAll().forEach(productList::add);
        return productList ;
    }

    @Override
    public Product AffectProductToCommand(Long idPro,Long idCommand) {
        Product product=productRepository.findById(idPro).orElse(null);
        Command command=commandRepository.findById(idCommand).orElse(null);

            productRepository.save(product);

        return product;
    }

    @Override
    public Product addProductToStock(Long idPro, Long quantity) {
        Product product=productRepository.findById(idPro).orElse(null);
        return null;
    }

    @Override
    public List<Product> getMostOrderedProduct() {
        List<Product> productList= productRepository.FindAllProductsByOrderCountDesc();
        return productList.subList(0,Math.min(5, productList.size()));
    }

    @Override
    public void updateProductQuantity(Product product, Long quantity) {
        if(quantity < 0){
            throw  new NoProductException("Quantity cannot be negative");
        }
        if (quantity == 0){
            throw  new NoProductException("Product is out of stock");
        }
    }


}
