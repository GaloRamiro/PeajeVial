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
    
    
    
    
    @Test
    public void testRecargarTag() {

        EstacionPeaje estacion = new EstacionPeaje();
        TagElectronico tag = new TagElectronico("TAG001");

        boolean resultado = estacion.recargarTag(tag, 10.00);

        assertTrue(resultado);
        assertEquals(10.00, tag.getSaldo());
    }
    @Test
    public void testRecargarTagMontoInvalido() {

        EstacionPeaje estacion = new EstacionPeaje();
        TagElectronico tag = new TagElectronico("TAG001");

        boolean resultado = estacion.recargarTag(tag, -5.00);

        assertFalse(resultado);
        assertEquals(0.00, tag.getSaldo());
    }
    @Test
    public void testCobrarPeaje() {

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

        estacion.recargarTag(vehiculo.getTag(), 10.00);

        boolean resultado = estacion.cobrarPeaje(vehiculo);

        assertTrue(resultado);
        assertEquals(9.00, vehiculo.getTag().getSaldo());
    }
    @Test
    public void testCobrarPeajeSinSaldo() {

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

        boolean resultado = estacion.cobrarPeaje(vehiculo);

        assertFalse(resultado);
        assertEquals(0.00, vehiculo.getTag().getSaldo());
    }
}