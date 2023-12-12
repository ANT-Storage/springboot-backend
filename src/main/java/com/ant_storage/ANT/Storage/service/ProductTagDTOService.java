package com.ant_storage.ANT.Storage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant_storage.ANT.Storage.entity.Product;
import com.ant_storage.ANT.Storage.entity.ProductTagDTO;
import com.ant_storage.ANT.Storage.entity.Tag;
import com.ant_storage.ANT.Storage.entity.TagsProduct;

@Service
public class ProductTagDTOService {

    @Autowired
    private final ProductService productService;

    @Autowired
    private final TagService tagService;

    @Autowired
    private final TagsProductService tagsProductService;

    public ProductTagDTOService(ProductService productService, TagService tagService,
            TagsProductService tagsProductService) {
        this.productService = productService;
        this.tagService = tagService;
        this.tagsProductService = tagsProductService;
    }

    public List<ProductTagDTO> getAllProductTag() {
        List<Product> products = productService.findAllProducts();
        List<Tag> tags = tagService.findAllTags();
        List<TagsProduct> tagsProducts = tagsProductService.findAllTagsProducts();

        List<ProductTagDTO> productTags = new ArrayList<>();

        for (Product product : products) {
            ProductTagDTO productTagDTO = new ProductTagDTO(product.getId(), product.getBarcode(), product.getName(),
                    product.getDescription(), product.getSize(), product.getLocation(), product.getDate(),
                    product.getCategory_id(), product.getImage_id(), product.getId(), null);

            List<String> tagNames = new ArrayList<>();

            for (TagsProduct tagsProduct : tagsProducts) {
                if (tagsProduct.getProduct_id().equals(product.getId())) {
                    Optional<Tag> optionalTag = tags.stream()
                            .filter(tag -> tag.getId().equals(tagsProduct.getTags_id())).findFirst();
                    optionalTag.ifPresent(tag -> tagNames.add(tag.getName()));
                }
            }

            productTagDTO.setTagName(String.join(", ", tagNames));
            productTags.add(productTagDTO);
        }

        return productTags;
    }
}
