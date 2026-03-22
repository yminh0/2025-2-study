package com.example.shop.product;

import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")

public class ProductController {

    private final ProductService productService;

    // 상품 정보 등록
    @PostMapping()
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateRequest request){
        Long ProductName = productService.createProduct(request);
        return ResponseEntity.created(URI.create("/items" + ProductName)).build();
    }

    // 상품 목록 조회
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        // Service 계층에서 상품 목록을 가져온다.
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // 특정 상품 조회
    @GetMapping("/{itemId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productName){
        Product product = productService.getProductById(productName);
        return ResponseEntity.ok(product);
    }

    // 상품 정보 수정
    @PatchMapping("/{itemId}")
    public ResponseEntity<Void> updateProduct(
            @PathVariable Long productName,
            @RequestBody ProductUpdateRequest request){
        productService.updateProduct(productName, request);
        return ResponseEntity.ok().build();
    }

    // 상품 삭제
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productName){
        productService.deleteProduct(productName);
        return ResponseEntity.noContent().build(); // 204 no content
    }
}
