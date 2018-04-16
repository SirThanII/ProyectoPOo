/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.*;

/**
 *
 * @author retr0
 */
public final class Counter {
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Casillero> casilleros;
    int cantidadCasilleros;

    public Counter(int cantidadCasilleros) {
        setCantidadCasilleros(cantidadCasilleros);
        casilleros = new ArrayList<>(this.cantidadCasilleros);
    }

    /**
     * 
     * @return la lista de clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * setter de la lista de clientes
     * @param clientes 
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * 
     * @return la lista de casilleros
     */
    public ArrayList<Casillero> getCasilleros() {
        return casilleros;
    }

    /**
     * setter de la lista de casilleros
     * @param casilleros 
     */
    public void setCasilleros(ArrayList<Casillero> casilleros) {
        this.casilleros = casilleros;
    }

    /**
     * 
     * @return la cantidad de casilleros
     */
    public int getCantidadCasilleros() {
        return cantidadCasilleros;
    }

    /**
     * setter de la cantidad de casilleros
     * @param cantidadCasilleros 
     */
    public void setCantidadCasilleros(int cantidadCasilleros) {
        this.cantidadCasilleros = cantidadCasilleros;
    }
    
    public void registrarCliente(String nombre, String correo, String telefono, String direccion, String sexo, String fechaNacimiento, Tipo tipo){
        if(clientes.size() < cantidadCasilleros){
            Cliente nuevo = new Cliente(nombre, correo, telefono, direccion, sexo, fechaNacimiento, tipo);
            clientes.add(nuevo);
        }
        else{
            System.out.println("No quedan casilleros disponibles");
        }
    }
    
    public void eliminarCliente(String idCliente){
        for(int i=0; clientes.size()>i;i++){
            if(clientes.get(i).getIdCliente().equals(idCliente)){
                clientes.remove(i);
                System.out.println("Cliente eliminado");
            }
        }
    }
    
    public void consultarCliente(String idCliente){
        Cliente cliente=selecionarCliente(idCliente);
        if("0".equals(cliente.getIdCliente())){
            System.out.println("Cliente no encontrado");
        }else{
            System.out.println(cliente.toString());
        }
    }
    
    public void consultarClientes(){
        for(int i=0;clientes.size()>i;i++){
            System.out.println(clientes.get(i).toString());
        }
    }
    
    public Cliente selecionarCliente(String idCliente ){
        boolean encontrado=false;
        Cliente cliente=new Cliente();
        for(int i=0;clientes.size()>i;i++){
            if(clientes.get(i).getIdCliente().equals(idCliente)){
                encontrado=true;
                cliente= clientes.get(i);
            }
        }
        if(!encontrado){
            cliente=clientes.get(0);
        }
        return cliente;
    }
    
    public void enviarCorreo(){
        //correo
    }
    
    public void recibirArticulo(Entregable entregable){
        String idCliente=entregable.getRemitente().getIdCliente();
        Cliente cliente=selecionarCliente(idCliente);
        if(cliente.getIdCliente().equals("0")){
            System.out.println("El cliente no existe");
        }else{
            cliente.getCasillero().agregarEntregable(entregable);
            System.out.println("Articulo Dejado en el casillero corrrespondiente");
            enviarCorreo();
        }
    }
    
    public void entregarArticulo(String codArticulo){
        
    }
}
