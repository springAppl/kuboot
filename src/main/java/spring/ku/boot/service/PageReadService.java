package spring.ku.boot.service;

import spring.ku.boot.model.Page;

import java.util.Optional;

public interface PageReadService {

    Optional<Page> query(String id);
}
