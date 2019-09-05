package com.nick.test;

import java.math.BigDecimal;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        BigDecimal porcentajeIva = new BigDecimal(21);

        BigDecimal montoTotalSinIva = new BigDecimal(1000);

        BigDecimal porcentajeKarabati = new BigDecimal(15);

        BigDecimal montoDeIvaDelTotal = montoTotalSinIva.multiply(porcentajeIva).divide(new BigDecimal(100)).setScale(2);

        BigDecimal montoTotalConIva = montoTotalSinIva.add(montoDeIvaDelTotal);

        BigDecimal montoKarabatiSinIva = montoTotalSinIva.multiply(porcentajeKarabati).divide(new BigDecimal(100)).setScale(2);

        BigDecimal montoDeIvaDeKarabati = montoKarabatiSinIva.multiply(porcentajeIva).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
//        BigDecimal montoDeIvaDeKarabati = montoKarabatiSinIva.multiply(porcentajeIva).divide(new BigDecimal(100)).setScale(DECIMALES_ESTANDAR_PRECIO, REDONDEO_ESTANDAR_PRECIO);

        BigDecimal montoKarabatiConIva = montoKarabatiSinIva.add(montoDeIvaDeKarabati);

        BigDecimal montoProveedorSinIva = montoTotalSinIva.subtract(montoKarabatiSinIva);

        BigDecimal montoACobrarAlProveedorEnIngenico = montoTotalConIva.subtract(montoKarabatiConIva);

        System.out.println(montoACobrarAlProveedorEnIngenico);

        System.out.println(new BigDecimal(1000).multiply(porcentajeIva.divide(new BigDecimal(100)).add(BigDecimal.ONE)));
    }
}
