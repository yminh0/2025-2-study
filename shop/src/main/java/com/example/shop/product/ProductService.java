package com.example.shop.product;

import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.hibernate.bytecode.internal.bytebuddy.PassThroughInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    @Transactional
    public Long createProduct(ProductCreateRequest request){
        Product existingProduct = productRepository.findByName(request.getName());
        if(existingProduct != null){
            throw new RuntimeException("이미 존재하는 상품입니다: " + request.getName());
        }

        Product product = new Product(
                request.getName(),
                request.getPrice(),
                request.getInventory()
        );

        productRepository.save(product);

        return product.getId();
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() { return productRepository.findAll(); }

    @Transactional(readOnly = true)
    public Product getProductById(Long id){
        Product product = productRepository.findById(id);

        if (product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        return product;
    }

    @Transactional
    public void updateProduct(Long id, ProductUpdateRequest request){
        Product product = productRepository.findById(id);

        if (product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        // 상품 정보 수정
        product.updateInfo(request.getName(),request.getPrice(),request.getInventory());
    }

    @Transactional
    public void deleteProduct(Long id){
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        // Repository를 통해 삭제
        productRepository.deleteById(id);
    }

}
