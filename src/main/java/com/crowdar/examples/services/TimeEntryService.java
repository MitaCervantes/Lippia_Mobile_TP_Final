package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.TimeEntryConstants;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * This class contains the business logic.
 * We can have querys, requests or steps to do certain things (how to log into the app).
 * If we need to only complete a field or click a button, we can put it in the steps.
 */
public class TimeEntryService {

    public static void isViewLoaded() {
        MobileActionManager.waitVisibility(TimeEntryConstants.TIME_ENTRY_LIST);
        Assert.assertTrue(MobileActionManager.isVisible(TimeEntryConstants.ACTION_BUTTON), TimeEntryConstants.VIEW_NOT_DISPLAYED_MESSAGE);
    }

    public static void clickEntry(){
        MobileActionManager.click(TimeEntryConstants.ACTION_BUTTON);
        MobileActionManager.waitVisibility(TimeEntryConstants.DIV_SECTION_HOUR);
    }

    public static void clickButtonSave(){
        MobileActionManager.click(TimeEntryConstants.ACTION_BUTTON);
    }

    public static void inputHours(String hour, String minute) {
        MobileActionManager.click(TimeEntryConstants.INPUT_HOUR);
        MobileActionManager.setInput(TimeEntryConstants.INPUT_HOUR, hour);
        MobileActionManager.setInput(TimeEntryConstants.INPUT_HOUR, hour);

        MobileActionManager.click(TimeEntryConstants.INPUT_MINUTE);
        MobileActionManager.setInput(TimeEntryConstants.INPUT_MINUTE, minute);
        MobileActionManager.setInput(TimeEntryConstants.INPUT_MINUTE, minute);
    }
    public static void isTitleEntryLoaded(){
        MobileActionManager.waitVisibility(TimeEntryConstants.TITLE_TIME_ENTRY);
    }

    public static void isEntryLoaded(){
        Assert.assertTrue(MobileActionManager.isVisible(TimeEntryConstants.ENTRY));
    }

    public static void clickTimeRange(){
        MobileActionManager.click(TimeEntryConstants.TIME_RANGE);
        MobileActionManager.waitVisibility(TimeEntryConstants.DATE_DIV);

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
            TpUtils.sleep(500);
            MobileActionManager.click(TimeEntryConstants.BTN_NEXT_MONTH);
        }
    }

    private static void retrocederMeses(int cantidadMeses) {
        for (int i = 0; i < cantidadMeses; i++) {
            TpUtils.sleep(500);
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

    public static void setHoraInicio(String hora, String min) {
        MobileActionManager.click(TimeEntryConstants.BTN_START);
        inputHours(hora, min);
    }

    public static void setHoraFin(String hora, String min) {
        MobileActionManager.click(TimeEntryConstants.BTN_END);
        inputHours(hora, min);
    }


}
