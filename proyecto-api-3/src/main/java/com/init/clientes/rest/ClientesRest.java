package com.init.clientes.rest;
import com.init.clientes.DAO.ClientesDAO;
import com.init.clientes.entity.Cliente;
import java.util.Optional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("clientes")
public class ClientesRest {

	@Autowired
	private ClientesDAO clienteDao;
	
	//@GetMapping 
	//Cuando devolvemos todos los valores almacenados
	@RequestMapping(value="getAllclientes", method =RequestMethod.GET)
	public ResponseEntity<List<Cliente>> getClientes(){
		List<Cliente> clientes = clienteDao.findAll();
		return ResponseEntity.ok(clientes);
	}
	
	//Cuando devolvemos un valor específico
	@RequestMapping(value="getAllclientes/{clienteId}", method =RequestMethod.GET)
	public ResponseEntity<Cliente> getClienteById(@PathVariable("clienteId") Long clienteId){
		Optional<Cliente> optionalCliente= clienteDao.findById(clienteId);
		if(optionalCliente.isPresent()) {
			return ResponseEntity.ok(optionalCliente.get());
		}
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value="insertCliente")
	//Hacemos un insert de un cliente
	public ResponseEntity<Cliente> insertCliente(@RequestBody Cliente cliente){
		Cliente newCliente = clienteDao.save(cliente);
		return  new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="deleteCliente/{clienteId}")
	//eliminamos un cliente pasándole  un id
	public ResponseEntity<String> deleteCliente(@PathVariable("clienteId") Long clienteId){
		clienteDao.deleteById(clienteId);
		return new ResponseEntity<>("Eliminado el registro: "+clienteId,  HttpStatus.NO_CONTENT);
	}
	
	
	@PutMapping(value="updateCliente/{clienteId}")
	//Actualizamos un registro de un cliente en concreto
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente){
		Optional<Cliente> optionalCliente= clienteDao.findById(cliente.getId());
		if(optionalCliente.isPresent()) {
			Cliente updateCliente = optionalCliente.get();
			updateCliente.setNombre(cliente.getNombre());
			clienteDao.save(updateCliente);
			return ResponseEntity.ok(updateCliente);
		}
		return ResponseEntity.noContent().build();
	}
	
}
