/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.model.transaccion;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Esta clase nos permite accesder a la base de datos mongo que se ha creado de
 * manera online y realizar diferentes consultas y metodos dentro de la base de
 * datos, algunos ya implementados por defecto y otros implentados por nosotros.
 *
 * @author camilo
 */
public interface TransaccionRepository extends MongoRepository<Transaccion, String> {

    /**
     * Este metodo permite obtener las transacciones desde la base de datos
     * mediante la cedula del vendedor.
     *
     * @param cedulaVendedor El numero de cedula del vendedor.
     * @return La lista con las transacciones que ha realizado el vendedor.
     */
    public List<Transaccion> findBycedulaVendedor(Integer cedulaVendedor);

    /**
     * Este metodo permite obtener las transacciones desde la base de datos
     * mediante la cedula del comprador.
     *
     * @param cedulaComprador El numero de cedula del comprador.
     * @return La lista con las transacciones que ha realizado el comprador.
     */
    public List<Transaccion> findBycedulaComprador(Integer cedulaComprador);
}
