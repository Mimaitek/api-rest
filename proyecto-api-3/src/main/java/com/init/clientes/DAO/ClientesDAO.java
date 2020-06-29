package com.init.clientes.DAO;
import com.init.clientes.entity.Cliente;
import com.init.clientes.entity.Cliente.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public interface ClientesDAO extends JpaRepository <Cliente, Long>{

}
