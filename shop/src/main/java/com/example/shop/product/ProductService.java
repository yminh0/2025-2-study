package com.example.shop.product;

import lombok.RequiredArgsConstructor;
import org.hibernate.bytecode.internal.bytebuddy.PassThroughInterceptor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    //@Transactional
    public Long createProduct(ProductCreateRequest request){
        Product existingProduct = productRepository.findByName(request.getProductName());
        if(existingProduct != null){
            throw new RuntimeException("이미 존재하는 상품입니다: " + request.getProductName());
        }

        Product product = new Product(
                request.getProductName(),
                request.getPrice()
        );

        productRepository.save(product);

        return product.getName();
    }

    //@Transactional(readOnly = true)
    public List<Product> getAllProducts() { return productRepository.findAll(); }

    //@Transactional(readOnly = true)
    public Product getProductByName(Long name){
        Product product = productRepository.findByName(name);

        if (product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        return product;
    }

    //@Transactional
    public void updateProduct(Long name, ProductUpdateRequest request){
        Product product = productRepository.findByName(name);

        if (product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        // 상품 정보 수정
        product.updateInfo(request.getProductName(),request.getPrice());
    }

    //@Transactional
    public void deleteProduct(Long name){
        Product product = productRepository.findByName(name);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        // Repository를 통해 삭제
        productRepository.deleteByName(name);
    }

}
