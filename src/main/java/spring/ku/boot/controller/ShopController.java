package spring.ku.boot.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.exception.WebException;
import spring.ku.boot.model.Shop;
import spring.ku.boot.util.ResourceUtil;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/all")
    public List<Shop> all(){
        return shops();
    }

    private List<Shop> shops(){
        String json = ResourceUtil.classPath("shop.json");
        try {
            return objectMapper.readValue(json, new TypeReference<List<Shop>>() { });
        } catch (IOException e) {
            //TODO 日志记录
            throw new WebException();
        }
    }

    @GetMapping("/{id}")
    public Shop detail(@PathVariable Long id){
        Optional<Shop> optionalShop = shops().stream()
        .filter(shop -> Objects.equals(id, shop.getId()))
        .findFirst();
        return optionalShop.orElseThrow(() -> new WebException("店铺不存在", 401));
    }
}
