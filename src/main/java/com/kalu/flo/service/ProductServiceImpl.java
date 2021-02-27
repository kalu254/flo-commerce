package com.kalu.flo.service;

import com.kalu.flo.exceptions.NotFoundException;
import com.kalu.flo.model.ProductEntity;
import com.kalu.flo.repository.ProductEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductEntityRepository productEntityRepository;
    public static String uploadProduct = System.getProperty("user.dir") + "/product_images";


    @Autowired
    public ProductServiceImpl(ProductEntityRepository productEntityRepository) {
        this.productEntityRepository = productEntityRepository;
    }

    @Override
    public List<ProductEntity> findAll() {
        return productEntityRepository.findAll();
    }

    @Override
    public ProductEntity findById(Integer id) throws NotFoundException {
        return productEntityRepository.findById(id).
            orElseThrow(()->new NotFoundException("Product not found"));
    }

    @Override
    public void deleteProduct(int id) {
        productEntityRepository.deleteById(id);
    }

    @Override
    public void saveProduct(MultipartFile[] imageFiles, ProductEntity productEntity) {
        StringBuilder fileName = new StringBuilder();

        List<String> imageDownloadUris = Arrays.asList(imageFiles)
            .stream()
            .map(imageFile -> {
                Path path = Paths.get(uploadProduct, imageFile.getOriginalFilename());
                fileName.append(imageFile.getOriginalFilename());
                try {
                    Files.write(path, imageFile.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String imageDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("product_images/")
                    .path(Objects.requireNonNull(imageFile.getOriginalFilename()))
                    .toUriString();

                return imageDownloadUri;
            })
            .collect(Collectors.toList());

        String main_img_url = imageDownloadUris.get(0);
        String img_url_one = imageDownloadUris.get(1);
        String img_url_two = imageDownloadUris.get(2);
        String img_url_three = imageDownloadUris.get(3);

        persistToDb(productEntity, main_img_url,img_url_one,img_url_two,img_url_three);
    }

    private void persistToDb(ProductEntity productEntity, String main_img_url, String img_url_one, String img_url_two, String img_url_three) {
        ProductEntity p = new ProductEntity();

        p.setCategory(productEntity.getCategory());
        p.setDescription(productEntity.getDescription());
        p.setTitle(productEntity.getTitle());
        p.setMain_image_url(main_img_url);
        p.setImage_url_one(img_url_one);
        p.setImage_url_two(img_url_two);
        p.setImage_url_three(img_url_three);
        p.setGender(productEntity.getGender());
        p.setPrice(productEntity.getPrice());

        productEntityRepository.saveAndFlush(p);
    }


}
