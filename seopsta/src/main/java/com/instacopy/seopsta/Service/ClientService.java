package com.instacopy.seopsta.Service;

import com.instacopy.seopsta.DTO.ClientDTO;
import com.instacopy.seopsta.Repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientService {
    private ClientRepository repository;

    public void setToken(ClientDTO clientDTO) throws Exception{
        repository.save(clientDTO.toEntity());
    }
}
