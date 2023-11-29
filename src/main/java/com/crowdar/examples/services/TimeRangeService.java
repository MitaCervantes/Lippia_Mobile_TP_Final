package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.TimeEntryConstants;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TimeRangeService {
    public static void clickTimeRange(){
        MobileActionManager.click(TimeEntryConstants.TIME_RANGE);
        SoftAssert assertsSoft = new SoftAssert();
        assertsSoft.assertTrue(MobileActionManager.isVisible(TimeEntryConstants.DATE_DIV), "Date Div is not visible");
    }

    public static void chosseDate(String dia, String mes, String anio) {
        String fecha = dia + "-" + mes + "-" + anio;
        Assert.assertTrue(validarFecha(fecha), "Fecha ingresada invalida");
        String strMes = strMesIngresado(mes);

        int anioIngresado = Integer.parseInt(anio);
        int diferenciaAnios = calcularDiferenciaAnios(anioIngresado);

        int mesIngresado = Integer.parseInt(mes);
        int diferenciaMeses = calcularDiferenciaMeses(mesIngresado);

        navegarPorCalendario(diferenciaAnios, diferenciaMeses);
        clickEnFechaElegida(dia, strMes, anio);
    }


    private static int calcularDiferenciaAnios(int anioIngresado) {
        return anioIngresado - anioActual();
    }

    private static int calcularDiferenciaMeses(int mesIngresado) {
        return mesIngresado - mesActual();
    }

    private static final int MESES_POR_ANIO = 12;

    private static void navegarPorCalendario(int diferenciaAnios, int diferenciaMeses) {
        int totalMeses = diferenciaAnios * MESES_POR_ANIO + diferenciaMeses;

        if (totalMeses > 0) {
            avanzarMeses(totalMeses);
        } else if (totalMeses < 0) {
            retrocederMeses(-totalMeses);
        }
    }

    private static void avanzarMeses(int cantidadMeses) {
        for (int i = 0; i < cantidadMeses; i++) {
            MobileActionManager.click(TimeEntryConstants.BTN_NEXT_MONTH);
        }
    }

    private static void retrocederMeses(int cantidadMeses) {
        for (int i = 0; i < cantidadMeses; i++) {
            MobileActionManager.click(TimeEntryConstants.BTN_PREVIOUS_MONTH);
        }
    }

    private static void clickEnFechaElegida(String dia, String strMes, String anio) {
        String fechaElegida = crearLocatorFecha(dia, strMes, anio);
        MobileActionManager.click(fechaElegida);
    }

    private static String crearLocatorFecha(String dia, String strMes, String anio) {
        return String.format("ACCESSIBILITY_ID:%s %s %s", dia, strMes, anio);
    }

    public static boolean validarFecha(String date) {
        String DATE_FORMAT = "dd-MM-yyyy";
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static String strMesIngresado(String mes) {
        Map<String, String> listaMeses = new HashMap<String, String>();
        listaMeses.put("01", "January");
        listaMeses.put("02", "February");
        listaMeses.put("03", "March");
        listaMeses.put("04", "April");
        listaMeses.put("05", "May");
        listaMeses.put("06", "June");
        listaMeses.put("07", "July");
        listaMeses.put("08", "August");
        listaMeses.put("09", "September");
        listaMeses.put("10", "October");
        listaMeses.put("11", "November");
        listaMeses.put("12", "December");
        return listaMeses.get(mes);
    }

    public static int anioActual() {
        LocalDate localDate = LocalDate.now();
        return localDate.getYear();
    }

    public static int mesActual() {
        LocalDate localDate = LocalDate.now();
        return localDate.getMonthValue();
    }
}
