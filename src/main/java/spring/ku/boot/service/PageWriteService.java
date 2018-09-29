package spring.ku.boot.service;

import spring.ku.boot.model.Page;

import java.util.Optional;

public interface PageWriteService {
    Optional<Page> save(Page page);

    void delete(String id);
}
