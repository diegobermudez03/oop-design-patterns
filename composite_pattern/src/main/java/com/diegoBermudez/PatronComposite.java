package com.diegoBermudez;




import com.diegoBermudez.composicion.productos.Nodo;
import com.diegoBermudez.composicion.productos.OrdenVenta;
import com.diegoBermudez.composicion.productos.Paquete;
import com.diegoBermudez.composicion.productos.Producto;

import java.util.Random;

public class PatronComposite {
    private final Random random = new Random();

    private Producto ram4gb;
    private Producto ram8gb;
    private Producto disk500gb;
    private Producto disk1tb;
    private Producto cpuAMD;
    private Producto cpuIntel;
    private Producto smallCabinete;
    private Producto bigCabinete;
    private Producto monitor20inch;
    private Producto monitor30inch;
    private Producto simpleMouse;
    private Producto gammerMouse;

    private Producto descuento;

    private Paquete gammerPC;
    private Paquete homePC;
    private Paquete pc2x1;

    private void CreardProductos() {
        //Configuraciòn de productos simples
        ram4gb = new Producto("RAM 4GB", 750, "KingStone", 0.15);
        ram8gb = new Producto("RAM 8GB", 1000, "KingStone", 0.54);
        disk500gb = new Producto("HDD 500GB", 1500, "ACME", .14);
        disk1tb = new Producto("HDD 1TB", 2000, "ACME",0.05);
        cpuAMD = new Producto("AMD phenon", 4000, "AMD",0.09);
        cpuIntel = new Producto("Intel i7", 4500, "Intel",0.07);
        smallCabinete = new Producto("Small cabinet", 2000, "ExCom",0.36);
        bigCabinete = new Producto("Big Cabinet", 2200, "ExCom",0.78);
        monitor20inch = new Producto("Display 20'", 1500, "HP",1.5);
        monitor30inch = new Producto("Display 30'", 2000, "HP",0.01);
        simpleMouse = new Producto("Simple mouse", 150, "Genius",0.11);
        gammerMouse = new Producto("Gammer mouse", 750, "Alien",0.14);
        descuento = new Producto("Descuento", 8000, "", 0);

        //Producto Compuesto con: Gammer pc de 8gb ram,HDD 1tb, Intel i7 processor
        //large cabinet,display 30' y one gammer mouse.
        gammerPC = new Paquete("Gammer PC");
        gammerPC.AgregarProducto(new Nodo(ram8gb, 2));
        gammerPC.AgregarProducto(new Nodo(disk1tb, 5));
        gammerPC.AgregarProducto(cpuIntel);
        gammerPC.AgregarProducto(bigCabinete);
        gammerPC.AgregarProducto(monitor30inch);
        gammerPC.AgregarProducto(gammerMouse);

        //Paquete: Home PC con RAM 4gb, HDD 500gb, AMD Phenon processor
        //small Cabinet, dsplay 20' y simple mouse.
        homePC = new Paquete("Home PC");
        homePC.AgregarProducto(new Nodo(ram4gb, 6));//
        homePC.AgregarProducto(disk500gb);
        homePC.AgregarProducto(cpuAMD);
        homePC.AgregarProducto(smallCabinete);
        homePC.AgregarProducto(new Nodo(monitor20inch,2));
        homePC.AgregarProducto(simpleMouse);

        //Combo confirmado por 2 paquetes, Gammer PC + Home PC
        pc2x1 = new Paquete("Pack PC Gammer + Home PC");
        pc2x1.AgregarProducto(gammerPC);
        pc2x1.AgregarProducto(homePC);
    }

    private void OrdenVentaParaConfiguracionSimpleProducto() {

        OrdenVenta OrdenSimple = new OrdenVenta(random.nextInt(), "Hector Lavoe");
        OrdenSimple.AgregarProducto(ram4gb);
        OrdenSimple.AgregarProducto(disk1tb);
        OrdenSimple.AgregarProducto(simpleMouse);
        OrdenSimple.AgregarProducto(descuento);
        OrdenSimple.ImprimirOrdenVenta();
    }

    private void OrdenVentaGammerPC() {
        OrdenVenta gammerOrdenVenta = new OrdenVenta(1, "Ismael Rivera");
        gammerOrdenVenta.AgregarProducto(gammerPC);
        gammerOrdenVenta.ImprimirOrdenVenta();
    }

    private void OrdenVentaHomePC() {
        OrdenVenta homeOrdenVenta = new OrdenVenta(2, "Celia Cruz");
        homeOrdenVenta.AgregarProducto(new Nodo(homePC, 2));
        homeOrdenVenta.ImprimirOrdenVenta();
    }
    private void OrdenVentaCombo() {
        OrdenVenta comboOrdenVenta = new OrdenVenta(3, "Paquete 2x1 en PC");
        comboOrdenVenta.AgregarProducto(pc2x1);
        comboOrdenVenta.ImprimirOrdenVenta();
    }

    private void OrdenVentaMega() {
        OrdenVenta OrdenVentaPersonalizada = new OrdenVenta(4, "Tito Nieves");
        OrdenVentaPersonalizada.AgregarProducto(homePC);
        OrdenVentaPersonalizada.AgregarProducto(ram8gb);
        OrdenVentaPersonalizada.AgregarProducto(ram4gb);
        OrdenVentaPersonalizada.AgregarProducto(monitor30inch);
        OrdenVentaPersonalizada.AgregarProducto(gammerMouse);
        OrdenVentaPersonalizada.AgregarProducto(new Nodo(pc2x1, 2));
        OrdenVentaPersonalizada.ImprimirOrdenVenta();
    }

    public static void main(String[] args) {
        PatronComposite main = new PatronComposite();
        main.CreardProductos();

        main.OrdenVentaParaConfiguracionSimpleProducto();
        main.OrdenVentaHomePC();
        main.OrdenVentaGammerPC();
        main.OrdenVentaCombo();
        main.OrdenVentaMega();


    }

}