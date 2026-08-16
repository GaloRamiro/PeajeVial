package com.krakedev.peaje.pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.servicios.EstacionPeaje;

public class TestVehiculo {

    @Test
    public void testCrearConductor() {

        Conductor conductor = new Conductor(
            "1712345678",
            "Galo",
            "Cisneros"
        );

        assertNotNull(conductor);
    }
    
    @Test
    public void testCrearVehiculo() {

        Vehiculo vehiculo = new Vehiculo("ABC123");

        assertNotNull(vehiculo);
        assertEquals("ABC123", vehiculo.getPlaca());
        assertEquals("L", vehiculo.getTipo());
    }
    
    @Test
    public void testComposicion() {

        Conductor conductor = new Conductor(
            "1712345678",
            "Galo",
            "Cisneros"
        );

        Vehiculo vehiculo = new Vehiculo("ABC123");
        TagElectronico tag = new TagElectronico("TAG001");

        vehiculo.setPropietario(conductor);
        vehiculo.setTag(tag);

        assertNotNull(vehiculo.getPropietario());
        assertNotNull(vehiculo.getTag());
    }
    
    @Test
    public void testRegistrarVehiculo() {

        EstacionPeaje estacion = new EstacionPeaje();

        Conductor conductor = new Conductor(
            "1712345678",
            "Galo",
            "Cisneros"
        );

        Vehiculo vehiculo = estacion.registrarVehiculo(
            "ABC123",
            "L",
            conductor
        );

        assertNotNull(vehiculo);
        assertNotNull(vehiculo.getPropietario());
        assertNotNull(vehiculo.getTag());
    }
}