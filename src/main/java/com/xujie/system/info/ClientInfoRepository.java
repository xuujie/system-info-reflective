package com.xujie.system.info;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientInfoRepository extends CrudRepository<ClientInfo, String> {
}
